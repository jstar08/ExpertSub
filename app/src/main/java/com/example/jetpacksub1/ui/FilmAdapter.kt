package com.example.jetpacksub1.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jetpacksub1.BuildConfig.IMAGE_URL
import com.example.jetpacksub1.R
import com.example.jetpacksub1.core.databinding.ListWatchBinding
import com.example.jetpacksub1.core.domain.model.FilmModel
import com.example.jetpacksub1.detail.DetailActivity

class FilmAdapter(private val context: Context) :
    RecyclerView.Adapter<FilmAdapter.FilmViewHolder>() {

    private var listFilm = ArrayList<FilmModel>()

    fun setData(list: List<FilmModel>) {
        if (list == null) return
        listFilm.clear()
        listFilm.addAll(list)
        notifyDataSetChanged()
    }

    inner class FilmViewHolder(private val binding: ListWatchBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(film: FilmModel) {
            binding.apply {
                tvFilmtitleyear.text = film.title
                tvReleaseDate.text = film.releaseDate
                tvRate.text =
                    String.format(context.resources.getString(R.string.rating_format), film.score)
                tvDesc.text = film.overview

                Glide.with(root).load("$IMAGE_URL${film.moviePoster}").into(ivPoster)

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder =
        FilmViewHolder(
            ListWatchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = listFilm[position]
        if (film != null) {
            holder.bind(film)
        }
    }

    override fun getItemCount(): Int = listFilm.size

}



