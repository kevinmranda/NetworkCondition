package com.example.networkcondition;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.networkcondition.model.Survey;
import com.example.networkcondition.repository.DatabaseHelper;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener{

    public Spinner sub_link;
    public EditText road, start, start_no, link, end_t, end_no, corridor, region, shoulder_type;
    public Button next, submit, see_survey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

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

        next = findViewById(R.id.nextFirst);
        submit = findViewById(R.id.submit);
        see_survey = findViewById(R.id.see_survey);

        next.setOnClickListener(this);
        submit.setOnClickListener(this);
        see_survey.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.nextFirst:
                Intent i = new Intent(this, SecondActivity.class);
                startActivity(i);
                break;
            case  R.id.see_survey:
                Intent intent = new Intent(this, SurveyActivity.class);
                startActivity(intent);
                break;
            case  R.id.submit:
                createSurvey();
                break;
        }
    }

    public void createSurvey(){
        String roadText = road.getText().toString();
        String startText = start.getText().toString();
        String start_noText = start_no.getText().toString();
        String linkText = link.getText().toString();
        String endText = end_t.getText().toString();
        String end_noText = end_no.getText().toString();
        String sublinkText = sub_link.getSelectedItem().toString();
        String corridorText = corridor.getText().toString();
        String regionText = region.getText().toString();
        String shoulder_typeText = shoulder_type.getText().toString();

        if (!roadText.equals("") &&
                !startText.equals("") &&
                !start_noText.equals("") &&
                !linkText.equals("") &&
                !endText.equals("") &&
                !end_noText.equals("") &&
                !sublinkText.equals("") &&
                !corridorText.equals("") &&
                !regionText.equals("") &&
                !shoulder_typeText.equals("")) {

            DatabaseHelper db = new DatabaseHelper(getApplicationContext());

            db.createSurvey(new Survey(
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
            Toast.makeText(this, "Survey Saved!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getApplicationContext(), SurveyActivity.class);
            startActivity(intent);
        }
    }
}
