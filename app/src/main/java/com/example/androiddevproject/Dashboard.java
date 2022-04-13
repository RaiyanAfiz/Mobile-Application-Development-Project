package com.example.androiddevproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androiddevproject.DataBase.MyDB;

public class Dashboard extends AppCompatActivity {

    Button mood, resources, journal, moodAnalysis, viewJournal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mood = findViewById(R.id.mood);
        resources = findViewById(R.id.resources);
        journal = findViewById(R.id.journal);
        moodAnalysis = findViewById(R.id.btnMoodAnalysis);
        viewJournal = findViewById(R.id.btnViewJournal);

        mood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Dashboard.this,Mood.class);
                startActivity(intent1);
            }
        });

        resources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Dashboard.this, Resources.class);
                startActivity(intent2);
            }
        });

        journal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(Dashboard.this, Journal.class);
                startActivity(intent3);
            }
        });

        moodAnalysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(Dashboard.this, MoodAnalytics.class);
                startActivity(intent4);
            }
        });

        viewJournal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(Dashboard.this, ViewJournal.class);
                startActivity(intent5);
            }
        });


    }

}