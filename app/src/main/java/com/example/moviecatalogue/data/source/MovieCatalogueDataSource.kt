package com.example.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.example.moviecatalogue.data.source.local.entity.MovieEntity
import com.example.moviecatalogue.data.source.local.entity.TvShowEntity
import com.example.moviecatalogue.vo.Resource

interface MovieCatalogueDataSource {

    fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getAllTvShows(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getMovieDetails(movieId: String): LiveData<MovieEntity>

    fun getTvShowDetails(tvShowId: String): LiveData<TvShowEntity>

    fun getFavoritedMovies(): LiveData<PagedList<MovieEntity>>

    fun getFavoritedTvShows(): LiveData<PagedList<TvShowEntity>>

    fun setMovieFavorite(movie: MovieEntity)

    fun setTvShowFavorite(tvShow: TvShowEntity)

}