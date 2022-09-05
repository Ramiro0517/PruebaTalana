package com.example.pruebatalana.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebatalana.PruebaTalanaApp.Companion.prefs
import com.example.pruebatalana.adapters.PostsAdapter
import com.example.pruebatalana.data.model.PostsModel
import com.example.pruebatalana.data.model.PostsProvider
import com.example.pruebatalana.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {

    private lateinit var  homeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)

        initRecyclerView()
        initUI()
    }

    private fun initUI(){
        val userName = prefs.getUser()
        homeBinding.tvUser.text="Bienvenido $userName "
        homeBinding.btnCerrarSesion.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("¿Seguro que desea cerrar sesión?")
                .setMessage("Si continua, deberá ingresar nuevamente con sus credenciales")
                .setPositiveButton("Si"){ _, it->
                    prefs.clear()
                    onBackPressed()
                }
                .setNegativeButton("No",null )
                .create()
                .show()

        }

    }

    private fun initRecyclerView(){
        val manager= LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this,manager.orientation )

        homeBinding.rvPosts.layoutManager = manager
        homeBinding.rvPosts.adapter =PostsAdapter(PostsProvider.posts) { onItemSelected(it) }
        homeBinding.rvPosts.addItemDecoration(decoration)
    }

    private fun onItemSelected(posts:PostsModel){
  //  Toast.makeText(this, posts.tittle, Toast.LENGTH_SHORT).show()
            val intent=Intent(this, HomeDetailActivity::class.java)
            intent.putExtra("tittle",posts.tittle)
            intent.putExtra("description",posts.description)
            intent.putExtra("date",posts.date)
            intent.putExtra("published",posts.published)
            intent.putExtra("image",posts.image)
            startActivity(intent)
    }
}