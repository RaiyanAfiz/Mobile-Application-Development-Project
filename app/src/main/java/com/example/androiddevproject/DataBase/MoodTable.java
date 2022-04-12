package com.example.androiddevproject.DataBase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MoodTable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "mood")
    private String mood;
    @ColumnInfo(name = "intensity")
    private int intensity;


    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getMood() {return mood;}
    public void setMood(String mood) {this.mood = mood;}

    public int getIntensity() {return intensity;}
    public void setIntensity(int intensity) {this.intensity = intensity;}

}
