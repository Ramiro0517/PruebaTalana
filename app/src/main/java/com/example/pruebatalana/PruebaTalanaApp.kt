package com.example.pruebatalana

import android.app.Application
import androidx.room.Room
import com.example.pruebatalana.data.database.TalanaDatabase

class PruebaTalanaApp: Application() {

    val room = Room
        .databaseBuilder(this, TalanaDatabase::class.java, "usuarios")
        .build()
}