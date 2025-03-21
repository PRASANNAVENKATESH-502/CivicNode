package com.example.civicnodemobileapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.civicnodemobileapplication.R;

public class MainActivity extends AppCompatActivity {

    private Button reportIssueBtn, viewComplaintsBtn, billPaymentBtn, logoutBtn, editProfileBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing Buttons
        reportIssueBtn = findViewById(R.id.reportIssueBtn);
        viewComplaintsBtn = findViewById(R.id.viewComplaintsBtn);
        billPaymentBtn = findViewById(R.id.billPaymentBtn);
        logoutBtn = findViewById(R.id.logoutBtn);
        editProfileBtn = findViewById(R.id.editProfileBtn); // Added Edit Profile Button

        // Button Click Listeners
        reportIssueBtn.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, ReportIssueActivity.class)));
        viewComplaintsBtn.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, ViewComplaintsActivity.class)));
        billPaymentBtn.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, BillPaymentActivity.class)));

        // Logout Functionality
        logoutBtn.setOnClickListener(view -> {
            // Implement logout logic (FirebaseAuth.getInstance().signOut())
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        });

        // Open Edit Profile Activity
        editProfileBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, EditProfileActivity.class);
            startActivity(intent);
        });
    }
}
