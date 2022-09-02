package com.example.pruebatalana.core

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelp {

    //val POSTS ="http://demo8937510.mockable.io/"

    var gson = GsonBuilder()
        .setLenient()
        .create()

    fun getRetrofit():Retrofit{
        return  Retrofit.Builder()
            .baseUrl("http://demo8937510.mockable.io/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}