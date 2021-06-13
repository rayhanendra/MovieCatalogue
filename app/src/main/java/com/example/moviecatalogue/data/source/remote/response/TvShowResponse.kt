package com.example.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShowResponse (
    var tvShowId: String,
    var title: String,
    var description: String,
    var genre: String,
    var rating: Int,
    var imagePath: String
):Parcelable