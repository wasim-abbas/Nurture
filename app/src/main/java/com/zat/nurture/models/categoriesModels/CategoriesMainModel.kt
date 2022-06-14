package com.zat.nurture.models.categoriesModels

data class CategoriesMainModel(
    var `data`: List<CategoryData>?,
    var message: String?,
    var status: Int?,
    var success: Boolean?
)