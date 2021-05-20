package com.example.jetpacksub1.core.domain.usecase

import com.example.jetpacksub1.core.domain.model.FilmModel
import com.example.jetpacksub1.core.domain.model.TvModel
import com.example.jetpacksub1.core.vo.Resource
import kotlinx.coroutines.flow.Flow

interface IMovieUseCase {

    fun getAllFilm(): Flow<Resource<List<FilmModel>>>

    fun getAllTv(): Flow<Resource<List<TvModel>>>

    fun getFilmWithId(filmId: Int): Flow<Resource<FilmModel>>

    fun getTvWithId(tvId: Int): Flow<Resource<TvModel>>

    fun setFavoriteFilm(film: FilmModel, state: Boolean)

    fun setFavoriteTv(tv: TvModel, state: Boolean)

    fun getFavoriteFilm(): Flow<List<FilmModel>>

    fun getFavoriteTv(): Flow<List<TvModel>>
}