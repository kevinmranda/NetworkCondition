package com.example.networkcondition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.networkcondition.R;
import com.example.networkcondition.SurveyActivity;
import com.example.networkcondition.model.Survey;
import com.example.networkcondition.repository.DatabaseHelper;

public class UpdateSurveyActivity extends AppCompatActivity implements View.OnClickListener{
    public Spinner sub_link;
    public EditText road, start, start_no, link, end_t, end_no, corridor, region, shoulder_type;
    public Button previous,update;

    public int surveyId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_survey);

        road = findViewById(R.id.roadTextbox);
        start = findViewById(R.id.startTextbox);
        start_no = findViewById(R.id.startTextbox2);
        link = findViewById(R.id.linkTextbox);
        end_t = findViewById(R.id.endtext);
        end_no = findViewById(R.id.endtext2);
        corridor = findViewById(R.id.corridortextbox);
        region = findViewById(R.id.regiontextbox);
        shoulder_type = findViewById(R.id.shoulderTypetextbox);
        sub_link = findViewById(R.id.sublink_spinner);
        previous = findViewById(R.id.previous);
        update = findViewById(R.id.update);

        surveyId =getIntent().getIntExtra("id", 0);
        String roadExtra = getIntent().getStringExtra("road");
        String startExtra = getIntent().getStringExtra("start");
        String start_noExtra = getIntent().getStringExtra("start_no");
        String linkExtra = getIntent().getStringExtra("link");
        String endExtra = getIntent().getStringExtra("end");
        String end_noExtra = getIntent().getStringExtra("end_no");
        String sub_linkExtra = getIntent().getStringExtra("sub_link");
        String corridorExtra = getIntent().getStringExtra("corridor");
        String regionExtra = getIntent().getStringExtra("region");
        String shoulder_typeExtra = getIntent().getStringExtra("shoulder_type");

        road.setText(roadExtra);
        start.setText(startExtra);
        start_no.setText(start_noExtra);
        link.setText(linkExtra);
        end_t.setText(endExtra);
        end_no.setText(end_noExtra);
        //sub_link.setText(sub_linkExtra);
        corridor.setText(corridorExtra);
        region.setText(regionExtra);
        shoulder_type.setText(shoulder_typeExtra);

        previous.setOnClickListener(this);
        update.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.previous:
                Intent i = new Intent(this, SurveyActivity.class);
                startActivity(i);
                this.finish();
            case  R.id.update:
                updateSurvey();
            case  R.id.delete:
                deleteSurvey();
        }
    }

    private void deleteSurvey() {
        String roadText = road.getText().toString();
        String startText = start.getText().toString();
        String start_noText = start_no.getText().toString();
        String linkText = link.getText().toString();
        String endText = end_t.getText().toString();
        String end_noText = end_no.getText().toString();
        String sublinkText = sub_link.toString();
        String corridorText = corridor.getText().toString();
        String regionText = region.getText().toString();
        String shoulder_typeText = shoulder_type.getText().toString();

        DatabaseHelper db = new DatabaseHelper(getApplicationContext());

        db.deleteSurvey(new Survey(
                surveyId,
                roadText,
                startText,
                start_noText,
                linkText,
                endText,
                end_noText,
                sublinkText,
                corridorText,
                regionText,
                shoulder_typeText
        ));
        Toast.makeText(this, "Survey Deleted", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getApplicationContext(),SurveyActivity.class);
        startActivity(intent);
    }

    private void updateSurvey() {
        String roadText = road.getText().toString();
        String startText = start.getText().toString();
        String start_noText = start_no.getText().toString();
        String linkText = link.getText().toString();
        String endText = end_t.getText().toString();
        String end_noText = end_no.getText().toString();
        String sublinkText = sub_link.toString();
        String corridorText = corridor.getText().toString();
        String regionText = region.getText().toString();
        String shoulder_typeText = shoulder_type.getText().toString();

        if (!roadText.equals("") &&
                !startText.equals("") &&
                !start_noText.equals("") &&
                !linkText.equals("") &&
                !endText.equals("") &&
                !end_noText.equals("")&&
                !sublinkText.equals("") &&
                !corridorText.equals("") &&
                !regionText.equals("")&&
                !shoulder_typeText.equals("")){

            DatabaseHelper db = new DatabaseHelper(getApplicationContext());

            db.updateSurvey(new Survey(
                    roadText,
                    startText,
                    start_noText,
                    linkText,
                    endText,
                    end_noText,
                    sublinkText,
                    corridorText,
                    regionText,
                    shoulder_typeText
            ));
            Toast.makeText(this, "Survey updated", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getApplicationContext(),SurveyActivity.class);
            startActivity(intent);
        }
    }
}