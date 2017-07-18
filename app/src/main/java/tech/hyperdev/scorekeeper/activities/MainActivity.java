package tech.hyperdev.scorekeeper.activities;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import tech.hyperdev.scorekeeper.R;
import tech.hyperdev.scorekeeper.fragments.ScoreFragment;

public class MainActivity extends AppCompatActivity {

    int sTheme;
    SharedPreferences shared;
    SharedPreferences.Editor editor;
    FragmentManager fm1, fm2;
    TextView teamName;
    int points = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shared = this.getPreferences(Context.MODE_PRIVATE);
        editor = shared.edit();

        if(shared.getInt("Theme", 0) != 0 && savedInstanceState != null){
            sTheme = shared.getInt("Theme", 0);
        }
        setTheme(sTheme);
        setContentView(R.layout.activity_main);

            teamName = (TextView) findViewById(R.id.tvTeamName);


            fm1 = getSupportFragmentManager();

            fm1.beginTransaction()
                    .replace(R.id.frame1, ScoreFragment.newInstance("Team 1", points))
                    .addToBackStack("team1")
                    .commit();


            fm2 = getSupportFragmentManager();
            fm2.beginTransaction()
                    .replace(R.id.frame2, ScoreFragment.newInstance("Team 2", points))
                    .addToBackStack("team2")
                    .commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.day, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.dayMode:
                if(shared.getInt("Theme", 0) == R.style.AppTheme){
                    item.setTitle("Day Mode");
                    sTheme = R.style.CustomTheme;
                    editor.putInt("Theme", sTheme);
                    editor.apply();
                    recreate();
                }
                else{
                    item.setTitle("Night Mode");
                    sTheme = R.style.AppTheme;
                    editor.putInt("Theme", sTheme);
                    editor.apply();
                    recreate();
                }
                return  true;

            default: return true;
        }
    }
}
