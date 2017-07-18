package tech.hyperdev.scorekeeper.activities;

import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import tech.hyperdev.scorekeeper.R;
import tech.hyperdev.scorekeeper.fragments.ScoreFragment;

public class MainActivity extends AppCompatActivity {

    FragmentManager fm1, fm2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         fm1 = getSupportFragmentManager();
            fm1.beginTransaction()
                    .replace(R.id.frame1, new ScoreFragment())
                    .addToBackStack("team1")
                    .commit();

         fm2 = getSupportFragmentManager();
            fm2.beginTransaction()
                    .replace(R.id.frame2, new ScoreFragment())
                    .addToBackStack("team2")
                    .commit();
    }
}
