package com.example.modul5lesson2.activity

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Switch
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modul5lesson2.Model.Chat
import com.example.modul5lesson2.Adapter.ChatAdapter
import com.example.modul5lesson2.Adapter.ThemeAdapter
import com.example.modul5lesson2.Model.Theme
import com.example.modul5lesson2.R
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.themes_layout)

//        initViewsMain()
//        initViewsContact()
//        initViewsNotification()
        initViewsTheme()
    }

    private fun initViewsTheme(){
        recyclerView = findViewById(R.id.rv_themes)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val themes : ArrayList<Theme> = ArrayList()
        themes.add(Theme(true))
        themes.add(Theme(false))
        themes.add(Theme(false))
        themes.add(Theme())
        themes.add(Theme())
        themes.add(Theme())
        themes.add(Theme())

        recyclerView.adapter = ThemeAdapter(themes)
    }


    private fun initViewsMain(){
        recyclerView = findViewById(R.id.recyclerViewMain)
        recyclerView.layoutManager = GridLayoutManager(this, 1)
        refreshAdapter(getAllChats())
    }

    private fun initViewsContact(){
        recyclerView = findViewById(R.id.recyclerViewContact)
        recyclerView.layoutManager = GridLayoutManager(this, 1)
        refreshAdapter(getAllChats())
    }

    private fun initViewsNotification(){
        val switch1 = findViewById<Switch>(R.id.switch1)

        switch1.setOnClickListener {
            if(switch1.isChecked){
                switch1.setBackgroundColor(Color.TRANSPARENT)
                switch1.setTextColor(Color.GREEN)
            }else{
                switch1.setBackgroundColor(Color.TRANSPARENT)
                switch1.setTextColor(Color.WHITE)
            }
        }

    }

    private fun refreshAdapter(chats : ArrayList<Chat>){
        val adapter = ChatAdapter(this, chats)
        recyclerView.adapter = adapter
    }

    private fun getAllChats() : ArrayList<Chat>{
        val chats = ArrayList<Chat>()

        for (i in 0..15){
            chats.add(Chat(R.drawable.img_profile, "Designer", "Thank you so much"))
        }
        return chats
    }
}