package com.example.androiddevproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class Journal extends AppCompatActivity {

    private Button btnfloat;
    private EditText journaltext;
    private TextView journalheading;
    private ListView item_list;
    private ArrayList<String> values=new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    LinearLayout layout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);

        layout1 = findViewById(R.id.layout1);
        btnfloat = findViewById(R.id.btnfloat);
        journaltext = findViewById(R.id.journaltext);
        journalheading = findViewById(R.id.journalheading);
        item_list = findViewById(R.id.listview);

        values = FileHandler.ReadData(this);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, values);
        item_list.setAdapter(adapter);

        btnfloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newItem = journaltext.getText().toString();
                if(!newItem.isEmpty()) {
                    values.add(newItem);
                }
                else if(newItem.isEmpty()){
                    Snackbar.make(layout1,"Cannot add item", Snackbar.LENGTH_SHORT).show();
                }
                journaltext.setText("");
                FileHandler.EnterData(getApplicationContext(), values);
                adapter.notifyDataSetChanged();
            }
        });
    }
}