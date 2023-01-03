package com.example.cleanofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CleanoMainpage extends AppCompatActivity {
    Button user;
    Button driver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleano_mainpage);
        user=findViewById(R.id.mainuser);
        driver=findViewById(R.id.maindriver);




        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CleanoMainpage.this,MainActivity.class));
            }
        });


        driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CleanoMainpage.this,DriverLogin.class));

            }
        });



    }
}