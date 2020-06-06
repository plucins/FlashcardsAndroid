package com.example.flashcardsandroid;

import com.example.flashcardsandroid.model.FlashCard;
import com.example.flashcardsandroid.model.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which provide data to fill up application
 */
public class DataProvider {

    /**
     * @return Questions for Quiz
     */
    public List<Question> getQuestions() {

        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Great Britain is an island made up of", "England, Scotland and Wales", "Britain, Scotland and Wales", "England and Ireland", 2));
        questions.add(new Question("England, Ireland, Scotland and Wales became one state in", "1536", "1708", "1800", 1));
        questions.add(new Question("The leek and daffodil are both plants used to symbolize", "Scotland", "Wales", "Yorkshire", 3));
        questions.add(new Question("In 1972 the UK joined", "NATO", "the European Economic Community", "the G7 group", 1));
        questions.add(new Question("The two main political parties are the Conservatives and", "Labour", "Liberals", "Social Democrats", 2));
        questions.add(new Question("The 20 or so most senior politicians are called the", "cabinet", "committee", "supreme council", 2));

        return questions;

    }

    public List<FlashCard> getFlashCards() {
        List<FlashCard> flashCards = new ArrayList<>();
        flashCards.add(new FlashCard("pies", "dog"));
        flashCards.add(new FlashCard("dom", "house"));
        flashCards.add(new FlashCard("lampa", "lamp"));
        flashCards.add(new FlashCard("komputer", "computer"));

        return flashCards;
    }
}
