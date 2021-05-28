package com.example.moviecatalogue.ui.tvshow.detailtvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moviecatalogue.R
import com.example.moviecatalogue.data.TvShowEntity
import com.example.moviecatalogue.databinding.ActivityDetailTvShowBinding
import com.example.moviecatalogue.databinding.ContentDetailTvShowBinding

class DetailTvShowActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TVSHOW = "extra_tvshow"
    }

    private lateinit var contentDetailTvShowBinding: ContentDetailTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailTvShowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        contentDetailTvShowBinding = activityDetailTvShowBinding.detailContent

        setContentView(activityDetailTvShowBinding.root)

        setSupportActionBar(activityDetailTvShowBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailTvShowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val tvShowId = extras.getString(EXTRA_TVSHOW)
            if (tvShowId !=null) {
                viewModel.setSelectedTvShow(tvShowId)
                populateTvShow(viewModel.getTvShow() as TvShowEntity)
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