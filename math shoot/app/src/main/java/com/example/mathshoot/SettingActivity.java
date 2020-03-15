package com.example.mathshoot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

public class SettingActivity extends AppCompatActivity {

    String type,chkType,music,chkMusic;
    int radioID;
    RadioGroup radioGroup;
    RadioButton radioButton,radioEasy,radioHard;
    Switch soundSwitch;
    SharedPreferences gameType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide status bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getWindow().setBackgroundDrawableResource(R.drawable.background_white);
        setContentView(R.layout.activity_setting);

        soundSwitch = (Switch) findViewById(R.id.switchSound);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioID = radioGroup.getCheckedRadioButtonId();
        radioButton =(RadioButton) findViewById(radioID);
        radioEasy = (RadioButton) findViewById(R.id.radioEasy);
        radioHard = (RadioButton) findViewById(R.id.radioHard);

        gameType = getSharedPreferences("GAME",MODE_PRIVATE);
        chkMusic = gameType.getString("MUSIC",chkMusic);
        if(chkMusic == "ON"){
            soundSwitch.setChecked(true);
        }else{
            soundSwitch.setChecked(false);
        }

        soundSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    music = "ON";
                    gameType.edit().putString("MUSIC",music).apply();
                }else{
                    music = "OFF";
                    gameType.edit().putString("MUSIC",music).apply();
                }
            }
        });


        chkType = gameType.getString("TYPE",chkType);

        if(chkType == "easy"){
            radioEasy.setChecked(true);
        }else if(chkType == "hard"){
            radioHard.setChecked(true);
        }
    }
    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();
        System.out.println("THE radio is "+checked);
        switch (view.getId()){
            case R.id.radioEasy:
                if(checked){
                    type = "easy";
                }
                break;
            case R.id.radioHard:
                if(checked){
                    type = "hard";
                }
                break;
        }
        gameType.edit().putString("TYPE",type).apply();

    }
    public void Exit(View view){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    public void Menu(View view){
        Intent myIntent = new Intent(this,MainActivity.class);
        startActivity(myIntent);
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
