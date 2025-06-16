package com.leandro.applistacurso0033.View;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.leandro.applistacurso0033.R;

public class TelaSplash extends AppCompatActivity {

    public static final long TIME_OUT_SPLASH = 3000;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        comutartelaSplash();
    }

    private void comutartelaSplash() {
        new Handler().postDelayed(new Runnable(){
            @Override
                    public void run(){
                Intent telaPrincipal = new Intent(TelaSplash.this, MainActivity.class);
                startActivity(telaPrincipal);
                finish();
            }
        },  TIME_OUT_SPLASH);
    }
}
