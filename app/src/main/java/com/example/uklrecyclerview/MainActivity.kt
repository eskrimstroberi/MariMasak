package com.example.uklrecyclerview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.View
import android.widget.Button
import android.widget.EditText

    class MainActivity : AppCompatActivity(), View.OnClickListener {
        private lateinit var username: EditText
        private lateinit var email: EditText
        private lateinit var password: EditText
        private lateinit var btnLogin: Button

        private val key_Username = "MM"
        private val key_Email = "II"
        private val key_password = "EE"

        @SuppressLint("WrongViewCast")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            username = findViewById(R.id.username)
            password = findViewById(R.id.password)

            val btnLogin: Button = findViewById(R.id.btnLogin)
            btnLogin.setOnClickListener(this)

            val btnRegister: Button = findViewById(R.id.btnRegister)
            btnRegister.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            val username = username.text.toString()
            val password = password.text.toString()
            if (username.isNotBlank() && username.isNotBlank() && password.isNotBlank()) {
                when (v.id) {
                    R.id.btnLogin -> {
                        val moveIntent = Intent(this@MainActivity, Home::class.java)
                        moveIntent.putExtra(key_Username, username)
                        moveIntent.putExtra(key_password, password)
                        startActivity(moveIntent)
                    }
                    R.id.btnRegister -> {
                        val moveIntent = Intent(this@MainActivity, Register::class.java)
                        startActivity(moveIntent)
                    }
                }
            }

        }
    }



