package com.example.user__admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

public class tasjile_hajiz_rendifu extends AppCompatActivity {

    CardView c1add,c1add2,c1add3,c1add4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasjile_hajiz_rendifu);

     //   rootDatabaseref= FirebaseDatabase.getInstance().getReference().child(students);















        c1add = findViewById(R.id.tasjil01);
        c1add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7 = new Intent(tasjile_hajiz_rendifu.this, adddata.class);
                startActivity(intent7);

            }
        });



        c1add3 = findViewById(R.id.mawa3idy);
        c1add3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7 = new Intent(tasjile_hajiz_rendifu.this, edit_data.class);
                startActivity(intent7);

            }
        });



        c1add4 = findViewById(R.id.ta3dil011);
        c1add4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });








        c1add2=findViewById(R.id.i3ref01);
        c1add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });




            }






    }
