package com.AAAG.MusicBro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import com.AAAG.MusicBro.Player.CountActivity;
import com.AAAG.MusicBro.Player.PlayListActivity;
import com.AAAG.MusicBro.Player.RatingActivity;

import java.util.ArrayList;

public class HomeActivity extends Activity {
    public static int Option;
    public static ArrayList<Song> Songs = new ArrayList<Song>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(ChoiceActivity.female)
            setContentView(R.layout.femalemain);
        else
            setContentView(R.layout.main);
        Button albumbutton = (Button)findViewById(R.id.Album);
//   Button weatherbutton = (Button)findViewById(R.id.Weather);
        Button moodbutton = (Button)findViewById(R.id.Mood);
        Button noplayedbutton = (Button)findViewById(R.id.NoPlayed);
        Button ratingbutton = (Button)findViewById(R.id.Rating);
        albumbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Option = 1;
                Intent in = new Intent(HomeActivity.this, PlayListActivity.class);
                startActivity(in);
            }
        });
        moodbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Option = 2;
                startActivity(new Intent(HomeActivity.this, MoodActivity.class));
            }
        });
        noplayedbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Option = 3;
                startActivity(new Intent(HomeActivity.this, CountActivity.class));
            }
        });
        ratingbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Option=4;
                startActivity(new Intent(HomeActivity.this, RatingActivity.class));
            }
        });
    }

}
