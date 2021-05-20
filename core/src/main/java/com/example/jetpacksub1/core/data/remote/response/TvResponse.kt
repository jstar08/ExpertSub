package com.example.jetpacksub1.core.data.remote.response

import com.google.gson.annotations.SerializedName


data class TvResponse(
    @field:SerializedName("results") val result: List<TvList>? = null
)

data class TvList(
    @field:SerializedName("id") var id: Int? = 0,
    @field:SerializedName("name") var title: String? = null,
    @field:SerializedName("vote_average") var score: Double? = 0.0,
    @field:SerializedName("overview") var overview: String? = null,
    @field:SerializedName("first_air_date") var releaseDate: String? = null,
    @field:SerializedName("poster_path") var tvPoster: String? = null
)

data class TvDetail(
    @field:SerializedName("id") var id: Int? = 0,
    @field:SerializedName("name") var title: String? = null,
    @field:SerializedName("vote_average") var score: Double? = 0.0,
    @field:SerializedName("overview") var overview: String? = null,
    @field:SerializedName("first_air_date") var releaseDate: String? = null,
    @field:SerializedName("poster_path") var tvPoster: String? = null,
    @field:SerializedName("genres") var genres: ArrayList<Genre>,
    @field:SerializedName("vote_count") var duration: Int? = 0
)