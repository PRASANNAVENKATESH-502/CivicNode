package com.example.civicnodemobileapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.civicnodemobileapplication.R;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ViewComplaintsActivity extends AppCompatActivity {

    private ListView listViewComplaints;
    private List<String> complaintsList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_complaints);
        listViewComplaints = findViewById(R.id.complaintsListView);  // Matches XML

        // Dummy data for now (Replace with Firebase retrieval)
        complaintsList = new ArrayList<>();
        complaintsList.add("Power outage in Sector 5");
        complaintsList.add("Water leakage near XYZ street");
        complaintsList.add("Street lights not working in ABC road");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, complaintsList);
        listViewComplaints.setAdapter(adapter);
    }
}
