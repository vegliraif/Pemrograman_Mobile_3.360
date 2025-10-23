package com.vegg.vegli

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vegg.vegli.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fullName = intent.getStringExtra("fullName")
        val username = intent.getStringExtra("username")
        val age = intent.getStringExtra("age")
        val email = intent.getStringExtra("email")
        val gender = intent.getStringExtra("gender")

        binding.tvFullname.text = "Full name : $fullName"
        binding.tvUsername.text = "Username : $username"
        binding.tvAge.text = "Age : $age"
        binding.tvEmail.text = "Email : $email"
        binding.tvGender.text = "Gender : $gender"
    }
}
