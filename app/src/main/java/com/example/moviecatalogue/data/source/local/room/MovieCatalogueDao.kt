package com.example.moviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.moviecatalogue.data.source.local.entity.MovieEntity
import com.example.moviecatalogue.data.source.local.entity.TvShowEntity

interface MovieCatalogueDao {

    @Query("SELECT * FROM movieentities")
    fun getMovies(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM movieentities where favorited = 1")
    fun getFavoritedMovie(): LiveData<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Transaction
    @Query("SELECT * FROM movieentities where movieId = :movieId")
    fun getMovieDetails(movieId: String): LiveData<MovieEntity>

    @Update
    fun updateMovie(movie: MovieEntity)


    @Query("SELECT * FROM tvshowentities")
    fun getTvShows(): LiveData<List<TvShowEntity>>

    @Query("SELECT * FROM tvshowentities where favorited = 1")
    fun getFavoritedTvShow(): LiveData<List<TvShowEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShows(movies: List<TvShowEntity>)

    @Transaction
    @Query("SELECT * FROM tvshowentities where tvShowId = :tvShowId")
    fun getTvShowDetails(tvShowId: String): LiveData<TvShowEntity>

    @Update
    fun updateTvShow(movie: TvShowEntity)


}