package com.example.androiddevproject.DataBase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {MoodTable.class}, version = 1)
public abstract class MyDB extends RoomDatabase {
    public abstract MoodDao moodDao();
}
