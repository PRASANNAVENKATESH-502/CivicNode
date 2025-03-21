package com.example.civicnodemobileapplication;
public class Issue {

    private String issueId;
    private String title;
    private String description;

    // Default constructor (required for Firebase)
    public Issue() {
    }

    // Constructor with issueId
    public Issue(String issueId, String title, String description) {
        this.issueId = issueId;
        this.title = title;
        this.description = description;
    }

    // Getters and Setters
    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
