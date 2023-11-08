package com.example.findmyclassmate;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class createProfile extends AppCompatActivity {
    ImageView uploadImage;
    Button createButton;
    EditText Name, Type;
    String imageURL;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_profile);

        uploadImage = findViewById(R.id.imageView3);
        Name = findViewById(R.id.uploadName);
        Type = findViewById(R.id.uploadtype);
        createButton = findViewById(R.id.uploadButton);

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            uri = data.getData();
                            uploadImage.setImageURI(uri);
                        } else {
                            Toast.makeText(createProfile.this, "No IMAGE SELECTED", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPick = new Intent(Intent.ACTION_GET_CONTENT);
                photoPick.setType("image/*");
                activityResultLauncher.launch(photoPick);
            }
        });

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    String uid = user.getUid();
                    String name = Name.getText().toString();
                    String type = Type.getText().toString();

                    if (!name.isEmpty() && !type.isEmpty() && uri != null) {
                        saveData(uid, name, type);
                    } else {
                        Toast.makeText(createProfile.this, "Please fill out all fields and select an image.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(createProfile.this, "User not authenticated. Please sign in.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void saveData(String uid, String name, String type) {
        StorageReference sr = FirebaseStorage.getInstance().getReference().child("Android Images").child(uri.getLastPathSegment());
        AlertDialog.Builder builder = new AlertDialog.Builder(createProfile.this);
        builder.setCancelable(false);
        AlertDialog dialog = builder.create();
        dialog.show();

        sr.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                uriTask.addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri urlImage) {
                        imageURL = urlImage.toString();
                        uploadData(uid, name, type);
                        dialog.dismiss();
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                dialog.dismiss();
                Toast.makeText(createProfile.this, "Image upload failed.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void uploadData(String uid, String name, String type) {
        profileData profileData = new profileData(name, type, imageURL);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("users").child(uid).setValue(profileData)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(createProfile.this, "Profile created and saved", Toast.LENGTH_SHORT).show();
                            Intent toViewCourse = new Intent(createProfile.this, ViewCourse.class);
                            startActivity(toViewCourse);
                            finish();
                        } else {
                            Toast.makeText(createProfile.this, "Failed to save profile data", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(createProfile.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
