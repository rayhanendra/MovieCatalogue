package com.example.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.example.moviecatalogue.data.source.local.entity.MovieEntity
import com.example.moviecatalogue.data.source.local.entity.TvShowEntity
import com.example.moviecatalogue.data.source.local.room.MovieCatalogueDao

class LocalDataSource private constructor(private val mMovieCatalogueDao: MovieCatalogueDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieCatalogueDao: MovieCatalogueDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieCatalogueDao)
    }

    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = mMovieCatalogueDao.getMovies()
    fun getAllTvShows(): DataSource.Factory<Int, TvShowEntity> = mMovieCatalogueDao.getTvShows()

    fun getMovieDetails(movieId: String): LiveData<MovieEntity> = mMovieCatalogueDao.getMovieDetails(movieId)
    fun getTvShowDetails(tvShowId: String): LiveData<TvShowEntity> = mMovieCatalogueDao.getTvShowDetails(tvShowId)

    fun getFavoritedMovies(): DataSource.Factory<Int, MovieEntity> = mMovieCatalogueDao.getFavoritedMovie()
    fun getFavoritedTvShows(): DataSource.Factory<Int, TvShowEntity> = mMovieCatalogueDao.getFavoritedTvShow()

    fun insertMovies(movies: List<MovieEntity>) = mMovieCatalogueDao.insertMovies(movies)
    fun insertTvShows(tvShows: List<TvShowEntity>) = mMovieCatalogueDao.insertTvShows(tvShows)

    fun setMovieFavorite(movie: MovieEntity) {
        movie.favorited = !movie.favorited
        mMovieCatalogueDao.updateMovie(movie)
    }

    fun setTvShowFavorite(tvShow: TvShowEntity) {
        tvShow.favorited = !tvShow.favorited
        mMovieCatalogueDao.updateTvShow(tvShow)
    }

}