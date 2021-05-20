package com.example.jetpacksub1.home.tv


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.jetpacksub1.core.domain.model.TvModel
import com.example.jetpacksub1.core.domain.usecase.IMovieUseCase
import com.example.jetpacksub1.core.vo.Resource

class TvViewModel(private val movieUseCase: IMovieUseCase) : ViewModel() {

    fun getTv(): LiveData<Resource<List<TvModel>>> = movieUseCase.getAllTv().asLiveData()
}