package com.example.umeed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WorkDoneActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<WorkData> mWorkData;
    private WorkDoneAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_done);
        // Initialize the RecyclerView.
        mRecyclerView = findViewById(R.id.my_recycler_view);

        // Set the Layout Manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the ArrayList that will contain the data.
        mWorkData = new ArrayList<>();

        // Initialize the adapter and set it to the RecyclerView.
        mAdapter = new WorkDoneAdapter(this, mWorkData);
        mRecyclerView.setAdapter(mAdapter);

        // Get the data.
        initializeData();

        // Helper class for creating swipe to dismiss and drag and drop
        // functionality.
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper
                .SimpleCallback(
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                        ItemTouchHelper.DOWN | ItemTouchHelper.UP,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            /**
             * Defines the drag and drop functionality.
             *
             * @param recyclerView The RecyclerView that contains the list items
             * @param viewHolder The SportsViewHolder that is being moved
             * @param target The SportsViewHolder that you are switching the
             *               original one with.
             * @return true if the item was moved, false otherwise
             */
            @Override
            public boolean onMove(RecyclerView recyclerView,
                                  RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {
                // Get the from and to positions.
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();

                // Swap the items and notify the adapter.
                Collections.swap(mWorkData, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }

            /**
             * Defines the swipe to dismiss functionality.
             *
             * @param viewHolder The viewholder being swiped.
             * @param direction The direction it is swiped in.
             */
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder,
                                 int direction) {
                // Remove the item from the dataset.
                mWorkData.remove(viewHolder.getAdapterPosition());
                // Notify the adapter.
                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });

        // Attach the helper to the RecyclerView.
        helper.attachToRecyclerView(mRecyclerView);
    }


    private void initializeData() {

        String[] desc,empId,encodedImage;
        mWorkData.clear();








        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ramji12.atwebpages.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UmeedApi api = retrofit.create(UmeedApi.class);
        Call<List<WorkData>> call = api.getPosts();
        call.enqueue(new Callback<List<WorkData>>() {
            @Override
            public void onResponse(Call<List<WorkData>> call, Response<List<WorkData>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Data and File Uploaded Successfully...", Toast.LENGTH_LONG).show();

                    return;
                }
                List<WorkData> posts = response.body();
                for (WorkData post : posts) {

//                    mWorkData.add(new WorkData(post.getDesc(),post.getEmpId(),post.getEncodedImage()));
                }
            }
            @Override
            public void onFailure(Call<List<WorkData>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}