package com.news.mvcnewsapp.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import androidx.databinding.DataBindingUtil
import com.news.mvcnewsapp.R
import com.news.mvcnewsapp.databinding.ActivityFullBinding
import com.news.mvcnewsapp.databinding.ActivityWebBinding

class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        var binding : ActivityWebBinding = DataBindingUtil.setContentView(this, com.news.mvcnewsapp.R.layout.activity_web)

        var i = intent
        var url = i.getStringExtra("url")
        Log.d("ugug", i.getStringExtra("url"))

        val webSettings = binding.webview!!.settings
        webSettings.javaScriptEnabled = true
        webSettings.builtInZoomControls = true
        binding.webview.loadUrl(url)


    }
}
