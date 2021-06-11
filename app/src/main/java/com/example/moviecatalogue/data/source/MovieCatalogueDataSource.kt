package com.example.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviecatalogue.data.source.local.entity.MovieEntity
import com.example.moviecatalogue.data.source.local.entity.TvShowEntity
import com.example.moviecatalogue.vo.Resource

interface MovieCatalogueDataSource {

    fun getAllMovies(): LiveData<Resource<List<MovieEntity>>>

    fun getAllTvShows(): LiveData<Resource<List<TvShowEntity>>>

    fun getMovieDetails(movieId: MutableLiveData<String>): LiveData<MovieEntity>

    fun getTvShowDetails(tvShowId: String): LiveData<TvShowEntity>

    fun getFavoritedMovies(): LiveData<List<MovieEntity>>

    fun getFavoritedTvShows(): LiveData<List<TvShowEntity>>

    fun setMovieFavorite(movie: MovieEntity, state: Boolean)

    fun setTvShowFavorite(tvShow: TvShowEntity, state: Boolean)
    fun getMovieDetails(movieId: String): LiveData<MovieEntity>
}