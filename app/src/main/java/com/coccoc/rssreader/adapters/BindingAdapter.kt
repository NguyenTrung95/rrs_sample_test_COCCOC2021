package com.coccoc.rssreader.adapters

import android.text.format.DateUtils
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import com.coccoc.rssreader.model.HabrPost

/**
 * @author nguyentrung
 * @since 02.01.2021
 */
@BindingAdapter("postTitle")
fun TextView.setPostTitle(habrPost: HabrPost?) {
    text = HtmlCompat.fromHtml(
            habrPost?.title ?: "",
            HtmlCompat.FROM_HTML_MODE_LEGACY
    ).toString()
}

@BindingAdapter("postDescription")
fun TextView.setPostDescription(habrPost: HabrPost?) {
    text = HtmlCompat.fromHtml(
                    habrPost?.description ?: "",
                    HtmlCompat.FROM_HTML_MODE_LEGACY
            ).toString()
            .replace("￼", "")
            .lines()
            .filter { !it.contains("→") }
            .joinToString(separator = "\n")
            .trim()
            .replace("""\n{3,}""".toRegex(), "\n\n")
}

@BindingAdapter("pubDate")
fun TextView.setPubDate(habrPost: HabrPost?) {
    text = DateUtils.getRelativeTimeSpanString(
            habrPost?.getPubDateMillis() ?: System.currentTimeMillis(),
            System.currentTimeMillis(),
            0
    )
}
