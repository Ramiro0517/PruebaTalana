package com.example.pruebatalana.ui.view

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.pruebatalana.PruebaTalanaApp
import com.example.pruebatalana.data.database.TalanaDatabase
import com.example.pruebatalana.data.database.dao.UserDao
import com.example.pruebatalana.data.database.entities.UserEntity
import com.example.pruebatalana.databinding.ActivityMainBinding
import com.example.pruebatalana.ui.viewModel.PostsViewModel
import kotlinx.coroutines.launch
import androidx.lifecycle.Observer
import com.example.pruebatalana.PruebaTalanaApp.Companion.prefs


class MainActivity : AppCompatActivity() {

    private lateinit var  binding : ActivityMainBinding
    private val postViewModel: PostsViewModel by viewModels()
    private lateinit var  user : PruebaTalanaApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        postViewModel.onCreate()
      /*  postViewModel.postsModel.observe(this, Observer {
            binding.edtUsuario.text= it.tittle
           // binding.edtPassword
            //binding.btnLogin
        })*/
        binding.btnLogin.setOnClickListener {
          login()
            //startActivity(Intent(this,HomeActivity::class.java ))
           // checkUserValues()
        }
        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java ))
        }
        if (prefs.getUser().isNotEmpty()) {
            showAlert()
        }
    }

    private fun checkUserValues(){
            startActivity(Intent(this,HomeActivity::class.java ))
    }

    private fun showAlert (){
        val userName = prefs.getUser()
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Bienvenido $userName")
            .setMessage("Usted ya inició sesión anteriormente")
            .setPositiveButton("Ingresar"){ _, it->
                checkUserValues()
            }
            .create()
            .show()
    }
    private fun login() {
        lifecycleScope.launch {
            val email = binding.edtUsuario.text.toString()
            val password = binding.edtPassword.text.toString()

            if (validateForm(email, password)) {
                val room1 = Room
                    .databaseBuilder(applicationContext, TalanaDatabase::class.java, "usuarios")
                    .build()
                val userdao: UserDao = room1.userDao()
               val a = userdao.getUsers(email, password)
                if (a !=null) {
                    prefs.saveGmail(email)
                    prefs.savePassword(password)
                   goToHome()
                }
                else {
                    Toast.makeText(applicationContext, "Sus credenciales no son las correctas", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(applicationContext, "Ingrese sus credenciales", Toast.LENGTH_LONG).show()
            }
        }


    }
    fun goToHome(){
        Toast.makeText(this, "Bienvenido!!", Toast.LENGTH_LONG).show()
        startActivity(Intent(this,HomeActivity::class.java ))
    }

    fun String.isEmailValid():Boolean{ //validacion para saber si el usuario ingreso el formato adecuado
        return !TextUtils.isEmpty(this)&& android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }
    private fun validateForm(email:String, password:String):Boolean{
        if (email.isBlank()){
            return false
        }
        if (password.isBlank()){
            return false
        }
        if (!email.isEmailValid()){
            return false
        }
        return true
    }
}