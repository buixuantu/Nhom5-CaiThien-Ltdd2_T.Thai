package com.example.doan_nhom5;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class ThongTinActivity extends AppCompatActivity {
    ImageView img_ThongTin;
    TextView tv_ThongTin,tv_ten;
    Button btn_Call,btn_YeuThich,btn_OK;
    RadioButton rbtn_BuaSang,rbtn_BuaTrua,rbtn_BuaToi,rbtn_Chinh,rbtn_Phu;
    RadioGroup radioGroupChinhPhu,radioGroupBua;
    private static final int REQUEST_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongtin);
        setControl();
        setEvent();
    }

    public void setControl() {
        img_ThongTin = (ImageView) findViewById(R.id.img_ThongTin);
        tv_ThongTin = (TextView) findViewById(R.id.tv_ThongTin);
        tv_ten =(TextView) findViewById(R.id.tv_Ten) ;
        btn_Call = (Button) findViewById(R.id.btn_Dathang);
        btn_YeuThich =(Button) findViewById(R.id.btn_YeuThich);


    }

    public void setEvent() {
        final Bundle bundle = getIntent().getExtras();

        int hinh = bundle.getInt("hinh");
        String ten = bundle.getString("tenmonan");
        final String title = bundle.getString("thongtin");

        img_ThongTin.setImageResource(hinh);
        tv_ThongTin.setText(title);
        tv_ten.setText(ten);
        //Toast.makeText(this,title, Toast.LENGTH_SHORT).show();
        btn_Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ContextCompat.checkSelfPermission(ThongTinActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(ThongTinActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                } else {

                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:09413286"));
                    startActivity(intent);
                }
            }
        });
        btn_YeuThich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 final Dialog dialog = new Dialog(ThongTinActivity.this);
                 dialog.setTitle("Danh Mục Yêu Thích");
                 dialog.setCancelable(false);
                 dialog.setContentView(R.layout.yeuthich);
                 btn_OK =(Button) dialog.findViewById(R.id.btn_OK);
                rbtn_BuaSang =(RadioButton)dialog.findViewById(R.id.btn_BuaSang);
                rbtn_BuaTrua =(RadioButton) dialog.findViewById(R.id.btn_BuaTrua);
                rbtn_BuaToi =(RadioButton) dialog.findViewById(R.id.btn_BuaToi);
                rbtn_Chinh =(RadioButton) dialog.findViewById(R.id.rbtn_Chinh);
                rbtn_Phu =(RadioButton) dialog.findViewById(R.id.rbtn_Phu);
                radioGroupBua =(RadioGroup) dialog.findViewById(R.id.gr_ChonBua);
                radioGroupChinhPhu =(RadioGroup) dialog.findViewById(R.id.gr_ChinhPhu);

                radioGroupBua.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        switch (checkedId){
                            case R.id.btn_BuaSang:
                                break;
                            case R.id.btn_BuaTrua:
                                break;
                            case R.id.btn_BuaToi:
                                break;
                            case R.id.rbtn_Chinh:
                                break;
                            case R.id.rbtn_Phu:
                                break;
                        }
                    }
                });

                 btn_OK.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         String BuaAn="";
                        if(rbtn_BuaSang.isChecked()){
                            BuaAn = rbtn_BuaSang.getText().toString();

                            dialog.cancel();
                        }
                        else if(rbtn_BuaTrua.isChecked()){
                                BuaAn = rbtn_BuaTrua.getText().toString();


                        }
                        else {
                              BuaAn= rbtn_BuaToi.getText().toString();

                         }
                         String ChinhPhu="";
                         if(rbtn_Chinh.isChecked()){
                              ChinhPhu = rbtn_Chinh.getText().toString();

                         }
                         else {
                             ChinhPhu = rbtn_Phu.getText().toString();

                         }
                         String ten=tv_ten.getText().toString();
                         YeuThich(BuaAn,ten,ChinhPhu);
                     }

                 });
                 dialog.cancel();
                 dialog.show();

            }
        });

    }
    public void YeuThich(String buaan,String ten,String chinhphu){

            Bundle bundle = new Bundle();
            bundle.putString("BuaAn",buaan);
            bundle.putString("tenmonAn",ten);
        bundle.putString("ChinhPhu",chinhphu);
            Intent intent = new Intent(this,YeuThichActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
    }
 /*   public void YeuThich1(String chinhphu){

        Bundle bundle = new Bundle();
        bundle.putString("ChinhPhu",chinhphu);
        Intent intent = new Intent(this,YeuThichActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }*/
}
