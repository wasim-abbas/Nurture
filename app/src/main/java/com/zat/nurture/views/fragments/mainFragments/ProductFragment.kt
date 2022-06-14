package com.zat.nurture.views.fragments.mainFragments

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.zat.nurture.R
import com.zat.nurture.base.BaseFragment
import com.zat.nurture.models.allProductmodels.AllProductData
import com.zat.nurture.models.categoriesModels.CategoryData
import com.zat.nurture.utils.*
import com.zat.nurture.viewModels.ProductViewModel
import com.zat.nurture.views.adapters.ProductAdapter
import kotlinx.android.synthetic.main.fragment_product.*


class ProductFragment : BaseFragment<ProductViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_product
    override val viewModelClass: Class<ProductViewModel>
        get() = ProductViewModel::class.java

    private lateinit var productAdapter: ProductAdapter
    private var categoryId = 0

    override fun observeLiveData() {
        with(viewModel) {
            errorLiveData.observe(viewLifecycleOwner) {
                hideLoadingBar()
                showToast(it)
            }
            allProductsLiveData.observe(viewLifecycleOwner) {
                hideLoadingBar()
                it.data?.let { productList ->
                    productAdapter.updateData(productList as ArrayList<AllProductData>)
                }
            }

            categoryLiveData.observe(viewLifecycleOwner) {
                hideLoadingBar()
                it.data?.let { category ->
                    var categoriesList = category
                    showCategorySpinner(categoriesList as ArrayList<CategoryData>)
                }
            }

            allProductsLiveData.observe(viewLifecycleOwner) {
                hideLoadingBar()
                it.data.let { prodList ->
                    productAdapter.updateData(prodList as ArrayList<AllProductData>)

                }

            }
        }
    }

    override fun init() {

        showLoadingBar()
        viewModel.getAllProducts()
        viewModel.getCategory()

        productAdapter = ProductAdapter(currentActivity()) { id ->
            val bundle = Bundle()
            bundle.putInt(PRODUCT_ID, id)
            currentActivity().replaceMainFragment(
                R.id.action_productFragment2_to_productDetailFragment, bundle
            )
        }

        // productAdapter.updateData(dummyList)
        rvProduct.let {
            it.adapter = productAdapter
        }


        txtBack.singleClick {
            currentActivity().onBackPressed()
        }

    }


    private fun showCategorySpinner(categoriesList: ArrayList<CategoryData>) {

        val list = ArrayList<String>()
        list.clear()
        list.add("Select Category")
        for (i in categoriesList) {
            list.add(i.name!!)
        }


        val adapter = ArrayAdapter<String>(currentActivity(), R.layout.spinner_list_main, list)
        adapter.setDropDownViewResource(R.layout.spinner_list_item)
        txtSpinnerCategory.adapter = adapter

//        txtSpinnerCategory.adapter = ArrayAdapter<String>(
//            currentActivity(), R.layout.spinner_list_main, list
//        )
//        txtSpinnerCategory.adapter = ArrayAdapter<String>(
//            currentActivity(),R.layout.spinner_list_item,list
//        )

        txtSpinnerCategory.isSelected = false
        txtSpinnerCategory.setSelection(0, true)
        txtSpinnerCategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {}

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {

                if (position == 0) {
                    txtAllProd.text = "All Products"
                } else {
                    categoryId = categoriesList[(position - 1)].id!!
                    txtAllProd.text = categoriesList[(position-1)].name
                    showLoadingBar()
                    viewModel.getbyCategory(categoryId)
                }
            }

        }

    }


    private fun getColoredSpanned(text: String, color: String): String? {
        return "<font color=$color>$text</font>"
    }

}