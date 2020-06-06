package com.example.flashcardsandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.example.flashcardsandroid.model.Question;
import com.example.flashcardsandroid.model.QuizContract;

import java.util.ArrayList;
import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "DB.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public QuizDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuizContract.QuestionsTable.TABLE_NAME + " ( " +
                QuizContract.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContract.QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void fillQuestionsTable() {
        List<Question> questions = provideInitData();
        questions.forEach(u -> {
            ContentValues cv = new ContentValues();
            cv.put(QuizContract.QuestionsTable.COLUMN_QUESTION, u.getQuestion());
            cv.put(QuizContract.QuestionsTable.COLUMN_OPTION1, u.getOption1());
            cv.put(QuizContract.QuestionsTable.COLUMN_OPTION2, u.getOption2());
            cv.put(QuizContract.QuestionsTable.COLUMN_OPTION3, u.getOption3());
            cv.put(QuizContract.QuestionsTable.COLUMN_ANSWER_NR, u.getAnswerNr());
            db.insert(QuizContract.QuestionsTable.TABLE_NAME, null, cv);
        });
    }

    private List<Question> provideInitData() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Great Britain is an island made up of", "England, Scotland and Wales", "Britain, Scotland and Wales", "England and Ireland", 2));
        questions.add(new Question("England, Ireland, Scotland and Wales became one state in", "1536", "1708", "1800", 1));
        questions.add(new Question("The leek and daffodil are both plants used to symbolize", "Scotland", "Wales", "Yorkshire", 3));
        questions.add(new Question("In 1972 the UK joined", "NATO", "the European Economic Community", "the G7 group", 1));
        questions.add(new Question("The two main political parties are the Conservatives and", "Labour", "Liberals", "Social Democrats", 2));
        questions.add(new Question("The 20 or so most senior politicians are called the", "cabinet", "committee", "supreme council", 2));

        return questions;
    }


}
