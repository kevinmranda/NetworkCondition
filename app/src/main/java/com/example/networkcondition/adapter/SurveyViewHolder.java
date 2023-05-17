package com.example.networkcondition.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.networkcondition.R;

public class SurveyViewHolder extends RecyclerView.ViewHolder {

public TextView road, start, start_no, link, end_t, end_no, sub_link, corridor, region,shoulder_type;

    public SurveyViewHolder(@NonNull View itemView) {
        super(itemView);
        this.road =itemView.findViewById(R.id.roadTextbox);
        this.start =itemView.findViewById(R.id.startTextbox);
        this.start_no =itemView.findViewById(R.id.startTextbox2);
        this.link =itemView.findViewById(R.id.linkTextbox);
        this.end_t =itemView.findViewById(R.id.endtext);
        this.end_no =itemView.findViewById(R.id.endtext2);
        this.sub_link =itemView.findViewById(R.id.sublink_spinner);
        this.corridor =itemView.findViewById(R.id.corridortextbox);
        this.region =itemView.findViewById(R.id.regiontextbox);
        this.shoulder_type =itemView.findViewById(R.id.shoulderTypetextbox);

    }
}
