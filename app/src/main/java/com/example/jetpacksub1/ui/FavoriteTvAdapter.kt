package com.example.jetpacksub1.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jetpacksub1.BuildConfig
import com.example.jetpacksub1.R
import com.example.jetpacksub1.core.databinding.ListWatchBinding
import com.example.jetpacksub1.core.domain.model.TvModel
import com.example.jetpacksub1.detail.DetailActivity

class FavoriteTvAdapter(private val context: Context) :
    RecyclerView.Adapter<FavoriteTvAdapter.FavoriteTvViewHolder>() {

    private var listFavoriteTv = ArrayList<TvModel>()

    fun setData(list: List<TvModel>) {
        if (list == null) return
        listFavoriteTv.clear()
        listFavoriteTv.addAll(list)
        notifyDataSetChanged()
    }

    inner class FavoriteTvViewHolder(private val binding: ListWatchBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(film: TvModel) {
            binding.apply {
                tvFilmtitleyear.text = film.title
                tvReleaseDate.text = film.releaseDate
                tvRate.text =
                    String.format(context.resources.getString(R.string.rating_format), film.score)
                tvDesc.text = film.overview

                Glide.with(root).load("${BuildConfig.IMAGE_URL}${film.seriesPoster}").into(ivPoster)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.FILM, film.id)
                    DetailActivity.isMovie = false
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    itemView.context.startActivity(intent)
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteTvViewHolder =
        FavoriteTvViewHolder(
            ListWatchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: FavoriteTvViewHolder, position: Int) {
        val tv = listFavoriteTv[position]
        if (tv != null) {
            holder.bind(tv)
        }
    }

    override fun getItemCount(): Int = listFavoriteTv.size
}
