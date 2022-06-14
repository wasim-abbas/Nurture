package com.zat.nurture.views.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.zat.nurture.R
import com.zat.nurture.base.BaseAdapter
import com.zat.nurture.base.BaseViewHolder
import com.zat.nurture.models.allProductmodels.AllProductData
import com.zat.nurture.utils.IMAGE_BASE_URL
import com.zat.nurture.utils.singleClick
import kotlinx.android.synthetic.main.item_view_medicine.view.*

class ProductAdapter(var context:Context, var onClick: (Int) -> Unit) :
    BaseAdapter<ProductAdapter.ProductViewHolder, AllProductData>() {

    class ProductViewHolder(itemView: View) : BaseViewHolder(itemView) {}

    override val layoutId: Int
        get() = R.layout.item_view_medicine


    override fun setData(holder: ProductViewHolder, model: AllProductData, position: Int) {
        var view = holder.itemView

        model.img_url?.let { img->
            Glide.with(context).load(IMAGE_BASE_URL+img).into(view.imgMedicineImage)
        }?:kotlin.run {
            Glide.with(context).load(R.drawable.syrup).into(view.imgMedicineImage)
        }
        view.txtMedicineName.text = model.name
        view.txtMedicineDes.text = model.description


        view.singleClick {
            onClick(model.id!!)
        }
    }


}