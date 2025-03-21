package com.example.civicnodemobileapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.civicnodemobileapplication.R;

public class UserProfileActivity extends AppCompatActivity {

    private TextView userName, userEmail, userPhone;
    private Button btnEditProfile, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        userName = findViewById(R.id.txtUserName);
        userEmail = findViewById(R.id.txtUserEmail);
        userPhone = findViewById(R.id.txtUserPhone);
        btnEditProfile = findViewById(R.id.btnEditProfile);
        btnLogout = findViewById(R.id.btnLogout);

        // Sample Data (Replace with Firebase/DB data)
        userName.setText("John Doe");
        userEmail.setText("john.doe@example.com");
        userPhone.setText("+91 9876543210");

        btnEditProfile.setOnClickListener(view -> {
            Intent intent = new Intent(UserProfileActivity.this, EditProfileActivity.class);
            startActivity(intent);
        });

        btnLogout.setOnClickListener(view -> {
            startActivity(new Intent(UserProfileActivity.this, LoginActivity.class));
            finish();
        });
    }
}
