package com.coccoc.rssreader.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author nguyentrung
 * @since 02.01.2021
 */
@Parcelize
data class HabrFeed(
        var channel: HabrChannel = HabrChannel(),
        var posts: MutableList<HabrPost> = mutableListOf()
) : Parcelable
