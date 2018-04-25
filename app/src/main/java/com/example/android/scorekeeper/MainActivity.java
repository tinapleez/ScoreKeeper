/*
 * Copyright (c) 2018. Tina Taylor
 *
 * Creative Commons Attribution License 3.0
 *
 * You are free to:
 * Share — copy and redistribute the material in any medium or format
 * Adapt — remix, transform, and build upon the material for any purpose, even commercially.
 * This license is acceptable for Free Cultural Works.
 * The licensor cannot revoke these freedoms as long as you follow the license terms.
 *
 * Under the following terms:
 * Attribution — You must give appropriate credit, provide a link to the license, and indicate if changes were made. You may do so in any reasonable manner, but not in any way that suggests the licensor endorses you or your use.
 *
 * No additional restrictions — You may not apply legal terms or technological measures that legally restrict others from doing anything the license permits.
 *
 * See full license here: https://creativecommons.org/licenses/by/3.0/us/legalcode
 */
/* Countdown timer code copied from https://codinginflow.com/code-examples/android/countdown-timer/part-1
 * Attribution given to Florian */

package com.example.android.scorekeeper;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final long START_TIME_IN_MILLIS = 180000;
    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private Button mButtonReset;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    private TextView player1ScoreView;
    private TextView player2ScoreView;
    // Declare score variables for Players
    int scorePlayer1 = 0;
    int scorePlayer2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player1ScoreView = findViewById(R.id.player_1_score);
        player1ScoreView.setText(R.string.text_score_p1);
        player2ScoreView = findViewById(R.id.player_2_score);
        player2ScoreView.setText(R.string.text_score_p2);

        displayPlayer1(0);
        displayPlayer2(0);

        mTextViewCountDown = findViewById(R.id.text_view_countdown);
        mButtonStartPause = findViewById(R.id.button_start_pause);
        mButtonReset = findViewById(R.id.button_reset);
        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });

        updateCountDownText();
    }

    // Countdown timer
    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mButtonStartPause.setText(R.string.text_start_timer);
                mButtonStartPause.setVisibility(View.INVISIBLE);
                mButtonReset.setVisibility(View.VISIBLE);
            }
        }.start();

        mTimerRunning = true;
        mButtonStartPause.setText(R.string.text_pause_timer);
        mButtonReset.setVisibility(View.INVISIBLE);
    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mButtonStartPause.setText(R.string.text_start_timer);
        mButtonReset.setVisibility(View.VISIBLE);
    }

    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        mTextViewCountDown.setText(timeLeftFormatted);
    }

    // Players 1 & 2 score calculation methods
    /**
     * Increase the score for Player 1 by 1 point.     */
    public void addOneForPlayer1(View v) {
        scorePlayer1 = scorePlayer1 + 1;
        displayPlayer1(scorePlayer1);
    }

    /**
     * Increase the score for Player 1 by 2 points.     */
    public void addTwoForPlayer1(View v) {
        scorePlayer1 = scorePlayer1 + 2;
        displayPlayer1(scorePlayer1);
    }

    /**
     * Increase the score for Player 1 by 3 points.     */
    public void addThreeForPlayer1(View v) {
        scorePlayer1 = scorePlayer1 + 3;
        displayPlayer1(scorePlayer1);
    }

    /**
     * Increase the score for Player 1 by 5 points.     */
    public void addFiveForPlayer1(View v) {
        scorePlayer1 = scorePlayer1 + 5;
        displayPlayer1(scorePlayer1);
    }

    /**
     * Increase the score for Player 1 by 11 points.     */
    public void addElevenForPlayer1(View v) {
        scorePlayer1 = scorePlayer1 + 11;
        displayPlayer1(scorePlayer1);
    }

    /**
     * Increase the score for Player 2 by 1 point.     */
    public void addOneForPlayer2(View v) {
        scorePlayer2 = scorePlayer2 + 1;
        displayPlayer2(scorePlayer2);
    }

    /**
     * Increase the score for Player 2 by 2 points.     */
    public void addTwoForPlayer2(View v) {
        scorePlayer2 = scorePlayer2 + 2;
        displayPlayer2(scorePlayer2);
    }

    /**
     * Increase the score for Player 2 by 3 points.     */
    public void addThreeForPlayer2(View v) {
        scorePlayer2 = scorePlayer2 + 3;
        displayPlayer2(scorePlayer2);
    }

    /**
     * Increase the score for Player 2 by 5 points.     */
    public void addFiveForPlayer2(View v) {
        scorePlayer2 = scorePlayer2 + 5;
        displayPlayer2(scorePlayer2);
    }

    /**
     * Increase the score for Player 2 by 11 points.     */
    public void addElevenForPlayer2(View v) {
        scorePlayer2 = scorePlayer2 + 11;
        displayPlayer2(scorePlayer2);
    }

    /**
     * Displays the given score for Player 1.     */
    public void displayPlayer1(int score) {
        player1ScoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Player 2.     */
    public void displayPlayer2(int score) {
        player2ScoreView.setText(String.valueOf(score));
    }

    /**
     *  Resets the scores for Players 1 and 2 to zero     */
    public void reset(View v) {
        scorePlayer1 = 0;
        scorePlayer2 = 0;
        displayPlayer1(scorePlayer1);
        displayPlayer2(scorePlayer2);
    }
}

