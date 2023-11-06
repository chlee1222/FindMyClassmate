package com.example.findmyclassmate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class rateClass extends AppCompatActivity {
    private EditText workloadEditText;
    private EditText scoreEditText;
    private CheckBox attendanceCheckBox;
    private CheckBox lateHomeworkCheckBox;
    private EditText commentsEditText;
    private Button submitReviewButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate_class);
        Course selectedCourse = (Course) getIntent().getSerializableExtra("course");

        workloadEditText = findViewById(R.id.workloadEditText);
        scoreEditText = findViewById(R.id.score);
        attendanceCheckBox = findViewById(R.id.attendanceCheckBox);
        lateHomeworkCheckBox = findViewById(R.id.lateHomeworkCheckBox);
        commentsEditText = findViewById(R.id.commentsEditText);
        submitReviewButton = findViewById(R.id.submitReviewButton);

        submitReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retrieve user inputs and create a new Review object
                String workload = workloadEditText.getText().toString();
                float score = Float.parseFloat(scoreEditText.getText().toString());
                boolean attendanceChecked = attendanceCheckBox.isChecked();
                boolean lateHomeworkAllowed = lateHomeworkCheckBox.isChecked();
                String comments = commentsEditText.getText().toString();

                Review review = new Review(comments, score, attendanceChecked, lateHomeworkAllowed);
                // Save the review to a database or other storage mechanism
                // You need to implement a storage solution for reviews
//                Toast.makeText(rateClass.this, "Review Submitted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}