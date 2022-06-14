package com.zat.nurture.views.fragments.mainFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zat.nurture.R
import com.zat.nurture.base.BaseFragment
import com.zat.nurture.utils.dummyList
import com.zat.nurture.utils.dummyList2
import com.zat.nurture.utils.singleClick
import com.zat.nurture.viewModels.BaseViewModel
import com.zat.nurture.views.adapters.HistoryAdapter
import kotlinx.android.synthetic.main.fragment_history.*


class HistoryFragment : BaseFragment<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_history
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java
    private lateinit var historyAdapter: HistoryAdapter

    override fun observeLiveData() {
    }

    override fun init() {

        txtBack.singleClick {
            currentActivity().onBackPressed()
        }
        lldownloadResult.singleClick {
            currentActivity().replaceMainFragment(R.id.action_historyFragment_to_resultFragment)
        }

        historyAdapter= HistoryAdapter(currentActivity(),{})
        historyAdapter.updateData(dummyList2)

        rvHistory.let {
            it.adapter=historyAdapter
        }

    }

}