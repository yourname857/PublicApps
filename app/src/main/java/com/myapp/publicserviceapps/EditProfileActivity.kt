package com.myapp.publicserviceapps

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import java.util.*

class EditProfileActivity : AppCompatActivity() {
    private lateinit var editNama: TextInputEditText
    private lateinit var editTanggalLahir: TextInputEditText
    private lateinit var editNoTelp: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editprofile)

        editNama = findViewById(R.id.editNama)
        editTanggalLahir = findViewById(R.id.editTanggalLahir)
        editNoTelp = findViewById(R.id.editNoTelp)

        val backButton = findViewById<ImageButton>(R.id.backButton)
        val btnSimpan = findViewById<MaterialButton>(R.id.btnSimpan)

        // Setup date picker untuk tanggal lahir
        editTanggalLahir.setOnClickListener {
            showDatePicker()
        }

        backButton.setOnClickListener {
            finish()
        }

        btnSimpan.setOnClickListener {
            if (validateInputs()) {
                saveProfile()
            }
        }

        // Load data sebelumnya (jika ada)
        loadProfile()
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            editTanggalLahir.setText(selectedDate)
        }, year, month, day).show()
    }

    private fun validateInputs(): Boolean {
        var isValid = true

        if (editNama.text.toString().trim().isEmpty()) {
            editNama.error = "Nama tidak boleh kosong"
            isValid = false
        }

        if (editTanggalLahir.text.toString().trim().isEmpty()) {
            editTanggalLahir.error = "Tanggal lahir tidak boleh kosong"
            isValid = false
        }

        if (editNoTelp.text.toString().trim().isEmpty()) {
            editNoTelp.error = "Nomor telepon tidak boleh kosong"
            isValid = false
        }

        return isValid
    }

    private fun saveProfile() {
        val sharedPreferences = getSharedPreferences("UserProfile", MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putString("nama", editNama.text.toString().trim())
        editor.putString("tanggalLahir", editTanggalLahir.text.toString().trim())
        editor.putString("noTelp", editNoTelp.text.toString().trim())
        editor.apply()

        Toast.makeText(this, "Profil berhasil disimpan", Toast.LENGTH_SHORT).show()
        finish()
    }

    private fun loadProfile() {
        val sharedPreferences = getSharedPreferences("UserProfile", MODE_PRIVATE)

        editNama.setText(sharedPreferences.getString("nama", ""))
        editTanggalLahir.setText(sharedPreferences.getString("tanggalLahir", ""))
        editNoTelp.setText(sharedPreferences.getString("noTelp", ""))
    }
}
