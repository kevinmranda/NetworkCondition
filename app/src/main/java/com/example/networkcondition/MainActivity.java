package com.example.networkcondition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public EditText username;
    public EditText password;
    public Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login  = (Button) findViewById(R.id.loginButton);

        login.setOnClickListener((View.OnClickListener) login);
    }

    @Override
    public void onClick(View v) {
        login();
    }

    private void login() {
        String usernameInput  = username.getText().toString().trim();
        String passwordInput  = password.getText().toString().trim();

        if(usernameInput.equals("groupOne") && passwordInput.equals("1234")) {
            Intent i = new Intent(this, FirstActivity.class);
            startActivity(i);

            Toast.makeText(this, "Welcome, "+usernameInput+ "!", Toast.LENGTH_LONG).show();

            this.finish();
        } else {
            Toast.makeText(this,"Wrong username or password!",Toast.LENGTH_SHORT).show();
        }

    }
}