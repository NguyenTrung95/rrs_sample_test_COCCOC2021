package com.coccoc.rssreader.network

import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

/**
 * @author nguyentrung
 * @since 02.01.2021
 */
object ApiFactory {

    private const val HABR_RSS_BASE_URL = "https://vnexpress.net/rss/"

    val habrRssApi: HabrRssApi = retrofit().create(HabrRssApi::class.java)

    private fun retrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(HABR_RSS_BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build()
    }
}
