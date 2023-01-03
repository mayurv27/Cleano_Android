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

public class ShowHistory extends AppCompatActivity {
   private Button showhistory;
   private ListView listhistory;
   private List<String> namelist=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_history);
        showhistory=findViewById(R.id.driverorder);
        listhistory=findViewById(R.id.driverhistory);



        showhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseFirestore.getInstance().collection("Orders").addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        for (DocumentSnapshot s :value)
                        {

                            namelist.add(s.getString("Tshirt") +
                                    ":" + s.getString("Saree")
                                    + ":" + s.getString("Pant")
                                    + ":" + s.getString("Blazer")
                                    + ":" + s.getString("Blanket")
                                    + ":" + s.getString("Bedsheet"));


                        }
                        ArrayAdapter adapter =new ArrayAdapter<String>(ShowHistory.this, android.R.layout.simple_selectable_list_item,namelist);
                        adapter.notifyDataSetChanged();
                        listhistory.setAdapter(adapter);





                    }
                });






            }
        });





    }
}