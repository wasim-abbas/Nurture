package com.zat.nurture.views.activities

import android.graphics.Bitmap
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.*
import android.widget.SearchView
import androidx.annotation.RequiresApi
import com.zat.nurture.R
import com.zat.nurture.utils.WEB_URL
import com.zat.nurture.utils.gone
import com.zat.nurture.utils.singleClick
import com.zat.nurture.utils.visible
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {
    var url: String = "https://www.google.com/"

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        llNoInterNet.gone()
        val bundle = intent.extras
        url = bundle?.getString(WEB_URL).toString()
        webViewSetup()
        txtReload.singleClick {
            mywebView.reload()
        }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSetup() {
        mywebView.webViewClient = object : WebViewClient() {
//            override fun onPageFinished(view: WebView?, url: String?) {
//
//            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                mywebView.visible()
                llNoInterNet.gone()
            }

            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                super.onReceivedError(view, request, error)
                view?.gone()
                llNoInterNet.visible()
            }
        }

        mywebView.settings.javaScriptEnabled = true
        mywebView.settings.safeBrowsingEnabled = true
        mywebView.loadUrl(url)
    }
}