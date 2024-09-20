package com.example.taller1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.taller1.activity.PrincipalActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private TextView greetingTextView, userNameTextView;
    private ConstraintLayout mainLayout;
    private Handler handler = new Handler();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);

        greetingTextView = findViewById(R.id.greetingTextView);
        userNameTextView = findViewById(R.id.userNameTextView);
        mainLayout = findViewById(R.id.mainLayout);
        Button mainActivityButton = findViewById(R.id.mainActivityButton);

        // Configurar el saludo inicial y el nombre de usuario
        setGreetingMessage();
        setUserName();

        // Cambia el saludo cada 60 segundos para reflejar la hora actual
        handler.postDelayed(this::setGreetingMessage, 60000);

        mainActivityButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PrincipalActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        applyBackground();  // Aplicar el fondo al reanudar la actividad
        setUserName();      // Actualizar el nombre del usuario si ha cambiado
    }

    @SuppressLint("SetTextI18n")
    private void setGreetingMessage() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        String greeting;

        if (hour >= 6 && hour < 12) {
            greeting = "¡Buenos días!";
        } else if (hour >= 12 && hour < 18) {
            greeting = "¡Buenas tardes!";
        } else {
            greeting = "¡Buenas noches!";
        }

        greetingTextView.setText(greeting);
    }

    private void setUserName() {
        // Obtener el nombre del usuario de SharedPreferences
        String userName = sharedPreferences.getString("userName", "");
        if (!userName.isEmpty()) {
            userNameTextView.setText("Hola, " + userName);
        } else {
            userNameTextView.setText("¡Bienvenido!");
        }
    }

    private void applyBackground() {
        String backgroundType = sharedPreferences.getString("backgroundType", "color");
        int backgroundValue = sharedPreferences.getInt("backgroundValue", Color.WHITE);

        if ("color".equals(backgroundType)) {
            mainLayout.setBackgroundColor(backgroundValue);
        } else if ("image".equals(backgroundType)) {
            mainLayout.setBackgroundResource(backgroundValue);
        }
    }
}
