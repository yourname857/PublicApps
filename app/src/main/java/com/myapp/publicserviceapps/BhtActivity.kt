package com.myapp.publicserviceapps

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class BhtActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bht)

        // Tombol Kembali ke MainActivity
        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            })
            finish()
        }

        // Tombol Download PDF
        val btnDownload = findViewById<MaterialButton>(R.id.btnDownload)
        btnDownload.setOnClickListener {
            Toast.makeText(this, "Memulai download dokumen...", Toast.LENGTH_SHORT).show()
            // TODO: Tambahkan fungsi download
        }
    }
}
