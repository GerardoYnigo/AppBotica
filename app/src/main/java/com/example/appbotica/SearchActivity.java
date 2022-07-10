package com.example.appbotica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.AnimationDrawable;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.widget.SearchView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements RecyclerViewProduct{


    DatabaseReference ref;
    ArrayList<Products> list;
    RecyclerView rv;
    SearchView searchView;
    AdapterProduct adapter;
    LinearLayoutManager lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        LinearLayout linearLayout = findViewById(R.id.searchLayout);

        AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        ref = FirebaseDatabase.getInstance().getReference().child("Products");
        rv = findViewById(R.id.rv);
        searchView = findViewById(R.id.search);
        lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        list = new ArrayList<>();
        adapter = new AdapterProduct(list, this);
        rv.setAdapter(adapter);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                        Products p = snapshot.getValue(Products.class);
                        list.add(p);
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                buscar(s);
                return false;
            }

        });
    }
    private void buscar(String s) {
        ArrayList<Products>milista = new ArrayList<>();
        for (Products obj: list){
            if (obj.getNameproduct().toLowerCase().contains(s.toLowerCase())){
                milista.add(obj);
            }

        }
        AdapterProduct adapter = new AdapterProduct(milista,null);
        rv.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(SearchActivity.this, ProductDetail.class);
        intent.putExtra("NAMEP",list.get(position).getNameproduct());
        intent.putExtra("PRICE",list.get(position).getPrice());
        intent.putExtra("DATAEXPIRATION",list.get(position).getDateexpiration());
        intent.putExtra("NAMEBOTICA",list.get(position).getNamebotica());
        intent.putExtra("DIRECTION",list.get(position).getDirectionbotica());
        startActivity(intent);
    }
}