package com.example.moviecatalogue.ui.movie.detailmovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.data.source.local.entity.MovieEntity
import com.example.moviecatalogue.data.source.MovieCatalogueRepository

class DetailMovieViewModel (private val movieCatalogueRepository: MovieCatalogueRepository): ViewModel(){

    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun getMovie(): LiveData<MovieEntity> = movieCatalogueRepository.getMovieDetails(movieId)

    fun setFavorite(movie: MovieEntity) {
        movieCatalogueRepository.setMovieFavorite(movie, false)
    }

}