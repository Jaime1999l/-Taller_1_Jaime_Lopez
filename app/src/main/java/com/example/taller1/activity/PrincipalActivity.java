package com.example.taller1.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.taller1.R;
import com.example.taller1.model.UserViewModel;

public class PrincipalActivity extends AppCompatActivity {

    private EditText nameEditText;
    private TextView nameTextView;
    private UserViewModel userViewModel;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        nameEditText = findViewById(R.id.nameEditText);
        Button saveButton = findViewById(R.id.saveButton);
        nameTextView = findViewById(R.id.nameTextView);
        Button settingsButton = findViewById(R.id.settingsButton);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        // Observa los cambios en el nombre del usuario y actualiza la UI
        userViewModel.getUserName().observe(this, name -> {
            if (name != null && !name.isEmpty()) {
                nameTextView.setText("Nombre: " + name);
            } else {
                nameTextView.setText("No se ha guardado ningún nombre.");
            }
        });

        saveButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString().trim();
            if (TextUtils.isEmpty(name)) {
                Toast.makeText(PrincipalActivity.this, "Por favor ingresa un nombre.", Toast.LENGTH_SHORT).show();
            } else {
                userViewModel.saveUserName(name);
                Toast.makeText(PrincipalActivity.this, "Nombre guardado correctamente.", Toast.LENGTH_SHORT).show();
                nameEditText.setText("");
            }
        });

        settingsButton.setOnClickListener(v -> {
            Intent intent = new Intent(PrincipalActivity.this, ConfiguracionActivity.class);
            startActivity(intent);
        });
    }
}

