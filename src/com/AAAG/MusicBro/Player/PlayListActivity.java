package com.AAAG.MusicBro.Player;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;
import com.AAAG.MusicBro.HomeActivity;
import com.AAAG.MusicBro.R;

public class PlayListActivity extends ListActivity {
    // Songs list
    public ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
    public static String Album;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist);

        ArrayList<HashMap<String, String>> songsListData = new ArrayList<HashMap<String, String>>();

        SongsManager plm = new SongsManager();
        // get all songs from sdcard
        this.songsList = plm.getAlbums();

        // looping through playlist
        for (int i = 0; i < songsList.size(); i++) {
            // creating new HashMap
            HashMap<String, String> song = songsList.get(i);

            // adding HashList to ArrayList
            songsListData.add(song);
        }

        // Adding menuItems to ListView
        ListAdapter adapter = new SimpleAdapter(this, songsListData,
                R.layout.playlist_item, new String[] { "songTitle" }, new int[] {
                R.id.songTitle });

        setListAdapter(adapter);

        // selecting single ListView item
        ListView lv = getListView();
        // listening to single listitem click
        lv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Album = songsList.get(position).get("songTitle");
                startActivity(new Intent(PlayListActivity.this, SongList.class));
                finish();
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 101){
            Intent in = new Intent(getApplicationContext(),
                    AndroidBuildingMusicPlayerActivity.class);
            int songIndex = data.getExtras().getInt("songIndex");
            in.putExtra("songIndex", SongList.songIndex);
            setResult(100, in);
            finish();
            // play selected song
        }

    }
    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
            startActivity(new Intent(PlayListActivity.this, HomeActivity.class));
        return super.onKeyDown(keyCode,event);
    }
}
