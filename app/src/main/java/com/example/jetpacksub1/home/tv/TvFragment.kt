package com.example.jetpacksub1.home.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.jetpacksub1.core.vo.Resource
import com.example.jetpacksub1.databinding.FragmentTvBinding
import com.example.jetpacksub1.ui.TvAdapter
import org.koin.android.viewmodel.ext.android.viewModel


class TvFragment : Fragment() {

    private lateinit var binding: FragmentTvBinding
    private val tvViewModel: TvViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTvBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val tvAdapter = TvAdapter(requireContext())

            tvViewModel.getTv().observe(viewLifecycleOwner, { tv ->
                if (tv != null) {
                    when (tv) {
                        is Resource.Loading -> showLoading(true)
                        is Resource.Success -> {
                            showLoading(false)
                            tvAdapter.setData(tv.data!!)
                        }
                        is Resource.Error -> {
                            showLoading(false)
                            Toast.makeText(context, "Data Loading Failed", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            })
            binding.rvMovie.adapter = tvAdapter
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


}