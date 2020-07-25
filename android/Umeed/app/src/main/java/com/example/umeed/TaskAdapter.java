package com.example.umeed;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {

    private List<Task> taskList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public Button btn;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.task_name);
            count = (TextView) view.findViewById(R.id.count);
            btn = view.findViewById(R.id.verify_button);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO:Send Verification to server
                    //Toast.makeText(this, "yayy1",Toast.LENGTH_SHORT).show();
                    Log.d("recycle", count.getText().toString());
                }
            });
        }
    }


    public TaskAdapter(List<Task> moviesList) {
        this.taskList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.one_task, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Task movie = taskList.get(position);
        holder.title.setText(movie.getmTask());
        holder.count.setText(movie.getmCount());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
}

