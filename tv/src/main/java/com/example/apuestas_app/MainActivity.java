package com.example.apuestas_app;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ocultar la barra de acción para experiencia completa en TV
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Hacer que la vista sea navegable con control remoto
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        // Ejemplo de cómo referenciar un TextView
        TextView textView = findViewById(R.id.textView);
        textView.setFocusable(true);
        textView.setFocusableInTouchMode(true);
    }
}
