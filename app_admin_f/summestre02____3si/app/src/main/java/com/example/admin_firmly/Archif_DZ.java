package com.example.admin_firmly;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.google.android.material.navigation.NavigationView;

public class Archif_DZ extends AppCompatActivity {
    Window window;
    CardView cardView1, cardView2, cardView3, cardView4;


    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mtouggle;

    private NavigationView navigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archif__d_z);


//___________________________1111_____________________tasjil01______________________
        cardView1 = findViewById(R.id.mou3id_maadat);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Archif_DZ.this, Maadat_main.class);
                startActivity(intent);

            }
        });


//__________________________22222______________________chat______________________
        cardView2 = findViewById(R.id.tal9ih_maadat);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Archif_DZ.this, Maadat_main.class);
                startActivity(intent);

            }
        });




//__________________________22222______________________chat______________________
        cardView3 = findViewById(R.id.statickk);
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Archif_DZ.this, statistic.class);
                startActivity(intent);

            }
        });


















    }
}