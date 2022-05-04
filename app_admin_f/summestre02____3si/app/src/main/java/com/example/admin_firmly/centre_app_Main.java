package com.example.admin_firmly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.google.android.material.navigation.NavigationView;

public class centre_app_Main extends AppCompatActivity {

Window window;
    CardView cardView1, cardView2, cardView3, cardView4;


    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mtouggle;

    private NavigationView navigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centre_app__main);




if(Build.VERSION.SDK_INT==22){
window=this.getWindow();
window.setStatusBarColor(this.getResources().getColor(R.color.ararara));
}



//___________________________1111_____________________tasjil01______________________
        cardView1 = findViewById(R.id.mou3id_maadat);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(centre_app_Main.this, MainActivity.class);
                startActivity(intent);

            }
        });


//__________________________22222______________________chat______________________
        cardView2 = findViewById(R.id.tal9ih_maadat);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(centre_app_Main.this, Main_vaccination.class);
                startActivity(intent);

            }
        });


        //__________________________333333_____________________program______________________

        cardView1 = findViewById(R.id.barnamag_vac);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(centre_app_Main.this, Send_notf_ma3niyin.class);
                startActivity(intent);

            }
        });


//__________________________444444_____________________nasaiiih______________________________________
        cardView2 = findViewById(R.id.nasaiiiih_dz);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(centre_app_Main.this, Archif_DZ.class);
                startActivity(intent);

            }
        });




        //__________________________555555_____________________send_notif______________________

        cardView1 = findViewById(R.id.send_notif);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(centre_app_Main.this, nasaiih_DZ.class);
                startActivity(intent);

            }
        });


//__________________________666666_____________________archiiff______________________________________
        cardView2 = findViewById(R.id.archif);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(centre_app_Main.this,couter_chat.class);
                startActivity(intent);

            }
        });

















        DrawerLayout drawerLayout;
        drawerLayout = findViewById(R.id.drawer);

        mtouggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(mtouggle);
        mtouggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //*****************************************

        navigationView = (NavigationView) findViewById(R.id.drawer_nav);
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(item -> {


            switch (item.getItemId()) {

                case R.id.about:
                    Intent intent = new Intent(centre_app_Main.this, about_app_menu.class);
                    startActivity(intent);
                    break;

                case R.id.setting:
                    Intent intent2 = new Intent(centre_app_Main.this, setting_menu.class);
                    startActivity(intent2);
                    break;


                case R.id.share:
                    Intent intent3 = new Intent(centre_app_Main.this, share_menu.class);
                    startActivity(intent3);
                    break;

                case R.id.how_are_we:
                    Intent intent4 = new Intent(centre_app_Main.this, who_are_we.class);
                    startActivity(intent4);
                    break;
                case R.id.ta9im:
                    Intent intent7 = new Intent(centre_app_Main.this,ta9yiim.class);
                    startActivity(intent7);
                    break;

                case R.id.call_me:
                    Intent intent5 = new Intent(centre_app_Main.this, call_me_menu.class);
                    startActivity(intent5);
                    break;
                case R.id.logout:
                    Intent intent6 = new Intent(centre_app_Main.this,logout_menu.class);
                    startActivity(intent6);
                    break;

            }
            return true;

        });



    }


/*

    @Override
    public boolean onCreateOptionsMenu(Menu menu ){
        getMenuInflater().inflate(R.menu.menu,menu);


       for(int i=0;i<menu.size();i++){
           MenuItem menuItem= menu.getItem(i);
           SpannableString spannable=new SpannableString(
                   menu.getItem(i).getTitle().toString()
           );
spannable.setSpan(new ForegroundColorSpan(Color.WHITE),0 ,spannable.length(),0);
       menuItem.setTitle(spannable);
       }
        return true;


                                               }
*/



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (mtouggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);

    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;

    }
*/
}


















