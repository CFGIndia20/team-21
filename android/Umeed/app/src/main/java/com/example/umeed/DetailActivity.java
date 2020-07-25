package com.example.umeed;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        // Initialize the views.
        TextView sportsTitle = findViewById(R.id.Description);
        TextView employeeDetail = findViewById(R.id.Employee);
        ImageView sportsImage = findViewById(R.id.workImageDetail);


        // Set the text from the Intent extra.
        sportsTitle.setText(getIntent().getStringExtra("desc"));
        employeeDetail.setText(getIntent().getStringExtra("emp"));
        String encodedString = getIntent().getStringExtra("img");
        byte[] imageByteArray = Base64.decode(encodedString, Base64.DEFAULT);

        // Load the image using the Glide library and the Intent extra.

        Glide.with(this).asBitmap().load(imageByteArray).into(sportsImage);


    }
}