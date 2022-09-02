package com.example.pruebatalana.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.pruebatalana.databinding.ActivityMainBinding
import com.example.pruebatalana.ui.viewModel.PostsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var  binding : ActivityMainBinding
    private val postViewModel: PostsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        postViewModel.onCreate()
        postViewModel.postsModel.observe(this, Observer {
            binding.edtUsuario.text= it.tittle
           // binding.edtPassword
            //binding.btnLogin

        })

        binding.btnLogin.setOnClickListener {
            val i = Intent(this,HomeActivity::class.java)
            startActivity(i)
        }
    }
}