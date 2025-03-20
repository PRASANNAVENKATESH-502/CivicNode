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
        setContentView(R.layout.activity_bill_payment);

        editTextAccountNumber = findViewById(R.id.editTextAccountNumber);
        editTextAmount = findViewById(R.id.editTextAmount);
        btnPayBill = findViewById(R.id.btnPayBill);

        btnPayBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String accountNumber = editTextAccountNumber.getText().toString().trim();
                String amount = editTextAmount.getText().toString().trim();

                if (accountNumber.isEmpty() || amount.isEmpty()) {
                    Toast.makeText(BillPaymentActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // TODO: Process payment (Use payment gateway API)
                    Toast.makeText(BillPaymentActivity.this, "Bill paid successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
