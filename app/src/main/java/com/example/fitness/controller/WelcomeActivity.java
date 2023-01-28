package com.example.fitness.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitness.R;

public class WelcomeActivity extends AppCompatActivity {

    Spinner mSpinnerGender;
    Spinner mSpinnerWeight;
    Spinner mSpinnerHeight;
    Spinner mSpinnerBirthday;
    Spinner mSpinnerGoal;
    Button mButtonNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mButtonNext = (Button) findViewById(R.id.buttonNext);
        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, ExercisesActivity.class);

                startActivity(intent);

            }
        });



    }
}
