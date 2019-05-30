package com.example.doan_nhom5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SouthFoodAdapter extends ArrayAdapter<SouthFood> {
    Context context;
    int layoutResourceId;
    ArrayList<SouthFood> data=null;

    public SouthFoodAdapter(Context context, int layoutResourceId, ArrayList<SouthFood> data) {
        super(context, layoutResourceId,data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    static class NorthfoodHolder{
        TextView tv_TenMonAn;
        ImageView imgMonAnMienNam;
        Button  btnXem,btnHuongDanMN;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row= convertView;
        NorthfoodHolder holder=null;
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new NorthfoodHolder();
            holder.btnXem =(Button) row.findViewById(R.id.btnXemMN);
            holder.btnHuongDanMN =(Button) row.findViewById(R.id.btnHuongDanMN);
            holder.tv_TenMonAn = (TextView) row.findViewById(R.id.tv_TenMonAnMN);
            holder.imgMonAnMienNam=(ImageView)row.findViewById(R.id.imgMonAnMienNam);
            row.setTag(holder);
        }
        else
        {
            holder=(NorthfoodHolder)row.getTag();
        }
         final SouthFood sf = data.get(position);
        holder.imgMonAnMienNam.setImageResource(sf.imgtenMonAn);
        holder.tv_TenMonAn.setText("Tên món Ăn : " + sf.getTenMonAn());
        holder.btnXem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int imgtenMonAn = sf.getImgtenMonAn();
                String tenmonan = sf.getTenMonAn();
                String thongTin = sf.getThongTin();
                xem(imgtenMonAn,tenmonan, thongTin);
            }
        });
        holder.btnHuongDanMN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int imgtenMonAn = sf.getImgtenMonAn();
                String huongdan = sf.getHuongDan();
                HuongDan(imgtenMonAn,huongdan);
            }
        });
        return row;

    }
    public void xem(final int hinh,final String ten ,final String ThongTin){


        Bundle bundle = new Bundle();
        bundle.putInt("hinh",hinh);
        bundle.putString("tenmonan",ten);
        bundle.putString("thongtin",ThongTin);
        Intent intent = new Intent(context,ThongTinActivity.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
    public void HuongDan(final int hinh, final String HuongDan){
        Bundle bundle = new Bundle();
        bundle.putInt("hinh",hinh);
        bundle.putString("HuongDan",HuongDan);
        Intent intent = new Intent(context,HuongDanActivity.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
}
