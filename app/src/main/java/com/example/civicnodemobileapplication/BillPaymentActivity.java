package com.example.civicnodemobileapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class BillPaymentActivity extends AppCompatActivity {

    private EditText editTextAccountNumber, editTextAmount;
    private Button btnPayBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_payment); // Ensure this matches your XML file name

        // Initializing UI elements
        editTextAccountNumber = findViewById(R.id.editTextAccountNumber);
        editTextAmount = findViewById(R.id.editTextAmount);
        btnPayBill = findViewById(R.id.btnPayBill);

        // Set button click listener
        btnPayBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String accountNumber = editTextAccountNumber.getText().toString().trim();
                String amount = editTextAmount.getText().toString().trim();

                if (accountNumber.isEmpty() || amount.isEmpty()) {
                    Toast.makeText(BillPaymentActivity.this, "Please enter all details", Toast.LENGTH_SHORT).show();
                } else {
                    // Here you can implement the payment logic
                    Toast.makeText(BillPaymentActivity.this, "Processing payment for Account: " + accountNumber, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
