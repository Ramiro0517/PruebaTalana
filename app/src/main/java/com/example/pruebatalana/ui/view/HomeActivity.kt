package com.example.pruebatalana.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebatalana.R
import com.example.pruebatalana.adapters.PostsAdapter
import com.example.pruebatalana.data.model.PostsProvider
import com.example.pruebatalana.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {

    private lateinit var  homeBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)
        initRecyclerView()
    }

    private fun initRecyclerView(){

        homeBinding.rvPosts.layoutManager = LinearLayoutManager(this)
        homeBinding.rvPosts.adapter =PostsAdapter(PostsProvider.posts)
    }
}