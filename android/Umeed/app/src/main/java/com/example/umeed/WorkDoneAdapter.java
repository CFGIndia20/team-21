package com.example.umeed;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WorkDoneAdapter extends RecyclerView.Adapter<WorkDoneAdapter.WorkDoneHolder> {

    @NonNull
    @Override
    public WorkDoneHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull WorkDoneHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class WorkDoneHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private final TextView questionItemView;
        private final TextView answerItemView;

        public WorkDoneHolder(@NonNull View itemView) {
            super(itemView);
            answerItemView = (TextView)itemView.findViewById(R.id.textAnswerView);
            questionItemView = (TextView)itemView.findViewById(R.id.textQuestionView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onItemClick(view, getAdapterPosition());
                }
            });
        }
    }
}
