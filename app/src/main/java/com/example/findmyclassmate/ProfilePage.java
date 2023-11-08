package com.example.findmyclassmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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


        // Show user data
        showUserData();

        // Set a click listener for the edit icon
        editIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open the edit profile page
//                startActivity(new Intent(ProfilePage.this, EditProfilePage.class));
            }
        });
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
