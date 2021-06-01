package com.example.moviecatalogue.data.source

import com.example.moviecatalogue.data.MovieEntity
import com.example.moviecatalogue.data.TvShowEntity

interface MovieCatalogueDataSource {

    fun getAllMovies(): List<MovieEntity>

    fun getAllTvShows(): List<TvShowEntity>
}