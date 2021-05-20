package com.example.jetpacksub1.core.data.local

import com.example.jetpacksub1.core.data.local.entity.FilmEntity
import com.example.jetpacksub1.core.data.local.entity.TvEntity
import com.example.jetpacksub1.core.data.local.room.MovieDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val mMoviesDao: MovieDao) {

    fun getAllFilm(): Flow<List<FilmEntity>> = mMoviesDao.getAllFilm()

    fun getAllTv(): Flow<List<TvEntity>> = mMoviesDao.getAllTv()

    suspend fun insertFilm(film: List<FilmEntity>) = mMoviesDao.insertFilm(film)

    suspend fun insertTv(tv: List<TvEntity>) = mMoviesDao.insertTv(tv)

    fun setFavoriteFilm(film: FilmEntity, newState: Boolean) {
        film.favorite = newState
        mMoviesDao.updateFilm(film)
    }

    fun setFavoriteTv(tv: TvEntity, newState: Boolean) {
        tv.favorite = newState
        mMoviesDao.updateTv(tv)
    }

    fun getFavoriteFilm(): Flow<List<FilmEntity>> = mMoviesDao.getFavoriteFilm()

    fun getFavoriteTv(): Flow<List<TvEntity>> = mMoviesDao.getFavoriteTv()

    fun getDetailFilm(id: Int) = mMoviesDao.getDetailFilm(id)

    fun getDetailTv(id: Int) = mMoviesDao.getDetailTv(id)


    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieDao: MovieDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieDao)
    }
}