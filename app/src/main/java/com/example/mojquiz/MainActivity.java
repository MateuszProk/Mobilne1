package com.example.mojquiz;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import  android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private TextView questionTextView;
    private int currentIndex=0;

    private Question[] questions = new Question[]{
            new Question(R.string.q_activity, true),
            new Question(R.string.q_find_resources, true),
            new Question(R.string.q_listener, false),
            new Question(R.string.q_resources, false),
            new Question(R.string.q_version, true)
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        nextButton = findViewById(R.id.next_button);
        questionTextView = findViewById(R.id.question_text_view);

        trueButton.setOnClickListener(v -> checkAnswerCorrectness(true));
        falseButton.setOnClickListener(v -> checkAnswerCorrectness(false));
        nextButton.setOnClickListener(v -> {
            currentIndex = (currentIndex + 1) % questions.length;
            setNextQuestion();
        });
        setNextQuestion();
    }
    private void setNextQuestion(){
        questionTextView.setText(questions[currentIndex].getQuestionId());
    }

    private void checkAnswerCorrectness(boolean userAnswer){
        boolean correctAnswer = questions[currentIndex].isTrueAnswer();
        int resultMessageId=0;
        if (userAnswer == correctAnswer){
            resultMessageId = R.string.correct_answer;
        }
        else{
            resultMessageId= R.string.incorrect_answer;
        }
        Toast.makeText(this,resultMessageId, Toast.LENGTH_SHORT).show();
    }

    }


