package com.example.jetpacksub1.favorite.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.jetpacksub1.core.domain.model.TvModel
import com.example.jetpacksub1.core.domain.usecase.IMovieUseCase

class FavoriteTvViewModel(private val movieUseCase: IMovieUseCase) : ViewModel() {

    fun getFavoriteTv(): LiveData<List<TvModel>> = movieUseCase.getFavoriteTv().asLiveData()
}