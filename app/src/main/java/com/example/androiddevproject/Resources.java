package com.example.androiddevproject;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Resources extends AppCompatActivity {

    Button back2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);

        back2 = findViewById(R.id.back2);

        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Resources.this,Dashboard.class);
                startActivity(intent);
            }
        });
    }

    public void WEcmha (View view) {
        goTo("https://windsoressex.cmha.ca/document-category/mental-health/");
    }

    public void fmhsOn (View view) {
        goTo("https://www.ontario.ca/page/find-mental-health-support");
    }

    private void goTo(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }


}
