package com.example.moviecatalogue.ui.movie

import com.example.moviecatalogue.data.source.MovieCatalogueRepository
import com.example.moviecatalogue.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Before
    fun setUp(){
        viewModel = MovieViewModel(movieCatalogueRepository)
    }

    @Test
    fun getMovies() {
        `when`(movieCatalogueRepository.getAllMovies()).thenReturn(DataDummy.generateDummyMovies() as <ArrayList<MovieEntity>>)
        val movieEntities = viewModel.getMovies()
        verify<MovieCatalogueRepository>(movieCatalogueRepository).getAllMovies()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities.size)
    }
}