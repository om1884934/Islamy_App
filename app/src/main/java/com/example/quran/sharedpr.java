package com.example.quran;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

// Inside MainActivity
public class sharedpr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Retrieve the shared preferences
        SharedPreferences preferences = getSharedPreferences("MyPreferences", MODE_PRIVATE);

        // Check if the button has been clicked before
        boolean isButtonClicked = preferences.getBoolean("isButtonClicked", false);

        // If the button has been clicked, start the next activity
        if (isButtonClicked) {
            Intent intent = new Intent(sharedpr.this, MainActivity2.class);
            startActivity(intent);
            finish(); // Finish this activity so that pressing back won't bring you here
        }

        // Button click listener
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Save the button click state in shared preferences
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("isButtonClicked", true);
                editor.apply();

                // Start the next activity
                Intent intent = new Intent(sharedpr.this, MainActivity2.class);
                startActivity(intent);
                finish(); // Finish this activity so that pressing back won't bring you here
            }
        });
    }
}
