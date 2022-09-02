package com.example.pruebatalana.data

import com.example.pruebatalana.data.model.PostsModel
import com.example.pruebatalana.data.model.PostsProvider
import com.example.pruebatalana.data.network.PostsService
import javax.inject.Inject

class PostsRepository @Inject constructor( private val api : PostsService, private val postsProvider: PostsProvider) {

    suspend fun getAllPosts():List<PostsModel>{
        val response = api.getPosts()
        postsProvider.posts = response
        return response
    }
}