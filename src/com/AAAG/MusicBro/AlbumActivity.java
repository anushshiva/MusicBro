package com.AAAG.MusicBro;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AlbumActivity extends Activity {

    ArrayAdapter<String> albums;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album);
        albums=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, HomeActivity.album);
        ListView albumlist=(ListView)findViewById(android.R.id.list);
        albumlist.setAdapter(albums);
        albums.notifyDataSetChanged();
    }
}
