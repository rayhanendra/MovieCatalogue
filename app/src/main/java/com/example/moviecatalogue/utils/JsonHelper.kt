package com.example.moviecatalogue.utils

import android.content.Context
import com.example.moviecatalogue.data.source.remote.response.MovieResponse
import com.example.moviecatalogue.data.source.remote.response.TvShowResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("movies.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val movieId = movie.getString("movieId")
                val title = movie.getString("title")
                val description = movie.getString("description")
                val genre = movie.getString("genre")
                val rating = movie.getInt("rating")
                val imagePath = movie.getString("imagePath")

                val movieResponse = MovieResponse(movieId, title, description, genre, rating, imagePath)
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }


    fun loadTvShows(): List<TvShowResponse> {
        val list = ArrayList<TvShowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("tvShows.json").toString())
            val listArray = responseObject.getJSONArray("tvshows")
            for (i in 0 until listArray.length()) {
                val tvShow = listArray.getJSONObject(i)

                val tvShowId = tvShow.getString("tvShowId")
                val title = tvShow.getString("title")
                val description = tvShow.getString("description")
                val genre = tvShow.getString("genre")
                val rating = tvShow.getInt("rating")
                val imagePath = tvShow.getString("imagePath")

                val tvShowResponse = TvShowResponse(tvShowId, title, description, genre, rating, imagePath)
                list.add(tvShowResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadMovieDetails(movieId: String): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("movies.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val movieId = movie.getString("movieId")
                val title = movie.getString("title")
                val description = movie.getString("description")
                val genre = movie.getString("genre")
                val rating = movie.getInt("rating")
                val imagePath = movie.getString("imagePath")

                val movieResponse = MovieResponse(movieId, title, description, genre, rating, imagePath)
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }


    fun loadTvShowsDetails(tvShowId: String): List<TvShowResponse> {
        val list = ArrayList<TvShowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("tvShows.json").toString())
            val listArray = responseObject.getJSONArray("tvshows")
            for (i in 0 until listArray.length()) {
                val tvShow = listArray.getJSONObject(i)

                val tvShowId = tvShow.getString("tvShowId")
                val title = tvShow.getString("title")
                val description = tvShow.getString("description")
                val genre = tvShow.getString("genre")
                val rating = tvShow.getInt("rating")
                val imagePath = tvShow.getString("imagePath")

                val tvShowResponse = TvShowResponse(tvShowId, title, description, genre, rating, imagePath)
                list.add(tvShowResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

}