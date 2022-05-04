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

public class Main_vaccination extends AppCompatActivity
{
    RecyclerView recview02;
    myadapter02 adapter02;
    FloatingActionButton fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_vaccination);

        setTitle("ابحث هنا...");

        recview02=(RecyclerView)findViewById(R.id.recview02);
        recview02.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<model02> options =
                new FirebaseRecyclerOptions.Builder<model02>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("listvac"), model02.class)
                        .build();


        adapter02=new myadapter02(options);
        recview02.setAdapter(adapter02);

        fb=(FloatingActionButton)findViewById(R.id.fadd02);
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
        adapter02.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter02.stopListening();
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
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("listvac").orderByChild("age").startAt(s).endAt(s+"\uf8ff"), model02.class)
                        .build();

        adapter02=new myadapter02(options);
        adapter02.startListening();
        recview02.setAdapter(adapter02);

    }
}