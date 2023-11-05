package com.example.findmyclassmate;

public class Review {
    private String comments;
    private float rating;
    private boolean attendanceChecked;
    private boolean lateHomeworkAllowed;

    public Review() {
        // Default constructor
    }

    public Review(String comments, float rating, boolean attendanceChecked, boolean lateHomeworkAllowed) {
        this.comments = comments;
        this.rating = rating;
        this.attendanceChecked = attendanceChecked;
        this.lateHomeworkAllowed = lateHomeworkAllowed;
    }

    // Getters and setters for each field

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public boolean isAttendanceChecked() {
        return attendanceChecked;
    }

    public void setAttendanceChecked(boolean attendanceChecked) {
        this.attendanceChecked = attendanceChecked;
    }

    public boolean isLateHomeworkAllowed() {
        return lateHomeworkAllowed;
    }

    public void setLateHomeworkAllowed(boolean lateHomeworkAllowed) {
        this.lateHomeworkAllowed = lateHomeworkAllowed;
    }
}

