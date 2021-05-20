package com.example.jetpacksub1.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvModel(
    var id: Int,
    var title: String,
    var score: Double,
    var overview: String,
    var releaseDate: String,
    var genre: String,
    var duration: Int,
    var seriesPoster: String,
    var favorite: Boolean = false
) : Parcelable