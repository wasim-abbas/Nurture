package com.zat.nurture.views.activities

import android.content.Intent
import android.os.Bundle
import com.zat.nurture.R
import com.zat.nurture.base.BaseActivity
import com.zat.nurture.utils.singleClick
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        MainScope().launch {
            delay(3000)
            startActivity(Intent(this@SplashActivity,BoardingActivity::class.java))
            finish()
        }
//        imgViewLogo.singleClick {
//            startActivity(Intent(this,BoardingActivity::class.java))
//            finish()
//        }

    }

    override fun attachViewMode() {

    }
}