package com.zat.nurture.views.fragments.mainFragments


import com.zat.nurture.R
import com.zat.nurture.base.BaseFragment
import com.zat.nurture.utils.singleClick
import com.zat.nurture.viewModels.AuthViewModel
import com.zat.nurture.viewModels.StaticViewModel

import kotlinx.android.synthetic.main.fragment_terms_andd_condition.*
import kotlinx.android.synthetic.main.fragment_terms_andd_condition.txtBack


class TermsAnddConditionFragment : BaseFragment<StaticViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_terms_andd_condition
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
                    txtTermsAndConditionQoutes.text =data!!.content

                }
            }
        }
    }

    override fun init() {
        txtBack.singleClick {
            currentActivity().onBackPressed()
        }

        showLoadingBar()
        viewModel.termsAndCondition()
    }

}