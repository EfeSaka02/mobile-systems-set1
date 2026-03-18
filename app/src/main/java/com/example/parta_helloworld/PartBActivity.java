package com.example.parta_helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PartBActivity extends AppCompatActivity { // That's the activity for partB

    @Override
    protected void onCreate(Bundle savedInstanceState) { // That's the method when an Activity is created
        super.onCreate(savedInstanceState); //
        setContentView(R.layout.activity_part_bactivity); // This activity associates the XML layout file with this Activity

        EditText editTextName = findViewById(R.id.editTextName); // It binds the EditText in XML to the code side
        Button buttonWitaj = findViewById(R.id.buttonWitaj); // It binds the Button in XML to the code side
        TextView textViewResult = findViewById(R.id.textViewResult); // It binds the TextView in XML to the code side

        buttonWitaj.setOnClickListener(new View.OnClickListener() { // It adds the click to the button
            @Override
            public void onClick(View v) { // That's the method works when clicked
                String input = editTextName.getText().toString().trim(); // It removes text from the EditText and clean first and last spaces
                if (input.isEmpty()) { // If the user didn't type anything
                    textViewResult.setText("Przedstaw sie."); // Writes the warning message to TextView
                } else { // if the user typed a text
                    textViewResult.setText("Witaj " + input); // Writes the Witaj and input variable
                }
            }
        });
    }
}