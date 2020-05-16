package com.example.flashcardsandroid.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.flashcardsandroid.DataProvider;
import com.example.flashcardsandroid.R;
import com.example.flashcardsandroid.model.FlashCard;

import java.util.List;

public class FlashCardEnglishSide extends Fragment {
    DataProvider provider;
    String englishText = "Empty";
    List<FlashCard> flashCards;
    Button englishButton;
    int flashCardNumber = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.english_flash_card_side, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        provider = new DataProvider();
        flashCards = provider.getFlashCards();
        englishText = flashCards.get(flashCardNumber).getEnglishSide();
        englishButton = view.findViewById(R.id.englishButton);
        englishButton.setText(englishText);

        view.findViewById(R.id.englishButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(FlashCardEnglishSide.this)
                        .navigate(R.id.action_flashCardEnglishSide_to_flashCardPolishSide);
            }
        });
    }
}
