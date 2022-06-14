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
import kotlinx.android.synthetic.main.fragment_congrats.*


class CongratsFragment : BaseFragment<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_congrats
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {
    }

    override fun init() {
        txtGotoHome.singleClick {
            currentActivity().replaceMainFragment(R.id.action_congratsFragment_to_homeFragment)
        }
    }

}