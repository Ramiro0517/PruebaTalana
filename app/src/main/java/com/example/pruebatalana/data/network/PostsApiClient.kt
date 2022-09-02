package com.example.pruebatalana.data.network

import com.example.pruebatalana.data.model.PostsModel
import retrofit2.Response

import retrofit2.http.GET

interface PostsApiClient {

    @GET("posts")
    suspend fun getAllPosts(): Response<List<PostsModel>>
}