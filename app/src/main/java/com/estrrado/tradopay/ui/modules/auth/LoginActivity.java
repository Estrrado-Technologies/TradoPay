

package com.estrrado.tradopay.ui.modules.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.estrrado.tradopay.ui.modules.MainActivity;
import com.example.tradopay.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
    public void onSkipClick(View view)
    {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }
}