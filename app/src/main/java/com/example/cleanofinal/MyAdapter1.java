package com.example.cleanofinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.MyViewHolder1> {



    Context context1;
    ArrayList<DriverRealtimeclass> list1;
    private OnNoteListener mOnNoteListener;

    public MyAdapter1(Context context, ArrayList<DriverRealtimeclass> list)
    {
        this.context1 = context;
        this.list1 = list;


    }

    @NonNull
    @Override
    public MyViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context1).inflate(R.layout.driverrecycle,parent,false);
        return new MyViewHolder1(v,mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull  MyViewHolder1 holder, int position) {
        DriverRealtimeclass driverRealtimeclass=list1.get(position);

        holder.CustName.setText(driverRealtimeclass.getCustName());
        holder.CustEmail.setText(driverRealtimeclass.getCustEmail());
        holder.CustNumber.setText(driverRealtimeclass.getCustNumber());
        holder.CustAddress.setText(driverRealtimeclass.getCustAddress());
        holder.CustClothes.setText(driverRealtimeclass.getCustClothes());
        holder.CustCost.setText(driverRealtimeclass.getCustCost());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseDatabase.getInstance().getReference().child("Delivery_Details").child(Delivery_details.CustNumber).removeValue();
            }
        });


    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public static class MyViewHolder1 extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView CustName,CustEmail,CustNumber,CustAddress,CustClothes,CustCost;
        OnNoteListener onNoteListener;
        ImageView edit,delete;

        public MyViewHolder1(@NonNull View itemView,OnNoteListener onNoteListener) {
            super(itemView);

            CustName = itemView.findViewById(R.id.tv_custname);
            CustEmail =itemView.findViewById(R.id.tv_custemail);
            CustNumber=itemView.findViewById(R.id.tv_custnumber);
            CustAddress=itemView.findViewById(R.id.tv_custaddress);
            CustClothes=itemView.findViewById(R.id.tv_custtotal);
            CustCost=itemView.findViewById(R.id.tv_custbill);
            delete=itemView.findViewById(R.id.deleteorder);
            this.onNoteListener=onNoteListener;








                itemView.setOnClickListener(this);





                }

        @Override
        public void onClick(View v) {
            onNoteListener.OnNoteClick(getAdapterPosition());

        }
    }
            public interface OnNoteListener{
                void OnNoteClick(int position);
            }

    }



