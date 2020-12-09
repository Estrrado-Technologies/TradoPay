package com.estrrado.tradopay.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

import com.example.tradopay.R

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initLayout() {
        setContentView(R.layout.activity_login)
    }

    override fun initListeners() {
        TODO("Not yet implemented")
    }

    override fun initObservers() {
        TODO("Not yet implemented")
    }

    fun onSkipClick(view: View?) {
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
    }
}