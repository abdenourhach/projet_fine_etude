package com.example.user__admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    CardView cardView1, cardView2, cardView3, cardView4,cardView5,cardView6;
   // TextView beconf;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mtouggle;

    private NavigationView navigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    /*    beconf=findViewById(R.id.be);
        beconf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });*/




//_____________________________________________111___chat______________________
        cardView1 = findViewById(R.id.ta3dil011);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);

            }
        });




//_________________________________________   02222_______tasjil01______________________
        cardView2 = findViewById(R.id.tasjil01);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, tasjile_hajiz_rendifu.class);
                startActivity(intent1);

            }
        });


        //__________________________333333_____________________program______________________

        cardView4 = findViewById(R.id.mawa3idy);
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, program_vac_DZ.class);
                startActivity(intent2);

            }
        });

//*****************************4444_______________________

        cardView3 = findViewById(R.id.i3ref01);
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this, nasaiih_DZ.class);
                startActivity(intent3);

            }
        });

//---------------------------------5555555555_____________________

        cardView5 = findViewById(R.id.demmandc);
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this, Mwa3idy.class);
                startActivity(intent3);

            }
        });





        cardView6 = findViewById(R.id.machine_learning);
        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this, MLT.class);
                startActivity(intent3);

            }
        });




























        DrawerLayout drawerLayout;
        drawerLayout = findViewById(R.id.drawer);
        mtouggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(mtouggle);
        mtouggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        navigationView = (NavigationView) findViewById(R.id.drawer_nav);
        navigationView.bringToFront(); navigationView.setNavigationItemSelectedListener(item -> {

            switch (item.getItemId()) {

                case R.id.about:
                    Intent intent = new Intent(MainActivity.this, about_app_menu.class);
                    startActivity(intent);
                    break;

                case R.id.setting:
                    Intent intent2 = new Intent(MainActivity.this, setting_menu.class);
                    startActivity(intent2);
                    break;


                case R.id.share:
                    Intent intent3 = new Intent(MainActivity.this, share_menu.class);
                    startActivity(intent3);
                    break;

                case R.id.how_are_we:
                    Intent intent4 = new Intent(MainActivity.this, who_are_we.class);
                    startActivity(intent4);
                    break;
                case R.id.ta9im:
                    Intent intent7 = new Intent(MainActivity.this,ta9yiim.class);
                    startActivity(intent7);
                    break;

                case R.id.call_me:
                    Intent intent5 = new Intent(MainActivity.this, call_me_menu.class);
                    startActivity(intent5);
                    break;
                case R.id.logout:
                    Intent intent6 = new Intent(MainActivity.this,logout_menu.class);
                    startActivity(intent6);
                    break;

            }
            return true;

        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (mtouggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);

    }
}