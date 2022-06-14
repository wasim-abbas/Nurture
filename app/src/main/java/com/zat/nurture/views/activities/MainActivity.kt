package com.zat.nurture.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.zat.nurture.R
import com.zat.nurture.base.BaseActivity
import com.zat.nurture.utils.gone
import com.zat.nurture.utils.visible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = Navigation.findNavController(
            this,
            R.id.navMainHomeFrag // name of nav graph
        )


        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.homeFragment ||
                destination.id == R.id.historyFragment ||
                destination.id == R.id.productFragment2 ||
                destination.id == R.id.settingFragment ||
                destination.id == R.id.captureNailsTestingFragment
            ) {
                bottom_Navigation.visible()
            } else {

                bottom_Navigation.gone()
            }
        }

        NavigationUI.setupWithNavController(bottom_Navigation, navController)

    }

    override fun attachViewMode() {

    }
}