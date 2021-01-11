package com.coccoc.rssreader.ui

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.webkit.WebSettingsCompat
import androidx.webkit.WebViewFeature
import com.coccoc.rssreader.R
import com.coccoc.rssreader.databinding.FragmentWebviewBinding
import com.coccoc.rssreader.util.URL_KEY

/**
 * @author nguyentrung
 * @since 06.03.2020
 */
class WebviewFragment : Fragment() {

    private lateinit var binding: FragmentWebviewBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_webview, container, false)
        binding.lifecycleOwner = this


        arguments?.getString(URL_KEY)?.let {
            binding.wvContent.loadUrl(it)

            binding.loadingProgressBar.visibility = View.VISIBLE

            binding.wvContent.settings.javaScriptEnabled = true
            binding.wvContent.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                    view?.loadUrl(url)
                    return true
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    binding.loadingProgressBar.visibility = View.GONE
                    super.onPageFinished(view, url)
                }
            }


        }

        val  nightModeFlags =
                context?.resources?.configuration?.uiMode
        when (nightModeFlags) {
            17 -> {
                if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
                    WebSettingsCompat.setForceDark(binding.wvContent.settings, WebSettingsCompat.FORCE_DARK_OFF)
                }
            }

            33 -> {
                if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
                    WebSettingsCompat.setForceDark(binding.wvContent.settings, WebSettingsCompat.FORCE_DARK_ON)
                }
            }

            Configuration.UI_MODE_NIGHT_UNDEFINED -> {
                if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
                    WebSettingsCompat.setForceDark(binding.wvContent.settings, WebSettingsCompat.FORCE_DARK_OFF)
                }
            }


        }


        return binding.root
    }
}
