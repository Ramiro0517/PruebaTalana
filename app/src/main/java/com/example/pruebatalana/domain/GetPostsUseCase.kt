package com.example.pruebatalana.domain

import com.example.pruebatalana.data.PostsRepository
import com.example.pruebatalana.data.model.PostsModel
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(private val repository : PostsRepository) {


    suspend operator fun  invoke():List<PostsModel>?{
        return repository.getAllPosts()
    }
}