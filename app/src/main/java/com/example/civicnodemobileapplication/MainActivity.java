package com.example.civicnodemobileapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText issueDescription;
    private Button reportButton;
    private RecyclerView issuesRecyclerView;
    private IssueAdapter issueAdapter;
    private List<Issue> issueList;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        issueDescription = findViewById(R.id.issueDescription);
        reportButton = findViewById(R.id.reportButton);
        issuesRecyclerView = findViewById(R.id.issuesRecyclerView);

        issueList = new ArrayList<>();
        issueAdapter = new IssueAdapter(issueList);
        issuesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        issuesRecyclerView.setAdapter(issueAdapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("issues");

        reportButton.setOnClickListener(v -> reportIssue());

        loadIssues();
    }

    private void reportIssue() {
        String description = issueDescription.getText().toString().trim();
        if (description.isEmpty()) {
            Toast.makeText(this, "Please enter a description", Toast.LENGTH_SHORT).show();
            return;
        }

        String id = databaseReference.push().getKey();
        Issue issue = new Issue(id, description);
        databaseReference.child(id).setValue(issue);
        issueDescription.setText("");
        Toast.makeText(this, "Issue reported", Toast.LENGTH_SHORT).show();
    }

    private void loadIssues() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                issueList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Issue issue = dataSnapshot.getValue(Issue.class);
                    issueList.add(issue);
                }
                issueAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Failed to load issues", Toast.LENGTH_SHORT).show();
            }
        });
    }
}