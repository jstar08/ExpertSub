package com.example.jetpacksub1.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.jetpacksub1.core.domain.model.FilmModel
import com.example.jetpacksub1.core.domain.model.TvModel
import com.example.jetpacksub1.core.domain.usecase.IMovieUseCase
import com.example.jetpacksub1.core.vo.Resource

class DetailViewModel(private val movieUseCase: IMovieUseCase) : ViewModel() {

    val id = MutableLiveData<Int>()

    fun setSelectedMovie(id: Int) {
        this.id.value = id
    }

    fun getFilmById(id: Int): LiveData<Resource<FilmModel>> {
        return movieUseCase.getFilmWithId(id).asLiveData()
    }

    fun getTvById(id: Int): LiveData<Resource<TvModel>> {
        return movieUseCase.getTvWithId(id).asLiveData()
    }


    fun setFilmFavorite(data: FilmModel) {
        val newState = !data.favorite
        movieUseCase.setFavoriteFilm(data, newState)
    }

    fun setTvFavorite(data: TvModel) {
        val newState = !data.favorite
        movieUseCase.setFavoriteTv(data, newState)
    }
}