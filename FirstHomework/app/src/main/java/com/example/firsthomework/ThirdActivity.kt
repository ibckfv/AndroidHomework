package com.example.firsthomework

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.firsthomework.R

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")

        findViewById<TextView>(R.id.textEmail).text = "Email: $email"
        findViewById<TextView>(R.id.textPassword).text = "Password: $password"
    }
}