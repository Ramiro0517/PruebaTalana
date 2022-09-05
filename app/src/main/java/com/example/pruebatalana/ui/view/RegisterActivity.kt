package com.example.pruebatalana.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.pruebatalana.PruebaTalanaApp
import com.example.pruebatalana.data.database.TalanaDatabase
import com.example.pruebatalana.data.database.dao.UserDao
import com.example.pruebatalana.data.database.entities.UserEntity
import com.example.pruebatalana.databinding.ActivityRegisterBinding
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {

    private lateinit var  registerBinding :ActivityRegisterBinding
    private lateinit var user : PruebaTalanaApp
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding= ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(registerBinding.root)

        registerBinding.btnRegisterBack.setOnClickListener {
            login()
        }
    }



    private fun login() {
        lifecycleScope.launch {
            val email = registerBinding.edtRegisterUsuario.text.toString()
            val password = registerBinding.edtRegisterPassword.text.toString()
            if (validateForm(email, password)) {
                val room1 = Room
                    .databaseBuilder(applicationContext, TalanaDatabase::class.java, "usuarios")
                    .build()
                val userdao: UserDao = room1.userDao()
              //  userdao.deleteAll()
                userdao.insert(UserEntity(0, email, password))
                val i = Intent(applicationContext, MainActivity::class.java)
                startActivity(i)
                //val createUser = UserEntity(0,email,password)
                //user.room1.userDao().insert(createUser)

            } else {
                Toast.makeText(applicationContext, "el formulario no es valido", Toast.LENGTH_SHORT).show()
            }
        }


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