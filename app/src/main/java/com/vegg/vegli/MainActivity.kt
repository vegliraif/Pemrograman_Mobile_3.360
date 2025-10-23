package com.vegg.vegli

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.vegg.vegli.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitButton.setOnClickListener {
            val fullName = binding.etFullName.text.toString().trim()
            val username = binding.etUsername.text.toString().trim()
            val age = binding.etAge.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val confirmPassword = binding.etConfirmPassword.text.toString().trim()

            val selectedGenderId = binding.genderGroup.checkedRadioButtonId
            val gender = when (selectedGenderId) {
                R.id.rbMale -> "Laki-laki"
                R.id.rbFemale -> "Perempuan"
                else -> ""
            }

            val emptyFields = mutableListOf<String>()
            if (fullName.isEmpty()) emptyFields.add("Full Name")
            if (username.isEmpty()) emptyFields.add("Username")
            if (age.isEmpty()) emptyFields.add("Age")
            if (email.isEmpty()) emptyFields.add("Email")
            if (gender.isEmpty()) emptyFields.add("Gender")
            if (password.isEmpty()) emptyFields.add("Password")
            if (confirmPassword.isEmpty()) emptyFields.add("Confirm Password")

            if (emptyFields.isNotEmpty()) {
                Toast.makeText(
                    this,
                    "Kolom belum diisi: ${emptyFields.joinToString(", ")}",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(this, "Password dan konfirmasi tidak sama!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("fullName", fullName)
            intent.putExtra("username", username)
            intent.putExtra("age", age)
            intent.putExtra("email", email)
            intent.putExtra("gender", gender)
            startActivity(intent)
        }
    }
}
