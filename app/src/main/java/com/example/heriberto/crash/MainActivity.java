package com.example.heriberto.crash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.heriberto.crash.Adaptadores.AdapterVerAlmacenes;
import com.example.heriberto.crash.clases.Almacenes;
import com.example.heriberto.crash.vistas.LoginActivity;
import com.example.heriberto.crash.vistas.verAlmacenes;
import com.example.heriberto.crash.vistas.verProductos;

import java.util.ArrayList;

import static com.example.heriberto.crash.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {

    //Button almacenes;
    Button iniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        iniciarSesion = (Button)findViewById(R.id.iniciarSesion);
        iniciarSesion.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent almacenes = new Intent(MainActivity.this, verAlmacenes.class);
                startActivity(almacenes);
            }
        });

       /* almacenes = (Button)findViewById(R.id.almacenes);
        almacenes.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent almacenes = new Intent(MainActivity.this, verAlmacenes.class);
                startActivity(almacenes);
            }
        });*/

        /*RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerCrearProductos);

        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<Productos> mDataset = new ArrayList<>();

        AdapterVerAlmacenes mAdapter = new AdapterVerAlmacenes(mDataset);
        mRecyclerView.setAdapter(mAdapter);*/



        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);*/
    }

}