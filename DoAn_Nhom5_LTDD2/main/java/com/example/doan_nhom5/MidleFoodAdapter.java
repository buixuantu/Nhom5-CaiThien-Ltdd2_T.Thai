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

public class MidleFoodAdapter  extends ArrayAdapter<MidleFood> {
    Context context;
    int layoutResourceId;
    ArrayList<MidleFood> data=null;

    final static String BUNDLE = "bundle";
    final static String HINH = "3";
    final static String HUONGDAN = "EWE";

    public MidleFoodAdapter(Context context, int layoutResourceId, ArrayList<MidleFood> data) {
        super(context, layoutResourceId,data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    static class NorthfoodHolder{
        TextView tv_TenMonAn,tv_ThongTin,tv_Ten;
        ImageView imgMonAnMienTrung,img_ThongTin,img_HuongDan;
        Button btnXem,btnHuongDanMT;
}

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row= convertView;
        NorthfoodHolder holder=null;
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new NorthfoodHolder();
            holder.btnXem =(Button)row.findViewById(R.id.btnXemMT);
            holder.btnHuongDanMT =(Button) row.findViewById(R.id.btnHuongDanMT);
            holder.img_ThongTin =(ImageView)row.findViewById(R.id.img_ThongTin);
            holder.img_HuongDan =(ImageView) row.findViewById(R.id.img_HuongDan);
            holder.tv_ThongTin =(TextView) row.findViewById(R.id.tv_ThongTin);
            holder.tv_TenMonAn = (TextView) row.findViewById(R.id.tv_TenMonAnMT);
            holder.tv_Ten =(TextView) row.findViewById(R.id.tv_Ten);

            holder.imgMonAnMienTrung=(ImageView)row.findViewById(R.id.imgMonAnMienTrung);
            row.setTag(holder);
        }
        else
        {
            holder=(NorthfoodHolder)row.getTag();
        }
        final MidleFood mf = data.get(position);

        //holder.img_ThongTin.setImageResource(mf.imgtenMonAn);
       // holder.tv_ThongTin.setText(mf.getThongTin());

        holder.imgMonAnMienTrung.setImageResource(mf.imgtenMonAn);
        holder.tv_TenMonAn.setText("Tên món Ăn : " + mf.getTenMonAn());
        holder.btnXem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int imgtenMonAn = mf.getImgtenMonAn();
                String tenmonan = mf.getTenMonAn();
                String thongTin = mf.getThongTin();
                xem(imgtenMonAn,tenmonan, thongTin);

            }
        });
        holder.btnHuongDanMT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int imgtenMonAn = mf.getImgtenMonAn();
                String huongdan = mf.getHuongDan();
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
