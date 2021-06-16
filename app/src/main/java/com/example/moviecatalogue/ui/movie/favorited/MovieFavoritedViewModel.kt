package com.example.moviecatalogue.ui.movie.favorited

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.moviecatalogue.data.source.MovieCatalogueRepository
import com.example.moviecatalogue.data.source.local.entity.MovieEntity

class MovieFavoritedViewModel(private val movieCatalogueRepository: MovieCatalogueRepository): ViewModel() {
    fun getMovies(): LiveData<PagedList<MovieEntity>> = movieCatalogueRepository.getFavoritedMovies()
}