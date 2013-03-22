package com.AAAG.MusicBro;


import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;
import com.AAAG.MusicBro.Player.PlayListActivity;
import com.AAAG.MusicBro.Player.SongList;

public class MoodActivity extends ListActivity {
    public static String Mood;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist);
        final ArrayList<HashMap<String, String>> moods = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> mood = new HashMap<String, String>();
        HashMap<String, String> mood1 = new HashMap<String, String>();
        HashMap<String, String> mood2 = new HashMap<String, String>();
        HashMap<String, String> mood3 = new HashMap<String, String>();
        HashMap<String, String> mood4 = new HashMap<String, String>();
        HashMap<String, String> mood5 = new HashMap<String, String>();
        HashMap<String, String> mood6 = new HashMap<String, String>();
        HashMap<String, String> mood7 = new HashMap<String, String>();
        HashMap<String, String> mood8 = new HashMap<String, String>();
        HashMap<String, String> mood9 = new HashMap<String, String>();
        HashMap<String, String> mood10 = new HashMap<String, String>();
        HashMap<String, String> mood11 = new HashMap<String, String>();
        HashMap<String, String> mood12 = new HashMap<String, String>();
        HashMap<String, String> mood13 = new HashMap<String, String>();
        mood.put("moodtype", "Happy"); mood.put("genre", "Pop");moods.add(0,mood);
        mood1.put("moodtype", "Sad"); mood1.put("genre", "Slow");moods.add(1,mood1);
        mood2.put("moodtype", "Alone"); mood2.put("genre", "Slow");moods.add(2,mood2);
        mood3.put("moodtype", "Angry"); mood3.put("genre", "Rock");moods.add(3,mood3);
        mood4.put("moodtype", "Annoyed"); mood4.put("genre", "Rock");moods.add(4,mood4);
        mood5.put("moodtype", "Sleepy"); mood5.put("genre", "R&B");moods.add(5,mood5);
        mood6.put("moodtype", "Calm"); mood6.put("genre", "R&B");moods.add(6,mood6);
        mood7.put("moodtype", "Cheerful"); mood7.put("genre", "Dance");moods.add(7,mood7);
        mood8.put("moodtype", "Indifferent"); mood8.put("genre", "Anything");moods.add(8,mood8);
        mood9.put("moodtype", "Energetic"); mood9.put("genre", "Dance");moods.add(9,mood9);
        mood10.put("moodtype", "Dull"); mood10.put("genre", "Slow");moods.add(10,mood10);
        mood11.put("moodtype", "Mischievous"); mood11.put("genre", "Dance");moods.add(11,mood11);
        mood12.put("moodtype", "Devotional"); mood12.put("genre", "Classical");moods.add(12,mood12);
        mood13.put("moodtype", "Tired"); mood13.put("genre", "Slow");moods.add(13,mood13);
        ListAdapter adapter = new SimpleAdapter(this, moods,
                R.layout.playlist_item, new String[] { "moodtype" }, new int[] {
                R.id.songTitle });
        setListAdapter(adapter);
        ListView lv = getListView();
        lv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Mood = moods.get(position).get("genre");
                startActivity(new Intent(MoodActivity.this, SongList.class));
                finish();
            }
        });
    }
}
