package com.example.user__admin;

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

public class demmande_certaficat extends AppCompatActivity
{
    EditText name,age,prenom,purl_date;
    Button submit,backk;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demmande_certaficat);

        prenom=(EditText)findViewById(R.id.cert_prenom);
        name=(EditText)findViewById(R.id.cert_nom);
        age=(EditText)findViewById(R.id.cert_age);
        purl_date=(EditText)findViewById(R.id.date_cert_dema);

      backk=(Button)findViewById(R.id.add_back_cert);
        backk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });

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
        Map<String, Object> map=new HashMap<>();
        map.put("name",name.getText().toString());
        map.put("prenom",prenom.getText().toString());
        map.put("age",age.getText().toString());
        map.put("purl_date",purl_date.getText().toString());
        FirebaseDatabase.getInstance().getReference().child("demmande_certaficat").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        name.setText("");
                        prenom.setText("");
                        age.setText("");
                        purl_date.setText("");
                        Toast.makeText(getApplicationContext(),"تم الطلب بنجاج", Toast.LENGTH_LONG).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e)
                    {
                        Toast.makeText(getApplicationContext(),"لم يم الطلب بنجاح", Toast.LENGTH_LONG).show();
                    }
                });

    }
}