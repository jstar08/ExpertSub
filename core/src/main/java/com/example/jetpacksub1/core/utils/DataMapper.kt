package com.example.jetpacksub1.core.utils

import com.example.jetpacksub1.core.data.local.entity.FilmEntity
import com.example.jetpacksub1.core.data.local.entity.TvEntity
import com.example.jetpacksub1.core.domain.model.FilmModel
import com.example.jetpacksub1.core.domain.model.TvModel

object DataMapper {

    fun mapFilmEntitiesToDomain(input: List<FilmEntity>): List<FilmModel> =
        input.map {
            FilmModel(
                it.id,
                it.title,
                it.score,
                it.overview,
                it.releaseDate,
                it.genre,
                it.duration,
                it.moviePoster,
                it.favorite
            )
        }

    fun mapTvEntitiesToDomain(input: List<TvEntity>): List<TvModel> =
        input.map {
            TvModel(
                it.id,
                it.title,
                it.score,
                it.overview,
                it.releaseDate,
                it.genre,
                it.duration,
                it.seriesPoster,
                it.favorite
            )
        }

    fun mapDomainToFilmEntities(input: FilmModel): FilmEntity =
        FilmEntity(
            input.id,
            input.title,
            input.score,
            input.overview,
            input.releaseDate,
            input.genre,
            input.duration,
            input.moviePoster,
            input.favorite
        )

    fun mapDomainToTvEntities(input: TvModel): TvEntity =
        TvEntity(
            input.id,
            input.title,
            input.score,
            input.overview,
            input.releaseDate,
            input.genre,
            input.duration,
            input.seriesPoster,
            input.favorite
        )

    fun mapDetailFilm(input: FilmEntity): FilmModel =
        FilmModel(
            input.id,
            input.title,
            input.score,
            input.overview,
            input.releaseDate,
            input.genre,
            input.duration,
            input.moviePoster,
            input.favorite
        )

    fun mapDetailTv(input: TvEntity): TvModel =
        TvModel(
            input.id,
            input.title,
            input.score,
            input.overview,
            input.releaseDate,
            input.genre,
            input.duration,
            input.seriesPoster,
            input.favorite
        )
}