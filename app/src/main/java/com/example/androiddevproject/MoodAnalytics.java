package com.example.androiddevproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.TextView;

import com.example.androiddevproject.DataBase.MoodTable;
import com.example.androiddevproject.DataBase.MyDB;

import java.util.List;

public class MoodAnalytics extends AppCompatActivity {

    TextView mostCommon, aveIntensity, top3List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_analytics);

        MyDB database = Room.databaseBuilder(getApplicationContext(),
                MyDB.class, "user_data")
                .allowMainThreadQueries()
                .build();

        List<MoodTable> moodTableList;
        String strMoodList = "";
        mostCommon = findViewById(R.id.tvMostCommon);
        aveIntensity = findViewById(R.id.tvAverageIntensity);
        top3List = findViewById(R.id.tvList);


        //Most Common Emotion
        moodTableList = database.moodDao().mostCommonEmotion();
        for (MoodTable e: moodTableList) {
            strMoodList = e.getMood();
        }
        mostCommon.setText(strMoodList);

        //Average Intensity
        moodTableList = database.moodDao().aveIntensity();
        for (MoodTable e: moodTableList) {
            strMoodList = e.getIntensity() + "";
        }
        aveIntensity.setText(strMoodList);

        // Emotion List
        strMoodList = "";
        moodTableList = database.moodDao().emotionList();
        for (MoodTable e: moodTableList) {
           strMoodList += "Emotion: " +  e.getMood() + "\nAverage Intensity: " + e.getIntensity() + "\n\n";
        }
        top3List.setText(strMoodList);
    }


}