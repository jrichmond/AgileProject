package com.tetchykitten.hellotab;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class AlbumsActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TextView textview = new TextView(this);
        textview.setText("This is the Albums tab");
        setContentView(textview);
        
    }
}
