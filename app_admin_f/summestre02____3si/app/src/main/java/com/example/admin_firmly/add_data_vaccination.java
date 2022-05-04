package com.example.admin_firmly;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class add_data_vaccination extends AppCompatActivity
{
    EditText name02,age02,nombre_pere02,purl02;
    Button submit,back;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data_vaccination);



        name02=(EditText)findViewById(R.id.add_name01);
        age02=(EditText)findViewById(R.id.add_email01);

        //**course howa search****************
        nombre_pere02=(EditText)findViewById(R.id.add_course01);


        purl02=(EditText)findViewById(R.id.add_purl01);


        //********************************************************
        back=(Button)findViewById(R.id.add_back01);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Main_vaccination.class));
                finish();
            }
        });

//**********************************************************************




        submit=(Button)findViewById(R.id.add_submit01);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processinsert();
            }
        });


    }

    private void processinsert()
    {
        Map<String,Object> map=new HashMap<>();
        map.put("name02",name02.getText().toString());
        map.put("age02",age02.getText().toString());
        map.put("nombre_pere02",nombre_pere02.getText().toString());
        map.put("purl02",purl02.getText().toString());
        FirebaseDatabase.getInstance().getReference().child("listvac").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        name02.setText("");
                        age02.setText("");
                        nombre_pere02.setText("");
                        purl02.setText("");
                        Toast.makeText(getApplicationContext(),"Inserted Successfully",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e)
                    {
                        Toast.makeText(getApplicationContext(),"Could not insert",Toast.LENGTH_LONG).show();
                    }
                });

    }
}