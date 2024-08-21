package com.vergil.mvvmlazy.binding.viewadapter.webview

import android.text.TextUtils
import androidx.databinding.BindingAdapter
import android.webkit.WebView

object ViewAdapter {
    @JvmStatic
    @BindingAdapter("render")
    fun loadHtml(webView: WebView, html: String?) {
        if (!TextUtils.isEmpty(html)) {
            webView.loadDataWithBaseURL(null, html!!, "text/html", "UTF-8", null)
        }
    }
}