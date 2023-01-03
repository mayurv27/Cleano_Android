package com.example.cleanofinal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//mport com.bumptech.glide.Glide;
//import com.google.android.gms.auth.api.signin.GoogleSignIn;
//import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import io.grpc.internal.DnsNameResolver;

public class Delivery_details extends AppCompatActivity {
    private EditText d1;
    private EditText d2;
    private EditText d3;
    private EditText d4;
    DatabaseReference deliverydb;
    private Button deliverhere;
    static String CustNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_details);
        d1=findViewById(R.id.deliveryname);
        d2=findViewById(R.id.deliverynumber);
        d3=findViewById(R.id.deliveryaddress);
        d4=findViewById(R.id.deliveryemail);
        deliverhere=findViewById(R.id.deliverybtn);
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String personName = acct.getDisplayName();
            //String personGivenName = acct.getGivenName();
            //String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            //String personId = acct.getId();
            Uri personPhoto = acct.getPhotoUrl();
            d1.setText(personName);
            d4.setText(personEmail);

        }

        Intent intent=getIntent();
        String message= intent.getStringExtra(Homefinal.MSG) ;
        String message1= intent.getStringExtra(Homefinal.MSG1) ;

        TextView cloth=findViewById(R.id.clothorder);
        TextView bill=findViewById(R.id.amount);
        cloth.setText(message);
        bill.setText(message1);
        deliverydb= FirebaseDatabase.getInstance().getReference().child("Delivery_Details");
        deliverhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String CustName=d1.getText().toString();
                String CustEmail=d4.getText().toString();
                CustNumber=d2.getText().toString();
                String CustAddress=d3.getText().toString();
                String CustClothes=cloth.getText().toString();
                String CustCost=bill.getText().toString();
               Delivery delivery=new Delivery(CustName,CustEmail,CustNumber,CustAddress,CustClothes,CustCost);
                deliverydb.child(CustNumber).setValue(delivery);
                if(CustNumber.isEmpty()){

                    d2.setError("Enter the Number");


                }else if (CustAddress.isEmpty()){


                    d3.setError("Enter Address");


                }else {


                    Toast.makeText(getApplicationContext(), "Order Saved Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Delivery_details.this,Ordersuccess.class));


                }


            }
        });







    }


}