package com.example.umeed;

import android.content.Intent;
import android.os.Bundle;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        final EditText name = findViewById(R.id.full_name);
        final EditText email = findViewById(R.id.email);
        final EditText age = findViewById(R.id.age);
        final EditText community = findViewById(R.id.community);
        final EditText psw = findViewById(R.id.psw);
        final EditText psw2 = findViewById(R.id.psw_again);

        Button loginBtn = (Button) findViewById(R.id.signup);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (psw != psw2) {
                    Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else {
                    SignUp(name, email, age, community, psw);

                }
            }

        });
    }

    protected void SignUp(final EditText name, final EditText email, final EditText age, final EditText community, final EditText psw) {
        //TODO: get signin results from backend
        StringRequest request = new StringRequest(Request.Method.POST, "hrrps://",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
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

            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("email", email.toString());
                params.put("fullname", name.toString());
                params.put("password", psw.toString());
                params.put("age", age.toString());
                params.put("communtiy", community.toString());
                return params;
            }
        };

        Volley.newRequestQueue(this).add(request);
    }
}

