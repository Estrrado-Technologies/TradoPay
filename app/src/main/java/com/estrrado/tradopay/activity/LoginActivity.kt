package com.estrrado.tradopay.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

import com.example.tradopay.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun onSkipClick(view: View?) {
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
    }
}