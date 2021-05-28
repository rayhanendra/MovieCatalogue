package com.example.moviecatalogue.ui.tvshow.detailtvshow

import com.example.moviecatalogue.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DetailTvShowViewModelTest {
    private lateinit var viewModel: DetailTvShowViewModel
    private var dummyTvShow = DataDummy.generateDummyTvShows()[0]
    private val tvShowId = dummyTvShow.tvShowId

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel()
        viewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getTvShow() {
        viewModel.setSelectedTvShow(dummyTvShow.tvShowId)
        val tvShowEntity = viewModel.getTvShow()
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.imagePath, tvShowEntity.imagePath)
        assertEquals(dummyTvShow.description, tvShowEntity.description)
        assertEquals(dummyTvShow.genre, tvShowEntity.genre)
        assertEquals(dummyTvShow.rating, tvShowEntity.rating)
        assertEquals(dummyTvShow.title, tvShowEntity.title)
        assertEquals(dummyTvShow.tvShowId, tvShowEntity.tvShowId)
    }
}