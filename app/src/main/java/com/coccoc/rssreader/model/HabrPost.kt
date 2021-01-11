package com.coccoc.rssreader.model

import android.os.Parcelable
import com.coccoc.rssreader.util.getDateFormat
import com.coccoc.rssreader.util.parseHabrDate
import kotlinx.android.parcel.Parcelize

/**
 * @author nguyentrung
 * @since 02.01.2021
 */
@Parcelize
data class HabrPost(
        var guid: String = "",
        var title: String = "",
        var description: String = "",
        var link: String = "",
        var pubDate: String = "",
        var categories: MutableList<String> = mutableListOf()
) : Parcelable {

    fun getPubDateMillis(): Long {
        return parseHabrDate(pubDate)
    }

    fun getDate() : String{
        return getDateFormat(getPubDateMillis())
    }
}
