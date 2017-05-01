package com.example.heriberto.crash.vistas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.heriberto.crash.Adaptadores.AdapterVerProductos;
import com.example.heriberto.crash.R;
import com.example.heriberto.crash.clases.Productos;

import java.util.ArrayList;

public class verProductos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_productos);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerVerProductos);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        ArrayList<Productos> myDataset = new ArrayList<>();
        myDataset.add(new Productos("Azucar","2000","11","23","500g","45",R.drawable.azucar));
        myDataset.add(new Productos("Sal","2000","11","23","500g","45",R.drawable.sal));
        myDataset.add(new Productos("Aceite","2000","11","23","500g","45",R.drawable.aceite));
        myDataset.add(new Productos("Arros Diana","2000","11","23","500g","45",R.drawable.arroz_diana));
        myDataset.add(new Productos("Frijol","2000","11","23","500g","45",R.drawable.frijoles));
        myDataset.add(new Productos("Cafe","2000","11","23","500g","45",R.drawable.cafe_));
        myDataset.add(new Productos("Lentejas","2000","11","23","500g","45",R.drawable.lentejas));
        myDataset.add(new Productos("Panela","2000","11","23","Atao","45",R.drawable.panela));

        AdapterVerProductos mAdapter = new AdapterVerProductos(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }



}


