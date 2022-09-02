package com.example.pruebatalana.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatalana.data.model.PostsModel
import com.example.pruebatalana.domain.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getPostsUseCase : GetPostsUseCase
    ): ViewModel() {

    val postsModel = MutableLiveData<PostsModel>()


    fun onCreate() {
          viewModelScope.launch {
              val result = getPostsUseCase()

              if (!result.isNullOrEmpty()){
                  postsModel.postValue(result[0])

              }
          }
    }



}