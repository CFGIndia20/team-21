package com.example.umeed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class VolunteerViewWork extends AppCompatActivity {

    RecyclerView recyclerView;
    TaskAdapter adapter;

    List<Task> taskList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_view_work);

        taskList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.taskRecyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        taskList.add(new Task("Nisha",25));
        taskList.add(new Task("Rekha",30));

        adapter = new TaskAdapter(this, taskList);
        recyclerView.setAdapter(adapter);
    }
}
