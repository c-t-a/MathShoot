package com.example.mathshoot;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;

public class GameActivity extends AppCompatActivity {

    boolean chkCorrect = false;
    String chkGameType,chkMusic;
    int chkGameLevel,gameScore,gameTime,startGameTime;
    SharedPreferences game;
    // Basketball Images Array
    Integer[] basketballImageArray = new Integer[]{
            R.drawable.basketball_yellow,
            R.drawable.basketball_purple,
            R.drawable.basketball_blue,
            R.drawable.basketball_origin
    };
    RelativeLayoutandImageViews [] rlivsArray;
    private MediaPlayer mp;

    AlertDialog dialog;
    RelativeLayout targetRLayout,ballRLayout1,ballRLayout2,ballRLayout3,ballRLayout4;
    ImageView ballImage1,ballImage2,ballImage3,ballImage4,dialogImage;
    TextView timer,question,ballText1,ballText2,ballText3,ballText4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide status bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getWindow().setBackgroundDrawableResource(R.drawable.background_white);
        setContentView(R.layout.activity_game);

        // Image View
        ballImage1 = (ImageView) findViewById(R.id.ballImage1);
        ballImage2 = (ImageView) findViewById(R.id.ballImage2);
        ballImage3 = (ImageView) findViewById(R.id.ballImage3);
        ballImage4 = (ImageView) findViewById(R.id.ballImage4);
        Collections.shuffle(Arrays.asList((basketballImageArray)));//Shuffle basketaball image
        ballImage1.setImageResource(basketballImageArray[0]);
        ballImage2.setImageResource(basketballImageArray[1]);
        ballImage3.setImageResource(basketballImageArray[2]);
        ballImage4.setImageResource(basketballImageArray[3]);

        // Relative Layout
        targetRLayout = (RelativeLayout) findViewById(R.id.targetRLayout);
        ballRLayout1 = (RelativeLayout) findViewById(R.id.ballRLayout1);
        ballRLayout2 = (RelativeLayout) findViewById(R.id.ballRLayout2);
        ballRLayout3 = (RelativeLayout) findViewById(R.id.ballRLayout3);
        ballRLayout4 = (RelativeLayout) findViewById(R.id.ballRLayout4);

        // Text View
        timer = (TextView) findViewById(R.id.timer);
        question = (TextView) findViewById(R.id.question);
        ballText1 = (TextView) findViewById(R.id.ballText1);
        ballText2 = (TextView) findViewById(R.id.ballText2);
        ballText3 = (TextView) findViewById(R.id.ballText3);
        ballText4 = (TextView) findViewById(R.id.ballText4);

        RelativeLayoutandImageViews rlivs1 = new RelativeLayoutandImageViews(ballRLayout1,ballText1);
        RelativeLayoutandImageViews rlivs2 = new RelativeLayoutandImageViews(ballRLayout2,ballText2);
        RelativeLayoutandImageViews rlivs3 = new RelativeLayoutandImageViews(ballRLayout3,ballText3);
        RelativeLayoutandImageViews rlivs4 = new RelativeLayoutandImageViews(ballRLayout4,ballText4);
        rlivsArray = new RelativeLayoutandImageViews[]{
                rlivs1,rlivs2,rlivs3,rlivs4
        };
        Collections.shuffle(Arrays.asList(rlivsArray));//Shuffle relative layout of rnts array

        //get game type and level
        game = getSharedPreferences("GAME", MODE_PRIVATE);
        chkGameType = game.getString("TYPE",chkGameType);
        chkGameLevel = game.getInt("LEVEL", chkGameLevel);

