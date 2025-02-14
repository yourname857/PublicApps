package com.myapp.publicserviceapps

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class EditAkunActivity : AppCompatActivity() {
    private lateinit var editNoKTA: TextInputEditText
    private lateinit var editNIK: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_akun)

        editNoKTA = findViewById(R.id.editNoKTA)
        editNIK = findViewById(R.id.editNIK)

        val backButton = findViewById<ImageButton>(R.id.backButton)
        val btnLupaPassword = findViewById<MaterialButton>(R.id.btnLupaPassword)
        val btnUbahPassword = findViewById<MaterialButton>(R.id.btnUbahPassword)
        val btnSimpan = findViewById<MaterialButton>(R.id.btnSimpan)

        backButton.setOnClickListener {
            finish()
        }

        btnLupaPassword.setOnClickListener {
            showLupaPasswordDialog()
        }

        btnUbahPassword.setOnClickListener {
            showUbahPasswordDialog()
        }

        btnSimpan.setOnClickListener {
            if (validateInputs()) {
                saveAccountData()
            }
        }

        // Load data sebelumnya (jika ada)
        loadAccountData()
    }

    private fun validateInputs(): Boolean {
        var isValid = true

        if (editNoKTA.text.toString().trim().isEmpty()) {
            editNoKTA.error = "No KTA tidak boleh kosong"
            isValid = false
        }

        if (editNIK.text.toString().trim().isEmpty()) {
            editNIK.error = "NIK tidak boleh kosong"
            isValid = false
        }

        return isValid
    }

    private fun saveAccountData() {
        val sharedPreferences = getSharedPreferences("UserAccount", MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putString("noKTA", editNoKTA.text.toString().trim())
        editor.putString("nik", editNIK.text.toString().trim())
        editor.apply()

        Toast.makeText(this, "Data akun berhasil disimpan", Toast.LENGTH_SHORT).show()
        finish()
    }

    private fun loadAccountData() {
        val sharedPreferences = getSharedPreferences("UserAccount", MODE_PRIVATE)

        editNoKTA.setText(sharedPreferences.getString("noKTA", ""))
        editNIK.setText(sharedPreferences.getString("nik", ""))
    }

    private fun showLupaPasswordDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Lupa Password")
        builder.setMessage("Silakan hubungi administrator untuk reset password.\n\nEmail: admin@pengadilanmiliter.go.id\nTelepon/wa: +62 812-3456-7890")
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        builder.show()
    }

    private fun showUbahPasswordDialog() {
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_ubah_password, null)
        builder.setView(dialogView)

        val dialog = builder.create()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent) // Membuat dialog lebih estetik

        val editPasswordLama = dialogView.findViewById<TextInputEditText>(R.id.editPasswordLama)
        val editPasswordBaru = dialogView.findViewById<TextInputEditText>(R.id.editPasswordBaru)
        val editPasswordKonfirmasi = dialogView.findViewById<TextInputEditText>(R.id.editPasswordKonfirmasi)
        val btnSimpan = dialogView.findViewById<Button>(R.id.btnSimpan)
        val btnKembali = dialogView.findViewById<ImageButton>(R.id.btnKembali)

        btnKembali.setOnClickListener {
            dialog.dismiss()
        }

        btnSimpan.setOnClickListener {
            val passwordLama = editPasswordLama.text.toString().trim()
            val passwordBaru = editPasswordBaru.text.toString().trim()
            val passwordKonfirmasi = editPasswordKonfirmasi.text.toString().trim()

            if (passwordLama.isEmpty() || passwordBaru.isEmpty() || passwordKonfirmasi.isEmpty()) {
                Toast.makeText(this, "Semua kolom harus diisi", Toast.LENGTH_SHORT).show()
            } else if (passwordBaru.length < 6) {
                Toast.makeText(this, "Password baru harus minimal 6 karakter", Toast.LENGTH_SHORT).show()
            } else if (passwordBaru != passwordKonfirmasi) {
                Toast.makeText(this, "Konfirmasi password tidak cocok", Toast.LENGTH_SHORT).show()
            } else {
                // Tampilkan konfirmasi sebelum menyimpan
                AlertDialog.Builder(this)
                    .setTitle("Konfirmasi")
                    .setMessage("Apakah Anda yakin ingin mengubah password?")
                    .setPositiveButton("Ya") { _, _ ->
                        // Simpan password baru (implementasi sesuai kebutuhan)
                        Toast.makeText(this, "Password berhasil diubah", Toast.LENGTH_SHORT).show()
                        dialog.dismiss()
                    }
                    .setNegativeButton("Batal") { dialogConfirm, _ ->
                        dialogConfirm.dismiss()
                    }
                    .show()
            }
        }

        dialog.show()
    }
}


