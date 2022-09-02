package com.example.pruebatalana.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebatalana.data.model.PostsModel
import com.example.pruebatalana.data.model.PostsProvider

class PostsAdapter(val postsList : List<PostsProvider>) : RecyclerView.Adapter<PostsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {

    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {

    }

    override fun getItemCount(): Int =  postsList.size
    }
}