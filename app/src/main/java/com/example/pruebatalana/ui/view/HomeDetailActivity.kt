package com.example.pruebatalana.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.pruebatalana.PruebaTalanaApp
import com.example.pruebatalana.R
import com.example.pruebatalana.databinding.ActivityHomeDetailBinding
import com.example.pruebatalana.ui.viewModel.PostsViewModel

class HomeDetailActivity : AppCompatActivity() {

    private val postViewModel: PostsViewModel by viewModels()
    private lateinit var detailBinding: ActivityHomeDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityHomeDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)
        initUI()
    }

    private fun initUI(){
        val title = intent.getStringExtra("tittle")
        val description = intent.getStringExtra("description")
        val date = intent.getStringExtra("date")
        val published = intent.getStringExtra("published")
        val image = intent.getStringExtra("image")

        detailBinding.tvTitleDetails.text= title
        detailBinding.tvDescriptionDetalis.text = "Descripción: $description"
        detailBinding.tvPublishiedDetail.text= "Date: $date"
        detailBinding.tvDateDetails.text= "Published: $published"
        Glide.with(detailBinding.ivPostsDetails.context).load(image).into(detailBinding.ivPostsDetails)

        detailBinding.btnBackDetails.setOnClickListener {
            onBackPressed()
        }
        /*postViewModel.onCreate()
        postViewModel.postsModel.observe(this, Observer {
            detailBinding.tvTitleDetails.text= it.tittle
            detailBinding.tvDescriptionDetalis.text = it.description
            detailBinding.tvPublishiedDetail.text= it.published
            detailBinding.tvDateDetails.text= it.date
            Glide.with(detailBinding.ivPostsDetails.context).load(it.image).into(detailBinding.ivPostsDetails)
            // binding.edtPassword
            //binding.btnLogin
        })*/
    }
}