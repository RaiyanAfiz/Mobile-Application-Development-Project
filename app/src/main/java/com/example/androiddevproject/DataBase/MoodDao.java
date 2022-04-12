package com.example.androiddevproject.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MoodDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(MoodTable mood);

    @Query("SELECT * FROM moodtable")
    List<MoodTable> getAllUsers();

    @Delete
    int delete(MoodTable mood);

    @Update
    int update(MoodTable mood);
}
