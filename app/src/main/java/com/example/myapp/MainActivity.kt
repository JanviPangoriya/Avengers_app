package com.example.myapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    var titleName :String? ="Avenger"
    lateinit var sharedPreferences : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name),Context.MODE_PRIVATE)
        setContentView(R.layout.scroll_view_practice)
        titleName = sharedPreferences.getString("Title","The Avengers")
        title  = titleName
    }

}
