package com.example.user__admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class tasjile_hajiz_rendifu extends AppCompatActivity {

    CardView c1add,c1add2,c1add3,c1add4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasjile_hajiz_rendifu);















        c1add = findViewById(R.id.add_rendivu);
        c1add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7 = new Intent(tasjile_hajiz_rendifu.this, adddata.class);
                startActivity(intent7);

            }
        });



        c1add2= findViewById(R.id.cancel_rendivu);
        c1add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7 = new Intent(tasjile_hajiz_rendifu.this, cancel_data.class);
                startActivity(intent7);

            }
        });





        c1add3 = findViewById(R.id.edit_rendivu);
        c1add3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7 = new Intent(tasjile_hajiz_rendifu.this, edit_data.class);
                startActivity(intent7);

            }
        });



        c1add4= findViewById(R.id.i3ref_akter);
        c1add4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7 = new Intent(tasjile_hajiz_rendifu.this, i3ref_akter.class);
                startActivity(intent7);

            }
        });




    }
}