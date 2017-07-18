package tech.hyperdev.scorekeeper.activities;

import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import tech.hyperdev.scorekeeper.R;
import tech.hyperdev.scorekeeper.fragments.ScoreFragment;

public class MainActivity extends AppCompatActivity {

    FragmentManager fm1, fm2;
    TextView teamName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         ScoreFragment sf = new ScoreFragment();
         sf.getArguments();
         teamName = (TextView)findViewById(R.id.tvTeamName);


         fm1 = getSupportFragmentManager();

            fm1.beginTransaction()
                    .replace(R.id.frame1, ScoreFragment.newInstance("Team 1"))
                    .addToBackStack("team1")
                    .commit();


             fm2 = getSupportFragmentManager();
                fm2.beginTransaction()
                        .replace(R.id.frame2, ScoreFragment.newInstance("Team 2"))
                        .addToBackStack("team2")
                        .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuitem, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.themeMode){
            if(item.getTitle().equals("Day Mode")) {
                item.setTitle("Night Mode");
                setTheme(R.style.NightMode);
            }
        }
//        else if(item.getTitle().equals("Night Mode")){
//            item.setTitle("Day Mode");
//        }

        return super.onOptionsItemSelected(item);
    }
}
