package com.example.androiddevproject.DataBase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {MoodTable.class, JournalTable.class}, version = 3)
public abstract class MyDB extends RoomDatabase {
    public abstract MoodDao moodDao();
    public abstract JournalDao journalDao();
}
