package com.example.umeed;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class WorkDoneAdapter extends RecyclerView.Adapter<WorkDoneAdapter.WorkDoneHolder> {
    private ArrayList<WorkData> mWorkDone;
    private Context mContext;

    WorkDoneAdapter(Context context, ArrayList<WorkData> sportsData) {
        this.mWorkDone = sportsData;
        this.mContext = context;
    }



    @NonNull
    @Override
    public WorkDoneHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WorkDoneHolder(LayoutInflater.from(mContext).
                inflate(R.layout.recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WorkDoneHolder holder, int position) {
        // Get current sport.
        WorkData currentSport = mWorkDone.get(position);

        // Populate the textviews with data.
//        holder.bindTo(currentSport);
    }

    @Override
    public int getItemCount() {
        return mWorkDone.size();
    }

    public class WorkDoneHolder extends RecyclerView.ViewHolder implements View.OnClickListener {



        public WorkDoneHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
        }


        void bindTo(WorkData currentPost){
            // Populate the textviews with data.

        }

        @Override
        public void onClick(View view) {
//            WorkData currentSport = mWorkDone.get(getAdapterPosition());
//            Intent detailIntent = new Intent(mContext, DetailActivity.class);
//            detailIntent.putExtra("title", currentSport.getTitle());
//
//            mContext.startActivity(detailIntent);
        }
    }
}
