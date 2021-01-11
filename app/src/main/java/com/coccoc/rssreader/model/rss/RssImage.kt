package com.coccoc.rssreader.model.rss

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

/**
 * @author nguyentrung
 * @since 02.01.2021
 */
@Root(name = "image", strict = false)
data class RssImage(

        @field:Element
        var title: String = "",

        @field:Element
        var url: String = "",

        @field:Element
        var link: String = ""
)
