package com.example.cleanofinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Contact_admin_page extends AppCompatActivity {
    private Spinner spinner;
    private EditText describe;
    Button Contact_admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_admin_page);
        spinner=findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Issues, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner=findViewById(R.id.spinner2);
        describe=findViewById(R.id.admincomplaint);
        Contact_admin=findViewById(R.id.Contact_admin);
          Contact_admin.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Map<String,String> v=new HashMap<>();
                  v.put("Issue",spinner.getSelectedItem().toString());
                  v.put("Complaint",describe.getText().toString());



                  FirebaseFirestore.getInstance().collection("Driver_Complaint") .add(v).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                      @Override
                      public void onComplete(@NonNull Task<DocumentReference> task) {

                          Toast.makeText(getApplicationContext(), "Complaint Register Successfully", Toast.LENGTH_SHORT).show();
                          Intent intent = new Intent (Contact_admin_page.this, Contact_admin_page.class);







                      }
                  } );



              }
          });
    }}