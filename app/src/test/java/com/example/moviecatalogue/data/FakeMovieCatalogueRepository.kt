package com.example.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviecatalogue.data.source.MovieCatalogueDataSource
import com.example.moviecatalogue.data.source.local.entity.MovieEntity
import com.example.moviecatalogue.data.source.local.entity.TvShowEntity
import com.example.moviecatalogue.data.source.remote.RemoteDataSource
import com.example.moviecatalogue.data.source.remote.response.MovieResponse
import com.example.moviecatalogue.data.source.remote.response.TvShowResponse

class FakeMovieCatalogueRepository (private val remoteDataSource: RemoteDataSource) : MovieCatalogueDataSource {

    override fun getAllMovies(): LiveData<List<MovieEntity>> {
        val movieResults = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(movieResponses: List<MovieResponse>) {
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
                movieResults.postValue(movieList)
            }
        })
        return movieResults
    }

    override fun getAllTvShows(): LiveData<List<TvShowEntity>> {
        val tvShowResults = MutableLiveData<List<TvShowEntity>>()
        remoteDataSource.getAllTvShows( object : RemoteDataSource.LoadTvShowsCallback {
            override fun onAllTvShowsReceived(tvShowResponses: List<TvShowResponse>) {
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
                tvShowResults.postValue(tvShowList)
            }
        })
        return tvShowResults
    }

    fun getMovieDetails(movieId: MutableLiveData<String>): LiveData<MovieEntity> {
        val movieResult = MutableLiveData<MovieEntity>()
        remoteDataSource.getMovieDetails(movieId, object : RemoteDataSource.LoadMovieDetailsCallback {
            override fun onMovieDetailsReceived(movieResponses: List<MovieResponse>) {
                lateinit var movie: MovieEntity
                for (response in movieResponses) {
                    if (response.movieId == movieId) {
                        movie = MovieEntity(response.movieId,
                            response.title,
                            response.description,
                            response.genre,
                            response.rating,
                            response.imagePath)
                    }
                }
                movieResult.postValue(movie)
            }
        })
        return movieResult
    }

    fun getTvShowDetails(tvShowId: String): LiveData<TvShowEntity> {
        val tvShowResult = MutableLiveData<TvShowEntity>()
        remoteDataSource.getTvShowDetails(tvShowId, object : RemoteDataSource.LoadTvShowDetailsCallback {
            override fun onTvShowDetailsReceived(tvShowResponses: List<TvShowResponse>) {
                lateinit var tvShow: TvShowEntity
                for (response in tvShowResponses) {
                    if (response.tvShowId == tvShowId) {
                        tvShow = TvShowEntity(response.tvShowId,
                            response.title,
                            response.description,
                            response.genre,
                            response.rating,
                            response.imagePath)
                    }
                }
                tvShowResult.postValue(tvShow)
            }
        })
        return tvShowResult
    }

}