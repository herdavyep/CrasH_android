package com.example.heriberto.crash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.heriberto.crash.Adaptadores.AdapterVerAlmacenes;
import com.example.heriberto.crash.clases.Almacenes;
import com.example.heriberto.crash.firebaseReferencias.Referencias;
import com.example.heriberto.crash.vistas.LoginActivity;
import com.example.heriberto.crash.vistas.VistaAdminActivity;
import com.example.heriberto.crash.vistas.verAlmacenes;
import com.example.heriberto.crash.vistas.verProductos;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import static com.example.heriberto.crash.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {

    //Button almacenes;
   // Button iniciarSesion;
    private String admin = "hdycotecnova@gmail.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        /*if (user.getEmail().equals(admin)){

            Intent almacenes = new Intent(MainActivity.this, VistaAdminActivity.class);
            startActivity(almacenes);
            finish();

        }else*/ if (user != null){

            Intent login = new Intent(MainActivity.this, verAlmacenes.class);
            startActivity(login);
            finish();
        }else {

            Intent login = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(login);
            finish();
        }


    }

}

        /*iniciarSesion = (Button)findViewById(R.id.iniciarSesion);
        iniciarSesion.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent almacenes = new Intent(MainActivity.this, verAlmacenes.class);
                startActivity(almacenes);
            }
        });*/

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

        ArrayList<ProductosEditar> mDataset = new ArrayList<>();

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
