package com.example.umeed;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class SigninActivity extends AppCompatActivity {
    private EditText name;
    private EditText email;
    private EditText age;
    private EditText community;
    private EditText psw;
    private EditText psw2;
    private EditText phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        Button loginBtn = (Button) findViewById(R.id.signup);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUp();
            }

        });
    }

    protected void SignUp() {
        name = findViewById(R.id.full_name);
        email = findViewById(R.id.email);
        age = findViewById(R.id.age);
        community = findViewById(R.id.community);
        psw = findViewById(R.id.psw);
        psw2 = findViewById(R.id.psw_again);
        phone = findViewById(R.id.phone);
        Log.d("hello",name.toString());
        //TODO: get signin results from backend
        StringRequest request = new StringRequest(Request.Method.POST, "http://ramji12.atwebpages.com/insert_bac.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("signup response",response);
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                        if (response.contains("1")) {
                            //startActivity(user);
                        } else {
                            Toast.makeText(getApplicationContext(), "Try Again!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error",error.toString());

            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("email", email.getText().toString());
                params.put("fullname", name.getText().toString());
                params.put("password", psw.getText().toString());
                params.put("age", age.getText().toString());
                params.put("phone", phone.getText().toString());
                params.put("communtiy", community.getText().toString());
                return params;
            }
        };

        Volley.newRequestQueue(this).add(request);
    }
}

