package com.example.doan_nhom5;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    TextView txtWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.up_to_down);
        txtWelcome = (TextView) findViewById(R.id.txtWelcome);
        txtWelcome.setAnimation(animation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Welcome.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },6000);
    }


}
