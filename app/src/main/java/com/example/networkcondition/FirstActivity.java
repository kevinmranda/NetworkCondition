package com.example.networkcondition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener{

    public Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        next = findViewById(R.id.next);

        next.setOnClickListener((View.OnClickListener) next);

    }

    @Override
    public void onClick(View v) {
            Intent i = new Intent(this, SecondActivity.class);
            startActivity(i);

            this.finish();
    }
}