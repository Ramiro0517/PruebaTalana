package com.example.pruebatalana.di

import com.example.pruebatalana.core.RetrofitHelp
import com.example.pruebatalana.data.network.PostsApiClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return  Retrofit.Builder()
            .baseUrl("http://demo8937510.mockable.io/")
            .addConverterFactory(GsonConverterFactory.create(RetrofitHelp.gson))
            .build()
    }

    @Singleton
    @Provides
    fun providePostsApiClient(retrofit: Retrofit):PostsApiClient{
        return retrofit.create(PostsApiClient::class.java)
    }
}*/