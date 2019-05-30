package com.example.doan_nhom5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class FirstLoadingActivity extends AppCompatActivity {
    ProgressBar progressBar;
    TextView textView;
    ImageView img_mienbac,img_mientrung,img_miennam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);
        setEvent();
        //setControl();
    }

    public void setEvent(){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
            progressBar = findViewById(R.id.progress_bar);
            textView = findViewById(R.id.text_view);
            progressBar.setMax(100);
            progressBar.setScaleY(3f);



            progressAnimation();


        }

    public void setControl(){
          img_mienbac = (ImageView) findViewById(R.id.img_MienBac);
          img_mientrung =(ImageView) findViewById(R.id.img_MienTrung);
          img_miennam =(ImageView) findViewById(R.id.img_MienNam);
    }
    public void progressAnimation(){
        ProgressBarAnimationNorth anim = new ProgressBarAnimationNorth(this,progressBar,textView,0f,100f);
        anim.setDuration(8000);
        progressBar.setAnimation(anim);
    }

}
