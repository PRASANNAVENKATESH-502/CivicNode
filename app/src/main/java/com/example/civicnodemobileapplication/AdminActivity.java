package com.example.civicnodemobileapplication;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AdminActivity extends AppCompatActivity {

    private RecyclerView issuesRecyclerView;
    private IssueAdapter issueAdapter;
    private List<Issue> issueList;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        issuesRecyclerView = findViewById(R.id.issuesRecyclerView);
        issueList = new ArrayList<>();
        issueAdapter = new IssueAdapter(issueList);
        issuesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        issuesRecyclerView.setAdapter(issueAdapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("issues");
        loadIssues();
    }

    private void loadIssues() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                issueList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Issue issue = dataSnapshot.getValue(Issue.class);
                    if (issue != null) {
                        issueList.add(issue);
                    }
                }
                issueAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(AdminActivity.this, "Failed to load issues: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
