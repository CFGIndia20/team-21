package com.example.umeed;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText name_txt;
    private EditText psw_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //ActionBar actionBar = getSupportActionBar(); // or getActionBar();
        getSupportActionBar().setTitle("Login");
        name_txt = findViewById(R.id.name_text);
        psw_txt = findViewById(R.id.psw_text);
        getSupportActionBar().setTitle("Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Button login = findViewById(R.id.login_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SignIn();

            }
        });
        Button signup = findViewById(R.id.signup_btn);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SigninActivity.class);
                //intent.putExtra("emergencyId", id.getId());
                startActivity(intent);
            }
        });
    }

    protected void SignIn(){
        //TODO: get signin results from backend
        Log.d("1","hello");
        StringRequest request = new StringRequest(Request.Method.POST, "http://ramji12.atwebpages.com/signin_back.php",

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject mainObject = new JSONObject(response);
                            String type = mainObject.getString("Type");
                            Log.d("response:",type);
                            if(type.equals("2")){
                                Intent intent = new Intent(getApplicationContext(), VolunteerVerifyWork.class);
                                //Toast.makeText(getApplicationContext(), "IT works", Toast.LENGTH_SHORT).show();
                                SharedPreferences sharedPreferences = getSharedPreferences("login_details",MODE_PRIVATE);
                                sharedPreferences.edit().putString("user_type",type).apply();
                                sharedPreferences.edit().putInt("user_id",12345).apply();
                                startActivity(intent);

                            }
                            else if(type.equals("1")){
                                Intent intent = new Intent(getApplicationContext(), UserViewWork.class);
                                //intent.putExtra("emergencyId", id.getId());
                                SharedPreferences sharedPreferences = getSharedPreferences("login_details",MODE_PRIVATE);
                                sharedPreferences.edit().putString("user_type",type).apply();
                                sharedPreferences.edit().putInt("user_id",12345).apply();
                                startActivity(intent);
                            }

                            else{
                                Toast.makeText(getApplicationContext(),"Try Again!",Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        ){
            @Override
            protected Map<String,String> getParams() throws AuthFailureError{
                Map<String,String> params = new HashMap<>();
                params.put("email",name_txt.getText().toString());
                params.put("password",psw_txt.getText().toString());
                return params;
            }
        };

        Volley.newRequestQueue(this).add(request);
        //return 1;
    }


}
