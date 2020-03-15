package com.example.mathshoot;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {

    AlertDialog description;
    String chkGameType,chkMusic;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide status bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getWindow().setBackgroundDrawableResource(R.drawable.background_white);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences("GAME",MODE_PRIVATE);
        chkGameType = preferences.getString("TYPE",chkGameType);
        chkMusic = preferences.getString("MUSIC",chkMusic);
        if(chkGameType == null){
            chkGameType = "easy";
            preferences.edit().putString("TYPE",chkGameType).apply();
        }
        if(chkMusic == null){
            chkMusic = "ON";
            preferences.edit().putString("MUSIC",chkMusic).apply();
        }
    }
    public void GoLevel(View view){
        Intent myIntent = new Intent(this,LevelActivity.class);
        startActivity(myIntent);
    }
    public void GoSetting(View view){
        Intent myIntent = new Intent(this,SettingActivity.class);
        startActivity(myIntent);
    }
    public void ShowDescription(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setView(R.layout.activity_description);
        description = builder.create();
        description.show();
    }
    //Disable back button
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            super.onKeyDown(keyCode, event);
            return true;
        }
        return false;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
