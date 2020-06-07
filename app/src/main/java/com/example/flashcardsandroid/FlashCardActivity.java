package com.example.flashcardsandroid;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.flashcardsandroid.model.FlashCard;

import java.util.List;

public class FlashCardActivity extends AppCompatActivity {

    DataProvider provider;
    List<FlashCard> flashCards;
    Button nextFlashCard;
    TextView frontView;
    TextView backView;
    Integer currentCard = 0;

    private AnimatorSet mSetRightOut;
    private AnimatorSet mSetLeftIn;
    private boolean mIsBackVisible = false;
    private View mCardFrontLayout;
    private View mCardBackLayout;
    private long mLastClickTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        provider = new DataProvider();
        setContentView(R.layout.activity_flash_card);
        flashCards = provider.getFlashCards();
        nextFlashCard = findViewById(R.id.button_next_flashcard);
        findViews();
        frontView.setText(flashCards.get(currentCard).getPolishSide());
        backView.setText(flashCards.get(currentCard).getEnglishSide());
        loadAnimations();
        changeCameraDistance();

        nextFlashCard.setOnClickListener(v -> changeFlashCardText());


    }

    private void changeFlashCardText() {
        if (currentCard < flashCards.size() - 1) {
            currentCard++;
            frontView.setText(flashCards.get(currentCard).getPolishSide());
            backView.setText(flashCards.get(currentCard).getEnglishSide());
        } else {
            currentCard = 0;
            frontView.setText(flashCards.get(currentCard).getPolishSide());
            backView.setText(flashCards.get(currentCard).getEnglishSide());
        }
    }

    private void changeCameraDistance() {
        int distance = 8000;
        float scale = getResources().getDisplayMetrics().density * distance;
        mCardFrontLayout.setCameraDistance(scale);
        mCardBackLayout.setCameraDistance(scale);
    }

    private void loadAnimations() {
        mSetRightOut = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.out_animation);
        mSetLeftIn = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.in_animation);
    }

    private void findViews() {
        mCardBackLayout = findViewById(R.id.card_back);
        mCardFrontLayout = findViewById(R.id.card_front);
        frontView = findViewById(R.id.cardFrontTextView);
        backView = findViewById(R.id.cardBackTextView);
    }

    public void flipCard(View view) {
        if (SystemClock.elapsedRealtime() - mLastClickTime < 810) {
            return;
        }
        mLastClickTime = SystemClock.elapsedRealtime();
        if (!mIsBackVisible) {
            mSetRightOut.setTarget(mCardFrontLayout);
            mSetLeftIn.setTarget(mCardBackLayout);
            mSetRightOut.start();
            mSetLeftIn.start();
            mIsBackVisible = true;
        } else {
            mSetRightOut.setTarget(mCardBackLayout);
            mSetLeftIn.setTarget(mCardFrontLayout);
            mSetRightOut.start();
            mSetLeftIn.start();
            mIsBackVisible = false;
        }
    }
}
