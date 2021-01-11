package com.coccoc.rssreader.repository

import com.coccoc.rssreader.model.HabrFeed
import com.coccoc.rssreader.model.rss.convertToHabrFeed
import com.coccoc.rssreader.network.HabrRssApi
import com.coccoc.rssreader.util.Result

/**
 * @author nguyentrung
 * @since 02.01.2021
 */
class HabrRssRepository(private val api: HabrRssApi) : BaseRepository() {

    suspend fun getBestDaily(): Result<HabrFeed> {
        return safeApiCall(converter = {it.convertToHabrFeed()}) {
            api.getBestDaily()
        }
    }


}
