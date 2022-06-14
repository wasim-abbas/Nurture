package com.zat.nurture.views.adapters

import android.content.Context
import android.view.View
import com.zat.nurture.R
import com.zat.nurture.base.BaseAdapter
import com.zat.nurture.base.BaseViewHolder
import com.zat.nurture.utils.singleClick

class HistoryAdapter(var context: Context, var onClick: (String) -> Unit) :
    BaseAdapter<HistoryAdapter.HistoryViewHolder, String>() {

    class HistoryViewHolder(itemView: View) : BaseViewHolder(itemView) {}

    override val layoutId: Int
        get() = R.layout.item_view_history

    override fun setData(holder: HistoryViewHolder, model: String, position: Int) {
        var view = holder.itemView

        view.singleClick {
            onClick(model)
        }
    }

}