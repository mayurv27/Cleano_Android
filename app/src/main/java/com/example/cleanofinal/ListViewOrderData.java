package com.example.cleanofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import io.reactivex.rxjava3.annotations.NonNull;

public class ListViewOrderData extends AppCompatActivity {

    ListView listView;
    ValueEventListener valueEventListener;
    DatabaseReference DR1 = FirebaseDatabase.getInstance().getReference("Orders");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_order_data);

        listView = findViewById(R.id.listView);
        ArrayList<String> list = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.list_item,list);
        listView.setAdapter(adapter);

        valueEventListener= new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                list.clear();
                for(DataSnapshot snapshot1 : snapshot.getChildren()){
                for (DataSnapshot snapshot2: snapshot1.getChildren())
                    list.add(snapshot2.getKey()+" "+snapshot2.getValue());

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@androidx.annotation.NonNull DatabaseError error) {

            }
        };
        DR1.addValueEventListener(valueEventListener);
}
    @Override
    protected void onDestroy() {
        super.onDestroy();
        DR1.removeEventListener(valueEventListener);
    }

}