package com.example.uklrecyclerview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

    class MainActivity : AppCompatActivity(), View.OnClickListener {
        private lateinit var email: EditText
        private lateinit var password: EditText
        private lateinit var btnLogin: Button

        private val key_Email = "MM"
        private val key_password = "EE"

        @SuppressLint("WrongViewCast")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            email = findViewById(R.id.username)
            password = findViewById(R.id.password)

            val btnLogin: Button = findViewById(R.id.btnLogin)
            btnLogin.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            val username = email.text.toString()
            val password = password.text.toString()
            if (username.isNotBlank() && password.isNotBlank()) {
                when (v.id) {
                    R.id.btnLogin -> {
                        val moveIntent = Intent(this@MainActivity, Home::class.java)
                        moveIntent.putExtra(key_Email, username)
                        moveIntent.putExtra(key_password, password)
                        startActivity(moveIntent)
                    }
                }
            }
        }
    }


