package com.coccoc.rssreader.network

import com.coccoc.rssreader.model.rss.RssFeed
import retrofit2.Response
import retrofit2.http.GET

/**
 * @author nguyentrung
 * @since 02.01.2021
 */
interface HabrRssApi {

    @GET("tin-moi-nhat.rss")
    suspend fun getBestDaily(): Response<RssFeed>

}
