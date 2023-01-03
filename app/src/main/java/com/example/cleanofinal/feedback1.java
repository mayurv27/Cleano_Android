package com.example.cleanofinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class feedback1 extends AppCompatActivity {
   private EditText name;
    private EditText userfeedback;
    private Button feedbackbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback1);
        name = findViewById(R.id.feedname);
        userfeedback = findViewById(R.id.userfeedback1);
        feedbackbtn = findViewById(R.id.feeddbackbtn1);


        feedbackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Map<String, String> v = new HashMap<>();
                v.put("Name", name.getText().toString());
                v.put("Feedback",userfeedback.getText().toString());

                FirebaseFirestore.getInstance().collection("Feedback").add(v).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {


                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        Toast.makeText(getApplicationContext(), "feeback entered", Toast.LENGTH_SHORT).show();
                    }


                });

            }
        });
    }}