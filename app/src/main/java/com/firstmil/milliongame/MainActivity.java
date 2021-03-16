package com.firstmil.milliongame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {
    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";

    private TextView textViewHighscore;
    private MediaPlayer mediaPlayer;

    private int highScore;
    private Animation animBlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewHighscore = findViewById(R.id.text_view_highscore);
        loadHighscore();

        // load the animation
        animBlink = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.blink);
        // set animation listener
        animBlink.setAnimationListener(this);
        animBlink.setDuration(1100);

        Button buttonStartQuiz = findViewById(R.id.button_start_quiz);
        ImageView imageView = findViewById(R.id.img);
        imageView.setAnimation(animBlink);
        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playClickHalf();
                startQuiz();
            }
        });

        Button buttonConf = findViewById(R.id.button_conf);
        Button buttonExit = findViewById(R.id.button_exit);

        buttonConf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playClickHalf();
                String url = "https://docs.google.com/document/d/1Nuw89TdbeqQFA5AAynBkPv0-f3mEyhHrzrdnAH4NrY4/edit?usp=sharing";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playClickHalf();
                finish();
            }
        });
    }

    private void startQuiz() {
        Intent intent = new Intent(MainActivity.this, QuizMilActivity.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_QUIZ) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizMilActivity.EXTRA_SCORE, 0);
                if (score > highScore) {
                    updateHighscore(score);
                }
            }
        }
    }

    private void loadHighscore() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highScore = prefs.getInt(KEY_HIGHSCORE, 0);
        textViewHighscore.setText("Максимальный выигрыш: " +  delimMoney(highScore) + "₽");
    }

    private void updateHighscore(int highscoreNew) {
        highScore = highscoreNew;
        textViewHighscore.setText("Максимальный выигрыш: " + delimMoney(highScore) + "₽");

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highScore);
        editor.apply();
    }

    private String delimMoney(int score)
    {
        DecimalFormat df = new DecimalFormat();
        df.setGroupingUsed(true);
        df.setGroupingSize(3);

        DecimalFormatSymbols decimalFormatSymbols = df.getDecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormatSymbols.setGroupingSeparator(' ');

        df.setDecimalFormatSymbols(decimalFormatSymbols);
        String sample = df.format(score);
        return sample;
    }


    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    private void playClickHalf() {
        stopPlaying();
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.click);
        }
        mediaPlayer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopPlaying();
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlaying();
    }

    private void stopPlaying(){
        if (mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}