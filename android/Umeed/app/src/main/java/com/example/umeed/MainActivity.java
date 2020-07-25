package com.example.umeed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loginBtn = (Button)findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                //intent.putExtra("emergencyId", id.getId());
                startActivity(intent);            }
        });
    }

    public void insertProductPhoto(View view) {
        Intent intent = new Intent(this, PhotoUpload.class);
        startActivity(intent);
    }


    public void viewWorkPosts(View view) {
        Intent intent = new Intent(this, PhotoUpload.class);
        startActivity(intent);
    }
}
