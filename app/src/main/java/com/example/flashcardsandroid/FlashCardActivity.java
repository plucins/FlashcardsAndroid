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

import java.util.Collections;
import java.util.List;

public class FlashCardActivity extends AppCompatActivity {

    private DataProvider provider;
    private List<FlashCard> flashCards;
    private Button shuffleFlashCardsButton;
    private Button nextFlashCardButton;
    private Button previousFlashCardButton;
    private TextView frontView;
    private TextView backView;
    private TextView counterView;
    private Integer currentCard = 0;
    private String counterText;

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
        findViews();
        setCounterText();
        frontView.setText(flashCards.get(currentCard).getPolishSide());
        backView.setText(flashCards.get(currentCard).getEnglishSide());
        loadAnimations();
        changeCameraDistance();

        nextFlashCardButton.setOnClickListener(v -> nextFlashCard());
        previousFlashCardButton.setOnClickListener(v -> previousFlashCard());
        shuffleFlashCardsButton.setOnClickListener(v -> shuffleFlashCards());
    }

    private void shuffleFlashCards() {
        Collections.shuffle(flashCards);
        currentCard = 0;
        frontView.setText(flashCards.get(currentCard).getPolishSide());
        backView.setText(flashCards.get(currentCard).getEnglishSide());
        flipBackToFront();
        setCounterText();
    }

    private void flipBackToFront() {
        if (mIsBackVisible) {
            mSetRightOut.setTarget(mCardBackLayout);
            mSetLeftIn.setTarget(mCardFrontLayout);
            mSetRightOut.start();
            mSetLeftIn.start();
            mIsBackVisible = false;
        }
    }

    private void setCounterText() {
        counterText = "Karta " + (currentCard + 1) + "/" + flashCards.size();
        counterView.setText(counterText);
    }

    private void previousFlashCard() {
        if (currentCard > 0) {
            currentCard--;
            frontView.setText(flashCards.get(currentCard).getPolishSide());
            backView.setText(flashCards.get(currentCard).getEnglishSide());
            flipBackToFront();
        } else {
            currentCard = flashCards.size() - 1;
            frontView.setText(flashCards.get(currentCard).getPolishSide());
            backView.setText(flashCards.get(currentCard).getEnglishSide());
        }
        setCounterText();
    }

    private void nextFlashCard() {
        if (currentCard < flashCards.size() - 1) {
            currentCard++;
            frontView.setText(flashCards.get(currentCard).getPolishSide());
            backView.setText(flashCards.get(currentCard).getEnglishSide());
            flipBackToFront();
        } else {
            currentCard = 0;
            frontView.setText(flashCards.get(currentCard).getPolishSide());
            backView.setText(flashCards.get(currentCard).getEnglishSide());
        }
        setCounterText();
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
        shuffleFlashCardsButton = findViewById(R.id.button_shuffle_flashcards);
        nextFlashCardButton = findViewById(R.id.button_next_flashcard);
        previousFlashCardButton = findViewById(R.id.button_previous_flashcard);
        mCardBackLayout = findViewById(R.id.card_back);
        mCardFrontLayout = findViewById(R.id.card_front);
        counterView = findViewById(R.id.flash_card_counter_text);
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
