package com.zat.nurture.utils.source

import android.app.AlertDialog
import android.content.Context
import com.zat.fryp.models.loginModels.LoginData
import io.paperdb.Paper

const val ACCESS_TOEKN = "ACCESS_TOEKN"
const val USER = "USER"
const val FIRST_TIME = "FIRST_TIME"
const val FIREBASE_TOKEN = "firebase_token"
const val FCM = "fcm"



fun setFirstTime(first_time: Boolean) {
    Paper.book(FIRST_TIME).write("first_time", first_time)
}


fun isFirstTime(): Boolean {
    val keys =
            Paper.book(FIRST_TIME).allKeys
    if (keys.size == 0) return true
    return Paper.book(FIRST_TIME).read("first_time")
}

fun addAccessToken(token: String?) {
    Paper.book(ACCESS_TOEKN).write("token", token)
}


fun getAccessToken(): String? {
    val keys =
            Paper.book(ACCESS_TOEKN).allKeys
    if (keys.size == 0) return null
    return Paper.book(ACCESS_TOEKN)?.read("token")
}


fun deleteAccessToken() {
    Paper.book(ACCESS_TOEKN).delete("token")
}

fun addUser(loginData: LoginData) {
    Paper.book(USER).write("loginUser", loginData)
}

fun deleteUser() {
    Paper.book(USER).delete("loginUser")
}

fun getUser(): LoginData? {
    val keys =
        Paper.book(USER).allKeys
    if (keys.size == 0) return null
    return Paper.book(USER)?.read("loginUser")
}

fun setFCMToken(token: String) {
    Paper.book(FIREBASE_TOKEN).write(FCM, token)
}

fun getFCMToken(): String? {
    val keys =
            Paper.book(FIREBASE_TOKEN).allKeys
    if (keys.size == 0) return ""
    return Paper.book(FIREBASE_TOKEN).read(FCM)
}


fun confirmationDialog(context: Context, title: String, message: String, okClick: () -> Unit) {
    AlertDialog.Builder(context)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton(
            android.R.string.ok
        ) { dialog, _ ->
            dialog.dismiss()
            okClick()
        }
        .show()
}




