package com.example.jetpacksub1.favorite.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.jetpacksub1.favorite.databinding.FragmentFavoriteTvBinding
import com.example.jetpacksub1.ui.FavoriteTvAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class FavoriteTvFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteTvBinding
    private val favoriteTvViewModel: FavoriteTvViewModel by viewModel()
    private lateinit var adapter: FavoriteTvAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteTvBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        adapter = FavoriteTvAdapter(requireContext())

        favoriteTvViewModel.getFavoriteTv().observe(viewLifecycleOwner, { tv ->
            adapter.setData(tv)
        })

        binding.rvFavTv.adapter = adapter
    }
}