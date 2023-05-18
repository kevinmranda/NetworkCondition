package com.example.networkcondition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    public Button previous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        previous = findViewById(R.id.previous);

        previous.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, FirstActivity.class);
        startActivity(i);
    }
}