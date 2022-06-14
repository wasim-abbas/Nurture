package com.zat.nurture.views.fragments.mainFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zat.nurture.R
import com.zat.nurture.base.BaseFragment
import com.zat.nurture.utils.FRAGMENT_NAME
import com.zat.nurture.utils.singleClick
import com.zat.nurture.viewModels.BaseViewModel
import kotlinx.android.synthetic.main.fragment_capture_nails_testing.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class CaptureNailsTestingFragment : BaseFragment<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_capture_nails_testing
    override val viewModelClass: Class<BaseViewModel>
        get() =BaseViewModel::class.java

    override fun observeLiveData() {
    }

    override fun init() {
        MainScope().launch {
            delay(2000)
            var bundle = Bundle()
            bundle.putString(FRAGMENT_NAME,CaptureNailsTestingFragment::class.java.simpleName)
            currentActivity().replaceMainFragment(R.id.action_captureNailsTestingFragment_to_resultFragment,bundle)
        }
        txtBack2.singleClick {
            currentActivity().onBackPressed()
        }
    }

}