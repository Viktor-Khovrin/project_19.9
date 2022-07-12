package com.example.FilmsSearch

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val filmsDataBase = listOf(
        Film("Stranger Things", R.drawable.stranger_things, "When a young boy disappears, his mother, a police chief and his friends must confront terrifying supernatural forces in order to get him back"),
        Film("A Call to Spy", R.drawable.a_call_to_spy, "In the beginning of WWII, with Britain becoming desperate, Churchill orders his new spy agency - SOE - to recruit and train women as spies"),
        Film("Big Daddy", R.drawable.big_daddy, "A lazy law-school grad adopts a kid to impress his girlfriend, but everything doesn't go as planned and he becomes the unlikely foster father"),
        Film("Blue Jasmine", R.drawable.blue_jasmine, "A New York socialite, deeply troubled and in denial, arrives in San Francisco to impose upon her sister. She looks like a million dollars but isn't bringing money, peace, or love"),
        Film("Boogie Nights", R.drawable.boogie_nights, "Back when sex was safe, pleasure was a business and business was booming, an idealistic porn producer aspires to elevate his craft to an art when he discovers a hot young talent"),
        Film("Catch Me If You Can", R.drawable.catch_me_if_you_can, "This should be a description"),
        Film("Deliverance", R.drawable.deliverance, "Intent on seeing the Cahulawassee River before it's dammed and turned into a lake, outdoor fanatic Lewis Medlock takes his friends on a canoeing trip they'll never forget into the dangerous American back-country"),
        Film("Goodfellas", R.drawable.goodfellas, "The story of Henry Hill and his life in the mob, covering his relationship with his wife Karen Hill and his mob partners Jimmy Conway and Tommy DeVito in the Italian-American crime syndicate"),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNavigation()
        initMenuButtons()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        main_recycler.apply {
            filmsAdapter = FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener{
                override fun click(film: Film) {
                    val bundle = Bundle()
                    bundle.putParcelable("film", film)
                    val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                    intent.putExtras(bundle)
                    startActivity(intent)
                }
            })
            adapter = filmsAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }

        filmsAdapter.addItems(filmsDataBase)
    }

    private lateinit var filmsAdapter: FilmListRecyclerAdapter
    private fun initNavigation(){
        topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.settings -> {
                    Toast.makeText(this, "Настройки", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
    private fun initMenuButtons(){
/*
        button_menu.setOnClickListener {
            Toast.makeText(this,"Меню",Toast.LENGTH_SHORT).show()
        }
        button_favorites.setOnClickListener {
            Toast.makeText(this,"Избранное",Toast.LENGTH_SHORT).show()
        }
        button_watch_later.setOnClickListener {
            Toast.makeText(this,"Посмотреть позже",Toast.LENGTH_SHORT).show()
        }
        button_selections.setOnClickListener {
            Toast.makeText(this,"Подборки",Toast.LENGTH_SHORT).show()
        }
        button_settings.setOnClickListener {
            Toast.makeText(this,"Настройки",Toast.LENGTH_SHORT).show()
        }*/
    }
}