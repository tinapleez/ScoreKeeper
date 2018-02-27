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

package com.example.android.scorekeeper;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /**
     * Declare score variable for Player 1
     */
    int scorePlayer1 = 0;
    /**
     * Declare score variable for Player 2
     */
    int scorePlayer2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayPlayer1(0);
        displayPlayer2(0);
        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();
    }
    /**
     * Increase the score for Player 1 by 1 point.
     */
    public void addOneForPlayer1(View v) {
        scorePlayer1 = scorePlayer1 + 1;
        displayPlayer1(scorePlayer1);
    }
    /**
     * Increase the score for Player 1 by 2 points.
     */
    public void addTwoForPlayer1(View v) {
        scorePlayer1 = scorePlayer1 + 2;
        displayPlayer1(scorePlayer1);
    }
    /**
     * Increase the score for Player 1 by 3 points.
     */
    public void addThreeForPlayer1(View v) {
        scorePlayer1 = scorePlayer1 + 3;
        displayPlayer1(scorePlayer1);
    }
    /**
     * Increase the score for Player 2 by 1 point.
     */
    public void addOneForPlayer2(View v) {
        scorePlayer2 = scorePlayer2 + 1;
        displayPlayer2(scorePlayer2);
    }
    /**
     * Increase the score for Player 2 by 2 points.
     */
    public void addTwoForPlayer2(View v) {
        scorePlayer2 = scorePlayer2 + 2;
        displayPlayer2(scorePlayer2);
    }
    /**
     * Increase the score for Player 2 by 3 points.
     */
    public void addThreeForPlayer2(View v) {
        scorePlayer2 = scorePlayer2 + 3;
        displayPlayer2(scorePlayer2);
    }
    /**
     * Displays the given score for Player 1.
     */
    public void displayPlayer1(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_1_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Player 2.
     */
    public void displayPlayer2(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_2_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     *  Resets the scores for Players 1 and 2 to zero
     */
    public void reset(View v) {
        scorePlayer1 = 0;
        scorePlayer2 = 0;
        displayPlayer1(scorePlayer1);
        displayPlayer2(scorePlayer2);
    }
}

