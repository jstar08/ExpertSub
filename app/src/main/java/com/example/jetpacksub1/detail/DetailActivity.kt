package com.example.jetpacksub1.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.jetpacksub1.BuildConfig
import com.example.jetpacksub1.R
import com.example.jetpacksub1.core.domain.model.FilmModel
import com.example.jetpacksub1.core.domain.model.TvModel
import com.example.jetpacksub1.core.vo.Resource
import com.example.jetpacksub1.databinding.ActivityDetailBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val detailViewModel: DetailViewModel by viewModel()
    private var isFavorite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarDetail)

        binding.ivActionBack.setOnClickListener { onBackPressed() }

        val film = intent.getIntExtra(FILM, 0)
        initDetailData(film)
    }

    private fun initDetailData(id: Int) {
        val extras = intent.extras
        if (extras != null) {
            if (isMovie == true) {
                detailViewModel.getFilmById(id).observe(this, { film ->
                    if (film != null) {
                        when (film) {
                            is Resource.Loading -> showLoading(true)
                            is Resource.Success -> {
                                if (film.data != null) {
                                    showLoading(false)
                                    loadFilmData(film.data!!)
                                    isFavorite = film.data!!.favorite
                                    changeFavlogo()
                                }
                            }
                            is Resource.Error -> {
                                showLoading(false)
                                Toast.makeText(this, "Data Loading Failed", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                    }
                })
            } else {
                detailViewModel.getTvById(id).observe(this, { tv ->
                    if (tv != null) {
                        when (tv) {
                            is Resource.Loading -> showLoading(true)
                            is Resource.Success -> {
                                if (tv.data != null) {
                                    showLoading(false)
                                    loadTvData(tv.data!!)
                                    isFavorite = tv.data!!.favorite
                                    changeFavlogo()
                                }
                            }
                            is Resource.Error -> {
                                showLoading(false)
                                Toast.makeText(this, "Data Loading Failed", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                    }
                })
            }
        }
    }


    private fun changeFavlogo() {
        if (isFavorite) {
            binding.fbAddFav.setImageResource(R.drawable.favorite)
        } else {
            binding.fbAddFav.setImageResource(R.drawable.favorite_border)
        }
    }


    private fun loadFilmData(filmModel: FilmModel) {

        binding.apply {
            tvTitleDetail.text = filmModel.title
            tvDuration.text = String.format(
                resources.getString(R.string.duration),
                filmModel.duration / 60,
                filmModel.duration % 60
            )
            tvReleaseDate.text = filmModel.releaseDate
            tvOverviewDetail.text = filmModel.overview
            tvGenre.text = filmModel.genre
            tvRatingDetail.text =
                String.format(resources.getString(R.string.rating_format), filmModel.score)

            Glide.with(root).load("${BuildConfig.IMAGE_URL}${filmModel.moviePoster}")
                .into(ivBackCoverDetail)
            Glide.with(root).load("${BuildConfig.IMAGE_URL}${filmModel.moviePoster}")
                .into(ivCoverDetail)
            Glide.with(root).load(R.drawable.ic_baseline_access_time_24).into(ivCategory)
        }
        setFavoriteFilm(filmModel)


    }

    private fun loadTvData(tvModel: TvModel) {
        binding.apply {
            tvTitleDetail.text = tvModel.title
            tvDuration.text = tvModel.duration.toString()
            tvReleaseDate.text = tvModel.releaseDate
            tvOverviewDetail.text = tvModel.overview
            tvGenre.text = tvModel.genre
            tvRatingDetail.text =
                String.format(resources.getString(R.string.rating_format), tvModel.score)
            tvDuration.text = tvModel.duration.toString()

            Glide.with(root).load("${BuildConfig.IMAGE_URL}${tvModel.seriesPoster}")
                .into(ivBackCoverDetail)
            Glide.with(root).load("${BuildConfig.IMAGE_URL}${tvModel.seriesPoster}")
                .into(ivCoverDetail)
            Glide.with(root).load(R.drawable.ic_baseline_how_to_vote_24).into(ivCategory)
            setFavoriteTv(tvModel)
        }
    }

    private fun setFavoriteFilm(film: FilmModel) {
        binding.apply {
            fbAddFav.setOnClickListener {
                detailViewModel.setFilmFavorite(film)
                isFavorite = !isFavorite
                changeFavlogo()
                if (isFavorite) Toast.makeText(
                    this@DetailActivity,
                    "Saved to favorite",
                    Toast.LENGTH_SHORT
                ).show()
                else Toast.makeText(
                    this@DetailActivity,
                    "Deleted from favorite",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun setFavoriteTv(tv: TvModel) {
        binding.apply {
            fbAddFav.setOnClickListener {
                detailViewModel.setTvFavorite(tv)
                isFavorite = !isFavorite
                changeFavlogo()
                if (isFavorite) Toast.makeText(
                    this@DetailActivity,
                    "Saved to favorite",
                    Toast.LENGTH_SHORT
                ).show()
                else Toast.makeText(
                    this@DetailActivity,
                    "Deleted from favorite",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }


    companion object {
        const val FILM = "FILM"
        var isMovie: Boolean? = null
    }
}