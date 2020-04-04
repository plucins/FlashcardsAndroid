package com.example.flashcardsandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FlashCardActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_card);

        Button backToMenu = findViewById(R.id.flashCardBackToMenuButton);
        Button nextFlashCard = findViewById(R.id.nextFlashCardButton);

        backToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMenu();
            }
        });
    }

    private void backToMenu() {
        Intent intent = new Intent(FlashCardActivity.this, StartingScreenActivity.class);
        startActivity(intent);
    }


}
