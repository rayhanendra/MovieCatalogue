package com.example.moviecatalogue.ui.tvshow.detailtvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.data.MovieEntity
import com.example.moviecatalogue.data.TvShowEntity
import com.example.moviecatalogue.data.source.MovieCatalogueRepository
import com.example.moviecatalogue.utils.DataDummy

class DetailTvShowViewModel (private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {
    private lateinit var tvShowId: String

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId = tvShowId
    }

    fun getTvShow(): LiveData<TvShowEntity> = movieCatalogueRepository.getTvShowDetails(tvShowId)

//    fun getTvShow(): TvShowEntity {
//        lateinit var tvShow: TvShowEntity
//        val tvShowEntities = DataDummy.generateDummyTvShows()
//        for (tvShowEntity in tvShowEntities) {
//            if (tvShowEntity.tvShowId == tvShowId) {
//                tvShow = tvShowEntity
//            }
//        }
//        return tvShow
//    }
}