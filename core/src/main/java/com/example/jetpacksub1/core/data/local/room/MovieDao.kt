package com.example.jetpacksub1.core.data.local.room

import androidx.room.*
import com.example.jetpacksub1.core.data.local.entity.FilmEntity
import com.example.jetpacksub1.core.data.local.entity.TvEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM filmEntities")
    fun getAllFilm(): Flow<List<FilmEntity>>

    @Query("SELECT * FROM tvEntities")
    fun getAllTv(): Flow<List<TvEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFilm(film: List<FilmEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTv(tv: List<TvEntity>)

    @Update
    fun updateFilm(film: FilmEntity)

    @Update
    fun updateTv(tv: TvEntity)

    @Query("SELECT * FROM filmEntities where id = :id")
    fun getDetailFilm(id: Int): Flow<FilmEntity>

    @Query("SELECT * FROM tvEntities where id = :id")
    fun getDetailTv(id: Int): Flow<TvEntity>

    @Query("SELECT * FROM filmEntities where favorite = 1")
    fun getFavoriteFilm(): Flow<List<FilmEntity>>

    @Query("SELECT * FROM tvEntities where favorite = 1")
    fun getFavoriteTv(): Flow<List<TvEntity>>


}