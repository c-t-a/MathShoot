package com.example.mathshoot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LevelActivity extends AppCompatActivity {

    Boolean chk1Pass=false,chk2Pass=false,chk3Pass=false,chk4Pass=false,chk5Pass=false,chk6Pass=false,chk7Pass=false,chk8Pass=false,chk9Pass=false,chk10Pass=false;
    String chkGameType;
    SharedPreferences game;
    TextView GameModeText;
    Button level1Btn,level2Btn,level3Btn,level4Btn,level5Btn,level6Btn,level7Btn,level8Btn,level9Btn,level10Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide status bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getWindow().setBackgroundDrawableResource(R.drawable.background_white);
        setContentView(R.layout.activity_level);

        GameModeText = (TextView) findViewById(R.id.gameModeText);
        level1Btn = (Button) findViewById(R.id.level1);
        level2Btn = (Button) findViewById(R.id.level2);
        level3Btn = (Button) findViewById(R.id.level3);
        level4Btn = (Button) findViewById(R.id.level4);
        level5Btn = (Button) findViewById(R.id.level5);
        level6Btn = (Button) findViewById(R.id.level6);
        level7Btn = (Button) findViewById(R.id.level7);
        level8Btn = (Button) findViewById(R.id.level8);
        level9Btn = (Button) findViewById(R.id.level9);
        level10Btn = (Button) findViewById(R.id.level10);

        game = getSharedPreferences("GAME",MODE_PRIVATE);
        chkGameType = game.getString("TYPE",chkGameType);
        if(chkGameType == "easy"){
            GameModeText.setText("Game Mode : "+chkGameType);
            chk1Pass = game.getBoolean("EasyLevel1",chk1Pass);
            chk2Pass = game.getBoolean("EasyLevel2",chk2Pass);
            chk3Pass = game.getBoolean("EasyLevel3",chk3Pass);
            chk4Pass = game.getBoolean("EasyLevel4",chk4Pass);
            chk5Pass = game.getBoolean("EasyLevel5",chk5Pass);
            chk6Pass = game.getBoolean("EasyLevel6",chk6Pass);
            chk7Pass = game.getBoolean("EasyLevel7",chk7Pass);
            chk8Pass = game.getBoolean("EasyLevel8",chk8Pass);
            chk9Pass = game.getBoolean("EasyLevel9",chk9Pass);
            chk10Pass = game.getBoolean("EasyLevel10",chk10Pass);
            if(chk1Pass == true){
                level1Btn.setBackgroundResource(R.drawable.button_leveldisable);
            }else{
                level1Btn.setBackgroundResource(R.drawable.button_level);
            }
            if(chk2Pass == true){
                level2Btn.setBackgroundResource(R.drawable.button_leveldisable);
            }else{
                level2Btn.setBackgroundResource(R.drawable.button_level);
            }
            if(chk3Pass == true){
                level3Btn.setBackgroundResource(R.drawable.button_leveldisable);
            }else{
                level3Btn.setBackgroundResource(R.drawable.button_level);
            }
            if(chk4Pass == true){
                level4Btn.setBackgroundResource(R.drawable.button_leveldisable);
            }else{
                level4Btn.setBackgroundResource(R.drawable.button_level);
            }
            if(chk5Pass == true){
                level5Btn.setBackgroundResource(R.drawable.button_leveldisable);
            }else{
                level5Btn.setBackgroundResource(R.drawable.button_level);
            }
            if(chk6Pass == true){
                level6Btn.setBackgroundResource(R.drawable.button_leveldisable);
            }else{
                level6Btn.setBackgroundResource(R.drawable.button_level);
            }
            if(chk7Pass == true){
                level7Btn.setBackgroundResource(R.drawable.button_leveldisable);
            }else{
                level7Btn.setBackgroundResource(R.drawable.button_level);
            }
            if(chk8Pass == true){
                level8Btn.setBackgroundResource(R.drawable.button_leveldisable);
            }else{
                level8Btn.setBackgroundResource(R.drawable.button_level);
            }
            if(chk9Pass == true){
                level9Btn.setBackgroundResource(R.drawable.button_leveldisable);
            }else{
                level9Btn.setBackgroundResource(R.drawable.button_level);
            }
            if(chk10Pass == true){
                level10Btn.setBackgroundResource(R.drawable.button_leveldisable);
            }else{
                level10Btn.setBackgroundResource(R.drawable.button_level);
            }
        }else if(chkGameType == "hard"){
            GameModeText.setText("Game Mode : "+chkGameType);
            chk1Pass = game.getBoolean("HardLevel1",chk1Pass);
            chk2Pass = game.getBoolean("HardLevel2",chk2Pass);
            chk3Pass = game.getBoolean("HardLevel3",chk3Pass);
            chk4Pass = game.getBoolean("HardLevel4",chk4Pass);
            chk5Pass = game.getBoolean("HardLevel5",chk5Pass);
            chk6Pass = game.getBoolean("HardLevel6",chk6Pass);
            chk7Pass = game.getBoolean("HardLevel7",chk7Pass);
            chk8Pass = game.getBoolean("HardLevel8",chk8Pass);
            chk9Pass = game.getBoolean("HardLevel9",chk9Pass);
            chk10Pass = game.getBoolean("HardLevel10",chk10Pass);
            if(chk1Pass == true){
                level1Btn.setBackgroundResource(R.drawable.button_leveldisable);
            }else{
                level1Btn.setBackgroundResource(R.drawable.button_level);
            }
            if(chk2Pass == true){
                level2Btn.setBackgroundResource(R.drawable.button_leveldisable);
            }else{
                level2Btn.setBackgroundResource(R.drawable.button_level);
            }
            if(chk3Pass == true){
                level3Btn.setBackgroundResource(R.drawable.button_leveldisable);
            }else{
                level3Btn.setBackgroundResource(R.drawable.button_level);
            }
            if(chk4Pass == true){
                level4Btn.setBackgroundResource(R.drawable.button_leveldisable);
            }else{
                level4Btn.setBackgroundResource(R.drawable.button_level);
            }
            if(chk5Pass == true){
                level5Btn.setBackgroundResource(R.drawable.button_leveldisable);
            }else{
                level5Btn.setBackgroundResource(R.drawable.button_level);
            }
            if(chk6Pass == true){
                level6Btn.setBackgroundResource(R.drawable.button_leveldisable);
            }else{
                level6Btn.setBackgroundResource(R.drawable.button_level);
            }
            if(chk7Pass == true){
                level7Btn.setBackgroundResource(R.drawable.button_leveldisable);
            }else{
                level7Btn.setBackgroundResource(R.drawable.button_level);
            }
            if(chk8Pass == true){
                level8Btn.setBackgroundResource(R.drawable.button_leveldisable);
            }else{
                level8Btn.setBackgroundResource(R.drawable.button_level);
            }
            if(chk9Pass == true){
                level9Btn.setBackgroundResource(R.drawable.button_leveldisable);
            }else{
                level9Btn.setBackgroundResource(R.drawable.button_level);
            }
            if(chk10Pass == true){
                level10Btn.setBackgroundResource(R.drawable.button_leveldisable);
            }else{
                level10Btn.setBackgroundResource(R.drawable.button_level);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void Level1(View view){
        game.edit().putInt("LEVEL",1).apply();
        Intent myIntent = new Intent(this, GameActivity.class);
        startActivity(myIntent);
    }
    public void Level2(View view){
        game.edit().putInt("LEVEL",2).apply();
        Intent myIntent = new Intent(this, GameActivity.class);
        startActivity(myIntent);
    }
    public void Level3(View view){
        game.edit().putInt("LEVEL",3).apply();
        Intent myIntent = new Intent(this, GameActivity.class);
        startActivity(myIntent);
    }
    public void Level4(View view){
        game.edit().putInt("LEVEL",4).apply();
        Intent myIntent = new Intent(this, GameActivity.class);
        startActivity(myIntent);
    }
    public void Level5(View view){
        game.edit().putInt("LEVEL",5).apply();
        Intent myIntent = new Intent(this, GameActivity.class);
        startActivity(myIntent);
    }
    public void Level6(View view){
        game.edit().putInt("LEVEL",6).apply();
        Intent myIntent = new Intent(this, GameActivity.class);
        startActivity(myIntent);
    }
    public void Level7(View view){
        game.edit().putInt("LEVEL",7).apply();
        Intent myIntent = new Intent(this, GameActivity.class);
        startActivity(myIntent);
    }
    public void Level8(View view){
        game.edit().putInt("LEVEL",8).apply();
        Intent myIntent = new Intent(this, GameActivity.class);
        startActivity(myIntent);
    }
    public void Level9(View view){
        game.edit().putInt("LEVEL",9).apply();
        Intent myIntent = new Intent(this, GameActivity.class);
        startActivity(myIntent);
    }
    public void Level10(View view){
        game.edit().putInt("LEVEL",10).apply();
        Intent myIntent = new Intent(this, GameActivity.class);
        startActivity(myIntent);
    }
    public void GoBack(View view){
        Intent myIntent = new Intent(this,MainActivity.class);
        startActivity(myIntent);
    }
    //Disable back button
    @Override
    public void onBackPressed() {
        // super.onBackPressed(); commented this line in order to disable back press
        //Write your code here
//        Toast.makeText(getApplicationContext(), "Back press disabled!", Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            super.onKeyDown(keyCode, event);
            return true;
        }
        return false;
    }
}
