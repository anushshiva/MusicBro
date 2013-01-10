package com.AAAG.MusicBro;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends Activity {

    public static List<String> songname = new ArrayList<String>();
    public static List<String> album = new ArrayList<String>();
    public static List<String> artist = new ArrayList<String>();
    public static List<String> genre = new ArrayList<String>();
    public static List<String> filepath = new ArrayList<String>();
    public static List<Integer> rating = new ArrayList<Integer>();
    public static List<Integer> noplayed = new ArrayList<Integer>();
    public static int j=0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button albumbutton;
        albumbutton = (Button) findViewById(R.id.Album);
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        File f = new File("/sdcard/");
        int j=0;
        for (File file : f.listFiles())
        {
            if(file.getName().endsWith(".mp3"))
            {
                String [] name = file.getName().split(".mp3");
                String actualname="";
                for(int i=0;i<name.length;i++)
                    actualname +=name[i]+" ";
               songname.add(actualname); j++;
               filepath.add(file.getAbsolutePath());
               mmr.setDataSource(String.valueOf(filepath));
               album.add(mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM));
               artist.add(mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST));
                genre.add(mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_GENRE));
            }
        }
        albumbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, AlbumActivity.class));
            }
        });
    }
}
