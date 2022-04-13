package com.example.androiddevproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.HandlerCompat;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androiddevproject.DataBase.MoodTable;
import com.example.androiddevproject.DataBase.MyDB;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Mood extends AppCompatActivity {

    RadioButton radEmotion;
    RadioGroup radGroupEmotion;
    Button btnSubmit, back;
    TextView lbl, lblIntensity;
    SeekBar emotionIntensity;

    private MyDB database;
    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    private Handler handler = HandlerCompat.createAsync(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);

        radGroupEmotion = findViewById(R.id.radGroupEmotions);
        btnSubmit = findViewById(R.id.btnSubmit);
        lbl = findViewById(R.id.lblShow);
        lblIntensity = findViewById(R.id.lblShowIntensity);
        emotionIntensity = findViewById(R.id.seekBarIntensity);
        back = findViewById(R.id.back);

        initDB();

        radGroupEmotion.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radEmotion = findViewById(selectedId);
            }
        });

        emotionIntensity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                lblIntensity.setText(i + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mood.this, Dashboard.class);
                startActivity(intent);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Useless delete later
                String temp = "Mood: ";
                temp += radEmotion.getText().toString() + " \nIntensity: ";
                temp += emotionIntensity.getProgress();
                lbl.setText(temp);

                String myMood = radEmotion.getText().toString();
                int myIntensity = emotionIntensity.getProgress();

                MoodTable moodT = new MoodTable();
                moodT.setMood(myMood);
                moodT.setIntensity(myIntensity);

                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        long id = database.moodDao().insert(moodT);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (id > 0) {
                                    Toast.makeText(Mood.this, "Data Insertion success.", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Mood.this, "Data Insertion failed.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                    }
                });

            }
        });

    }

    private void initDB() {
        database = Room.databaseBuilder(getApplicationContext(),
                MyDB.class, "user_data")
                .fallbackToDestructiveMigration()
                .build();
    }

}