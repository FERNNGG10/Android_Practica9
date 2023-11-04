package com.example.android_practica9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.android_practica9.adapters.EquipoAdapter;
import com.example.android_practica9.models.Equipo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity implements EquipoAdapter.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        List <Equipo> Lista_equipos = new ArrayList<>();
        Lista_equipos.add(new Equipo("Santos","Torreón",6, R.drawable.santos));
        Lista_equipos.add(new Equipo("Chivas","Guadalajara",13, R.drawable.chivas));
        Lista_equipos.add(new Equipo("Mazatlan","Mazatlan",0, R.drawable.mazatlan));

        EquipoAdapter equipoAdapter= new EquipoAdapter(Lista_equipos);
        RecyclerView recyclerView =findViewById(R.id.Requipos);
        recyclerView.setAdapter(equipoAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        equipoAdapter.setOnClickListener(this);
    }

    @Override
    public void onClick(int position, Equipo model) {
        Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
        intent.putExtra("Equipo",model);
        startActivity(intent);
    }
}