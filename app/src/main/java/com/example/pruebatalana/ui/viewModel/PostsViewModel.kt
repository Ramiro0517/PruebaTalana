package com.example.pruebatalana.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatalana.data.model.PostsModel
import com.example.pruebatalana.domain.GetPostsUseCase
import kotlinx.coroutines.launch

class PostsViewModel: ViewModel() {

    val postsModel = MutableLiveData<PostsModel>()

    var getPostsUseCase = GetPostsUseCase()

    fun onCreate() {
          viewModelScope.launch {
              val result = getPostsUseCase()

              if (!result.isNullOrEmpty()){
                  postsModel.postValue(result[0])

              }
          }
    }



}