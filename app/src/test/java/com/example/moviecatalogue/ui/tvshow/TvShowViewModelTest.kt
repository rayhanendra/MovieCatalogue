package com.example.moviecatalogue.ui.tvshow

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun getTvShows() {
        val tvShowEntities = viewModel.getTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities.size)
    }
}