package com.AAAG.MusicBro;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class ChoiceActivity extends Activity {

    public static boolean chosen;
    public static boolean female;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice);
        Button malebutton;
        malebutton = (Button) findViewById(R.id.male);
        Button femalebutton;
        femalebutton = (Button) findViewById(R.id.female);
        if(malebutton!=null)
        malebutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               chosen = true;
               female = false;
               SharedPreferences settings = getSharedPreferences("MyPrefs",0);
               SharedPreferences.Editor editor = settings.edit();
               editor.putBoolean("chosen", chosen);
               editor.putBoolean("female",female);
               editor.commit();
                startActivity(new Intent(ChoiceActivity.this, HomeActivity.class));
           }
        });
        femalebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                female = true;
                chosen = true;
                SharedPreferences settings = getSharedPreferences("MyPrefs",0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean("chosen", chosen);
                editor.putBoolean("female",female);
                editor.commit();
                startActivity(new Intent(ChoiceActivity.this, HomeActivity.class));
            }
        });
    }
}
