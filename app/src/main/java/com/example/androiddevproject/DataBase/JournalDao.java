package com.example.androiddevproject.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface JournalDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(JournalTable journal);

    @Query("SELECT * FROM journaltable")
    List<JournalTable> getAllJournals();

    @Delete
    int delete(JournalTable journal);

    @Update
    int update(JournalTable journal);
}
