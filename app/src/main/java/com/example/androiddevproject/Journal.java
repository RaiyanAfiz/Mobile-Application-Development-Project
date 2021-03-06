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
import android.widget.EditText;
import android.widget.Toast;

import com.example.androiddevproject.DataBase.JournalTable;
import com.example.androiddevproject.DataBase.MyDB;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Journal extends AppCompatActivity {

    private Button addText, button5;
    private EditText journalInput;

    private MyDB database;
    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    private Handler handler = HandlerCompat.createAsync(Looper.getMainLooper());



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);


        addText = findViewById(R.id.btnAddTextJournal);
        button5 = findViewById(R.id.button5);
        journalInput = findViewById(R.id.etJournalText);
        initDB();

        addText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String journalText = journalInput.getText().toString().trim();

                JournalTable journalT = new JournalTable();
                journalT.setJournal(journalText);

                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        long id = database.journalDao().insert(journalT);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (id > 0) {
                                    Toast.makeText(Journal.this, "Your journal entry has be added", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Journal.this, "Error: Could not add journal entry", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                    }
                });

                journalInput.setText("");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(Journal.this, Dashboard.class);
                startActivity(intent5);
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