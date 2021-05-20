package com.example.jetpacksub1.favorite.film

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.jetpacksub1.favorite.databinding.FragmentFavoriteFilmBinding
import com.example.jetpacksub1.ui.FavoriteFilmAdapter
import org.koin.android.viewmodel.ext.android.viewModel


class FavoriteFilmFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteFilmBinding
    private val favoriteFilmViewModel: FavoriteFilmViewModel by viewModel()
    private lateinit var adapter: FavoriteFilmAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteFilmBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = FavoriteFilmAdapter(requireContext())

        favoriteFilmViewModel.getFavoriteFilm().observe(viewLifecycleOwner, { film ->
            adapter.setData(film)
        })

        binding.rvFavMovie.adapter = adapter

    }

}