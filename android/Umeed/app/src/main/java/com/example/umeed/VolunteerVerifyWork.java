package com.example.umeed;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class VolunteerVerifyWork extends AppCompatActivity {
    private List<Task> taskList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TaskAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_view_work);
        //Toolbar toolbar =  findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        getSupportActionBar().setTitle("Tasks");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mAdapter = new TaskAdapter(taskList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareData();
    }
    private void prepareData() {
        Task task = new Task("Asha", "25 Diyas");
        taskList.add(task);

        task = new Task("Rekha", "25 Diyas");
        taskList.add(task);

        task = new Task("Megha", "50 Diyas");
        taskList.add(task);

        final List<Task> list=new ArrayList<>();
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest request = new StringRequest(Request.Method.GET, "http://ramji12.atwebpages.com/check.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("json", response);
                try {
                    //JSONObject object=new JSONObject(response);
                    JSONArray array=new JSONArray(response);
                    for(int i=0;i<array.length();i++) {
                        JSONObject object1=array.getJSONObject(i);
                        String name =object1.getString("wname");
                        String whrs =object1.getString("Workas");
                        Log.d("actual values",name+" "+whrs);
                        taskList.add(new Task(name,whrs));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error",error.toString());
            }
        });
        queue.add(request);
        mAdapter.notifyDataSetChanged();

    }
}