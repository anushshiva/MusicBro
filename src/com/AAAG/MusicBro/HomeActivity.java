package com.AAAG.MusicBro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import com.AAAG.MusicBro.Player.AndroidBuildingMusicPlayerActivity;
import com.AAAG.MusicBro.Player.PlayListActivity;

public class HomeActivity extends Activity {
    public static int Option;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(ChoiceActivity.female)
            setContentView(R.layout.femalemain);
        else
            setContentView(R.layout.main);
        Button albumbutton = (Button)findViewById(R.id.Album);
//        Button weatherbutton = (Button)findViewById(R.id.Weather);
        Button moodbutton = (Button)findViewById(R.id.Mood);
//        Button noplayedbutton = (Button)findViewById(R.id.NoPlayed);
//        Button ratingbutton = (Button)findViewById(R.id.Rating);
        albumbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Option = 1;
                startActivity(new Intent(HomeActivity.this, PlayListActivity.class));
            }
        });
        moodbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Option = 2;
                startActivity(new Intent(HomeActivity.this, MoodActivity.class));
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            finish();
            stopService(new Intent(String.valueOf(HomeActivity.this)));
        }
        return super.onKeyDown(keyCode,event);
    }


}
