package com.example.doan_nhom5;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class HuongDanActivity extends AppCompatActivity {
    ImageView img_HuongDan;
    TextView tv_HuongDan;
    Button btnHuongDan;
    MediaController mediaController;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.huongdan);
        setControl();
        setEvent();
        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName()+ "/" +R.raw.huongdan));
        videoView.requestFocus();
        videoView.start();


    }
    public void setControl(){
        img_HuongDan =(ImageView) findViewById(R.id.img_HuongDan);
        tv_HuongDan =(TextView) findViewById(R.id.tv_HuongDan);
        videoView =(VideoView) findViewById(R.id.VideoView);
        mediaController = new MediaController(this);

    }
    public void setEvent(){
        Bundle bundle = getIntent().getExtras();
        int hinh = bundle.getInt("hinh");
        String title = bundle.getString("HuongDan");
        img_HuongDan.setImageResource(hinh);
        tv_HuongDan.setText(title);


    }

}
