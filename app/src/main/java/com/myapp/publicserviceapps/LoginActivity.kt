package com.myapp.publicserviceapps

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameField = findViewById<EditText>(R.id.usernameEditText)
        val passwordField = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val registerText = findViewById<TextView>(R.id.registerTextView)
        val passwordToggle = findViewById<ImageView>(R.id.passwordToggle)

        var isPasswordVisible = false

        // Toggle Password Visibility
        passwordToggle.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            if (isPasswordVisible) {
                passwordField.transformationMethod = HideReturnsTransformationMethod.getInstance()
                passwordToggle.setImageResource(R.drawable.ic_launcher_keyon) // Ganti ikon mata terbuka
            } else {
                passwordField.transformationMethod = PasswordTransformationMethod.getInstance()
                passwordToggle.setImageResource(R.drawable.ic_launcher_keyoff) // Ganti ikon mata tertutup
            }
            passwordField.setSelection(passwordField.text.length) // Jaga posisi kursor
        }

        loginButton.setOnClickListener {
            val username = usernameField.text.toString().trim()
            val password = passwordField.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Username dan Password harus diisi!", Toast.LENGTH_SHORT).show()
            } else if (username == "admin" && password == "admin123") {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Username atau Password salah!", Toast.LENGTH_SHORT).show()
            }
        }

        registerText.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
