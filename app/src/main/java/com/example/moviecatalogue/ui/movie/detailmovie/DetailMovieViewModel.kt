package com.example.moviecatalogue.ui.movie.detailmovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.data.MovieEntity
import com.example.moviecatalogue.data.source.MovieCatalogueRepository
import com.example.moviecatalogue.utils.DataDummy

class DetailMovieViewModel (private val movieCatalogueRepository: MovieCatalogueRepository): ViewModel(){
    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun getMovie(): LiveData<MovieEntity> = movieCatalogueRepository.getMovieDetails(movieId)


}