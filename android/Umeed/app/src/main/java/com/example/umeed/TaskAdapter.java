package com.example.umeed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends
        RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    private Context mCtx;
    private List<Task> taskList;

    public TaskAdapter(Context mCtx, List<Task> taskList) {
        this.mCtx = mCtx;
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public TaskAdapter.TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.one_task, parent,false);
        TaskViewHolder holder = new TaskViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.TaskViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.taskName.setText(task.getmTask());
        holder.count.setText(task.getmCount());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView taskName, count;
        public TaskViewHolder(@NonNull View itemView)
        {
            super(itemView);

            taskName = itemView.findViewById(R.id.task_name);
            count = itemView.findViewById(R.id.count);

        }
    }

}
