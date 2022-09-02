package com.example.pruebatalana.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pruebatalana.data.model.PostsModel
import com.example.pruebatalana.databinding.ItemPostsBinding
import java.util.*


class PostsViewHolder(view:View):RecyclerView.ViewHolder(view) {

    val binding = ItemPostsBinding.bind(view)

    fun render(posts:PostsModel, onClickListener:(PostsModel)->Unit){
        binding.tvTittle.text = posts.tittle.uppercase(Locale.getDefault())
        binding.tvDescription.text = posts.description
        Glide.with(binding.ivPosts.context).load(posts.image).into(binding.ivPosts)
        itemView.setOnClickListener {
            onClickListener(posts)
        }
    }
}