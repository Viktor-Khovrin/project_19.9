package com.example.filmsSearch

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.filmsSearch.databinding.FilmItemBinding

//import kotlinx.android.synthetic.main.film_item.view.*

class FilmViewHolder(itemView: FilmItemBinding) : RecyclerView.ViewHolder(itemView.root) {
    private val title = itemView.title
    private val poster = itemView.poster
    private val description = itemView.description
    private val ratingDonut = itemView.ratingDonut
    fun onBind(film: Film){
        title.text = film.title
        Glide.with(itemView)
            .load(film.poster)
            .centerCrop()
            .into(poster)
        description.text = film.description
        ratingDonut.setProgress((film.rating * 10).toInt())
    }
}