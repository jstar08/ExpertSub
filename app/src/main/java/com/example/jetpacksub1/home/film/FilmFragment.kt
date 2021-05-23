package com.example.jetpacksub1.home.film

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.jetpacksub1.core.vo.Resource
import com.example.jetpacksub1.databinding.FragmentFilmBinding
import com.example.jetpacksub1.ui.FilmAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class FilmFragment : Fragment() {

    private var _binding: FragmentFilmBinding? = null
    private val binding: FragmentFilmBinding get() = _binding!!
    private val filmViewModel: FilmViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFilmBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val filmAdapter = FilmAdapter(requireContext())


            filmViewModel.getFilm().observe(viewLifecycleOwner, { film ->
                if (film != null) {
                    when (film) {
                        is Resource.Loading -> showLoading(true)
                        is Resource.Success -> {
                            showLoading(false)
                            filmAdapter.setData(film.data!!)
                        }
                        is Resource.Error -> {
                            showLoading(false)
                            Toast.makeText(context, "Data Loading Failed", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            })
            binding.rvMovie.adapter = filmAdapter
        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.VISIBLE
            binding.rvMovie.visibility = View.GONE
        } else {
            binding.progressBar.visibility = View.GONE
            binding.rvMovie.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}