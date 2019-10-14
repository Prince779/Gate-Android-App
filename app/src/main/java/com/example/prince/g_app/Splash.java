package com.example.prince.g_app;

import android.content.Intent;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Splash extends AppCompatActivity implements Animation.AnimationListener {
    TextView no;
    Animation move;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        no=(TextView)findViewById(R.id.no);
        move = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        move.setAnimationListener(this);
        no.startAnimation(move);



    }
    boolean h=new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            Intent i=new Intent(Splash.this,Main_Window.class);
            startActivity(i);
            finish();
        }
    },4000);

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
