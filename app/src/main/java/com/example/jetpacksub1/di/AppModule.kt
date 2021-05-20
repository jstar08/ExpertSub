package com.example.jetpacksub1.di

import com.example.jetpacksub1.core.domain.usecase.IMovieUseCase
import com.example.jetpacksub1.core.domain.usecase.MovieInteractor
import com.example.jetpacksub1.detail.DetailViewModel
import com.example.jetpacksub1.home.film.FilmViewModel
import com.example.jetpacksub1.home.tv.TvViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<IMovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { FilmViewModel(get()) }
    viewModel { TvViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}