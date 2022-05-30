package com.example.FilmsSearch

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initMenuButtons()
    }
    private fun initMenuButtons(){
        button_menu.setOnClickListener(){
            Toast.makeText(this,"Меню",Toast.LENGTH_SHORT).show()
        }
        button_favorites.setOnClickListener(){
            Toast.makeText(this,"Избранное",Toast.LENGTH_SHORT).show()
        }
        button_watch_later.setOnClickListener(){
            Toast.makeText(this,"Посмотреть позже",Toast.LENGTH_SHORT).show()
        }
        button_selections.setOnClickListener(){
            Toast.makeText(this,"Подборки",Toast.LENGTH_SHORT).show()
        }
        button_settings.setOnClickListener(){
            Toast.makeText(this,"Настройки",Toast.LENGTH_SHORT).show()
        }
    }
}