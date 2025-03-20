package com.example.civicnodemobileapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.civicnodemobileapplication.ReportIssueActivity;
import com.example.civicnodemobileapplication.ViewComplaintsActivity;
import com.example.civicnodemobileapplication.BillPaymentActivity;


public class MainActivity extends AppCompatActivity {

    private Button reportIssueBtn, viewComplaintsBtn, billPaymentBtn;
    private TextView welcomeMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find views
        welcomeMessage = findViewById(R.id.welcomeMessage);
        reportIssueBtn = findViewById(R.id.btnReportIssue);
        viewComplaintsBtn = findViewById(R.id.btnViewComplaints);
        billPaymentBtn = findViewById(R.id.btnBillPayment);

        // Set onClickListeners
        reportIssueBtn.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ReportIssueActivity.class));
        });

        viewComplaintsBtn.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ViewComplaintsActivity.class));
        });

        billPaymentBtn.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, BillPaymentActivity.class));
        });
    }
}
