package tdc.edu.vn.myapplication;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
   ImageView img,imgco,imgco2,imgcay;
   Button btnStart,btnstop,btnJump;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          setControl();
             btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.setImageResource(R.drawable.horse);
                AnimationDrawable anim = (AnimationDrawable)img.getDrawable();
                anim.start();

                Animation anim2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.buicochuyendong);
                imgco.startAnimation(anim2);
                imgco2.startAnimation(anim2);

                btnJump.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Animation anim3 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.nhay);
                        img.startAnimation(anim3);
                    }
                });

            }
        });


    }
    public void setControl(){
        img =(ImageView) findViewById(R.id.img);
        btnStart =(Button)findViewById(R.id.btnStart);
        btnJump =(Button)findViewById(R.id.btnJump);
        imgcay=(ImageView)findViewById(R.id.cay);
        imgco=(ImageView)findViewById(R.id.buico);
        imgco2=(ImageView)findViewById(R.id.buico2);

    }
}
