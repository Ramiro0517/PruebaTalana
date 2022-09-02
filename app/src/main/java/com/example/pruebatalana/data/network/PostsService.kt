package com.example.pruebatalana.data.network

import com.example.pruebatalana.core.RetrofitHelp
import com.example.pruebatalana.data.model.PostsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class   PostsService @Inject constructor(private val api: PostsApiClient ) {

      suspend fun getPosts():List<PostsModel>{
        return withContext(Dispatchers.IO){
            val response = api.getAllPosts()
            response.body() ?: emptyList()
        }

    }
}