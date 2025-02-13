package com.myapp.publicserviceapps

// Library untuk komponen Android dasar
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// Library untuk format tanggal
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

// Library untuk loading gambar (akan digunakan nanti)
// import com.bumptech.glide:glide:4.12.0
// import com.squareup.picasso:picasso:2.8

// Library untuk networking (akan digunakan nanti)
// import com.squareup.retrofit2:retrofit:2.9.0
// import com.squareup.retrofit2:converter-gson:2.9.0
// import com.google.code.gson:gson:2.8.9

// Library untuk reactive programming (akan digunakan nanti)
// import io.reactivex.rxjava3:rxjava:3.0.0
// import io.reactivex.rxjava3:rxandroid:3.0.0

// Library untuk dependency injection (akan digunakan nanti)
// import com.google.dagger:hilt-android:2.44
// import com.google.dagger:hilt-android-compiler:2.44

// Library untuk view binding (akan digunakan nanti)
// import androidx.viewbinding:viewbinding:7.1.2

class BeritaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berita)

        // Set current date
        val dateTextView = findViewById<TextView>(R.id.currentDate)
        val dateFormat = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale("id", "ID"))
        val currentDate = dateFormat.format(Date())
        dateTextView.text = currentDate

        // Handle notification click
        findViewById<View>(R.id.notificationButton).setOnClickListener {
            // Implementasi untuk menampilkan notifikasi
        }


        // Handle search click
        findViewById<View>(R.id.searchLayout).setOnClickListener {
            // Implementasi untuk memulai pencarian
        }
    }
}