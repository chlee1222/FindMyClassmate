package com.example.findmyclassmate;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class createProfile extends AppCompatActivity {
    ImageView uploadImage;
    Button createButton;

    EditText Name, Type;

    String imgURL;

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
                new ActivityResultContracts.StartActivityForResult,
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            uri = data.getData();
                            uploadImage.setImageURI(uri);
                        } else {
                            Toast.makeText(createProfile.this, "No IMAGE SELECTED", Toast.LENGTH_SHORT);
                        }
                    }
                }
        );
        uploadImage.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent photoPick = new Intent(Intent.ACTION_PICK);
                photoPick.setType ("image/*");
                activityResultLauncher.launch(photoPick);
            }
        });

        createButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });

//        public void saveData(){
//            StorageReference sr = FirebaseStorage.getInstance().getReference().child("Android Images")
//        }
    }
}