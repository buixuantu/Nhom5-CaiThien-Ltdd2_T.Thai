package com.example.doan_nhom5;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView img_mienbac,img_mientrung,img_miennam;
    Button btnThoat;
    FloatingActionButton fl_choose, fl_mb,fl_mt,fl_mn;
    boolean AnHien =false;
    ProgressBar progressBar;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        HieuUngTruot();
        setEvent();

    }

    public void HieuUngTruot() {

        //hieu ung truot cho nut chon vung mien
        Animation anim1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slidedown_vungmien);
        img_mienbac.startAnimation(anim1);
        img_mientrung.startAnimation(anim1);
        img_miennam.startAnimation(anim1);
    }

     public void setEvent(){



        img_mienbac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MienBac();
            }
        });
       img_mientrung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MienTrung();
            }
        });
       img_miennam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MienNam();
            }
        });


         fl_choose.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(AnHien == false){
                     Hien();
                     AnHien =true;
                 }
                 else
                 {
                     An();
                     AnHien =false;
                 }
             }
         });
         fl_mb.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 MienBac();
             }
         });
         fl_mt.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 MienTrung();
             }
         });
         fl_mn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 MienNam();
             }
         });
     }
    public void Hien(){
        fl_mb.show();
        fl_mt.show();
        fl_mn.show();
    }
    public void An(){
        fl_mb.hide();
        fl_mt.hide();
        fl_mn.hide();
    }


     public void MienBac(){
        Intent intent = new Intent(this,FirstLoadingActivity.class);
        this.startActivity(intent);
    }

    public void MienTrung(){
        Intent intent = new Intent(this,SecondLoadingActivity.class);
        this.startActivity(intent);
    }
    public void MienNam(){
        Intent intent = new Intent(this,ThirdLoadingActivity.class);
        this.startActivity(intent);
    }

    public void setControl() {
    /*    btnThoat = (Button) findViewById(R.id.btnThoat);*/
        img_mienbac = (ImageView) findViewById(R.id.img_MienBac);
       img_mientrung = (ImageView) findViewById(R.id.img_MienTrung);
        img_miennam = (ImageView) findViewById(R.id.img_MienNam);
        fl_choose =(FloatingActionButton) findViewById(R.id.fl_Choose);
        fl_mb =(FloatingActionButton) findViewById(R.id.fl_MB);
        fl_mt =(FloatingActionButton) findViewById(R.id.fl_MT);
        fl_mn =(FloatingActionButton) findViewById(R.id.fl_MN);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_actionbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnuGioiThieu:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông tin ứng dụng");
                builder.setMessage("Ứng dụng hướng dẫn nấu ăn các món ăn ngon của từng vùng miền"
                      );
                builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
                break;

            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}

