package com.AAAG.MusicBro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

public class FHomeActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.femalemain);

        }
    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            startActivity(new Intent(FHomeActivity.this, ChoiceActivity.class));
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
}
