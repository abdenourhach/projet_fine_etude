package com.example.admin_firmly;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;
public class Maadat_main extends AppCompatActivity {


    RecyclerView recview03;
    myadapter02 adapter03;
    FloatingActionButton fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maadat_main);
        setTitle("ابحث هنا...");

        recview03=(RecyclerView)findViewById(R.id.recview03);
        recview03.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<model02> options =
                new FirebaseRecyclerOptions.Builder<model02>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("mouadat"), model02.class)
                        .build();


        adapter03=new myadapter02(options);
        recview03.setAdapter(adapter03);

        fb=(FloatingActionButton)findViewById(R.id.fadd03);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),add_data_vaccination.class));
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        adapter03.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter03.stopListening();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.searchmenu,menu);

        MenuItem item=menu.findItem(R.id.search);

        SearchView searchView=(SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextSubmit(String s) {

                processsearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                processsearch(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void processsearch(String s)
    {
        FirebaseRecyclerOptions<model02> options =
                new FirebaseRecyclerOptions.Builder<model02>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("moadatt").orderByChild("age").startAt(s).endAt(s+"\uf8ff"), model02.class)
                        .build();

        adapter03=new myadapter02(options);
        adapter03.startListening();
        recview03.setAdapter(adapter03);

    }
}