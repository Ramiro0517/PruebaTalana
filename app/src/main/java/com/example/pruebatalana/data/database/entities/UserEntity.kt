package com.example.pruebatalana.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table" )
data class UserEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id") val id: Int=0,
    @ColumnInfo(name="userName") val userName: String?,
    @ColumnInfo(name="password") val password: String?
 )