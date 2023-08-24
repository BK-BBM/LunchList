package com.example.lunchlist;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* An intent is used when you want to achieve a specific task in Android.
                In natural language when you want to do Activity B : we say you have the intention to do activity B

                Same logic in Android, the intent class is an abstraction of whatever activity/ operation you want to do

                In this example, we want to move from LoginActivity to DashboardActivity.
                we create an intent that will achieve this task and then start the activity for the specific intent

                Usually when an intent is done you can put finish()
                * */
                Intent activityIntent = new Intent();
                activityIntent = new Intent(LoginActivity.this,
                        DashboardActivity.class );
                startActivity(activityIntent);

            }
        });
    }
}
