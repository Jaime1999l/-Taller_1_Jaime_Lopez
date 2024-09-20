package com.example.taller1.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.taller1.R;
import com.example.taller1.model.UserViewModel;

public class PrincipalActivity extends AppCompatActivity {

    private EditText nameEditText;
    private TextView nameTextView;
    private UserViewModel userViewModel;

    @SuppressLint("MissingInflatedId")
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
                nameTextView.setText(name);
            }
        });

        saveButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString();
            userViewModel.saveUserName(name);
        });

        settingsButton.setOnClickListener(v -> {
            Intent intent = new Intent(PrincipalActivity.this, ConfiguracionActivity.class);
            startActivity(intent);
        });
    }
}
