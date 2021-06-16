package com.example.moviecatalogue.ui.menu.ui.favorited

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.moviecatalogue.R
import com.example.moviecatalogue.ui.movie.favorited.MovieFavoritedFragment
import com.example.moviecatalogue.ui.tvshow.favorited.TvShowFavoritedFragment

class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movies, R.string.tv_shows)
    }

    override fun getItem(position: Int): Fragment =
        when(position) {
            0 -> MovieFavoritedFragment()
            1 -> TvShowFavoritedFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence = mContext.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int  = TAB_TITLES.size

}