package com.example.networkcondition.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.networkcondition.R;
import com.example.networkcondition.model.Survey;

import java.util.ArrayList;

public class SurveyAdapter extends RecyclerView.Adapter<SurveyViewHolder>{
    ArrayList<Survey> surveys;
    Context context;

    private OnClickListener onClickListener;

    public SurveyAdapter(Context ctx, ArrayList<Survey> surveys) {
        this.context = ctx;
        this.surveys = surveys;
    }

    @NonNull
    @Override
    public SurveyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View listItem =inflater.inflate(R.layout.list_item,parent,false);
        return new SurveyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull SurveyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Survey survey = surveys.get(position);
        holder.road.setText(surveys.get(position).getRoad());
        holder.start.setText(surveys.get(position).getStart());
        holder.start_no.setText(surveys.get(position).getStart_no());
        holder.link.setText(surveys.get(position).getLink());
        holder.end_t.setText(surveys.get(position).getEnd_t());
        holder.end_no.setText(surveys.get(position).getEnd_no());
        holder.sub_link.setText(surveys.get(position).getSub_link());
        holder.corridor.setText(surveys.get(position).getCorridor());
        holder.region.setText(surveys.get(position).getRegion());
        holder.shoulder_type.setText(surveys.get(position).getShoulder_type());

        holder.itemView.setOnClickListener(v -> onClickListener.onClick(position,survey));

    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener {
        void onClick(int position, Survey survey);
    }

    @Override
    public int getItemCount() {
        return surveys.size();
    }
}

