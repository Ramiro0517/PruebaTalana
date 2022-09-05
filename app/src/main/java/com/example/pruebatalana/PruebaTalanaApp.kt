package com.example.pruebatalana

import android.app.Application
import androidx.room.Room
import com.example.pruebatalana.data.database.Prefs
import com.example.pruebatalana.data.database.TalanaDatabase

class PruebaTalanaApp: Application() {

    /*val room = Room
        .databaseBuilder(this, TalanaDatabase::class.java, "usuarios")
        .build()*/
    companion object{
       lateinit var prefs:Prefs
    }
    override fun onCreate() {
        super.onCreate()
         prefs =Prefs(applicationContext)
    }
}