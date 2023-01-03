package com.example.cleanofinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    Context context;
    ArrayList<Realtimeclass> list;

    public MyAdapter(Context context, ArrayList<Realtimeclass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return  new MyViewHolder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        Realtimeclass realtimeclass=list.get(position);
        holder.tshirt.setText(realtimeclass.getTshirt());
        holder.blazer.setText(realtimeclass.getBlazer());
        holder.saree.setText(realtimeclass.getSaree());
        holder.pant.setText(realtimeclass.getPant());
        holder.blanket.setText(realtimeclass.getBlanket());
        holder.bedsheet.setText(realtimeclass.getBedsheet());
        holder.total.setText(realtimeclass.getTotal());
        holder.total_Estimate.setText(realtimeclass.getTotal_Estimate());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{



        TextView tshirt,blazer,saree,pant,blanket,bedsheet,total,total_Estimate;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tshirt = itemView.findViewById(R.id.tv_tshirt);
            blazer =itemView.findViewById(R.id.tv_blazer);
            saree =itemView.findViewById(R.id.tv_saree);
            pant =itemView.findViewById(R.id.tv_pant);
            blanket =itemView.findViewById(R.id.tv_blanket);
            bedsheet =itemView.findViewById(R.id.tv_bedsheet);
            total=itemView.findViewById(R.id.tv_Total_clothes);
            total_Estimate =itemView.findViewById(R.id.tv_Cost);
        }
    }


}
