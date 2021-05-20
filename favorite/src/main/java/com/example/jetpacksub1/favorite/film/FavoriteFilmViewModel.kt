package com.example.jetpacksub1.favorite.film

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.jetpacksub1.core.domain.model.FilmModel
import com.example.jetpacksub1.core.domain.usecase.IMovieUseCase

class FavoriteFilmViewModel(private val movieUseCase: IMovieUseCase) : ViewModel() {

    fun getFavoriteFilm(): LiveData<List<FilmModel>> = movieUseCase.getFavoriteFilm().asLiveData()
}