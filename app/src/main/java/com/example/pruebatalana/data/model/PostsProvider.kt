package com.example.pruebatalana.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostsProvider @Inject constructor() {

        var posts:List<PostsModel> = emptyList()

}