package com.coccoc.rssreader.viewmodels

import androidx.lifecycle.ViewModel
import com.coccoc.rssreader.model.FeedType

/**
 * @author nguyentrung
 * @since 06.03.2020
 */
class FeedsViewModel : ViewModel() {

    val feedTypes: List<FeedType> = FeedType.values().toList()
}
