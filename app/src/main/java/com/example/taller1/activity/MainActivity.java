package com.example.taller1.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.taller1.R;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);

        TextView greetingTextView = findViewById(R.id.greetingTextView);
        Button mainActivityButton = findViewById(R.id.mainActivityButton);

        setGreetingMessage(greetingTextView);

        mainActivityButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PrincipalActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        applyBackgroundColor();  // Aplicar el color de fondo cuando la actividad vuelva a primer plano
    }

    private void setGreetingMessage(TextView greetingTextView) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (hour >= 6 && hour < 12) {
            greetingTextView.setText("¡Buenos días!");
        } else if (hour >= 12 && hour < 18) {
            greetingTextView.setText("¡Buenas tardes!");
        } else {
            greetingTextView.setText("¡Buenas noches!");
        }
    }

    private void applyBackgroundColor() {
        int color = sharedPreferences.getInt("backgroundColor", Color.WHITE);
        getWindow().getDecorView().setBackgroundColor(color);
    }
}
