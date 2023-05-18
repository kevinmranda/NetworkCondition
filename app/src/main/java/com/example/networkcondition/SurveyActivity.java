package com.example.networkcondition;

import static com.example.networkcondition.R.id;
import static com.example.networkcondition.R.layout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.networkcondition.adapter.SurveyAdapter;
import com.example.networkcondition.model.Survey;
import com.example.networkcondition.repository.DatabaseHelper;

import java.util.ArrayList;

public class SurveyActivity extends AppCompatActivity implements View.OnClickListener, SurveyAdapter.OnClickListener {

    public RecyclerView surveyRecycleView;
    public ArrayList<Survey> surveys = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_survey);

        surveyRecycleView = findViewById(id.surveyRecycleView);

        getSurveys();

        SurveyAdapter adapter = new SurveyAdapter(this, surveys);

        adapter.setOnClickListener(this);
        surveyRecycleView.setHasFixedSize(true);
        surveyRecycleView.setLayoutManager(new LinearLayoutManager(this));
        surveyRecycleView.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onClick(int position, Survey survey) {
        Toast.makeText(this, "Position: "+position+" id: "+survey.getId(), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, UpdateSurveyActivity.class);
        intent.putExtra("id",survey.getId());
        intent.putExtra("road",survey.getRoad());
        intent.putExtra("start",survey.getStart());
        intent.putExtra("start_no",survey.getStart_no());
        intent.putExtra("link",survey.getLink());
        intent.putExtra("end_t",survey.getEnd_t());
        intent.putExtra("end_no",survey.getEnd_no());
        intent.putExtra("sub_link",survey.getSub_link());
        intent.putExtra("corridor",survey.getCorridor());
        intent.putExtra("region",survey.getRegion());
        intent.putExtra("shoulder_type",survey.getShoulder_type());

        startActivity(intent);
    }

    private void getSurveys() {
        DatabaseHelper db = new DatabaseHelper(getApplicationContext());
        surveys = db.getAllSurveys();
        Toast.makeText(this, "DATA: "+surveys.size(), Toast.LENGTH_SHORT).show();
    }
}