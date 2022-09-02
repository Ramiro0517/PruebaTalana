package com.example.pruebatalana.data.model

import com.google.gson.annotations.SerializedName

data class PostsModel (@SerializedName("id") val id :Int, @SerializedName("title") val tittle: String,
                       @SerializedName("image") val image : String, @SerializedName("description") val description:String)