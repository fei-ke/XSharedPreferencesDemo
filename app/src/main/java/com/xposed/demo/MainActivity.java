package com.xposed.demo;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        setContentView(textView);
        try {
            getSharedPreferences("test", Context.MODE_WORLD_READABLE);
            textView.setText("worked");
        } catch (SecurityException e) {
            e.printStackTrace();
            textView.setText(e.getMessage());
        }
    }
}