        if(chkGameType == "easy"){
            // For easy game mode
            gameTime = 20000;
            startGameTime = 15;
            if(chkGameLevel == 1){
                Questions q = new Questions("pi Value(π)?","3.14","5.6","2.89","7.77");
                question.setText(q.getQuestion());
                targetRLayout.setTag(q.getRightAnswer());
                rlivsArray[0].getRelativeLayout().setTag(q.getRightAnswer());
                rlivsArray[0].getTextView().setText(q.getRightAnswer());
                rlivsArray[1].getRelativeLayout().setTag(q.getWrongAnswer1());
                rlivsArray[1].getTextView().setText(q.getWrongAnswer1());
                rlivsArray[2].getRelativeLayout().setTag(q.getWrongAnswer2());
                rlivsArray[2].getTextView().setText(q.getWrongAnswer2());
                rlivsArray[3].getRelativeLayout().setTag(q.getWrongAnswer3());
                rlivsArray[3].getTextView().setText(q.getWrongAnswer3());
            }else if(chkGameLevel == 2){
                Questions q = new Questions("300 - 199?","101","122","100","123");
                question.setText(q.getQuestion());
                targetRLayout.setTag(q.getRightAnswer());
                rlivsArray[0].getRelativeLayout().setTag(q.getRightAnswer());
                rlivsArray[0].getTextView().setText(q.getRightAnswer());
                rlivsArray[1].getRelativeLayout().setTag(q.getWrongAnswer1());
                rlivsArray[1].getTextView().setText(q.getWrongAnswer1());
                rlivsArray[2].getRelativeLayout().setTag(q.getWrongAnswer2());
                rlivsArray[2].getTextView().setText(q.getWrongAnswer2());
                rlivsArray[3].getRelativeLayout().setTag(q.getWrongAnswer3());
                rlivsArray[3].getTextView().setText(q.getWrongAnswer3());
            }else if (chkGameLevel == 3){
                Questions q = new Questions("$60.00 is equal to?","$60","$50","$70","$40");
                question.setText(q.getQuestion());
                targetRLayout.setTag(q.getRightAnswer());
                rlivsArray[0].getRelativeLayout().setTag(q.getRightAnswer());
                rlivsArray[0].getTextView().setText(q.getRightAnswer());
                rlivsArray[1].getRelativeLayout().setTag(q.getWrongAnswer1());
                rlivsArray[1].getTextView().setText(q.getWrongAnswer1());
                rlivsArray[2].getRelativeLayout().setTag(q.getWrongAnswer2());
                rlivsArray[2].getTextView().setText(q.getWrongAnswer2());
                rlivsArray[3].getRelativeLayout().setTag(q.getWrongAnswer3());
                rlivsArray[3].getTextView().setText(q.getWrongAnswer3());
            }else if (chkGameLevel == 4){
                Questions q = new Questions("67 + 73?","140","126","138","159");
                question.setText(q.getQuestion());
                targetRLayout.setTag(q.getRightAnswer());
                rlivsArray[0].getRelativeLayout().setTag(q.getRightAnswer());
                rlivsArray[0].getTextView().setText(q.getRightAnswer());
                rlivsArray[1].getRelativeLayout().setTag(q.getWrongAnswer1());
                rlivsArray[1].getTextView().setText(q.getWrongAnswer1());
                rlivsArray[2].getRelativeLayout().setTag(q.getWrongAnswer2());
                rlivsArray[2].getTextView().setText(q.getWrongAnswer2());
                rlivsArray[3].getRelativeLayout().setTag(q.getWrongAnswer3());
                rlivsArray[3].getTextView().setText(q.getWrongAnswer3());
            }else if (chkGameLevel == 5){
                Questions q = new Questions("6.75 + 2(3.85)","14.45","10.6","12.95","16");
                question.setText(q.getQuestion());
                targetRLayout.setTag(q.getRightAnswer());
                rlivsArray[0].getRelativeLayout().setTag(q.getRightAnswer());
                rlivsArray[0].getTextView().setText(q.getRightAnswer());
                rlivsArray[1].getRelativeLayout().setTag(q.getWrongAnswer1());
                rlivsArray[1].getTextView().setText(q.getWrongAnswer1());
                rlivsArray[2].getRelativeLayout().setTag(q.getWrongAnswer2());
                rlivsArray[2].getTextView().setText(q.getWrongAnswer2());
                rlivsArray[3].getRelativeLayout().setTag(q.getWrongAnswer3());
                rlivsArray[3].getTextView().setText(q.getWrongAnswer3());
            }else if (chkGameLevel == 6){
                Questions q = new Questions("2000 Pounds?","1 ton","0.5 ton","2 ton","3 ton");
                question.setText(q.getQuestion());
                targetRLayout.setTag(q.getRightAnswer());
                rlivsArray[0].getRelativeLayout().setTag(q.getRightAnswer());
                rlivsArray[0].getTextView().setText(q.getRightAnswer());
                rlivsArray[1].getRelativeLayout().setTag(q.getWrongAnswer1());
                rlivsArray[1].getTextView().setText(q.getWrongAnswer1());
                rlivsArray[2].getRelativeLayout().setTag(q.getWrongAnswer2());
                rlivsArray[2].getTextView().setText(q.getWrongAnswer2());
                rlivsArray[3].getRelativeLayout().setTag(q.getWrongAnswer3());
                rlivsArray[3].getTextView().setText(q.getWrongAnswer3());
            }else if (chkGameLevel == 7){
                Questions q = new Questions("25 x 50%","12.5","20","25","22.5");
                question.setText(q.getQuestion());
                targetRLayout.setTag(q.getRightAnswer());
                rlivsArray[0].getRelativeLayout().setTag(q.getRightAnswer());
                rlivsArray[0].getTextView().setText(q.getRightAnswer());
                rlivsArray[1].getRelativeLayout().setTag(q.getWrongAnswer1());
                rlivsArray[1].getTextView().setText(q.getWrongAnswer1());
                rlivsArray[2].getRelativeLayout().setTag(q.getWrongAnswer2());
                rlivsArray[2].getTextView().setText(q.getWrongAnswer2());
                rlivsArray[3].getRelativeLayout().setTag(q.getWrongAnswer3());
                rlivsArray[3].getTextView().setText(q.getWrongAnswer3());
            }else if (chkGameLevel == 8){
                Questions q = new Questions("10 x 1,000?","10,000","5000","1,000","100");
                question.setText(q.getQuestion());
                targetRLayout.setTag(q.getRightAnswer());
                rlivsArray[0].getRelativeLayout().setTag(q.getRightAnswer());
                rlivsArray[0].getTextView().setText(q.getRightAnswer());
                rlivsArray[1].getRelativeLayout().setTag(q.getWrongAnswer1());
                rlivsArray[1].getTextView().setText(q.getWrongAnswer1());
                rlivsArray[2].getRelativeLayout().setTag(q.getWrongAnswer2());
                rlivsArray[2].getTextView().setText(q.getWrongAnswer2());
                rlivsArray[3].getRelativeLayout().setTag(q.getWrongAnswer3());
                rlivsArray[3].getTextView().setText(q.getWrongAnswer3());
            }else if (chkGameLevel == 9){
                Questions q = new Questions("1 + 1?","2","1","11","None");
                question.setText(q.getQuestion());
                targetRLayout.setTag(q.getRightAnswer());
                rlivsArray[0].getRelativeLayout().setTag(q.getRightAnswer());
                rlivsArray[0].getTextView().setText(q.getRightAnswer());
                rlivsArray[1].getRelativeLayout().setTag(q.getWrongAnswer1());
                rlivsArray[1].getTextView().setText(q.getWrongAnswer1());
                rlivsArray[2].getRelativeLayout().setTag(q.getWrongAnswer2());
                rlivsArray[2].getTextView().setText(q.getWrongAnswer2());
                rlivsArray[3].getRelativeLayout().setTag(q.getWrongAnswer3());
                rlivsArray[3].getTextView().setText(q.getWrongAnswer3());
            }else if (chkGameLevel == 10){
                Questions q = new Questions("3+2*4-2/2?","10","9","4.5","5");
                question.setText(q.getQuestion());
                targetRLayout.setTag(q.getRightAnswer());
                rlivsArray[0].getRelativeLayout().setTag(q.getRightAnswer());
                rlivsArray[0].getTextView().setText(q.getRightAnswer());
                rlivsArray[1].getRelativeLayout().setTag(q.getWrongAnswer1());
                rlivsArray[1].getTextView().setText(q.getWrongAnswer1());
                rlivsArray[2].getRelativeLayout().setTag(q.getWrongAnswer2());
                rlivsArray[2].getTextView().setText(q.getWrongAnswer2());
                rlivsArray[3].getRelativeLayout().setTag(q.getWrongAnswer3());
                rlivsArray[3].getTextView().setText(q.getWrongAnswer3());
            }
        }else if(chkGameType == "hard"){
            gameTime = 10000;
            startGameTime = 5;
            //For hard game mode
            if(chkGameLevel == 1){
                Questions q = new Questions("Square root of 121?","11","121","10","9");
                question.setText(q.getQuestion());
                targetRLayout.setTag(q.getRightAnswer());
                rlivsArray[0].getRelativeLayout().setTag(q.getRightAnswer());
                rlivsArray[0].getTextView().setText(q.getRightAnswer());
                rlivsArray[1].getRelativeLayout().setTag(q.getWrongAnswer1());
                rlivsArray[1].getTextView().setText(q.getWrongAnswer1());
                rlivsArray[2].getRelativeLayout().setTag(q.getWrongAnswer2());
                rlivsArray[2].getTextView().setText(q.getWrongAnswer2());
                rlivsArray[3].getRelativeLayout().setTag(q.getWrongAnswer3());
                rlivsArray[3].getTextView().setText(q.getWrongAnswer3());
            }else if(chkGameLevel == 2){
                Questions q = new Questions("35+486+0.9=?","521.9","5219","52.19","510.9");
                question.setText(q.getQuestion());
                targetRLayout.setTag(q.getRightAnswer());
                rlivsArray[0].getRelativeLayout().setTag(q.getRightAnswer());
                rlivsArray[0].getTextView().setText(q.getRightAnswer());
                rlivsArray[1].getRelativeLayout().setTag(q.getWrongAnswer1());
                rlivsArray[1].getTextView().setText(q.getWrongAnswer1());
                rlivsArray[2].getRelativeLayout().setTag(q.getWrongAnswer2());
                rlivsArray[2].getTextView().setText(q.getWrongAnswer2());
                rlivsArray[3].getRelativeLayout().setTag(q.getWrongAnswer3());
                rlivsArray[3].getTextView().setText(q.getWrongAnswer3());
            }else if (chkGameLevel == 3){
                Questions q = new Questions("99/5?","19.55","94","104","19.8");
                question.setText(q.getQuestion());
                targetRLayout.setTag(q.getRightAnswer());
                rlivsArray[0].getRelativeLayout().setTag(q.getRightAnswer());
                rlivsArray[0].getTextView().setText(q.getRightAnswer());
                rlivsArray[1].getRelativeLayout().setTag(q.getWrongAnswer1());
                rlivsArray[1].getTextView().setText(q.getWrongAnswer1());
                rlivsArray[2].getRelativeLayout().setTag(q.getWrongAnswer2());
                rlivsArray[2].getTextView().setText(q.getWrongAnswer2());
                rlivsArray[3].getRelativeLayout().setTag(q.getWrongAnswer3());
                rlivsArray[3].getTextView().setText(q.getWrongAnswer3());
            }else if (chkGameLevel == 4){
                Questions q = new Questions("987-389","598","600","597","599");
                question.setText(q.getQuestion());
                targetRLayout.setTag(q.getRightAnswer());
                rlivsArray[0].getRelativeLayout().setTag(q.getRightAnswer());
                rlivsArray[0].getTextView().setText(q.getRightAnswer());
                rlivsArray[1].getRelativeLayout().setTag(q.getWrongAnswer1());
                rlivsArray[1].getTextView().setText(q.getWrongAnswer1());
                rlivsArray[2].getRelativeLayout().setTag(q.getWrongAnswer2());
                rlivsArray[2].getTextView().setText(q.getWrongAnswer2());
                rlivsArray[3].getRelativeLayout().setTag(q.getWrongAnswer3());
                rlivsArray[3].getTextView().setText(q.getWrongAnswer3());
            }else if (chkGameLevel == 5){
                Questions q = new Questions("679/0.5","1358","2716","1458","None");
                question.setText(q.getQuestion());
                targetRLayout.setTag(q.getRightAnswer());
                rlivsArray[0].getRelativeLayout().setTag(q.getRightAnswer());
                rlivsArray[0].getTextView().setText(q.getRightAnswer());
                rlivsArray[1].getRelativeLayout().setTag(q.getWrongAnswer1());
                rlivsArray[1].getTextView().setText(q.getWrongAnswer1());
                rlivsArray[2].getRelativeLayout().setTag(q.getWrongAnswer2());
                rlivsArray[2].getTextView().setText(q.getWrongAnswer2());
                rlivsArray[3].getRelativeLayout().setTag(q.getWrongAnswer3());
                rlivsArray[3].getTextView().setText(q.getWrongAnswer3());
            }else if (chkGameLevel == 6){
                Questions q = new Questions("255/5","51","31","41","21");
                question.setText(q.getQuestion());
                targetRLayout.setTag(q.getRightAnswer());
                rlivsArray[0].getRelativeLayout().setTag(q.getRightAnswer());
                rlivsArray[0].getTextView().setText(q.getRightAnswer());
                rlivsArray[1].getRelativeLayout().setTag(q.getWrongAnswer1());
                rlivsArray[1].getTextView().setText(q.getWrongAnswer1());
                rlivsArray[2].getRelativeLayout().setTag(q.getWrongAnswer2());
                rlivsArray[2].getTextView().setText(q.getWrongAnswer2());
                rlivsArray[3].getRelativeLayout().setTag(q.getWrongAnswer3());
                rlivsArray[3].getTextView().setText(q.getWrongAnswer3());
            }else if (chkGameLevel == 7){
                Questions q = new Questions("8*52","416","400","320","396");
                question.setText(q.getQuestion());
                targetRLayout.setTag(q.getRightAnswer());
                rlivsArray[0].getRelativeLayout().setTag(q.getRightAnswer());
                rlivsArray[0].getTextView().setText(q.getRightAnswer());
                rlivsArray[1].getRelativeLayout().setTag(q.getWrongAnswer1());
                rlivsArray[1].getTextView().setText(q.getWrongAnswer1());
                rlivsArray[2].getRelativeLayout().setTag(q.getWrongAnswer2());
                rlivsArray[2].getTextView().setText(q.getWrongAnswer2());
                rlivsArray[3].getRelativeLayout().setTag(q.getWrongAnswer3());
                rlivsArray[3].getTextView().setText(q.getWrongAnswer3());
            }else if (chkGameLevel == 8){
                Questions q = new Questions("89-569","-480","-470","480","470");
                question.setText(q.getQuestion());
                targetRLayout.setTag(q.getRightAnswer());
                rlivsArray[0].getRelativeLayout().setTag(q.getRightAnswer());
                rlivsArray[0].getTextView().setText(q.getRightAnswer());
                rlivsArray[1].getRelativeLayout().setTag(q.getWrongAnswer1());
                rlivsArray[1].getTextView().setText(q.getWrongAnswer1());
                rlivsArray[2].getRelativeLayout().setTag(q.getWrongAnswer2());
                rlivsArray[2].getTextView().setText(q.getWrongAnswer2());
                rlivsArray[3].getRelativeLayout().setTag(q.getWrongAnswer3());
                rlivsArray[3].getTextView().setText(q.getWrongAnswer3());
            }else if (chkGameLevel == 9){
                Questions q = new Questions("20% of 2 equal to?","0.4","0.04","4","20");
                question.setText(q.getQuestion());
                targetRLayout.setTag(q.getRightAnswer());
                rlivsArray[0].getRelativeLayout().setTag(q.getRightAnswer());
                rlivsArray[0].getTextView().setText(q.getRightAnswer());
                rlivsArray[1].getRelativeLayout().setTag(q.getWrongAnswer1());
                rlivsArray[1].getTextView().setText(q.getWrongAnswer1());
                rlivsArray[2].getRelativeLayout().setTag(q.getWrongAnswer2());
                rlivsArray[2].getTextView().setText(q.getWrongAnswer2());
                rlivsArray[3].getRelativeLayout().setTag(q.getWrongAnswer3());
                rlivsArray[3].getTextView().setText(q.getWrongAnswer3());
            }else if (chkGameLevel == 10){
                Questions q = new Questions("sin θ","1/csc θ","1/sec θ","1/cos θ","1/tan θ");
                question.setText(q.getQuestion());
                targetRLayout.setTag(q.getRightAnswer());
                rlivsArray[0].getRelativeLayout().setTag(q.getRightAnswer());
                rlivsArray[0].getTextView().setText(q.getRightAnswer());
                rlivsArray[1].getRelativeLayout().setTag(q.getWrongAnswer1());
                rlivsArray[1].getTextView().setText(q.getWrongAnswer1());
                rlivsArray[2].getRelativeLayout().setTag(q.getWrongAnswer2());
                rlivsArray[2].getTextView().setText(q.getWrongAnswer2());
                rlivsArray[3].getRelativeLayout().setTag(q.getWrongAnswer3());
                rlivsArray[3].getTextView().setText(q.getWrongAnswer3());
            }
        }
        //Set game timer
        chkMusic = game.getString("MUSIC",chkMusic);

