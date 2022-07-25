package com.example.FilmsSearch

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNavigation()
        initMenuButtons()
    }
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
        bottom_navigation.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.favorites -> {
                    Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.watch_later -> {
                    Toast.makeText(this, "Посмотреть позже", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.selections -> {
                    Toast.makeText(this, "Подборки", Toast.LENGTH_SHORT).show()
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