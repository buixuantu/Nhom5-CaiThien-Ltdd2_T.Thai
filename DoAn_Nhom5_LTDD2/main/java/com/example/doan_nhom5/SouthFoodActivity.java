package com.example.doan_nhom5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SouthFoodActivity extends AppCompatActivity {

    private ListView SouthFoodListView;
    ArrayList<SouthFood> data = new ArrayList<>();
    NorthFoodAdapter adapter=null;
    Button btnXem,btnHuongDan;
    TextView tv_tenmonan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.southfood);
        setControl();
        setEvent();
    }
    public void setControl(){
        SouthFoodListView =(ListView) findViewById(R.id.lv_FoodMienNam);
        tv_tenmonan =(TextView) findViewById(R.id.tv_TenMonAnMN);
    }
    public void setEvent(){
        KhoiTao();
        SouthFoodAdapter adapter = new SouthFoodAdapter(this,R.layout.southfood_listview_row_item,data);
        SouthFoodListView.setAdapter(adapter);
    }
    public void KhoiTao(){
        data.add(new SouthFood("Cá lóc nướng trui","","",R.drawable.calocnuongchui));
        data.add(new SouthFood("Cơm Tấm Sài Gòn","","",R.drawable.comtam));
        data.add(new SouthFood("Cháo cua đồng Bến Tre","","",R.drawable.chaocuadong));
    }
}
