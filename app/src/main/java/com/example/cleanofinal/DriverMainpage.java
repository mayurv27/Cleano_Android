package com.example.cleanofinal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class DriverMainpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView name,email15;
        ImageView pic;
        //Button b1;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_mainpage);
        email15=findViewById(R.id.email15);
        name=findViewById(R.id.name);
        pic=findViewById(R.id.pic);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String personName = acct.getDisplayName();
            //String personGivenName = acct.getGivenName();
            //String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            //String personId = acct.getId();
            Uri personPhoto = acct.getPhotoUrl();

            email15.setText(personEmail);
            name.setText(personName);
            Glide.with(this).load(String.valueOf(personPhoto)).into(pic);

        }
    }


    public void openactivity3(View view) {
        Toast.makeText(this, "Here it is", Toast.LENGTH_SHORT).show();
        Intent i3 = new Intent(DriverMainpage.this, Delivery_Orders.class);
        startActivity(i3);
    }

    public void openactivity4(View view) {
        Toast.makeText(this, "Your contribution", Toast.LENGTH_SHORT).show();
       // Intent i4 = new Intent(MainActivity2.this, MainActivity4.class);
        //startActivity(i4);
    }

    public void toadmin(View view) {
        Toast.makeText(this, "Fill Your Query", Toast.LENGTH_SHORT).show();
       Intent i5 = new Intent(DriverMainpage.this, Contact_admin_page.class);
        startActivity(i5);
    }

}