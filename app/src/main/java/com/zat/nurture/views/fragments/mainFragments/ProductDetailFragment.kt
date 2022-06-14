package com.zat.nurture.views.fragments.mainFragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.zat.nurture.R
import com.zat.nurture.base.BaseFragment
import com.zat.nurture.utils.IMAGE_BASE_URL
import com.zat.nurture.utils.PRODUCT_ID
import com.zat.nurture.utils.WEB_URL
import com.zat.nurture.utils.singleClick
import com.zat.nurture.viewModels.AuthViewModel
import com.zat.nurture.viewModels.BaseViewModel
import com.zat.nurture.viewModels.ProductViewModel
import com.zat.nurture.views.activities.WebActivity
import kotlinx.android.synthetic.main.fragment_product_detail.*
import kotlinx.android.synthetic.main.item_view_medicine.view.*


class ProductDetailFragment : BaseFragment<ProductViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_product_detail
    override val viewModelClass: Class<ProductViewModel>
        get() = ProductViewModel::class.java

    override fun observeLiveData() {

        with(viewModel) {
            errorLiveData.observe(viewLifecycleOwner) {
                hideLoadingBar()
                showToast(it)
            }

            getProductByIdLiveData.observe(viewLifecycleOwner) {
                hideLoadingBar()
                it.data.let { productData ->
                    productData?.img_url.let { img ->
                        Glide.with(currentActivity()).load(IMAGE_BASE_URL + img)
                            .into(txtMedicineImage)
                    } ?: kotlin.run {
                        Glide.with(currentActivity()).load(R.drawable.syrup).into(txtMedicineImage)
                    }

                    txtMedicineName.text = productData!!.name
                    txtLink.text = productData.link
                    txtMedicineDes.text = productData.description


                }
            }
        }
    }

    override fun init() {
        val product_id = getIntArgument(PRODUCT_ID)

        showLoadingBar()
        viewModel.getProductbyID(product_id!!)

        txtBack.singleClick {
            currentActivity().onBackPressed()
        }
        txtLink.singleClick {
            val intent = Intent(currentActivity(), WebActivity::class.java)
            intent.putExtra(WEB_URL, txtLink.text)
            startActivity(intent)
        }
    }

}