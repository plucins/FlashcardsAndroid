package com.example.flashcardsandroid.model;

public class FlashCard {
    private String polishSide;
    private String englishSide;

    public FlashCard(String polishSide, String englishSide) {
        this.polishSide = polishSide;
        this.englishSide = englishSide;
    }

    public String getPolishSide() {
        return polishSide;
    }

    public void setPolishSide(String polishSide) {
        this.polishSide = polishSide;
    }

    public String getEnglishSide() {
        return englishSide;
    }

    public void setEnglishSide(String englishSide) {
        this.englishSide = englishSide;
    }
}
