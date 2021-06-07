package com.example.moviecatalogue.data.source.remote

import android.os.Handler
import android.os.Looper
import com.example.moviecatalogue.data.source.remote.response.MovieResponse
import com.example.moviecatalogue.data.source.remote.response.TvShowResponse
import com.example.moviecatalogue.utils.EspressoIdlingResource
import com.example.moviecatalogue.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun getAllMovies(callback: LoadMoviesCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllMoviesReceived(jsonHelper.loadMovies())
            EspressoIdlingResource.decrement()
            }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getAllTvShows(callback: LoadTvShowsCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllTvShowsReceived(jsonHelper.loadTvShows())
            EspressoIdlingResource.decrement()
            }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getMovieDetails(movieId: String, callback: LoadMovieDetailsCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onMovieDetailsReceived(jsonHelper.loadMovieDetails(movieId))
            EspressoIdlingResource.decrement()
            }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getTvShowDetails(tvShowId: String, callback: LoadTvShowDetailsCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onTvShowDetailsReceived(jsonHelper.loadTvShowsDetails(tvShowId))
            EspressoIdlingResource.decrement()
            }, SERVICE_LATENCY_IN_MILLIS)
    }

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(movieResponses: List<MovieResponse>)
    }

    interface LoadTvShowsCallback {
        fun onAllTvShowsReceived(tvShowResponses: List<TvShowResponse>)
    }

    interface LoadMovieDetailsCallback {
        fun onMovieDetailsReceived(movieResponses: List<MovieResponse>)
    }

    interface LoadTvShowDetailsCallback {
        fun onTvShowDetailsReceived(tvShowResponses: List<TvShowResponse>)
    }

}