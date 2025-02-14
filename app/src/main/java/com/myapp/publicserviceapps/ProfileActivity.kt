package com.myapp.publicserviceapps

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val backButton = findViewById<ImageButton>(R.id.backButton)
        val profileImage = findViewById<ImageView>(R.id.profileImage)
        val editProfileButton = findViewById<ImageView>(R.id.editProfileButton)
        val akunSection = findViewById<CardView>(R.id.akunSection)
        val bantuanSection = findViewById<CardView>(R.id.bantuanSection)
        val saranSection = findViewById<CardView>(R.id.saranSection)

        backButton.setOnClickListener {
            finish()
        }

        profileImage.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            startActivity(intent)
        }

        editProfileButton.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            startActivity(intent)
        }

        akunSection.setOnClickListener {
            val intent = Intent(this, EditAkunActivity::class.java)
            startActivity(intent)
        }

        //bantuanSection.setOnClickListener {
            //val intent = Intent(this, BantuanActivity::class.java)
           // startActivity(intent)
        //}

        //saranSection.setOnClickListener {
         //   val intent = Intent(this, SaranActivity::class.java)
          //  startActivity(intent)
        //}
    }
}
