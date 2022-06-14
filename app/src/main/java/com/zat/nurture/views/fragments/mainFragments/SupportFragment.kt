package com.zat.nurture.views.fragments.mainFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zat.nurture.R
import com.zat.nurture.base.BaseFragment
import com.zat.nurture.models.requestModels.SupportRequestModel
import com.zat.nurture.utils.getString
import com.zat.nurture.utils.isEmpty
import com.zat.nurture.utils.singleClick
import com.zat.nurture.viewModels.AuthViewModel
import com.zat.nurture.viewModels.BaseViewModel
import com.zat.nurture.viewModels.StaticViewModel
import kotlinx.android.synthetic.main.fragment_support.*


class SupportFragment : BaseFragment<StaticViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_support
    override val viewModelClass: Class<StaticViewModel>
        get() = StaticViewModel::class.java

    override fun observeLiveData() {

        with(viewModel) {
            errorLiveData.observe(this@SupportFragment) {
                hideLoadingBar()
                showToast(it)
            }
            feedSupportLiveData.observe(viewLifecycleOwner) {
                hideLoadingBar()
                it?.message?.let { msg ->
                    showToast(msg)
                    currentActivity().replaceMainFragment(R.id.action_supportFragment_to_supportDoneFragment)
                }
            }

        }

    }

    override fun init() {
        txtBack.singleClick { currentActivity().onBackPressed() }

        btnSend.singleClick {
            if (isValidate()) {
                var feedSupportReq = SupportRequestModel(
                    edTitle.getString(),
                    edDescription.getString(),
                    edEmail.getString()
                )
                showLoadingBar()
                viewModel.feedSupport(feedSupportReq)

            }


        }
    }

    fun isValidate() = when {
        edTitle.isEmpty() -> {
            edTitle.error = getString(R.string.fill_this_field_first)
            false
        }
        edEmail.isEmpty() -> {
            edEmail.error = getString(R.string.fill_this_field_first)
            false
        }
        edDescription.isEmpty() -> {
            edDescription.error = getString(R.string.fill_this_field_first)
            false
        }
        else -> true

    }

}


