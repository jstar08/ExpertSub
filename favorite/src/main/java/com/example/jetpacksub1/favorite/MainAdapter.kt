package com.example.jetpacksub1.favorite

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.jetpacksub1.favorite.film.FavoriteFilmFragment
import com.example.jetpacksub1.favorite.tv.FavoriteTvFragment

class MainAdapter(private val activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FavoriteFilmFragment()
            1 -> FavoriteTvFragment()
            else -> FavoriteFilmFragment()
        }
    }
}