package com.example.jetpacksub1.home.film

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.jetpacksub1.core.domain.model.FilmModel
import com.example.jetpacksub1.core.domain.usecase.IMovieUseCase
import com.example.jetpacksub1.core.vo.Resource

class FilmViewModel(private val movieUseCase: IMovieUseCase) : ViewModel() {

    fun getFilm(): LiveData<Resource<List<FilmModel>>> = movieUseCase.getAllFilm().asLiveData()
}


















