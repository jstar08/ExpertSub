package com.example.jetpacksub1.core.di

import androidx.room.Room
import com.example.jetpacksub1.core.BuildConfig.BASE_URL
import com.example.jetpacksub1.core.data.local.LocalDataSource
import com.example.jetpacksub1.core.data.local.room.MovieDatabase
import com.example.jetpacksub1.core.data.remote.RemoteDataSource
import com.example.jetpacksub1.core.data.remote.api.ApiService
import com.example.jetpacksub1.core.domain.repository.IMovieRepository
import com.example.jetpacksub1.core.utils.AppExecutors
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<MovieDatabase>().movieDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            MovieDatabase::class.java, "Movies.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IMovieRepository> {
        com.example.jetpacksub1.core.data.MovieRepository(
            get(),
            get(),
            get()
        )
    }
}