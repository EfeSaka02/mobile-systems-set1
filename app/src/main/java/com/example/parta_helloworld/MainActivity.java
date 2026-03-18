// Course: Introduction to Mobile Systems
// Lab: Lab 1 (Set 1)
// Student name: Efe Saka
// Student ID: 55934

package com.example.parta_helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonPartB = findViewById(R.id.buttonPartB);
        Button buttonPartC = findViewById(R.id.buttonPartC);

        buttonPartB.setOnClickListener(v -> {
            startActivity(new Intent(this, PartBActivity.class));
        });

        buttonPartC.setOnClickListener(v -> {
            startActivity(new Intent(this, PartCActivity.class));
        });



    }
}