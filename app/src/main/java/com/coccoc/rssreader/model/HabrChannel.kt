package com.coccoc.rssreader.model

import android.os.Parcelable
import android.webkit.URLUtil
import kotlinx.android.parcel.Parcelize

/**
 * @author nguyentrung
 * @since 02.01.2021
 */
@Parcelize
data class HabrChannel(
        var title: String = "",
        var link: String = "",
        var imageTitle: String = "",
        var imageUrl: String = "",
        var imageLink: String = ""
) : Parcelable {

    fun isValid(): Boolean {
        return URLUtil.isValidUrl(link)
    }
}
