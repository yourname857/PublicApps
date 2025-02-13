package com.myapp.publicserviceapps

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Pastikan XML sesuai

        // Inisialisasi Bottom Navigation
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        bottomNavigation.setOnItemSelectedListener { menuItem: MenuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    showToast("Home")
                    return@setOnItemSelectedListener true
                }
                R.id.nav_profile -> {
                    showToast("Profil")
                    return@setOnItemSelectedListener true
                }
                else -> false
            }
        }

        // Tombol Pengambilan Surat BHT
        val btnBht = findViewById<LinearLayout>(R.id.btnBht)
        btnBht.setOnClickListener {
            val intent = Intent(this, BhtActivity::class.java)
            startActivity(intent)
        }

        // Tombol Berita
        val btnBerita = findViewById<LinearLayout>(R.id.btnBerita)
        btnBerita.setOnClickListener {
            val intent = Intent(this, BeritaActivity::class.java)
            startActivity(intent)
        }

    }



    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
