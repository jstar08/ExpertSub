package com.example.jetpacksub1.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jetpacksub1.core.BuildConfig
import com.example.jetpacksub1.core.R
import com.example.jetpacksub1.core.databinding.ListWatchBinding
import com.example.jetpacksub1.core.domain.model.FilmModel
import com.example.jetpacksub1.detail.DetailActivity

class FavoriteFilmAdapter(private val context: Context) :
    RecyclerView.Adapter<FavoriteFilmAdapter.FavoriteFilmViewHolder>() {

    private var listFavoriteFilm = ArrayList<FilmModel>()

    fun setData(list: List<FilmModel>) {
        if (list == null) return
        listFavoriteFilm.clear()
        listFavoriteFilm.addAll(list)
        notifyDataSetChanged()
    }

    inner class FavoriteFilmViewHolder(private val binding: ListWatchBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(film: FilmModel) {
            binding.apply {
                tvFilmtitleyear.text = film.title
                tvReleaseDate.text = film.releaseDate
                tvRate.text =
                    String.format(context.resources.getString(R.string.rating_format), film.score)
                tvDesc.text = film.overview

                Glide.with(root).load("${BuildConfig.IMAGE_URL}${film.moviePoster}").into(ivPoster)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.FILM, film.id)
                    DetailActivity.isMovie = true
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    itemView.context.startActivity(intent)
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteFilmViewHolder =
        FavoriteFilmViewHolder(
            ListWatchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: FavoriteFilmViewHolder, position: Int) {
        val film = listFavoriteFilm[position]
        holder.bind(film)
    }

    override fun getItemCount(): Int = listFavoriteFilm.size

}
