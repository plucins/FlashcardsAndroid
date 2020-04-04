package com.example.flashcardsandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class StartingScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_screen);

        Button buttonStartQuiz = findViewById(R.id.button_start_quiz);
        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });

        Button buttonStartChart = findViewById(R.id.button_start_flashcard);
        buttonStartChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFlashCard();
            }
        });

    }


    private void startQuiz() {
        Intent intent = new Intent(StartingScreenActivity.this, QuizActivity.class);
        startActivity(intent);
    }

    private void startFlashCard() {
        Intent intent = new Intent(StartingScreenActivity.this, FlashCardActivity.class);
        startActivity(intent);
    }
}
