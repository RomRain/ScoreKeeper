package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mScore1;
    private int mScore2;
    private TextView mScoreText1;
    private TextView mScoreText2;

    private static final String STATE_SCORE_1 = "STATE_SCORE_1";
    private static final String STATE_SCORE_2 = "STATE_SCORE_2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreText1 = findViewById(R.id.score_team_one);
        mScoreText2 = findViewById(R.id.score_team_two);

        if (savedInstanceState != null) {

            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2);

            mScoreText1.setText(String.valueOf(mScore1));
            mScoreText2.setText(String.valueOf(mScore2));
        }


    }

    public void decreaseScore(View view) {

        int viewInt = view.getId();

        switch (viewInt) {

            case R.id.decrease_team_one:

                if (mScore1 >= 1) {
                    mScore1--;
                }
                mScoreText1.setText(String.valueOf(mScore1));
                break;

            case R.id.decrease_team_two:

                if (mScore2 >= 1) {
                    mScore2--;
                }
                mScoreText2.setText(String.valueOf(mScore2));
                break;
        }
    }

    public void increaseScore(View view) {

        int viewInt = view.getId();

        switch (viewInt) {

            case R.id.increase_team_one:

                mScore1++;
                mScoreText1.setText(String.valueOf(mScore1));
                break;

            case R.id.increase_team_two:

                mScore2++;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {

            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else {

            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.night_mode) {

            int nightMode = AppCompatDelegate.getDefaultNightMode();

            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {

                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {

                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }

            recreate();

        }

        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putInt(STATE_SCORE_1, mScore1);
        outState.putInt(STATE_SCORE_2, mScore2);
        super.onSaveInstanceState(outState);
    }
}
