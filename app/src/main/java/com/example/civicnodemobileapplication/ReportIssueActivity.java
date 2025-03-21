package com.example.civicnodemobileapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.civicnodemobileapplication.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ReportIssueActivity extends AppCompatActivity {

    private EditText issueTitle, issueDescription;
    private Button submitIssueBtn;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_issue);

        issueTitle = findViewById(R.id.issueTitle);
        issueDescription = findViewById(R.id.issueDescription);
        submitIssueBtn = findViewById(R.id.submitIssueBtn);

        databaseReference = FirebaseDatabase.getInstance().getReference("Issues");

        submitIssueBtn.setOnClickListener(view -> {
            String title = issueTitle.getText().toString().trim();
            String description = issueDescription.getText().toString().trim();

            if (title.isEmpty() || description.isEmpty()) {
                Toast.makeText(ReportIssueActivity.this, "Fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            String issueId = databaseReference.push().getKey();
            Issue issue = new Issue(issueId, title, description);

            databaseReference.child(issueId).setValue(issue)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(ReportIssueActivity.this, "Issue Reported", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(ReportIssueActivity.this, "Failed to Report", Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }
}
