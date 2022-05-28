package com.example.petapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.QuickContactBadge;

import com.example.petapp.R;
import com.example.petapp.core.Data;
import com.example.petapp.domain.AdapterPets;
import com.example.petapp.domain.Pet;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        star = findViewById(R.id.star);

        String dataPets = Data.DATA_PET;

        Pet data = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().fromJson(dataPets, Pet.class);

        if(data.getPets().size() > 0){
            AdapterPets adapter = new AdapterPets(data.getPets());

            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        }

        star.setOnClickListener(v -> {
            startActivity(new Intent(this, SecondActivity.class));
        });
    }
}