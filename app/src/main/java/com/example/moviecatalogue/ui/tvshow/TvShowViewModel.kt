package com.example.moviecatalogue.ui.tvshow

import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.data.TvShowEntity
import com.example.moviecatalogue.utils.DataDummy

class TvShowViewModel : ViewModel() {
    fun getTvShows(): List<TvShowEntity> = DataDummy.generateDummyTvShows()
}