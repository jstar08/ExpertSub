package com.example.jetpacksub1.core.data.remote.api

import com.example.jetpacksub1.core.data.remote.response.FilmDetail
import com.example.jetpacksub1.core.data.remote.response.FilmResponse
import com.example.jetpacksub1.core.data.remote.response.TvDetail
import com.example.jetpacksub1.core.data.remote.response.TvResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    suspend fun getFilmList(@Query("api_key") api_key: String): FilmResponse

    @GET("tv/popular")
    suspend fun getTvList(@Query("api_key") api_key: String): TvResponse

    @GET("movie/{movie_id}")
    suspend fun getFilmDetail(@Path("movie_id") id: Int, @Query("api_key") api_key: String)
            : FilmDetail

    @GET("tv/{tv_id}")
    suspend fun getTvDetail(@Path("tv_id") id: Int, @Query("api_key") api_key: String)
            : TvDetail
}