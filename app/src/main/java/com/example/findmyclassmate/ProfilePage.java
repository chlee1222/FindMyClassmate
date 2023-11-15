package com.example.findmyclassmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class ProfilePage extends AppCompatActivity {
    TextView profileUsername;
    TextView welcomeText;
    ImageView profileImage;
    ImageView pencilIcon;
    ImageView editIcon;

    TextView userType;

    LinearLayout registeredCoursesLayout;
    String userId;

    View logOut;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        // Initialize your views
        profileUsername = findViewById(R.id.usernameText);
        welcomeText = findViewById(R.id.welcomeText);
        profileImage = findViewById(R.id.profileImage);
        pencilIcon = findViewById(R.id.pencilIcon);
        editIcon = findViewById(R.id.editIcon);
        userType = findViewById(R.id.userRoleText);
        registeredCoursesLayout = findViewById(R.id.registeredCoursesLayout);
        logOut = findViewById(R.id.logOut);

        // Show user data
        showUserData();

        // Retrieve the user's registered courses
        DatabaseReference coursesRef = FirebaseDatabase.getInstance().getReference("courses");
        userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        Log.d("ProfilePage", "Before coursesRef.child(userId).addListenerForSingleValueEvent");
        loadRegisteredCourses();
        Log.d("UserID", userId);
        editIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open the edit profile page
//            startActivity(new Intent(ProfilePage.this, EditProfilePage.class));
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(ProfilePage.this, MainActivity.class));
            }
        });


    }


    public void loadRegisteredCourses() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");

        if (user != null) {
            String userId = user.getUid();
            Log.d("ProfilePage", "loadRegisteredCourses: User ID: " + userId);

            // Assuming that the user's registered courses are stored under "courses" in the user's node.
            Query query = reference.child(userId).child("courses");

            query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    Log.d("ProfilePage", "onDataChange: Entire Snapshot: " + snapshot);

                    if (snapshot.exists()) {
                        // Loop through each registered course under the "courses" node
                        for (DataSnapshot courseSnapshot : snapshot.getChildren()) {
                            // Assuming you have a "Course" class to represent the course data
                            RegisteredCourse registeredCourse = courseSnapshot.getValue(RegisteredCourse.class);
                            Log.d("regis", "onDataChange: " + registeredCourse.getcName());
                            if (registeredCourse != null) {

                            // Inflate the course item layout for each registered course
                            View courseItemView = LayoutInflater.from(ProfilePage.this).inflate(R.layout.registered_course_item, registeredCoursesLayout, false);

                            // Find the TextViews in the inflated layout
                            TextView courseNameTextView = courseItemView.findViewById(R.id.courseNameTextView);
                            TextView courseSectionTextView = courseItemView.findViewById(R.id.courseSectionTextView);
                            TextView courseTimeTextView = courseItemView.findViewById(R.id.courseTimeTextView);

                            // Set the values of the TextViews with registered course details
                            courseNameTextView.setText(registeredCourse.getcName());
                            courseSectionTextView.setText("Section: " + registeredCourse.getSection());
                            courseTimeTextView.setText("Time: " + registeredCourse.getTime());

                            // Add the inflated layout to the coursesLayout
                            registeredCoursesLayout.addView(courseItemView);
                            }
                        }
                    } else {
                        // Handle the case where the user's registered courses data doesn't exist in the database
                        Log.d("ProfilePage", "onDataChange: No registered courses found for the user");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    // Handle errors
                    Log.e("ProfilePage", "loadRegisteredCourses onCancelled: " + error.getMessage());
                }
            });
        }
    }



    public void showUserData() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");

        if (user != null) {
            String uid = user.getUid();
            Query query = reference.child(uid);

            query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        String imageUrl = snapshot.child("dataImage").getValue(String.class);
                        String name = snapshot.child("dataName").getValue(String.class);
                        String type = snapshot.child("dataType").getValue(String.class);

                        // Update the views with the retrieved data
                        welcomeText.setText("Welcome, " + name);
                        profileUsername.setText(name);
                        userType.setText(type);
                        // You can use an image loading library to load the image from the URL
                        // For example, you can use Picasso or Glide to load the image.
                        // Here's an example using Picasso:
                        Picasso.get().load(imageUrl).into(profileImage);
                    } else {
                        // Handle the case where the user's data doesn't exist in the database
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    // Handle errors
                }
            });
        } else {
            // No user is signed in
            // Handle the case where no user is signed in or not yet authenticated
        }
    }
}
