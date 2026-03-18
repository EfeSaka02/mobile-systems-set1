package com.example.parta_helloworld;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class PartCActivity extends AppCompatActivity {

    int secretNumber; // That's the secret number which saved in computer's memory
    int attemptCount; // That's the user attempt and computer also save the attempt in memory
    Random random = new Random(); // Created the random object

    @Override
    protected void onCreate(Bundle savedInstanceState) { // It runs when activity started
    super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_cactivity);

        EditText editTextGuess = findViewById(R.id.editTextGuess);
        Button buttonGuess = findViewById(R.id.buttonGuess);
        TextView textViewMessage = findViewById(R.id.textViewMessage);
        TextView textViewAttempt = findViewById(R.id.textViewAttempt);

        startNewGame(textViewMessage, textViewAttempt);

        buttonGuess.setOnClickListener(v -> {
            String input = editTextGuess.getText().toString().trim();

            // Input validation
            if (input.isEmpty()) { // If the user didn't write anything it gives the warning message
                textViewMessage.setText("Please enter an integer number.");
                return;
            }

            int guess; // That's the variable for the user's guess
            try {
                guess = Integer.parseInt(input); // That's the transform from the string to integer
            } catch (NumberFormatException e) { // If it's not the integer this method catches the error
                textViewMessage.setText("Please enter an integer number."); // Shows the error message
                return;
            }

            if (guess < 1 || guess > 10) { // if the integer is not between the 1 and 10 it shows the text message below
                textViewMessage.setText("Number must be in range 1..10.");
                return;
            }

            attemptCount++; // Increase the number of attempts by 1
            textViewAttempt.setText("Attempt: " + attemptCount); // It prints the current number of attemps to the screen

            if (guess == secretNumber) { // If the guess is right and git it right on the second try it prints the screen message below
                if (attemptCount == 2) {
                    textViewMessage.setText("Correct! You won on attempt 2!");  // That's win message
                    startNewGame(textViewMessage, textViewAttempt); // Restart the game
                } else { // If it's true but not second try it prints the below message
                    textViewMessage.setText("Correct, but not on the 2nd attempt. Try again.");
                    startNewGame(textViewMessage, textViewAttempt); // Restart the game
                }
            } else if (guess < secretNumber) { // If the guess number smaller than secret number it prints the value too small message
                textViewMessage.setText("Value too small");
            } else { // If not it prints the value too large message
                textViewMessage.setText("Value too large");
            }

            editTextGuess.setText(""); // It cleans the editText
        });
    }

    void startNewGame(TextView message, TextView attempt) { // That's the method that starts the new game
        secretNumber = random.nextInt(10) + 1; // It generates random numbers between 1 and 10
        attemptCount = 0; // It resets the number of attempts
        attempt.setText("Attempt: 0"); // it shows the number of attempts like 0
    }
}