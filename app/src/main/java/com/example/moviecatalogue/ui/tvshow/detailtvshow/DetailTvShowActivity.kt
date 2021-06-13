package com.example.moviecatalogue.ui.tvshow.detailtvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moviecatalogue.R
import com.example.moviecatalogue.data.source.local.entity.TvShowEntity
import com.example.moviecatalogue.databinding.ActivityDetailTvShowBinding
import com.example.moviecatalogue.databinding.ContentDetailTvShowBinding
import com.example.moviecatalogue.viewmodel.ViewModelFactory
import com.example.moviecatalogue.vo.Status

class DetailTvShowActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TVSHOW = "extra_tvshow"
    }

    private lateinit var contentDetailTvShowBinding: ContentDetailTvShowBinding
    private lateinit var tvShowEntity: TvShowEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailTvShowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        contentDetailTvShowBinding = activityDetailTvShowBinding.detailContent

        setContentView(activityDetailTvShowBinding.root)

        setSupportActionBar(activityDetailTvShowBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailTvShowViewModel::class.java]

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
                })
            }
        }

    }

    private fun populateTvShow(tvShowEntity: TvShowEntity) {
        contentDetailTvShowBinding.tvItemTitle.text = tvShowEntity.title
        contentDetailTvShowBinding.tvItemRating.text = tvShowEntity.rating.toString()
        contentDetailTvShowBinding.tvItemGenre.text = tvShowEntity.genre
        contentDetailTvShowBinding.tvItemDesc.text = tvShowEntity.description

        Glide.with(this)
            .load(tvShowEntity.imagePath)
            .centerCrop()
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .into(contentDetailTvShowBinding.imagePoster)
    }
}