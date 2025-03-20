package com.example.civicnodemobileapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ReportIssueActivity extends AppCompatActivity {

    private EditText editTextIssueTitle, editTextIssueDescription;
    private Button btnSubmitIssue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_issue);

        editTextIssueTitle = findViewById(R.id.editTextIssueTitle);
        editTextIssueDescription = findViewById(R.id.editTextIssueDescription);
        btnSubmitIssue = findViewById(R.id.btnSubmitIssue);

        btnSubmitIssue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editTextIssueTitle.getText().toString().trim();
                String description = editTextIssueDescription.getText().toString().trim();

                if (title.isEmpty() || description.isEmpty()) {
                    Toast.makeText(ReportIssueActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // TODO: Send issue report to Firebase/Database
                    Toast.makeText(ReportIssueActivity.this, "Issue reported successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
