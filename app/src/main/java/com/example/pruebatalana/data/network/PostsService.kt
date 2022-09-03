package com.example.pruebatalana.data.network

import com.example.pruebatalana.core.RetrofitHelp
import com.example.pruebatalana.data.model.PostsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
class   PostsService () {

    private val retrofit = RetrofitHelp.getRetrofit()
      suspend fun getPosts():List<PostsModel>{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(PostsApiClient::class.java).getAllPosts()
            response.body() ?: emptyList()
        }

    }
}