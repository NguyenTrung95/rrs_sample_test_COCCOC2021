package com.coccoc.rssreader.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.coccoc.rssreader.model.FeedType
import com.coccoc.rssreader.ui.PostsListFragment

/**
 * @author nguyentrung
 * @since 06.03.2020
 */
class FeedsPagerAdapter(
        fragment: Fragment,
        private val feedTypes: List<FeedType>
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return feedTypes.count()
    }

    override fun createFragment(position: Int): Fragment {
        return PostsListFragment.create(feedTypes[position])
    }
}
