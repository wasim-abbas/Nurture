package com.zat.nurture.views.fragments.mainFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zat.nurture.R
import com.zat.nurture.base.BaseFragment
import com.zat.nurture.utils.FRAGMENT_NAME
import com.zat.nurture.utils.gone
import com.zat.nurture.utils.singleClick
import com.zat.nurture.utils.visible
import com.zat.nurture.viewModels.BaseViewModel
import kotlinx.android.synthetic.main.fragment_result.*


class ResultFragment : BaseFragment<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_result
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {
    }

    override fun init() {
        val fragName = getStringArgument(FRAGMENT_NAME)
        if (fragName == "CaptureNailsTestingFragment") {
            btnTest.visible()
        } else {
            btnTest.gone()
        }

        txtBack.singleClick {
            if (fragName == "CaptureNailsTestingFragment") {
                currentActivity().replaceMainFragment(R.id.action_resultFragment_to_homeFragment)
            } else {
                currentActivity().onBackPressed()
            }
        }

        btnTest.singleClick {
            currentActivity().replaceMainFragment(R.id.action_resultFragment_to_captureNailFragment)
        }
    }

}