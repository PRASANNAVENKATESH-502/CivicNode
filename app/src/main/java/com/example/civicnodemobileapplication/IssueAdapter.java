package com.example.civicnodemobileapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class IssueAdapter extends RecyclerView.Adapter<IssueAdapter.IssueViewHolder> {

    private List<Issue> issueList;

    public IssueAdapter(List<Issue> issueList) {
        this.issueList = issueList;
    }

    @NonNull
    @Override
    public IssueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_issue, parent, false);
        return new IssueViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IssueViewHolder holder, int position) {
        Issue issue = issueList.get(position);
        holder.titleTextView.setText(issue.getTitle());
        holder.descriptionTextView.setText(issue.getDescription());
    }

    @Override
    public int getItemCount() {
        return issueList.size();
    }

    public static class IssueViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, descriptionTextView;

        public IssueViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.issueTitle);
            descriptionTextView = itemView.findViewById(R.id.issueDescription);
        }
    }
}
