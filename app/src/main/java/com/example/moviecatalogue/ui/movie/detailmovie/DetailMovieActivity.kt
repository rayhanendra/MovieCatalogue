package com.example.moviecatalogue.ui.movie.detailmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moviecatalogue.R
import com.example.moviecatalogue.data.MovieEntity
import com.example.moviecatalogue.databinding.ActivityDetailMovieBinding
import com.example.moviecatalogue.databinding.ContentDetailMovieBinding

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var contentDetailMovieBinding: ContentDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        contentDetailMovieBinding = activityDetailMovieBinding.detailContent

        setContentView(activityDetailMovieBinding.root)

        setSupportActionBar(activityDetailMovieBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (movieId != null) {
                viewModel.setSelectedMovie(movieId)
                populateMovie(viewModel.getMovie() as MovieEntity)
            }
        }
    }

    private fun populateMovie(movieEntity: MovieEntity) {
        contentDetailMovieBinding.tvItemTitle.text = movieEntity.title
        contentDetailMovieBinding.tvItemRating.text = movieEntity.rating.toString()
        contentDetailMovieBinding.tvItemGenre.text = movieEntity.genre
        contentDetailMovieBinding.tvItemDesc.text = movieEntity.description

        Glide.with(this)
            .load(movieEntity.imagePath)
            .centerCrop()
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .into(contentDetailMovieBinding.imagePoster)
    }
}