package com.example.pruebatalana.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pruebatalana.data.database.dao.UserDao
import com.example.pruebatalana.data.database.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class TalanaDatabase:RoomDatabase() {

    abstract fun userDao():UserDao
}