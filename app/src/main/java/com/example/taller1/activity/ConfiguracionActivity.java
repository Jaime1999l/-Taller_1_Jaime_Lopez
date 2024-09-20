package com.example.taller1.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.taller1.MainActivity;
import com.example.taller1.R;

public class ConfiguracionActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "MyAppPrefs";
    private static final String KEY_BACKGROUND_TYPE = "backgroundType"; // "color" o "image"
    private static final String KEY_BACKGROUND_VALUE = "backgroundValue"; // Color o ID de recurso de imagen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        // RadioGroup y RadioButtons para seleccionar el tipo de fondo
        RadioGroup radioGroupBackgroundType = findViewById(R.id.radioGroupBackgroundType);
        RadioButton radioButtonColor = findViewById(R.id.radioButtonColor);
        RadioButton radioButtonImage = findViewById(R.id.radioButtonImage);

        // Layouts que contienen las opciones de selección
        LinearLayout colorSelectionLayout = findViewById(R.id.colorSelectionLayout);
        LinearLayout imageSelectionLayout = findViewById(R.id.imageSelectionLayout);

        // Botones para seleccionar fondo de color (CardViews)
        CardView colorRedButton = findViewById(R.id.colorRedButton);
        CardView colorGreenButton = findViewById(R.id.colorGreenButton);
        CardView colorBlueButton = findViewById(R.id.colorBlueButton);

        // Botones para seleccionar fondo de imagen
        CardView image1Button = findViewById(R.id.image1Button);
        CardView image2Button = findViewById(R.id.image2Button);

        // Botón para volver a la pantalla principal
        Button backButton = findViewById(R.id.backButton);

        // Cambia la visibilidad de las opciones según la selección del tipo de fondo
        radioGroupBackgroundType.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.radioButtonColor) {
                colorSelectionLayout.setVisibility(LinearLayout.VISIBLE);
                imageSelectionLayout.setVisibility(LinearLayout.GONE);
            } else if (checkedId == R.id.radioButtonImage) {
                colorSelectionLayout.setVisibility(LinearLayout.GONE);
                imageSelectionLayout.setVisibility(LinearLayout.VISIBLE);
            }
        });

        colorRedButton.setOnClickListener(v -> setColorAndReturn(Color.RED));
        colorGreenButton.setOnClickListener(v -> setColorAndReturn(Color.GREEN));
        colorBlueButton.setOnClickListener(v -> setColorAndReturn(Color.BLUE));

        // Asegúrate de que los recursos existen antes de asignar los oyentes
        image1Button.setOnClickListener(v -> setImageAndReturn(R.drawable.background_image1));
        image2Button.setOnClickListener(v -> setImageAndReturn(R.drawable.background_image2));

        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(ConfiguracionActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void setColorAndReturn(int color) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_BACKGROUND_TYPE, "color");
        editor.putInt(KEY_BACKGROUND_VALUE, color);
        editor.apply();
        navigateToMainActivity();
    }

    private void setImageAndReturn(int imageResId) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_BACKGROUND_TYPE, "image");
        editor.putInt(KEY_BACKGROUND_VALUE, imageResId);
        editor.apply();
        navigateToMainActivity();
    }

    private void navigateToMainActivity() {
        Intent intent = new Intent(ConfiguracionActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
