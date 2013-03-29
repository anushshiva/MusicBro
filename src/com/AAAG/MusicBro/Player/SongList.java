package com.AAAG.MusicBro.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;
import com.AAAG.MusicBro.*;

public class SongList extends ListActivity {
    // Songs list
    public static ArrayList<Song> songsList = new ArrayList<Song>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist);
        ArrayList<String> songsListData = new ArrayList<String>();
        for(int i=0;i<HomeActivity.Songs.size();i++)
        {
            if(songsList.indexOf(HomeActivity.Songs.get(i))==-1)
                songsList.add(HomeActivity.Songs.get(i));
        }
        SharedPreferences settings = getSharedPreferences("MyPrefs",0);
        for(int i=0;i<songsList.size();i++)
        {
            songsList.get(i).count = settings.getInt(songsList.get(i).name,0);
            songsList.get(i).rating = settings.getInt(songsList.get(i).name+"r",0);
        }
        if(HomeActivity.Option==1)sort("album");
        if(HomeActivity.Option==3)
        {
            for(int i=0;i<songsList.size()-1;i++)
            {
                for (int j=0;j<songsList.size()-i-1;j++)
                {
                    if(songsList.get(j).count<songsList.get(j+1).count){
                        Collections.swap(songsList,j,j+1);
                    }
                }
            }
        }
        if(HomeActivity.Option==4)
        {
            for(int i=0;i<songsList.size()-1;i++)
            {
                for (int j=0;j<songsList.size()-i-1;j++)
                {
                    if(songsList.get(j).rating<songsList.get(j+1).rating){
                        Collections.swap(songsList,j,j+1);
                    }
                }
            }
        }
        for (int i = 0; i < songsList.size(); i++) {
            if(HomeActivity.Option==1)if(PlayListActivity.Album.equalsIgnoreCase(songsList.get(i).album))songsListData.add(songsList.get(i).name);
            if(HomeActivity.Option==2)if(MoodActivity.Mood.equals("genre") || MoodActivity.Mood.equals("Anything")) songsListData.add(songsList.get(i).name);
            if(HomeActivity.Option==3) songsListData.add(songsList.get(i).name);
            if(HomeActivity.Option==4) songsListData.add(songsList.get(i).name);
        }


        ListAdapter adapter = new ArrayAdapter<String>(this,R.layout.playlist_item,R.id.songTitle,songsListData);

        setListAdapter(adapter);

        ListView lv = getListView();

        lv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                AndroidBuildingMusicPlayerActivity.currentSongIndex = index(parent.getItemAtPosition(position).toString());
                Intent in = new Intent(SongList.this, AndroidBuildingMusicPlayerActivity.class);
                in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(in);
                finish();
            }
        });

    }

    public int index(String song){
        for(int i=0;i<songsList.size();i++)
        {
            if(songsList.get(i).name.equalsIgnoreCase(song))return i;
        }
        return -1;
    }

    public void sort(String attribute){
        for(int i=0;i<songsList.size()-1;i++)
        {
            for (int j=0;j<songsList.size()-i-1;j++)
            {
                if(songsList.get(j).album.compareToIgnoreCase(songsList.get(j+1).album)>0){
                    Collections.swap(songsList,j,j+1);
                }
            }

        }
    }

}
