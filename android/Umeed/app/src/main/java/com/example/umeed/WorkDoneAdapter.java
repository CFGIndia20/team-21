package com.example.umeed;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        holder.bindTo(currentSport);
    }

    @Override
    public int getItemCount() {
        return mWorkDone.size();
    }

    public class WorkDoneHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView desc;
        private TextView mInfoText;
        private ImageView mWorkImage;



        public WorkDoneHolder(@NonNull View itemView) {
            super(itemView);

            desc = itemView.findViewById(R.id.Desc);
            mInfoText = itemView.findViewById(R.id.subTitle);
            mWorkImage = itemView.findViewById(R.id.workImage);
            itemView.setOnClickListener(this);
        }


        void bindTo(WorkData currentPost){
            // Populate the textviews with data.
            String encodedString = currentPost.getEncodedImage();
            desc.setText(currentPost.getDesc());
            byte[] imageByteArray = Base64.decode(encodedString, Base64.DEFAULT);


            Glide.with(mContext).asBitmap().load(imageByteArray).into(mWorkImage);
        }

        @Override
        public void onClick(View view) {
            WorkData currentWork = mWorkDone.get(getAdapterPosition());
            Intent detailIntent = new Intent(mContext, DetailActivity.class);
            detailIntent.putExtra("desc", currentWork.getDesc());
            detailIntent.putExtra("emp", currentWork.getEmpId());
            detailIntent.putExtra("img", currentWork.getEncodedImage());
            mContext.startActivity(detailIntent);
        }
    }
}
