package com.myapp.publicserviceapps

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameField = findViewById<EditText>(R.id.usernameEditText)  // Ganti emailField dengan usernameEditText
        val passwordField = findViewById<EditText>(R.id.passwordEditText)  // Ganti passwordField dengan passwordEditText
        val loginButton = findViewById<Button>(R.id.loginButton)  // Menambahkan tanda kurung yang hilang

        loginButton.setOnClickListener {
            val username = usernameField.text.toString().trim()  // Ganti email dengan username
            val password = passwordField.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Username dan Password harus diisi!", Toast.LENGTH_SHORT).show()
            } else if (username == "admin@example.com" && password == "admin123") {
                // Login berhasil, pindah ke MainActivity
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // Login gagal
                Toast.makeText(this, "Username atau Password salah!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
