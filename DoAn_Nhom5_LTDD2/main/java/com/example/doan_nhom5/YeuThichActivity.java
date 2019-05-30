package com.example.doan_nhom5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class YeuThichActivity extends AppCompatActivity {
     TextView tv_BuaAn,tv_ChinhPhu,tv_tenmonan;
     ListView lv_yeuthich;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeu_thich);
        setConnTrol();

      /*  ArrayAdapter<String> yeuthich = new ArrayAdapter<String>(this,R.layout.yeuthich_lv_row,R.id.tv_BuaAn);
        lv_yeuthich.setAdapter(yeuthich);*/
        Bundle bundle = getIntent().getExtras();
        String bua =bundle.getString("BuaAn");
        String chinhphu= bundle.getString("ChinhPhu");
        String tenMonAn =bundle.getString("tenmonAn");
        tv_tenmonan.setText(tenMonAn);
        tv_BuaAn.setText(bua);
        tv_ChinhPhu.setText(chinhphu);
    }

    public void setConnTrol(){
        tv_BuaAn =(TextView) findViewById(R.id.tv_BuaAn);
        tv_ChinhPhu =(TextView) findViewById(R.id.tv_ChinhPhu);
        tv_tenmonan =(TextView) findViewById(R.id.tv_TenMonYeuThich);
    /* lv_yeuthich =(ListView) findViewById(R.id.lv_YeuThich);*/
    }
}
