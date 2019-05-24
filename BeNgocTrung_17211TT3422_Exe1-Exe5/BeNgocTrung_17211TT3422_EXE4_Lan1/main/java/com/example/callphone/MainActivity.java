package com.example.callphone;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActivityChooserView;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;


public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CALL =1;
    int REQUEST_CAMERA=123;
    private EditText sodt,phone,text;
    private ImageView imgPhone,imgChup;
    private VideoView videoView;
    private Button btnChup,btnXem,btnSend;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();

    }
    public void setControl(){
         sodt =(EditText) findViewById(R.id.SDT);
         imgPhone= (ImageView) findViewById(R.id.image_call);
         imgChup= (ImageView) findViewById(R.id.imgChup);
         btnChup =(Button) findViewById(R.id.btnChup);
         videoView =(VideoView) findViewById(R.id.VideoView);
         btnXem = (Button) findViewById(R.id.btnXem);
         mediaController = new MediaController(this);
         btnSend =(Button) findViewById(R.id.btnSend);
         phone = (EditText) findViewById(R.id.edit_Phone);
         text = (EditText) findViewById(R.id.edit_Text);

    }
    public void setEvent(){


        imgPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MakePhone();
            }
        });

        btnChup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
               startActivityForResult(intent,REQUEST_CAMERA);
            }
        });
        btnXem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String videopath = "android.resource://com.example.callphone/" +R.raw.sakura;
                Uri uri = Uri.parse(videopath);
                videoView.setVideoURI(uri);
                videoView.setMediaController(mediaController);
                mediaController.setAnchorView(videoView);
                videoView.start();

            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                    Message();
                } else {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS}, 0);
                }
            }
        });

    }

    public void Message() {
        String sdt = phone.getText().toString();
        String textt = text.getText().toString();
        if (!phone.getText().toString().equals("") || !text.getText().toString().equals("")) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(sdt, null, textt, null, null);
            Toast.makeText(this, "Sent", Toast.LENGTH_SHORT).show();
        }

    }

    public void MakePhone(){

        String number = sodt.getText().toString();
        if(number.trim().length() >0){
             if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

                 ActivityCompat.requestPermissions(MainActivity.this, new String[]{ Manifest.permission.CALL_PHONE},REQUEST_CALL);
             }
             else {
                 Intent intent = new Intent(Intent.ACTION_CALL);
                 intent.setData(Uri.parse("tel:" + number));
                 startActivity(intent);
             }
         }
         else {
             Toast.makeText(this, "Vui lòng nhập số điện thoại", Toast.LENGTH_SHORT).show();
         }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode  == REQUEST_CALL){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                MakePhone();
                Message();
            }
            else {
                Toast.makeText(this, "Không gọi được", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
         if(requestCode == REQUEST_CAMERA && resultCode ==RESULT_OK ){
             Bitmap bitmap =  (Bitmap) data.getExtras().get("data");
             imgChup.setImageBitmap(bitmap);
        }
    }
}
