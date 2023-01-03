package com.example.cleanofinal;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class OrderstoPick extends AppCompatActivity {
    private Button showhistory1;
    private ListView listhistory1;
    private List<String> namelist1=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordersto_pick);
        showhistory1=findViewById(R.id.driverorder);
        listhistory1=findViewById(R.id.driverhistory);






        showhistory1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseFirestore.getInstance().collection("Delivery_Details").addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        for (DocumentSnapshot s :value)
                        {

                            namelist1.add(s.getString("Number") +
                                    ":" + s.getString("Name")
                                    + ":" + s.getString("Clothes")
                                    + ":" + s.getString("Bill")
                                    + ":" + s.getString("Address"));



                        }
                        ArrayAdapter adapter =new ArrayAdapter<String>(OrderstoPick.this, android.R.layout.simple_selectable_list_item,namelist1);
                        adapter.notifyDataSetChanged();
                        listhistory1.setAdapter(adapter);





                    }
                });






            }
        });





    }
}