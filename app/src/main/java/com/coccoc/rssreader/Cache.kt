package com.coccoc.rssreader

import com.coccoc.rssreader.model.FeedType
import com.coccoc.rssreader.model.HabrFeed

/**
 * @author nguyentrung
 * @since 02.01.2021
 */
object Cache {

    private val feeds: MutableMap<FeedType, HabrFeed> = mutableMapOf()

    fun addFeedToCache(feedType: FeedType, habrFeed: HabrFeed) {
        feeds[feedType] = habrFeed
    }

    fun getFeedFromCache(feedType: FeedType): HabrFeed? {
        return feeds[feedType]
    }
}
