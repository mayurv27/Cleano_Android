package com.example.cleanofinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Delivery_Orders extends AppCompatActivity {
    RecyclerView recyclerView1;
    DatabaseReference deliverydata;
    MyAdapter1 myAdapter1;
    ArrayList<DriverRealtimeclass> list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_orders);
        recyclerView1=findViewById(R.id.deliverylist);
        deliverydata= FirebaseDatabase.getInstance().getReference("Delivery_Details");
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));


        list1=new ArrayList<>();
        myAdapter1=new MyAdapter1(this,list1);
        recyclerView1.setAdapter(myAdapter1);


        deliverydata.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){

                    DriverRealtimeclass driverRealtimeclass=dataSnapshot.getValue(DriverRealtimeclass.class);
                    list1.add(driverRealtimeclass);


                }
                myAdapter1.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}