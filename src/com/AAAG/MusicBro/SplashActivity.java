package com.AAAG.MusicBro;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.content.Intent;
import android.provider.MediaStore;


public class SplashActivity extends Activity  {
    String[] STAR = { "*" };
    int totalSongs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash);
        ListAllSongs();
        SharedPreferences settings = getSharedPreferences("MyPrefs",0);
        ChoiceActivity.chosen = settings.getBoolean("chosen",false);
        ChoiceActivity.female = settings.getBoolean("female",false);
    int delay = 1000;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent1 = new Intent(SplashActivity.this, HomeActivity.class);
                Intent intent2 = new Intent(SplashActivity.this, ChoiceActivity.class);
                if(ChoiceActivity.chosen)
                    startActivity(intent1);
                else
                    startActivity(intent2);
            }
        }, delay);


    }

    public void ListAllSongs()
    {
        Uri allsongsuri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";

        Cursor cursor = getContentResolver().query(allsongsuri, STAR, selection, null, null);

        totalSongs = cursor.getCount();

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    Song song = new Song();
                    song.name = cursor
                            .getString(cursor
                                    .getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));

                    song.path = cursor.getString(cursor
                            .getColumnIndex(MediaStore.Audio.Media.DATA));

                    song.album = cursor.getString(cursor
                            .getColumnIndex(MediaStore.Audio.Media.ALBUM));

                    song.artist = cursor.getString(cursor
                            .getColumnIndex(MediaStore.Audio.Media.ARTIST));

                    HomeActivity.Songs.add(song);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
    }

}
