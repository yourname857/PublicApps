package com.myapp.publicserviceapps

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.myapp.publicserviceapps.LoginActivity
import com.myapp.publicserviceapps.R

class RegisterActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val phoneEditText = findViewById<EditText>(R.id.phoneEditText)
        val ktpEditText = findViewById<EditText>(R.id.ktpEditText)
        val ktaEditText = findViewById<EditText>(R.id.ktaEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val registerButton = findViewById<Button>(R.id.registerButton)
        val loginTextView = findViewById<TextView>(R.id.loginTextView)
        val eyeIcon = findViewById<ImageView>(R.id.showPasswordIcon)

        // Menyembunyikan password secara default
        passwordEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

        eyeIcon.setOnClickListener {
            // Simpan posisi kursor
            val cursorPositionStart = passwordEditText.selectionStart
            val cursorPositionEnd = passwordEditText.selectionEnd

            // Ubah input type untuk password visibility
            if (passwordEditText.inputType == InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD) {
                passwordEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                eyeIcon.setImageResource(R.drawable.ic_launcher_keyon) // Ganti dengan ikon open
            } else {
                passwordEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                eyeIcon.setImageResource(R.drawable.ic_launcher_keyoff) // Ganti dengan ikon tersembunyi
            }

            // Setelah mengubah inputType, kembalikan posisi kursor ke posisi sebelumnya
            passwordEditText.setSelection(cursorPositionStart.coerceAtMost(cursorPositionEnd)) // Jaga posisi kursor tetap valid
        }


        registerButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val phone = phoneEditText.text.toString()
            val ktp = ktpEditText.text.toString()
            val kta = ktaEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty() && ktp.isNotEmpty() && kta.isNotEmpty() && password.isNotEmpty()) {
                Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

        loginTextView.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
