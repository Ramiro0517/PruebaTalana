package com.example.pruebatalana.data

import com.example.pruebatalana.data.model.PostsModel
import com.example.pruebatalana.data.model.PostsProvider
import com.example.pruebatalana.data.network.PostsService

class PostsRepository {

    private val api = PostsService()

    suspend fun getAllPosts():List<PostsModel>{
        val response = api.getPosts()
        PostsProvider.posts = response
        return response
    }
}