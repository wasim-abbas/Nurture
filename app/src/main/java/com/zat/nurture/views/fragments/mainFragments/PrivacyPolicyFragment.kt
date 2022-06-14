package com.zat.nurture.views.fragments.mainFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zat.nurture.R
import com.zat.nurture.base.BaseFragment
import com.zat.nurture.utils.singleClick
import com.zat.nurture.viewModels.AuthViewModel
import com.zat.nurture.viewModels.BaseViewModel
import com.zat.nurture.viewModels.StaticViewModel
import kotlinx.android.synthetic.main.fragment_privacy_policy.*
import kotlinx.android.synthetic.main.fragment_privacy_policy.txtBack
import kotlinx.android.synthetic.main.fragment_terms_andd_condition.*


class PrivacyPolicyFragment : BaseFragment<StaticViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_privacy_policy
    override val viewModelClass: Class<StaticViewModel>
        get() = StaticViewModel::class.java

    override fun observeLiveData() {

        with(viewModel) {
            errorLiveData.observe(viewLifecycleOwner) {
                hideLoadingBar()
                showToast(it)
            }
            staticLiveData.observe(viewLifecycleOwner) {
                hideLoadingBar()
                it.data.let {data->
                    txtAboutUsQoutes.text =data!!.content

                }
            }
        }
    }

    override fun init() {

        showLoadingBar()
        viewModel.privacyPolicy()

        txtBack.singleClick {
            currentActivity().onBackPressed()
        }
    }

}