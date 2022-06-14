package com.zat.nurture.base

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.kaopiz.kprogresshud.KProgressHUD
import com.zat.nurture.R

abstract class BaseActivity: AppCompatActivity() {


    var progressBar: KProgressHUD? = null

    private lateinit var options: NavOptions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        progressBar = KProgressHUD.create(this)
            .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
            .setCancellable(true)
            .setBackgroundColor(Color.TRANSPARENT)
            .setAnimationSpeed(1)
            .setDimAmount(0.5f)

        options = NavOptions.Builder()
            .setLaunchSingleTop(true)
            .setEnterAnim(R.anim.fade_in)
            .setExitAnim(R.anim.fade_out)
            .setPopEnterAnim(R.anim.fade_in)
            .setPopExitAnim(R.anim.fade_out)
            .build()

    }


    fun showLoadingBar() {
        progressBar?.show()
    }

    fun hideLoadingBar() {
        progressBar?.dismiss()
    }

    abstract fun attachViewMode()

    fun replaceMainFragment(action: Int) {
        Navigation.findNavController(this, R.id.navMainHomeFrag).navigate(action, null, options)
    }

    fun replaceMainFragment(action: Int, bundle: Bundle) {
        Navigation.findNavController(this, R.id.navMainHomeFrag)
            .navigate(action, bundle, options)
    }

    //
//    fun replaceAndRemoveMainFragment(action1: Int, action2: Int, bundle: Bundle? = null) {
//        Navigation.findNavController(this, R.id.navMainHostFragment).popBackStack(action1, true)
//        Navigation.findNavController(this, R.id.navMainHostFragment)
//            .navigate(action2, bundle, options)
//
//    }
//
    fun replaceFragmentBoarding(action: Int) {
        Navigation.findNavController(this, R.id.boarding_homeFragment).navigate(action, null, options)
    }

    //    fun replaceFragmentInAuth(action: Int, bundle: Bundle) {
//        Navigation.findNavController(this, R.id.authHostFragment).navigate(action, bundle, options)
//    }
//
//    fun replaceAndRemoveFragmentInAuth(action1: Int, action2: Int, bundle: Bundle? = null) {
//        Navigation.findNavController(this, R.id.authFragment).popBackStack(action1, true)
//        Navigation.findNavController(this, R.id.authFragment).navigate(action2, bundle, options)
//
//    }

//    fun replaceFragmentInBoarding(action: Int) {
//        Navigation.findNavController(this, R.id.boardingHostFragment)
//            .navigate(action, null, options)
//    }
//
//    fun replaceFragmentInNPO(action: Int) {
//        Navigation.findNavController(this, R.id.npoHostFragment).navigate(action, null, options)
//    }
//
//    fun replaceFragmentInNPO(action: Int, bundle: Bundle) {
//        Navigation.findNavController(this, R.id.npoHostFragment).navigate(action, bundle, options)
//    }
//
//    fun replaceAndRemoveFragmentInNPO(action1: Int, action2: Int, bundle: Bundle? = null) {
//        Navigation.findNavController(this, R.id.npoHostFragment).popBackStack(action1, true)
//        Navigation.findNavController(this, R.id.npoHostFragment).navigate(action2, bundle, options)
//    }


    fun showToast(message: String?) {
        message?.let {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        } ?: kotlin.run {
            Toast.makeText(this, getString(R.string.something_went_wrong), Toast.LENGTH_SHORT)
                .show()
        }

    }
}