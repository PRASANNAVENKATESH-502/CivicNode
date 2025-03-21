package com.example.civicnodemobileapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.civicnodemobileapplication.R;

public class EditProfileActivity extends AppCompatActivity {
    private EditText name, email, phone;
    private Button saveProfileBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        name = findViewById(R.id.editName);
        email = findViewById(R.id.editEmail);
        phone = findViewById(R.id.editPhone);
        saveProfileBtn = findViewById(R.id.saveProfileBtn);

        saveProfileBtn.setOnClickListener(view -> {
            // Handle profile update logic here
        });
    }
}
