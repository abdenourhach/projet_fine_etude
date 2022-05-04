package com.example.admin_firmly;

import android.annotation.SuppressLint;
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

public class add_3agbo_vaccin extends AppCompatActivity {
    Button submit;

    EditText name1,date_reserve,age1,purl;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singlerow);


        name1 = (EditText) getText(R.id.nametext);


        //**course howa search****************
        date_reserve = (EditText) getText(R.id.coursetext);


//*********************************************************************
        age1 = (EditText) getText(R.id.emailtext);


        //   purl=(EditText)findViewById(R.id.add_purl);




    }

/*
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


        map.put("name1",name1.getText().toString());
        map.put("age1",age1.getText().toString());
        map.put("date_reserve",date_reserve.getText().toString());
        map.put("purl",purl.getText().toString());


        FirebaseDatabase.getInstance().getReference().child("li_3agbovac").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        name1.setText("");
                        age1.setText("");
                        date_reserve.setText("");
                        purl.setText("");
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

    }*/

}