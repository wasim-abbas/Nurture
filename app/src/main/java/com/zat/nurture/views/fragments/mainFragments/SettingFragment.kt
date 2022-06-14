package com.zat.nurture.views.fragments.mainFragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zat.nurture.R
import com.zat.nurture.base.BaseFragment
import com.zat.nurture.utils.singleClick
import com.zat.nurture.viewModels.BaseViewModel
import com.zat.nurture.views.activities.BoardingActivity
import kotlinx.android.synthetic.main.fragment_setting.*


class SettingFragment : BaseFragment<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_setting
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {
    }

    override fun init() {

        txtPersonalInfo.singleClick {
            currentActivity().replaceMainFragment(R.id.action_settingFragment_to_editProfileFragment)
        }

        txtAboutUs.singleClick {
            currentActivity().replaceMainFragment(R.id.action_settingFragment_to_aboutUsFragment)
        }

        txtTermsAndCond.singleClick {
            currentActivity().replaceMainFragment(R.id.action_settingFragment_to_termsAnddConditionFragment)
        }

        txtPrivacyPolicy.singleClick {
            currentActivity().replaceMainFragment(R.id.action_settingFragment_to_privacyPolicyFragment)
        }
        txtOurSupport.singleClick {
            currentActivity().replaceMainFragment(R.id.action_settingFragment_to_supportFragment)
        }
        btnLogout.singleClick {
            startActivity(Intent(currentActivity(), BoardingActivity::class.java))
            currentActivity().finish()
        }

        txtBack.singleClick {
            currentActivity().onBackPressed()
        }
    }

}