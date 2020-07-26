package com.example.umeed;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import java.util.HashMap;
import java.util.Map;

public class DetailActivity extends AppCompatActivity {
    Switch simpleSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        simpleSwitch = (Switch)findViewById(R.id.simpleSwitch);

        // Initialize the views.
        TextView sportsTitle = findViewById(R.id.Description);
        TextView employeeDetail = findViewById(R.id.Employee);
        ImageView sportsImage = findViewById(R.id.workImageDetail);


        // Set the text from the Intent extra.
        sportsTitle.setText(getIntent().getStringExtra("desc"));
        employeeDetail.setText(getIntent().getStringExtra("emp"));
        String encodedString = getIntent().getStringExtra("img");
        String verify = getIntent().getStringExtra("verify");
        String id =  getIntent().getStringExtra("id");
        byte[] imageByteArray = Base64.decode(encodedString, Base64.DEFAULT);

        // Load the image using the Glide library and the Intent extra.

        if(verify.equals("1"))
        {
           simpleSwitch.setChecked(true);
        }
        else{
            simpleSwitch.setChecked(false);
        }



        Glide.with(this).asBitmap().load(imageByteArray).into(sportsImage);

        simpleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // do something, the isChecked will be
                // true if the switch is in the On position
                if(isChecked)
                {
                    StringRequest request = new StringRequest(Request.Method.POST, "http://ramji12.atwebpages.com/update.php",
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Log.d("post response",response);
                                    Toast.makeText(getApplicationContext(), "Data and File Uploaded Successfully...", Toast.LENGTH_LONG).show();

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
                            params.put("id", id);
                            return params;
                        }
                    };
                    Volley.newRequestQueue(DetailActivity.this).add(request);
                }

            }
        });





    }
}