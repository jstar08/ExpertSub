package com.example.jetpacksub1.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class FilmResponse(
    @field:SerializedName("results") val result: List<FilmList>? = null
)

data class FilmList(
    @field:SerializedName("id") var id: Int? = 0,
    @field:SerializedName("title") var title: String? = null,
    @field:SerializedName("vote_average") var score: Double? = 0.0,
    @field:SerializedName("overview") var overview: String? = null,
    @field:SerializedName("release_date") var releaseDate: String? = null,
    @field:SerializedName("poster_path") var moviePoster: String? = null
)

data class FilmDetail(
    @field:SerializedName("id") var id: Int? = 0,
    @field:SerializedName("title") var title: String? = null,
    @field:SerializedName("vote_average") var score: Double? = 0.0,
    @field:SerializedName("overview") var overview: String? = null,
    @field:SerializedName("release_date") var releaseDate: String? = null,
    @field:SerializedName("poster_path") var moviePoster: String? = null,
    @field:SerializedName("genres") var genres: ArrayList<Genre>,
    @field:SerializedName("runtime") var duration: Int? = 0
)

