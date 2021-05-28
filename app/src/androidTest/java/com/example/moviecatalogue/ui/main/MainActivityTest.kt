package com.example.moviecatalogue.ui.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.moviecatalogue.R
import com.example.moviecatalogue.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTvShow = DataDummy.generateDummyTvShows()

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie(){
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_item_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.tv_item_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_desc)).check(matches(withText(dummyMovie[0].description)))
        onView(withId(R.id.tv_item_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_genre)).check(matches(withText(dummyMovie[0].genre)))
        onView(withId(R.id.tv_item_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_rating)).check(matches(withText(dummyMovie[0].rating.toString())))
        onView(withId(R.id.image_poster)).check(matches(isDisplayed()))
    }

    @Test
    fun loadTvShows() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_item_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_title)).check(matches(withText(dummyTvShow[0].title)))
        onView(withId(R.id.tv_item_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_desc)).check(matches(withText(dummyTvShow[0].description)))
        onView(withId(R.id.tv_item_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_genre)).check(matches(withText(dummyTvShow[0].genre)))
        onView(withId(R.id.tv_item_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_rating)).check(matches(withText(dummyTvShow[0].rating.toString())))
        onView(withId(R.id.image_poster)).check(matches(isDisplayed()))
    }
}