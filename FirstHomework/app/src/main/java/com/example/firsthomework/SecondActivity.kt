package com.example.firsthomework

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.firsthomework.R

class SecondActivity : AppCompatActivity() {

    private lateinit var emailEdit: EditText
    private lateinit var passwordEdit: EditText
    private lateinit var continueButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        emailEdit = findViewById(R.id.editEmail)
        passwordEdit = findViewById(R.id.editPassword)
        continueButton = findViewById(R.id.buttonContinue)

        val watcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                validateInputs()
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }

        emailEdit.addTextChangedListener(watcher)
        passwordEdit.addTextChangedListener(watcher)

        continueButton.setOnClickListener {
            val email = emailEdit.text.toString()
            val password = passwordEdit.text.toString()
            val intent = Intent(this, ThirdActivity::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            startActivity(intent)
        }
    }

    private fun validateInputs() {
        val email = emailEdit.text.toString()
        val password = passwordEdit.text.toString()

        val emailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val passwordValid = password.length >= 8 &&
                password.any { it.isDigit() } &&
                password.any { it.isUpperCase() } &&
                password.any { it.isLowerCase() }

        continueButton.isEnabled = emailValid && passwordValid
    }
}