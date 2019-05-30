package com.example.doan_nhom5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NorthFoodActivity extends AppCompatActivity {
     private  ListView NorthFoodListView;
     ArrayList<northfood> data = new ArrayList<>();
     NorthFoodAdapter adapter=null;
     Button btnXem,btnHuongDan;
     TextView tv_tenmonan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.northfood);
        setControl();
        setEvent();
    }
    public void setControl(){
        NorthFoodListView =(ListView) findViewById(R.id.lv_FoodMienBac);
        tv_tenmonan =(TextView) findViewById(R.id.tv_TenMonAnMB);
        btnXem =(Button) findViewById(R.id.btnXemMB);
    }
    public void setEvent(){
        KhoiTao();
        NorthFoodAdapter adapter = new NorthFoodAdapter(this,R.layout.northfood_listview_row_item,data);
        NorthFoodListView.setAdapter(adapter);
    }

    public void KhoiTao(){
        data.add(new northfood("Phở","Mon pho ha Noi","Video",R.drawable.pho));
        data.add(new northfood("Bún chả Hà Nội","Món bún chả Hà Nội","Video",R.drawable.buncha));
        data.add(new northfood("Bánh cuốn Thanh Trì","Món Bánh cuốn Thanh Trì","Video",R.drawable.banhcuonthanhtri));
    }
}
