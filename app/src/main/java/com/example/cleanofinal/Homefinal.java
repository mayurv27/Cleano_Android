package com.example.cleanofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

public class Homefinal extends AppCompatActivity {
    public static final String MSG ="com.example.cleanofinal.MSG";
    public static final String MSG1 ="com.example.cleanofinal.MSG1";
    private EditText t1;
    private EditText t2;
    private EditText t3;
    private EditText t4;
    private EditText t5;
    private EditText t6;
    private Button order;
    DatabaseReference cleanodb;
    TextView add;
    TextView estimate;
    int t11,t12,t13,t14,t15,t16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homefinal);

        t1=findViewById(R.id.tshirt1);
        t2=findViewById(R.id.blazer);
        t3=findViewById(R.id.saree1);
        t4=findViewById(R.id.pant1);
        t5=findViewById(R.id.blanket);
        t6=findViewById(R.id.bedsheet1);
        add=findViewById(R.id.sum);
        estimate=findViewById(R.id.multiply);

        order=findViewById(R.id.placeorder);
        cleanodb= FirebaseDatabase.getInstance().getReference().child("Orders");
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Tshirt=t1.getText().toString();
                String Blazer=t2.getText().toString();
                String Saree=t3.getText().toString();
                String Pant=t4.getText().toString();
                String Blanket=t5.getText().toString();
                String Bedsheet=t6.getText().toString();
                String Total=add.getText().toString();
                String Total_Estimate=estimate.getText().toString();
                if (Tshirt.isEmpty()){


                    t1.setError("Enter Value");


                }else if (Blazer.isEmpty()){
                    t2.setError("Enter Value");


                }else if(Saree.isEmpty()){

                    t3.setError("Enter Value");

                }else if (Pant.isEmpty()){


                    t4.setError("Enter Value");
                }else if(Blanket.isEmpty()){

                    t5.setError("Enter Value");

                }else if (Bedsheet.isEmpty()){

                    t6.setError("Enter Values");
                }else {

                    Students students = new Students(Tshirt, Blazer, Saree, Pant, Blanket, Bedsheet, Total, Total_Estimate);
                    cleanodb.push().setValue(students);
                    Toast.makeText(Homefinal.this, "Enter Delivery Details", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Homefinal.this, Delivery_details.class);
                    String message = add.getText().toString();
                    String message1 = estimate.getText().toString();
                    intent.putExtra(MSG, message);
                    intent.putExtra(MSG1, message1);
                    startActivity(intent);

                }
                } ;




        });







    }
    public boolean getNumbers(){
        t1=findViewById(R.id.tshirt1);
        t2=findViewById(R.id.blazer);
        t3=findViewById(R.id.saree1);
        t4=findViewById(R.id.pant1);
        t5=findViewById(R.id.blanket);
        t6=findViewById(R.id.bedsheet1);
        add=findViewById(R.id.sum);
        estimate=findViewById(R.id.multiply);


        String s1 = t1.getText().toString();

        // taking input from text box 2
        String s2 = t2.getText().toString();
        String s3 = t3.getText().toString();

        // taking input from text box 2
        String s4 = t4.getText().toString();
        String s5 = t5.getText().toString();

        // taking input from text box 2
        String s6 = t6.getText().toString();


        t11 = Integer.parseInt(s1);

        // converting string to int.
        t12 = Integer.parseInt(s2);
        t13 = Integer.parseInt(s3);

        // converting string to int.
        t14 = Integer.parseInt(s4);
        t15 = Integer.parseInt(s5);

        // converting string to int.
        t16 = Integer.parseInt(s6);


    return true;
    }

    public void doSum(View v){
        if(getNumbers()) {
            int sum = t11 + t12 + t13 + t14 + t15 + t16 ;
            add.setText(Integer.toString(sum));


        }
    }


    public void doMul(View v){
        if(getNumbers()) {
            int sum = t11*8 + t12*8+ t13*8 + t14 *8 + t15*8+ t16*8;
            estimate.setText(Integer.toString(sum));


        }
    }

}