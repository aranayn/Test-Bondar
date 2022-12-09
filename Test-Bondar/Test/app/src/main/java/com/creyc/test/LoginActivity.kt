package com.creyc.test

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.view.*

class LoginActivity : AppCompatActivity() {
    private lateinit var shared: SharedPreferences

    private fun changeActivity(activity: Class<*>){
        val intent = Intent(this, activity)
        startActivity(intent)
    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        shared = getSharedPreferences("data", MODE_PRIVATE)

        btnLogin.setOnClickListener {
            if (!((email.text.toString() == shared.getString("email", "no-login").toString()) && (etPass.text.toString()==shared.getString("password", "no-password").toString()))){
                showToast("Неверный логин или пароль")
                return@setOnClickListener
            }
            if (rememberLogin.isChecked){
                shared.edit().putString("autoLogin", "true").apply()
            }
            changeActivity(MainActivity::class.java)
        }
    }


}