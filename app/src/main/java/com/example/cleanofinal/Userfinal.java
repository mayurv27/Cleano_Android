package com.example.cleanofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Userfinal extends AppCompatActivity {
    ImageView img2;
    ImageView img1;
    ImageView history;
    ImageView feedback;
    ImageView Contactme;
    ImageView aboutus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userfinal);
        img1=findViewById(R.id.home);
        img2=findViewById(R.id.profile);
        history=findViewById(R.id.history);
        feedback=findViewById(R.id.userfeedback1);
        Contactme=findViewById(R.id.emailus);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Userfinal.this,user.class));
            }
        });

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Userfinal.this,Homefinal.class));
            }
        });
history.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Userfinal.this,RecyclerOrders.class);
        startActivity(intent);

    }
});

feedback.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(Userfinal.this,feedback1.class));

    }
});


Contactme.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(Userfinal.this,MailActivity.class));
    }
});



    }



}