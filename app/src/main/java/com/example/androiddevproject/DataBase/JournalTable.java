package com.example.androiddevproject.DataBase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class JournalTable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "journal")
    private String journal;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getJournal() {return journal;}
    public void setJournal(String journal) {this.journal = journal;}
}
