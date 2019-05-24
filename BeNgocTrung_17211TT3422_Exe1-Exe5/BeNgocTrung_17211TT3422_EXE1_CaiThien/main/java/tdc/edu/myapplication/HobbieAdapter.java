package tdc.edu.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HobbieAdapter extends RecyclerView.Adapter<HobbieAdapter.MyViewHolder>{
    Context context;
    ArrayList<Hobbies> data;
    int layoutResource;

    public HobbieAdapter(Context context, ArrayList<Hobbies> data, int layoutResource) {
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
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {

        myViewHolder.txtTenCaSy.setText(data.get(i).getTxtHoTen());
        myViewHolder.txtBaiHatYeuThich.setText(data.get(i).getTxtBaihat());
        myViewHolder.txtTheLoaiNhac.setText(data.get(i).getTxtTheLoai());
        myViewHolder.imageView.setImageResource(data.get(i).getIcon());
        myViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RemoveItem(i);
                Toast.makeText(context, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView txtTenCaSy, txtBaiHatYeuThich, txtTheLoaiNhac;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            txtTenCaSy= itemView.findViewById(R.id.txtTenCaSy);
            txtBaiHatYeuThich = itemView.findViewById(R.id.txtTenBaiHat);
            txtTheLoaiNhac = itemView.findViewById(R.id.txtTheLoai);
            imageView = itemView.findViewById(R.id.imgIcon);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener !=null)
                    {
                        listener.onItemClick(itemView,getLayoutPosition());
                    }
                }
            });

        }
    }
    public void RemoveItem(int position){
        data.remove(position);
        notifyItemRemoved(position);
    }
    private static OnItemClickListener listener;
    public interface  OnItemClickListener{
        void onItemClick(View itemView,int position);
    }
   public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
   }
}
