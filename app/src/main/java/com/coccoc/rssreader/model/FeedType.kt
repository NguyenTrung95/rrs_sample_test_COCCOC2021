package com.coccoc.rssreader.model

import com.coccoc.rssreader.R
import com.coccoc.rssreader.repository.HabrRssRepository
import com.coccoc.rssreader.util.Result

/**
 * @author nguyentrung
 * @since 02.01.2021
 */
enum class FeedType(val feedTitleResId: Int) {

    BEST_DAILY(R.string.feed_type_best_daily) {
        override suspend fun getHabrFeed(habrRssRepository: HabrRssRepository): Result<HabrFeed> {
            return habrRssRepository.getBestDaily()
        }
    },

    ;

    abstract suspend fun getHabrFeed(habrRssRepository: HabrRssRepository): Result<HabrFeed>
}
