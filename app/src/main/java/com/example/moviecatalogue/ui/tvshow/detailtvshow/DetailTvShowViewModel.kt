package com.example.moviecatalogue.ui.tvshow.detailtvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.data.source.local.entity.TvShowEntity
import com.example.moviecatalogue.data.source.MovieCatalogueRepository

class DetailTvShowViewModel (private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {
    private lateinit var tvShowId: String

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId = tvShowId
    }

    fun getTvShow(): LiveData<TvShowEntity> = movieCatalogueRepository.getTvShowDetails(tvShowId)

}