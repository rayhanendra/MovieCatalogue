package com.example.moviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.example.moviecatalogue.data.source.local.entity.MovieEntity
import com.example.moviecatalogue.data.source.local.entity.TvShowEntity

@Dao
interface MovieCatalogueDao {

    @Query("SELECT * FROM movieentities")
    fun getMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movieentities where favorited = 1")
    fun getFavoritedMovie(): DataSource.Factory<Int, MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Transaction
    @Query("SELECT * FROM movieentities where movieId = :movieId")
    fun getMovieDetails(movieId: String): LiveData<MovieEntity>

    @Update
    fun updateMovie(movie: MovieEntity)


    @Query("SELECT * FROM tvshowentities")
    fun getTvShows(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM tvshowentities where favorited = 1")
    fun getFavoritedTvShow(): DataSource.Factory<Int, TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShows(movies: List<TvShowEntity>)

    @Transaction
    @Query("SELECT * FROM tvshowentities where tvShowId = :tvShowId")
    fun getTvShowDetails(tvShowId: String): LiveData<TvShowEntity>

    @Update
    fun updateTvShow(movie: TvShowEntity)


}