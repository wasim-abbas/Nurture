package com.zat.fryp.models.loginModels

import com.zat.nurture.models.loginModels.LoginUser

data class LoginData(
    var token: String?,
    var user: LoginUser?
)