package com.zat.nurture.models.allProductmodels

data class AllProductsMainModel(
    var `data`: List<AllProductData>?,
    var message: String?,
    var status: Int?,
    var success: Boolean?
)