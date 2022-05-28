package com.example.petapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.petapp.R;
import com.example.petapp.core.Data;
import com.example.petapp.domain.AdapterPets;
import com.example.petapp.domain.Pet;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SecondActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        recyclerView = findViewById(R.id.recyclerView);
        back = findViewById(R.id.back);

        String dataPets = Data.DATA_PET_FAVORITE;

        Pet data = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().fromJson(dataPets, Pet.class);

        if(data.getPets().size() > 0){
            AdapterPets adapter = new AdapterPets(data.getPets());

            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        }

        back.setOnClickListener(v -> onBackPressed());
    }
}