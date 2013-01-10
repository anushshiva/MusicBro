package com.AAAG.MusicBro;

import android.app.Activity;
import android.os.Bundle;

public class HomeActivity extends Activity {

//    @InjectView(R.id.Album)
//    Button albumbutton;
//
//    public List<String> songname = new ArrayList<String>();
//    public List<String> album = new ArrayList<String>();
//    public List<String> artist = new ArrayList<String>();
//    public List<String> genre = new ArrayList<String>();
//    public List<String> filepath = new ArrayList<String>();
//    public List<Integer> rating = new ArrayList<Integer>();
//    public List<Integer> noplayed = new ArrayList<Integer>();
//    public int i=0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
//        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
//        File f = new File("/sdcard/");
//        int j=0;
//        for (File file : f.listFiles())
//        {
//            if(file.getName().endsWith(".mp3"))
//            {
//                String [] name = file.getName().split(".mp3");
//                String actualname="";
//                for(i=0;i<name.length;i++)
//                    actualname +=name[i]+" ";
//                songname.add(actualname);
//                filepath.add(file.getAbsolutePath());
//                mmr.setDataSource(String.valueOf(filepath));
//                album.add(mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM));
//                artist.add(mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST));
//                genre.add(mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_GENRE));
//            }
//        }
//        albumbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(HomeActivity.this, AlbumActivity.class));
//            }
//        });
    }
}
