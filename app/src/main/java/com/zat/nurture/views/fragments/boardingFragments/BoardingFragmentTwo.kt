package com.zat.nurture.views.fragments.boardingFragments


import com.zat.nurture.R
import com.zat.nurture.base.BaseFragment
import com.zat.nurture.models.requestModels.RegisterRequestModels
import com.zat.nurture.utils.getString
import com.zat.nurture.utils.isEmpty
import com.zat.nurture.utils.singleClick
import com.zat.nurture.viewModels.AuthViewModel
import com.zat.nurture.viewModels.BaseViewModel
import kotlinx.android.synthetic.main.fragment_boarding_two.*


class BoardingFragmentTwo : BaseFragment<AuthViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_boarding_two
    override val viewModelClass: Class<AuthViewModel>
        get() = AuthViewModel::class.java

    override fun observeLiveData() {
        with(viewModel) {
            errorLiveData.observe(viewLifecycleOwner) {
                hideLoadingBar()
                showToast(it)
            }

            registerLiveData.observe(viewLifecycleOwner) {
                hideLoadingBar()
                it.message.let { msg ->
                    showToast(msg)
                    if (it.data != null) {
                        currentActivity().replaceFragmentBoarding(R.id.action_boardingFragmentTwo_to_alertFragment)

                    }
                }
            }
        }
    }

    override fun init() {

        btnProceed.singleClick {
            if (edEmail.isEmpty()) {
                edEmail.error = getString(R.string.fill_this_field_first)
            } else {
                showLoadingBar()
                viewModel.register(RegisterRequestModels(edEmail.getString()))
            }

//            currentActivity().replaceFragmentBoarding(R.id.action_boardingFragmentTwo_to_alertFragment)
        }

        btnSkip.singleClick {
            currentActivity().replaceFragmentBoarding(R.id.action_boardingFragmentTwo_to_alertFragment)

        }
    }

}