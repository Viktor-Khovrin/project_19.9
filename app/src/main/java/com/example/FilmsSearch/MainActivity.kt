package com.example.FilmsSearch

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val filmsDataBase = listOf(
        Film("Stranger Things", R.drawable.stranger_things, "When a young boy disappears, his mother, a police chief and his friends must confront terrifying supernatural forces in order to get him back", 6.5f),
        Film("A Call to Spy", R.drawable.a_call_to_spy, "In the beginning of WWII, with Britain becoming desperate, Churchill orders his new spy agency - SOE - to recruit and train women as spies", 7.2f),
        Film("Big Daddy", R.drawable.big_daddy, "A lazy law-school grad adopts a kid to impress his girlfriend, but everything doesn't go as planned and he becomes the unlikely foster father", 6.9f),
        Film("Blue Jasmine", R.drawable.blue_jasmine, "A New York socialite, deeply troubled and in denial, arrives in San Francisco to impose upon her sister. She looks like a million dollars but isn't bringing money, peace, or love", 7.1f),
        Film("Boogie Nights", R.drawable.boogie_nights, "Back when sex was safe, pleasure was a business and business was booming, an idealistic porn producer aspires to elevate his craft to an art when he discovers a hot young talent", 8.1f),
        Film("Catch Me If You Can", R.drawable.catch_me_if_you_can, "This should be a description", 5.3f),
        Film("Deliverance", R.drawable.deliverance, "Intent on seeing the Cahulawassee River before it's dammed and turned into a lake, outdoor fanatic Lewis Medlock takes his friends on a canoeing trip they'll never forget into the dangerous American back-country", 4.4f),
        Film("Goodfellas", R.drawable.goodfellas, "The story of Henry Hill and his life in the mob, covering his relationship with his wife Karen Hill and his mob partners Jimmy Conway and Tommy DeVito in the Italian-American crime syndicate", 3.3f),
    )

    private var time_pressed = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSupportActionBar()?.hide()
        initNavigation()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_placeholder, HomeFragment())
            .commit()
    }

    fun launchDetailsFragment(film: Film) {
        val bundle = Bundle()
        bundle.putParcelable("film", film)
        val fragment = DetailsFragment()
        fragment.arguments = bundle
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun initNavigation(){
        bottom_navigation.setOnNavigationItemSelectedListener{
            when (it.itemId) {
                R.id.favorites -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_placeholder, FavoritesFragment())
                        .addToBackStack(null)
                        .commit()
                    true
                }
                R.id.selections -> {
                    Toast.makeText(this,R.string.menu_selections_title, Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.watch_later -> {
                    Toast.makeText(this,R.string.menu_watch_later_title, Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }

    override fun onBackPressed(){
        if (supportFragmentManager.backStackEntryCount == 0){
            if (time_pressed + BACK_PRESSED_TIMEOUT > System.currentTimeMillis()){
                super.onBackPressed()
                finish()
            }else {
                Toast.makeText(this, R.string.on_back_pressed, Toast.LENGTH_SHORT).show()
                time_pressed = System.currentTimeMillis()
            }
        }else{
            super.onBackPressed()
        }

    }

    companion object{
        const val BACK_PRESSED_TIMEOUT = 2000
    }


}