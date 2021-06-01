package com.example.moviecatalogue.data.source

import com.example.moviecatalogue.data.MovieEntity
import com.example.moviecatalogue.data.TvShowEntity
import com.example.moviecatalogue.data.source.remote.RemoteDataSource

class MovieCatalogueRepository private constructor(private val remoteDataSource: RemoteDataSource) : MovieCatalogueDataSource {

    companion object {
        @Volatile
        private var instance: MovieCatalogueRepository? = null

        fun getInstance(remoteData: RemoteDataSource): MovieCatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: MovieCatalogueRepository(remoteData).apply { instance = this }
            }
    }

    override fun getAllMovies(): ArrayList<MovieEntity> {
        val movieResponses = remoteDataSource.getAllMovies()
        val movieList = ArrayList<MovieEntity>()
        for (response in movieResponses) {
            val movie = MovieEntity(response.movieId,
                response.title,
                response.description,
                response.genre,
                response.rating,
                response.imagePath)
            movieList.add(movie)
        }
        return movieList
    }

    override fun getAllTvShows(): List<TvShowEntity> {
        val tvShowResponses = remoteDataSource.getAllTvShows()
        val tvShowList = ArrayList<TvShowEntity>()
        for (response in tvShowResponses) {
            val tvShow = TvShowEntity(response.tvShowId,
                response.title,
                response.description,
                response.genre,
                response.rating,
                response.imagePath)
            tvShowList.add(tvShow)
        }
        return tvShowList
    }

}