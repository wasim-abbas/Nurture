package com.zat.nurture.views.fragments.mainFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zat.nurture.R
import com.zat.nurture.base.BaseFragment
import com.zat.nurture.utils.singleClick
import com.zat.nurture.viewModels.BaseViewModel
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : BaseFragment<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_home
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {
    }

    override fun init() {
        llAddNewTest.singleClick {
            currentActivity().replaceMainFragment(R.id.action_homeFragment_to_captureNailFragment)
        }
    }

}