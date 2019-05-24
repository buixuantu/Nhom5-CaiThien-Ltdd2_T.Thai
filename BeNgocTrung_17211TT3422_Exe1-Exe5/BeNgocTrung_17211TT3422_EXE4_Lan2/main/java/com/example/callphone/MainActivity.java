package com.example.callphone;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActivityChooserView;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity {



    private VideoView videoView;
    private Button btn_TT,btnXem;
    MediaController mediaController;
    ListView lv_videoo;
    TextView tv_TenBaiHat,tv_TongThoiGian,tv_DangPhat;
    ArrayList<String>videolist;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();

    }
    public void setControl(){
         videoView =(VideoView) findViewById(R.id.VideoView);
         lv_videoo =(ListView) findViewById(R.id.lv_Video);
         btnXem = (Button) findViewById(R.id.btnXem);
         btn_TT =(Button) findViewById(R.id.btn_TT);
         mediaController = new MediaController(this);
         tv_DangPhat =(TextView) findViewById(R.id.tv_DangPhat);
         tv_TenBaiHat =(TextView) findViewById(R.id.tv_TenBaiHat);
         tv_TongThoiGian =(TextView) findViewById(R.id.tv_TongThoiGian);

    }
    public void setEvent(){
        videolist = new ArrayList<>();
        videolist.add("sakura");
        videolist.add("takemehand");



        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,videolist);
        lv_videoo.setAdapter(adapter);
        lv_videoo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 switch (position){
                     case 0:
                         videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName()+ "/" +R.raw.sakura));
                             nutXem();
                              break;
                     case 1:
                         videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName()+ "/" +R.raw.takemehand));
                         nutXem();
                         break;

                 }
            }
        });
        btn_TT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


        /*        int startTime = videoView.getDuration();
                String maxTimeString = millisecondsToString(startTime);
                tv_TongThoiGian.setText(maxTimeString);

                int Time = videoView.getCurrentPosition();
                String maxTimeString1 = millisecondsToString(startTime);
                tv_DangPhat.setText(maxTimeString1);
*/
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông Tin Bài Hát Đang Phát");
                builder.setView(R.layout.lv_item_video);

                builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
    }
     public void nutXem()
     {
         btnXem.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                     videoView.setMediaController(mediaController);
                     mediaController.setAnchorView(videoView);
                     videoView.start();
             }
         });
     }
    public  String millisecondsToString(int milliseconds)  {
        long minutes = TimeUnit.MILLISECONDS.toMinutes((long) milliseconds);
        long seconds =  TimeUnit.MILLISECONDS.toSeconds((long) milliseconds) ;
        return minutes+":"+ seconds;
    }

}
