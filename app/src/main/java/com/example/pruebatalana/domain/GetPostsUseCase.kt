package com.example.pruebatalana.domain

import com.example.pruebatalana.data.PostsRepository
import com.example.pruebatalana.data.model.PostsModel

class GetPostsUseCase {

    private val repository= PostsRepository()

    suspend operator fun  invoke():List<PostsModel>?{
        return repository.getAllPosts()
    }
}