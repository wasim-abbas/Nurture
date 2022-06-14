package com.zat.nurture.views.fragments.boardingFragments


import com.zat.nurture.R
import com.zat.nurture.base.BaseFragment
import com.zat.nurture.utils.singleClick
import com.zat.nurture.viewModels.BaseViewModel
import kotlinx.android.synthetic.main.fragment_boarding_first.*


class BoardingFragmentOne : BaseFragment<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_boarding_first
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {
    }

    override fun init() {

        btnGetStarted.singleClick {
            currentActivity().replaceFragmentBoarding(
                R.id.action_boardingFragmentOne_to_boardingFragmentTwo
            )
        }
    }

}