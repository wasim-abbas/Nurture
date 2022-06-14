package com.zat.nurture.models

data class SimpleMessageModel(
        var message: String?,
        var status: Int?,
        var success:Boolean?,
        var errors: ArrayList<String>?

)