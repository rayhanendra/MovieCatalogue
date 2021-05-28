package com.example.moviecatalogue.ui.movie.detailmovie

import com.example.moviecatalogue.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DetailMovieViewModelTest {
    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.movieId

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel()
        viewModel.setSelectedMovie(movieId)
    }

    @Test
    fun getMovie() {
        viewModel.setSelectedMovie(dummyMovie.movieId)
        val movieEntity = viewModel.getMovie()
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.movieId, movieEntity.movieId)
        assertEquals(dummyMovie.imagePath, movieEntity.imagePath)
        assertEquals(dummyMovie.description, movieEntity.description)
        assertEquals(dummyMovie.genre, movieEntity.genre)
        assertEquals(dummyMovie.rating, movieEntity.rating)
        assertEquals(dummyMovie.title, movieEntity.title)
    }
}