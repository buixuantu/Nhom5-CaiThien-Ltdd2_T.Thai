package com.example.doan_nhom5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MidleFoodActivity extends AppCompatActivity {

    private ListView MidleFoodListView;
    ArrayList<MidleFood> data = new ArrayList<>();
    NorthFoodAdapter adapter=null;
    Button btnXem,btnHuongDan;
    TextView tv_tenmonan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.midlefood);
        setControl();
        setEvent();
    }
    public void setControl(){
        MidleFoodListView =(ListView) findViewById(R.id.lv_FoodMienTrung);
        tv_tenmonan =(TextView) findViewById(R.id.tv_TenMonAnMT);
        btnXem =(Button) findViewById(R.id.btnXemMT);
        btnHuongDan=(Button) findViewById(R.id.btnHuongDanMT);
    }
    public void setEvent(){

        MidleFoodAdapter adapter = new MidleFoodAdapter(this,R.layout.midlefood_listview_row_item,data);
        MidleFoodListView.setAdapter(adapter);
        KhoiTao();

    }

    public void KhoiTao(){
        data.add(new MidleFood("Bánh canh cá lóc Quảng Trị","Xuất xứ : Quảng Trị \n","* Nguyên Liệu \n" +
                "- Hành,Tỏi \n"+
                "- Dầu Ăn \n "+"...",R.drawable.banhcanhcaloc));
        data.add(new MidleFood("Bún chả cá Quy Nhơn","","",R.drawable.bunchaquynhon));
        data.add(new MidleFood("Cao Lầu","","",R.drawable.caolau));
    }

}
