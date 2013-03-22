package com.AAAG.MusicBro.Player;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.AAAG.MusicBro.HomeActivity;
import com.AAAG.MusicBro.MoodActivity;
import com.AAAG.MusicBro.R;

public class SongList extends ListActivity {
    // Songs list
    public ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
    public static int songIndex=0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist);
        String album, genre;
        final ArrayList<HashMap<String, String>> songsListData = new ArrayList<HashMap<String, String>>();
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        SongsManager plm = new SongsManager();
        this.songsList = plm.getSongs();
        for (int i = 0; i < songsList.size(); i++) {
            HashMap<String, String> song = songsList.get(i);
            mmr.setDataSource(song.get("songPath"));
            album = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);
            genre =  mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_GENRE);
            if(album==null)album="Unknown";
            if(genre==null)genre = "Unknown";
            if(HomeActivity.Option==1)if(PlayListActivity.Album.equals(album))songsListData.add(song);
            if(HomeActivity.Option==2)if(MoodActivity.Mood.equals(genre) || MoodActivity.Mood.equals("Anything")) songsListData.add(song);
        }

        ListAdapter adapter = new SimpleAdapter(this, songsListData,
                R.layout.playlist_item, new String[] { "songTitle" }, new int[] {
                R.id.songTitle });

        setListAdapter(adapter);

        ListView lv = getListView();

        lv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                songIndex = songsList.indexOf(songsListData.get(position));
                startActivity(new Intent(SongList.this, AndroidBuildingMusicPlayerActivity.class));

            }
        });

    }
    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            if(HomeActivity.Option==1)startActivity(new Intent(SongList.this, PlayListActivity.class));
            if(HomeActivity.Option==2)startActivity(new Intent(SongList.this, MoodActivity.class));
        }
        return super.onKeyDown(keyCode,event);
    }
}
