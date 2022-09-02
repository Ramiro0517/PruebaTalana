package com.example.pruebatalana.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebatalana.R
import com.example.pruebatalana.adapters.PostsAdapter
import com.example.pruebatalana.data.model.PostsModel
import com.example.pruebatalana.data.model.PostsProvider
import com.example.pruebatalana.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var  homeBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        val manager= LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this,manager.orientation )

        homeBinding.rvPosts.layoutManager = manager
        homeBinding.rvPosts.adapter =PostsAdapter(PostsProvider.posts) { onItemSelected(it) }
        homeBinding.rvPosts.addItemDecoration(decoration)
    }

    private fun onItemSelected(posts:PostsModel){
            val i=Intent(this, HomeDetailActivity::class.java)
            startActivity(i)
    }
}