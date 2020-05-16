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

public class FlashCardPolishSide extends Fragment {
    DataProvider provider;
    String polishText = "Empty";
    List<FlashCard> flashCards;
    Button polishButton;
    int flashCardNumber = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.polish_flash_card_side, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        provider = new DataProvider();
        flashCards = provider.getFlashCards();
        polishText = flashCards.get(flashCardNumber).getPolishSide();
        polishButton = view.findViewById(R.id.polishButton);
        polishButton.setText(polishText);


        view.findViewById(R.id.polishButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(FlashCardPolishSide.this)
                        .navigate(R.id.action_flashCardPolishSide_to_flashCardEnglishSide);
            }
        });
    }
}
