package com.example.FilmsSearch

import android.content.Intent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {
    private lateinit var film: Film

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDetailedContent()
    }

    private fun setDetailedContent() {
        val film = arguments?.get(FILM_FIELD_NAME) as Film
        details_toolbar.title = film.title
        details_poster.setImageResource(film.poster)
        details_description.text = film.description

        details_fab_favorites.setImageResource(
            if (!film.isInFavorites) R.drawable.ic_baseline_favorite_24
            else R.drawable.ic_baseline_favorite_border_24
        )

        details_fab_favorites.setOnClickListener{
            if (!film.isInFavorites){
                details_fab_favorites.setImageResource(R.drawable.ic_baseline_favorite_24)
                film.isInFavorites = true
            }else{
                details_fab_favorites.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                film.isInFavorites = false
            }
        }

        details_fab_share.setOnClickListener{
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, "Checkout this film: $film.title \n\n $film.description")
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Share to:"))
        }
    }
    companion object{
        private const val FILM_FIELD_NAME = "film"
    }
}