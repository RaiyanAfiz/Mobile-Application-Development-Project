package com.example.androiddevproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class Mood extends AppCompatActivity {

    RadioButton radEmotion;
    RadioGroup radGroupEmotion;
    Button btnSubmit;
    TextView lbl, lblIntensity;
    SeekBar emotionIntensity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);

        radGroupEmotion = findViewById(R.id.radGroupEmotions);
        btnSubmit = findViewById(R.id.btnSubmit);
        lbl = findViewById(R.id.lblShow);
        lblIntensity = findViewById(R.id.lblShowIntensity);
        emotionIntensity = findViewById(R.id.seekBarIntensity);


        radGroupEmotion.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radEmotion = findViewById(selectedId);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = "Mood: ";
                temp += radEmotion.getText().toString() + " \nIntensity: ";
                temp += emotionIntensity.getProgress();
                lbl.setText(temp);
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



    }
}