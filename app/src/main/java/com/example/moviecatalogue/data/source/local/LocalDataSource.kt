package com.example.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import com.example.moviecatalogue.data.source.local.entity.MovieEntity
import com.example.moviecatalogue.data.source.local.entity.TvShowEntity
import com.example.moviecatalogue.data.source.local.room.MovieCatalogueDao

class LocalDataSource private constructor(private val mMovieCatalogueDao: MovieCatalogueDao) {

    fun getAllMovies(): LiveData<List<MovieEntity>> = mMovieCatalogueDao.getMovies()
    fun getAllTvShows(): LiveData<List<TvShowEntity>> = mMovieCatalogueDao.getTvShows()

    fun getMovieDetails(movieId: String): LiveData<MovieEntity> = mMovieCatalogueDao.getMovieDetails(movieId)
    fun getTvShowDetails(tvShowId: String): LiveData<TvShowEntity> = mMovieCatalogueDao.getTvShowDetails(tvShowId)

    fun getFavoritedMovies(): LiveData<List<MovieEntity>> = mMovieCatalogueDao.getFavoritedMovie()
    fun getFavoritedTvShows(): LiveData<List<TvShowEntity>> = mMovieCatalogueDao.getFavoritedTvShow()

    fun insertMovies(movies: List<MovieEntity>) = mMovieCatalogueDao.insertMovies(movies)
    fun insertTvShows(tvShows: List<TvShowEntity>) = mMovieCatalogueDao.insertTvShows(tvShows)

    fun setMovieFavorite(movie: MovieEntity, newState: Boolean) {
        movie.favorited = newState
        mMovieCatalogueDao.updateMovie(movie)
    }

    fun setTvShowFavorite(tvShows: TvShowEntity, newState: Boolean) {
        tvShows.favorited = newState
        mMovieCatalogueDao.updateTvShow(tvShows)
    }

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieCatalogueDao: MovieCatalogueDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieCatalogueDao)
    }
}