package com.example.jetpacksub1.core.data.remote

import android.util.Log
import com.example.jetpacksub1.core.BuildConfig.API_KEY
import com.example.jetpacksub1.core.data.remote.api.ApiService
import com.example.jetpacksub1.core.data.remote.response.*
import com.example.jetpacksub1.core.utils.EspressoIdlingResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getListFilm(): Flow<ApiResponse<List<FilmList>>> {
        EspressoIdlingResource.increment()

        return flow {
            try {
                val resultFilm = apiService.getFilmList(API_KEY)
                val dataArray = resultFilm.result
                if (dataArray != null) {
                    emit(ApiResponse.Success(dataArray))
                } else {
                    emit(ApiResponse.Empty)
                }
                EspressoIdlingResource.decrement()
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e(TAG, e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }


    suspend fun getListTv(): Flow<ApiResponse<List<TvList>>> {
        EspressoIdlingResource.increment()

        return flow {
            try {
                val resultTv = apiService.getTvList(API_KEY)
                val dataArray = resultTv.result
                if (dataArray != null) {
                    emit(ApiResponse.Success(dataArray))
                } else {
                    emit(ApiResponse.Empty)
                }
                EspressoIdlingResource.decrement()
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e(TAG, e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    fun getFilmDetail(id: Int): Flow<ApiResponse<FilmDetail>> {
        EspressoIdlingResource.increment()

        return flow {
            try {
                val detailFilm = apiService.getFilmDetail(id, API_KEY)
                if (detailFilm.id != null) {
                    emit(ApiResponse.Success(detailFilm))
                } else {
                    emit(ApiResponse.Empty)
                }
                EspressoIdlingResource.decrement()
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e(TAG, e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    fun getTvDetail(id: Int): Flow<ApiResponse<TvDetail>> {
        EspressoIdlingResource.increment()
        return flow {
            try {
                val detailTv = apiService.getTvDetail(id, API_KEY)
                if (detailTv.id != null) {
                    emit(ApiResponse.Success(detailTv))
                } else {
                    emit(ApiResponse.Empty)
                }
                EspressoIdlingResource.decrement()
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e(TAG, e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    companion object {
        private val TAG = RemoteDataSource::class.java.simpleName

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service).apply { instance = this }
            }
    }


}