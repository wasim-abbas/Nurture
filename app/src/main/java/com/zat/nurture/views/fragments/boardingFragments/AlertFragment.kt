package com.zat.nurture.views.fragments.boardingFragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zat.nurture.R
import com.zat.nurture.base.BaseFragment
import com.zat.nurture.viewModels.BaseViewModel
import com.zat.nurture.views.activities.BoardingActivity
import com.zat.nurture.views.activities.MainActivity
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AlertFragment : BaseFragment<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_alert
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {
    }

    override fun init() {
        MainScope().launch {
            delay(3000)
            startActivity(Intent(currentActivity(), MainActivity::class.java))
           currentActivity().finish()
        }
    }

}