package com.zat.nurture.models.registerModeld

data class RegisterMainModel(
    var `data`: RegisterData?,
    var message: String?,
    var status: Int?,
    var success: Boolean?,
    var error: ArrayList<String>?
)