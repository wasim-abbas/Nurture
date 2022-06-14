package com.zat.nurture.models.loginModels

import com.zat.fryp.models.loginModels.LoginData

data class LoginMainModel(
    var `data`: LoginData?,
    var message: String?,
    var status: Int?,
    var success: Boolean?,
    var errors: ArrayList<String>?
)