package com.example.moviecatalogue.ui.tvshow.detailtvshow

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
import com.example.moviecatalogue.databinding.ActivityDetailTvShowBinding
import com.example.moviecatalogue.databinding.ContentDetailTvShowBinding
import com.example.moviecatalogue.viewmodel.ViewModelFactory
import com.example.moviecatalogue.vo.Status

class DetailTvShowActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TVSHOW = "extra_tvshow"
    }

    private lateinit var activityDetailTvShowBinding: ActivityDetailTvShowBinding
    private lateinit var contentDetailTvShowBinding: ContentDetailTvShowBinding
    private lateinit var tvShowEntity: TvShowEntity
    private lateinit var viewModel: DetailTvShowViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailTvShowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        contentDetailTvShowBinding = activityDetailTvShowBinding.detailContent

        setContentView(activityDetailTvShowBinding.root)

        setSupportActionBar(activityDetailTvShowBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailTvShowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val tvShowId = extras.getString(EXTRA_TVSHOW)
            if (tvShowId != null) {

                activityDetailTvShowBinding.progressBar.visibility = View.VISIBLE
                activityDetailTvShowBinding.content.visibility = View.INVISIBLE

                viewModel.setSelectedTvShow(tvShowId)
                viewModel.getTvShow().observe(this, { tvShow ->
                    activityDetailTvShowBinding.progressBar.visibility = View.GONE
                    activityDetailTvShowBinding.content.visibility = View.VISIBLE
                    tvShowEntity = tvShow
                    tvShowEntity.favorited = tvShow.favorited
                    populateTvShow(tvShow)

                    favoriteState(tvShow.favorited)
                })
            }
        }
    }

    private fun favoriteState(check: Boolean){
        if (check){
            contentDetailTvShowBinding.btnFavorite.background = ContextCompat.getDrawable(applicationContext, R.drawable.ic_baseline_favorite_24)
        } else {
            contentDetailTvShowBinding.btnFavorite.background = ContextCompat.getDrawable(applicationContext, R.drawable.ic_baseline_favorite_border_24)
        }
    }

    private fun setFavorite(tvShow: TvShowEntity){
        if (tvShow.favorited){
            Toast.makeText(applicationContext, "Removed from favorite", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(applicationContext, "Added to favorite", Toast.LENGTH_SHORT).show()
        }
        viewModel.setFavorite(tvShow)
    }

    private fun populateTvShow(tvShow: TvShowEntity) {
        contentDetailTvShowBinding.tvItemTitle.text = tvShow.title
        contentDetailTvShowBinding.tvItemRating.text = tvShow.rating.toString()
        contentDetailTvShowBinding.tvItemGenre.text = tvShow.genre
        contentDetailTvShowBinding.tvItemDesc.text = tvShow.description

        Glide.with(this)
            .load(tvShow.imagePath)
            .centerCrop()
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .into(contentDetailTvShowBinding.imagePoster)

        contentDetailTvShowBinding.btnFavorite.setOnClickListener {
            if (tvShow != null) {
                setFavorite(tvShow)
                Toast.makeText(applicationContext, "Write your message here", Toast.LENGTH_LONG).show()
            }
        }
    }
}