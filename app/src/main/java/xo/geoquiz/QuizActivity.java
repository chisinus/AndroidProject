package xo.geoquiz;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import xo.objects.TrueFalse;


public class QuizActivity extends Activity
{
    private static final String TAG = "QuizActivity";

    private Button btnTrue;
    private Button btnFalse;
    private TextView ctrlQuestion;
    private Button btnNext;
    private Button btnPrev;

    private TrueFalse[] questionBank = new TrueFalse[] {
                                                new TrueFalse(R.string.question_mideast, false),
                                                new TrueFalse(R.string.question_africa, false),
                                                new TrueFalse(R.string.question_americas, true),
                                                new TrueFalse(R.string.question_asia, true)
                                            };

    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle savedInstanceState) called");

        setContentView(R.layout.activity_quiz);

        ctrlQuestion = (TextView)findViewById(R.id.question_text_view);
        ctrlQuestion.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizActivity.this, "Why do you click me?", Toast.LENGTH_SHORT).show();
            }
        });

        btnTrue = (Button)findViewById(R.id.true_button);
        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        btnFalse = (Button)findViewById(R.id.false_button);
        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        btnPrev = (Button)findViewById(R.id.ctrlPrev);
        btnPrev.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                currentIndex = currentIndex - 1;
                if (currentIndex == -1)
                {
                    currentIndex = questionBank.length - 1;
                    if (currentIndex == -1) currentIndex = questionBank.length - 1;
                }

                updateQuestion();
            }
        });

        btnNext = (Button)findViewById(R.id.ctrlNext);
        btnNext.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                currentIndex = (currentIndex+1) % questionBank.length;
                updateQuestion();
            }
        });

        updateQuestion();
    }

    private void updateQuestion()
    {
        int questionID = questionBank[currentIndex].getQuestionID();
        ctrlQuestion.setText(questionID);
    }

    private void checkAnswer(boolean answer)
    {
        boolean correctAnswer = questionBank[currentIndex].isTrueQuestion();

        int msgID;
        if (answer == correctAnswer)
            msgID = R.string.correct_toast;
        else
            msgID = R.string.incorrect_toast;

        Toast.makeText(QuizActivity.this, msgID,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");

    }

}
