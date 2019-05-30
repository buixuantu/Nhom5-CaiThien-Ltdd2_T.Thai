package com.example.doan_nhom5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NorthFoodAdapter  extends ArrayAdapter<northfood> {
   Context context;
   int layoutResourceId;
   ArrayList<northfood> data=null;

    public NorthFoodAdapter(Context context, int layoutResourceId, ArrayList<northfood> data) {
        super(context, layoutResourceId,data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    static class NorthfoodHolder{
       TextView tv_TenMonAn;
       ImageView imgMonAnMienBac;
       Button btnXem,btnHuongDanMB;
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
            holder.btnXem =(Button) row.findViewById(R.id.btnXemMB);
            holder.btnHuongDanMB =(Button) row.findViewById(R.id.btnHuongDanMB);
            holder.tv_TenMonAn = (TextView) row.findViewById(R.id.tv_TenMonAnMB);
            holder.imgMonAnMienBac=(ImageView)row.findViewById(R.id.imgMonAnMienBac);
            row.setTag(holder);
        }
        else
        {
            holder=(NorthfoodHolder)row.getTag();
        }
        final northfood nf = data.get(position);
        holder.imgMonAnMienBac.setImageResource(nf.imgtenMonAn);
        holder.tv_TenMonAn.setText("Tên món Ăn : " + nf.getTenMonAn());
        holder.btnXem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int imgtenMonAn = nf.imgtenMonAn;
                String thongtin = nf.getThongTin();
                xem(imgtenMonAn, thongtin);
            }
        });
        holder.btnHuongDanMB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int imgtenMonAn = nf.getImgtenMonAn();
                String huongdan = nf.getHuongDan();
                HuongDan(imgtenMonAn,huongdan);
            }
        });
        return row;
    }
    public void xem(final int hinh, final String ThongTin){
        Bundle bundle = new Bundle();
        bundle.putInt("hinh",hinh);
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
