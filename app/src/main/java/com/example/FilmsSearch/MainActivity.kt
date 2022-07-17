package com.example.FilmsSearch

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var timeBackPressed = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //initNavigation()
        navigationInit()
        //initMenuButtons()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_placeholder,HomeFragment())
            .commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            super.onBackPressed()
        } else{
            if (timeBackPressed + TIME_INTERVAL > System.currentTimeMillis()){
                super.onBackPressed()
                finish()
            }else Toast.makeText(this,R.string.double_tap_text,Toast.LENGTH_SHORT).show()
        }
        timeBackPressed = System.currentTimeMillis()
    }

    companion object{
        const val TIME_INTERVAL = 2000
    }

    fun launchDetailsFragment(film: Film){
        val bundle = Bundle()
        bundle.putParcelable("film",film)
        val fragment = DetailsFragment()
        fragment.arguments = bundle
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder,fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun navigationInit(){
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.favorites -> {
                    Toast.makeText(this, R.string.menu_favorites_title, Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.watch_later -> {
                    Toast.makeText(this, R.string.menu_watch_later_title, Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.selections -> {
                    Toast.makeText(this, R.string.menu_selections_title, Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
/*
    private fun initNavigation(){
        topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.settings -> {
                    Toast.makeText(this, R.string.menu_settings_title, Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
*/
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