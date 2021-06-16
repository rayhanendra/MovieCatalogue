package com.example.moviecatalogue.ui.movie.detailmovie

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moviecatalogue.R
import com.example.moviecatalogue.data.source.local.entity.MovieEntity
import com.example.moviecatalogue.data.source.local.entity.TvShowEntity
import com.example.moviecatalogue.databinding.ContentDetailMovieBinding
import com.example.moviecatalogue.ui.movie.favorited.MovieFavoritedViewModel
import com.example.moviecatalogue.viewmodel.ViewModelFactory
import com.example.moviecatalogue.databinding.ActivityDetailMovieBinding as ActivityDetailMovieBinding1

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var activityDetailMovieBinding: ActivityDetailMovieBinding1
    private lateinit var contentDetailMovieBinding: ContentDetailMovieBinding
    private lateinit var movieEntity: MovieEntity
    private lateinit var viewModel: DetailMovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailMovieBinding = ActivityDetailMovieBinding1.inflate(layoutInflater)
        contentDetailMovieBinding = activityDetailMovieBinding.detailContent

        setContentView(activityDetailMovieBinding.root)

        setSupportActionBar(activityDetailMovieBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (movieId != null) {

                activityDetailMovieBinding.progressBar.visibility = View.VISIBLE
                activityDetailMovieBinding.content.visibility = View.INVISIBLE

                viewModel.setSelectedMovie(movieId)
                viewModel.getMovie().observe(this, { movie ->
                    activityDetailMovieBinding.progressBar.visibility = View.GONE
                    activityDetailMovieBinding.content.visibility = View.VISIBLE
                    movieEntity = movie
                    movieEntity.favorited = movie.favorited
                    populateMovie(movie)

                    favoriteState(movie.favorited)
                })
            }
        }
    }

    private fun favoriteState(check: Boolean){
        if (check){
            contentDetailMovieBinding.btnFavorite.background = ContextCompat.getDrawable(applicationContext, R.drawable.ic_baseline_favorite_24)
        } else {
            contentDetailMovieBinding.btnFavorite.background = ContextCompat.getDrawable(applicationContext, R.drawable.ic_baseline_favorite_border_24)
        }
    }

    private fun setFavorite(movie: MovieEntity){
        if (movie.favorited){
            Toast.makeText(applicationContext, "Removed from favorite", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(applicationContext, "Added to favorite", Toast.LENGTH_SHORT).show()
        }
        viewModel.setFavorite(movie)
    }

    private fun populateMovie(movie: MovieEntity) {

        contentDetailMovieBinding.tvItemTitle.text = movie.title
        contentDetailMovieBinding.tvItemRating.text = movie.rating.toString()
        contentDetailMovieBinding.tvItemGenre.text = movie.genre
        contentDetailMovieBinding.tvItemDesc.text = movie.description

        Glide.with(this)
            .load(movie.imagePath)
            .centerCrop()
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .into(contentDetailMovieBinding.imagePoster)

        contentDetailMovieBinding.btnFavorite.setOnClickListener {
            if (movie != null) {
                setFavorite(movie)
                Toast.makeText(applicationContext, "Write your message here", Toast.LENGTH_LONG).show()
            }
        }
    }
}