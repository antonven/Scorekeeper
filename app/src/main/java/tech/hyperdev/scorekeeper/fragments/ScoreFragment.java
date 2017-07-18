package tech.hyperdev.scorekeeper.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import tech.hyperdev.scorekeeper.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFragment extends Fragment {

    int teamScore = 0;
    TextView teamName, textScore;
    String team;
    ImageButton minus, plus;
    public ScoreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_score, container, false);

        teamName = (TextView)v.findViewById(R.id.tvTeamName);
        textScore = (TextView)v.findViewById(R.id.textScore);
        plus = (ImageButton)v.findViewById(R.id.btnPlus);
        minus = (ImageButton)v.findViewById(R.id.btnMinus);


        readBundle(getArguments());
        teamName.setText(team);

        if(savedInstanceState != null) {
            teamScore = savedInstanceState.getInt("points");
            textScore.setText(teamScore + "");
        }

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teamScore++;
                textScore.setText(teamScore + "");
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teamScore--;
                textScore.setText(teamScore + "");
            }
        });


        return v;
    }

    public static ScoreFragment newInstance(String teamName, int score) {
        
        Bundle args = new Bundle();
        ScoreFragment fragment = new ScoreFragment();

        args.putString("team", teamName);
        args.putInt("score", score);
        fragment.setArguments(args);
        return fragment;
    }

    private void readBundle(Bundle bundle){
        if(bundle != null){
            team = bundle.getString("team");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("points", teamScore);
    }
}
