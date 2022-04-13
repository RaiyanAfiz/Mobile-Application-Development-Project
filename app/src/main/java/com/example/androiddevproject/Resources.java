package com.example.androiddevproject;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.Button;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class Resources extends AppCompatActivity {

    Button back2, button1, button2, button3, button4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);

        back2 = findViewById(R.id.back2);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Resources.this,Dashboard.class);
                startActivity(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = "https://windsoressex.cmha.ca/document-category/mental-health/";
                Intent intent = new Intent(Resources.this, Webview.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = "https://www.ontario.ca/page/find-mental-health-support";
                Intent intent = new Intent(Resources.this, Webview.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = "https://www.uwindsor.ca/wellness/304/counselling";
                Intent intent = new Intent(Resources.this, Webview.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = "https://www.youtube.com/watch?v=F28MGLlpP90";
                Intent intent = new Intent(Resources.this, Webview.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });

    }

}
