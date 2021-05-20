package com.example.jetpacksub1.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class Genre(
    @field:SerializedName("id") val id: Int? = 0,
    @field:SerializedName("name") val genreName: String? = null
)