        new CountDownTimer(gameTime,1000){
            public void onTick(long millisUntilFinished){
                if(millisUntilFinished/1000<startGameTime){
                    timer.setText(""+millisUntilFinished/1000);
                    if(chkMusic == "ON"){
                        mp = MediaPlayer.create(GameActivity.this,R.raw.coach_whistle);
                        mp.start();
                    }
                    // Set On touch listener on each basketball
                    rlivsArray[0].getRelativeLayout().setOnTouchListener(new ChoiceTouchListener());
                    rlivsArray[1].getRelativeLayout().setOnTouchListener(new ChoiceTouchListener());
                    rlivsArray[2].getRelativeLayout().setOnTouchListener(new ChoiceTouchListener());
                    rlivsArray[3].getRelativeLayout().setOnTouchListener(new ChoiceTouchListener());
                    // Set on drag listener on target
                    targetRLayout.setOnDragListener(new ChoiceDragListener());
                }
                if(millisUntilFinished/1000<startGameTime-1){
                    mp.stop();
                    stopPlaying();
                }
                if(chkGameType=="hard"){
                    if(millisUntilFinished/1000<startGameTime){
                        rlivsArray[0].getTextView().setVisibility(View.INVISIBLE);
                        rlivsArray[1].getTextView().setVisibility(View.INVISIBLE);
                        rlivsArray[2].getTextView().setVisibility(View.INVISIBLE);
                        rlivsArray[3].getTextView().setVisibility(View.INVISIBLE);
                    }
                }else{
                    if(millisUntilFinished/1000<startGameTime-5){
                        rlivsArray[0].getTextView().setVisibility(View.INVISIBLE);
                        rlivsArray[1].getTextView().setVisibility(View.INVISIBLE);
                        rlivsArray[2].getTextView().setVisibility(View.INVISIBLE);
                        rlivsArray[3].getTextView().setVisibility(View.INVISIBLE);
                    }
                }
            }
            public void onFinish(){
                //Lose Dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
                builder.setView(R.layout.activity_dialog);
                dialog = builder.create();
                dialog.show();
                dialog.setCancelable(false);
                dialogImage = dialog.findViewById(R.id.imageDialog);
                dialogImage.setImageResource(R.drawable.game_lose);
                MediaPlayer mpLose = MediaPlayer.create(GameActivity.this,R.raw.game_lose);
            }
        }.start();
    }
    private void stopPlaying(){
        if(mp!=null){
            mp.stop();
            mp.release();
            mp = null;
        }
    }
    // For touch
    public class ChoiceTouchListener implements View.OnTouchListener{
        @Override
        public boolean onTouch(View view, MotionEvent event){
            if(event.getAction()==MotionEvent.ACTION_DOWN && ((RelativeLayout)view).getDrawableState()!=null){
                ClipData data = ClipData.newPlainText("","");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data,shadowBuilder,view,0);
                return true;
            }else{
                return false;
            }
        }
    }
    // For drag
    private class ChoiceDragListener implements View.OnDragListener{
        @Override
        public boolean onDrag(View view, DragEvent event){
            RelativeLayout targetLayout = (RelativeLayout) view;
            RelativeLayout choiceLayout = (RelativeLayout) event.getLocalState();
            String target = (String) targetLayout.getTag();
            String choice = (String) choiceLayout.getTag();
            switch (event.getAction()){
                case DragEvent.ACTION_DRAG_STARTED:
                    choiceLayout.setVisibility(View.INVISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:

                    if(target.equals(choice)){
                        if(chkMusic == "ON"){
                            stopPlaying();
                            mp = MediaPlayer.create(GameActivity.this,R.raw.game_win);
                            mp.start();
                        }
                        choiceLayout.setVisibility(View.INVISIBLE);
                        chkCorrect = true;
//                        gameScore = game.getInt("point",gameScore);
//                        gameScore = gameScore +10;
//                        game.edit().putInt("point",gameScore).apply();
                    }else{
                        if(chkMusic == "ON"){
                            stopPlaying();
                            mp = MediaPlayer.create(GameActivity.this,R.raw.game_lose);
                            mp.start();
                        }
                    }
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
                    builder.setView(R.layout.activity_dialog);
                    dialog = builder.create();
                    dialog.show();
                    dialog.setCancelable(false);
                    if(chkCorrect == true){
                        choiceLayout.setVisibility(View.INVISIBLE);
                        dialogImage = dialog.findViewById(R.id.imageDialog);
                        dialogImage.setImageResource(R.drawable.game_win);
                        if(chkGameType == "easy"){
                            if(chkGameLevel == 1){
                                game.edit().putBoolean("EasyLevel1",chkCorrect).apply();
                            }else if(chkGameLevel == 2){
                                game.edit().putBoolean("EasyLevel2",chkCorrect).apply();
                            }else if(chkGameLevel == 3){
                                game.edit().putBoolean("EasyLevel3",chkCorrect).apply();
                            }else if(chkGameLevel == 4){
                                game.edit().putBoolean("EasyLevel4",chkCorrect).apply();
                            }else if(chkGameLevel == 5){
                                game.edit().putBoolean("EasyLevel5",chkCorrect).apply();
                            }else if(chkGameLevel == 6){
                                game.edit().putBoolean("EasyLevel6",chkCorrect).apply();
                            }else if(chkGameLevel == 7){
                                game.edit().putBoolean("EasyLevel7",chkCorrect).apply();
                            }else if(chkGameLevel == 8){
                                game.edit().putBoolean("EasyLevel8",chkCorrect).apply();
                            }else if(chkGameLevel == 9){
                                game.edit().putBoolean("EasyLevel9",chkCorrect).apply();
                            }else if(chkGameLevel == 10){
                                game.edit().putBoolean("EasyLevel10",chkCorrect).apply();
                            }
                        }else if(chkGameType == "hard"){
                            if(chkGameLevel == 1){
                                game.edit().putBoolean("HardLevel1",chkCorrect).apply();
                            }else if(chkGameLevel == 2){
                                game.edit().putBoolean("HardLevel2",chkCorrect).apply();
                            }else if(chkGameLevel == 3){
                                game.edit().putBoolean("HardLevel3",chkCorrect).apply();
                            }else if(chkGameLevel == 4){
                                game.edit().putBoolean("HardLevel4",chkCorrect).apply();
                            }else if(chkGameLevel == 5){
                                game.edit().putBoolean("HardLevel5",chkCorrect).apply();
                            }else if(chkGameLevel == 6){
                                game.edit().putBoolean("HardLevel6",chkCorrect).apply();
                            }else if(chkGameLevel == 7){
                                game.edit().putBoolean("HardLevel7",chkCorrect).apply();
                            }else if(chkGameLevel == 8){
                                game.edit().putBoolean("HardLevel8",chkCorrect).apply();
                            }else if(chkGameLevel == 9){
                                game.edit().putBoolean("HardLevel9",chkCorrect).apply();
                            }else if(chkGameLevel == 10){
                                game.edit().putBoolean("HardLevel10",chkCorrect).apply();
                            }
                        }
                    }
                    if(chkCorrect == false){
                        choiceLayout.setVisibility(View.VISIBLE);
                        dialogImage = dialog.findViewById(R.id.imageDialog);
                        dialogImage.setImageResource(R.drawable.game_lose);
                    }
                    break;
            }
            return true;
        }
    }
    public void GoLevel(View view){
        Intent myIntent = new Intent(this,LevelActivity.class);
        startActivity(myIntent);
    }
    @Override
    protected void onStart() {
        super.onStart();
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
