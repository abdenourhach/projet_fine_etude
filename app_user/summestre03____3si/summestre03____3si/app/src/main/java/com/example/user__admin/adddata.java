package com.example.user__admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class adddata extends AppCompatActivity
{
   EditText name,age,nombre_pere,purl;
   Button submit,back ,taajil;
private  EditText input,input2,input3,input4,input5;

private DatabaseReference rootDatabaseref;
private TextView textView,textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddata);

        name=(EditText)findViewById(R.id.cert_prenom);
        age=(EditText)findViewById(R.id.cert_nom);
        nombre_pere=(EditText)findViewById(R.id.cert_age);
        purl=(EditText)findViewById(R.id.date_cert_dema);

        back=(Button)findViewById(R.id.add_back_cert);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),tasjile_hajiz_rendifu.class));
                finish();
            }
        });


        taajil=(Button)findViewById(R.id.taajii);
        taajil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
int id=Integer.parseInt(input.getText().toString());
String name=input2.getText().toString();
String age=input3.getText().toString();
String nombre_pere=input4.getText().toString();
String purl=input5.getText().toString();


HashMap hashMap=new HashMap();
hashMap.put("name",name);
hashMap.put("age",age);
hashMap.put("nombre_pere",nombre_pere);
hashMap.put("purl",purl);

                rootDatabaseref.child("students").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(getApplicationContext(),"edit new info UPdated Successfully", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });



  //****************************************************************************************************
        submit=(Button)findViewById(R.id.add_submit_cert);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processinsert();
            }
        });
    }








    private void processinsert()
    {
        int id=Integer.parseInt(input.getText().toString());
        Map<String, Object> map=new HashMap<>();
        map.put("name",name.getText().toString());
        map.put("age",age.getText().toString());
        map.put("nombre_pere",nombre_pere.getText().toString());
        map.put("purl",purl.getText().toString());
        FirebaseDatabase.getInstance().getReference().child("students").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                       name.setText("");
                       age.setText("");
                        nombre_pere.setText("");
                       purl.setText("");
                        Toast.makeText(getApplicationContext(),"Inserted Successfully", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e)
                    {
                        Toast.makeText(getApplicationContext(),"Could not insert", Toast.LENGTH_LONG).show();
                    }
                });

    }
}