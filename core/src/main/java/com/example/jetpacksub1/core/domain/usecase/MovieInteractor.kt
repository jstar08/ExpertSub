package com.example.jetpacksub1.core.domain.usecase

import com.example.jetpacksub1.core.domain.model.FilmModel
import com.example.jetpacksub1.core.domain.model.TvModel
import com.example.jetpacksub1.core.domain.repository.IMovieRepository
import com.example.jetpacksub1.core.vo.Resource
import kotlinx.coroutines.flow.Flow

class MovieInteractor(private val movieRepository: IMovieRepository) : IMovieUseCase {

    override fun getAllFilm(): Flow<Resource<List<FilmModel>>> = movieRepository.getAllFilm()

    override fun getAllTv(): Flow<Resource<List<TvModel>>> = movieRepository.getAllTv()

    override fun getFilmWithId(filmId: Int): Flow<Resource<FilmModel>> =
        movieRepository.getFilmWithId(filmId)

    override fun getTvWithId(tvId: Int): Flow<Resource<TvModel>> =
        movieRepository.getTvWithId(tvId)

    override fun setFavoriteFilm(film: FilmModel, state: Boolean) =
        movieRepository.setFavoriteFilm(film, state)

    override fun setFavoriteTv(tv: TvModel, state: Boolean) =
        movieRepository.setFavoriteTv(tv, state)

    override fun getFavoriteFilm(): Flow<List<FilmModel>> =
        movieRepository.getFavoriteFilm()

    override fun getFavoriteTv(): Flow<List<TvModel>> =
        movieRepository.getFavoriteTv()

}