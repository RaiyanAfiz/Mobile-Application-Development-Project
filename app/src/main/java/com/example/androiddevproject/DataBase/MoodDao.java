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

    @Query("SELECT id, mood, intensity FROM moodtable GROUP BY mood ORDER BY COUNT(mood) DESC LIMIT 1")
    List<MoodTable> mostCommonEmotion();

    @Query("SELECT id, mood, AVG(intensity) as intensity FROM moodtable;")
    List<MoodTable> aveIntensity();

    @Query("SELECT id, mood, AVG(intensity) as intensity FROM moodtable GROUP BY mood ORDER BY COUNT(mood) DESC;")
    List<MoodTable> emotionList();
}
