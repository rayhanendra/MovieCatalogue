package com.example.moviecatalogue.ui.tvshow.favorited

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.moviecatalogue.data.source.MovieCatalogueRepository
import com.example.moviecatalogue.data.source.local.entity.TvShowEntity

class TvShowFavoritedViewModel(private val movieCatalogueRepository: MovieCatalogueRepository): ViewModel() {
    fun getTvShows(): LiveData<PagedList<TvShowEntity>> = movieCatalogueRepository.getFavoritedTvShows()
}