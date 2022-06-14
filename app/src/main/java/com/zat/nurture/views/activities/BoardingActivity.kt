package com.zat.nurture.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.zat.nurture.R
import com.zat.nurture.base.BaseActivity

class BoardingActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boarding)
    }

    override fun attachViewMode() {
    }
}