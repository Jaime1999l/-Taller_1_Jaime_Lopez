package com.example.taller1.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.taller1.R;

public class ConfiguracionActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        Button colorRedButton = findViewById(R.id.colorRedButton);
        Button colorGreenButton = findViewById(R.id.colorGreenButton);
        Button colorBlueButton = findViewById(R.id.colorBlueButton);
        Button backButton = findViewById(R.id.backButton);

        sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);

        colorRedButton.setOnClickListener(v -> setColorAndReturn(Color.RED));
        colorGreenButton.setOnClickListener(v -> setColorAndReturn(Color.GREEN));
        colorBlueButton.setOnClickListener(v -> setColorAndReturn(Color.BLUE));

        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(ConfiguracionActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void setColorAndReturn(int color) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("backgroundColor", color);
        editor.apply();

        // Regresar a la pantalla principal después de guardar el color
        Intent intent = new Intent(ConfiguracionActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
