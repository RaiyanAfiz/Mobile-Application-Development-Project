package com.example.androiddevproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.TextView;

import com.example.androiddevproject.DataBase.JournalTable;
import com.example.androiddevproject.DataBase.MoodTable;
import com.example.androiddevproject.DataBase.MyDB;

import java.util.List;

public class ViewJournal extends AppCompatActivity {

    TextView viewJournal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_journal);

        MyDB database = Room.databaseBuilder(getApplicationContext(),
                MyDB.class, "user_data")
                .allowMainThreadQueries()
                .build();

        viewJournal = findViewById(R.id.tvViewJournal);

        List<JournalTable> journalTables;
        String strJournal = "";

        journalTables = database.journalDao().getAllJournals();
        for (JournalTable e: journalTables) {
            strJournal += e.getJournal() + "\n\n";
        }
        viewJournal.setText(strJournal);


    }
}