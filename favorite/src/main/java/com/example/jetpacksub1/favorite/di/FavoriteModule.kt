package com.example.jetpacksub1.favorite.di

import com.example.jetpacksub1.favorite.film.FavoriteFilmViewModel
import com.example.jetpacksub1.favorite.tv.FavoriteTvViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val favoriteModule = module {
    viewModel { FavoriteFilmViewModel(get()) }
    viewModel { FavoriteTvViewModel(get()) }
}