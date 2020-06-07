package com.example.flashcardsandroid;

import com.example.flashcardsandroid.model.Question;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class QuizDbHelperTest {


    @Mock
    QuizDbHelper quizDbHelper;
    List<Question> questions;

    @Before
    public void setup() {
        questions = new ArrayList<>();
        questions.add(new Question("In 1972 the UK joined", "NATO", "the European Economic Community", "the G7 group", 1));
        questions.add(new Question("The two main political parties are the Conservatives and", "Labour", "Liberals", "Social Democrats", 2));
        questions.add(new Question("The 20 or so most senior politicians are called the", "cabinet", "committee", "supreme council", 2));
    }


    @Test
    public void ShouldGetAllQuestions_When_CorrectCall() {
        //when
        when(quizDbHelper.getAllQuestions()).thenReturn(questions);

        Assert.assertEquals(questions.size(), quizDbHelper.getAllQuestions().size());
    }
}
