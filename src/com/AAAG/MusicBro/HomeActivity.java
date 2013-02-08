package com.AAAG.MusicBro;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;
import com.AAAG.MusicBro.Helper.SongDB;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeActivity extends Activity {

    public static List<SongDB> Songs = new ArrayList<SongDB>();
    public static int j=0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(ChoiceActivity.female)
            setContentView(R.layout.femalemain);
        else
            setContentView(R.layout.main);
        Button albumbutton = (Button)findViewById(R.id.Album);
        Button weatherbutton = (Button)findViewById(R.id.Weather);
        Button moodbutton = (Button)findViewById(R.id.Mood);
        Button noplayedbutton = (Button)findViewById(R.id.NoPlayed);
        Button ratingbutton = (Button)findViewById(R.id.Rating);
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
//        File f = new File("/sdcard/");
//        int j=0;
//        for (File file : f.listFiles())
//        {
//            if(file.getName().endsWith(".mp3"))
//            {
//                SongDB songinstance = new SongDB();
//                String [] name = file.getName().split(".mp3");
//                String actualname="";
//                for(int i=0;i<name.length;i++)
//                    actualname +=name[i]+" ";
//               songinstance.Name = actualname; j++;
//               songinstance.FilePath = file.getAbsolutePath();
//               mmr.setDataSource(String.valueOf(file.getAbsolutePath()));
//               songinstance.Album =  mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);
//               songinstance.Artist =  mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
//               songinstance.Genre =  mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_GENRE);
//            }
//        }
        weatherbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    GetWeather();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            startActivity(new Intent(HomeActivity.this, SplashActivity.class));
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }

    public void GetWeather()throws ClientProtocolException, IOException
    {
        HttpClient httpClient = new DefaultHttpClient();
        HttpContext localContext = new BasicHttpContext();
        HttpGet httpGet = new HttpGet("https://www.google.com/search?q=weather+chennai");
        HttpResponse response = httpClient.execute(httpGet, localContext);
        String result = "";

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        response.getEntity().getContent()
                )
        );

        String line = null;
        while ((line = reader.readLine()) != null){
            result += line + "\n";
        }
        final Pattern pattern = Pattern.compile("<span class=\"vk_gy vk_sh\" id=\"wob_dc\">(.+?)</span>");
        final Matcher matcher = pattern.matcher(result);
        matcher.find();
        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(this);
        helpBuilder.setTitle("Weather");
        helpBuilder.setMessage(matcher.group(1) + "is the Weather");
        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
    }

}
