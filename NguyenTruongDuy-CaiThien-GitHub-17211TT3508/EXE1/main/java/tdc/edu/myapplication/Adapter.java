package tdc.edu.myapplication;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{
    Context context;
    ArrayList<ThucDon> data;
    int layoutResource;

    public Adapter(Context context, ArrayList<ThucDon> data, int layoutResource) {
        this.context = context;
        this.data = data;
        this.layoutResource = layoutResource;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View row = inflater.inflate(layoutResource, viewGroup, false);
        return new MyViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.txtAn.setText(data.get(i).getTxtAn());
        myViewHolder.txtUong.setText(data.get(i).getTxtUong());
        myViewHolder.txtGioitinh.setText(data.get(i).getTxtGioiTinh());
        myViewHolder.imageView.setImageResource(data.get(i).getIcon());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView txtAn, txtUong, txtGioitinh;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAn = itemView.findViewById(R.id.txtMa1);
            txtUong = itemView.findViewById(R.id.txtTen1);
            txtGioitinh = itemView.findViewById(R.id.txtGioitinh);
            imageView = itemView.findViewById(R.id.imgIcon);
        }
    }
}
