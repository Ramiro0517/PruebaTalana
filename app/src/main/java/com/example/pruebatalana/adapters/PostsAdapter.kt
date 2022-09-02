package com.example.pruebatalana.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebatalana.R
import com.example.pruebatalana.data.model.PostsModel
import com.example.pruebatalana.data.model.PostsProvider

class PostsAdapter(private val postsList : List<PostsModel>, private val onClickListener:(PostsModel)->Unit) : RecyclerView.Adapter<PostsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val layoutInflater =LayoutInflater.from(parent.context)
        return PostsViewHolder(layoutInflater.inflate(R.layout.item_posts, parent, false))
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val item = postsList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int =  postsList.size

}