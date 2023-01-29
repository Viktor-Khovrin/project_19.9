package com.example.FilmsSearch

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

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