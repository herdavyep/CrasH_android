package com.example.heriberto.crash.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.heriberto.crash.Adaptadores.AdapterAdminProductos;
import com.example.heriberto.crash.Adaptadores.AdapterVerProductos;
import com.example.heriberto.crash.R;
import com.example.heriberto.crash.clases.Productos;

import java.util.ArrayList;

public class ProductosAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_admin);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerAdminVerProductos);

        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<Productos> myDataset = new ArrayList<>();
        myDataset.add(new Productos("Azucar",2000,"11","23","500g","45",R.drawable.azucar));
        /*productos.add(new Productos("Sal","2000","11","23","500g","45",R.drawable.sal));
        productos.add(new Productos("Aceite","2000","11","23","500g","45",R.drawable.aceite));
        productos.add(new Productos("Arros Diana","2000","11","23","500g","45",R.drawable.arroz_diana));
        productos.add(new Productos("Frijol","2000","11","23","500g","45",R.drawable.frijoles));
        productos.add(new Productos("Cafe","2000","11","23","500g","45",R.drawable.cafe_));
        productos.add(new Productos("Lentejas","2000","11","23","500g","45",R.drawable.lentejas));
        productos.add(new Productos("Panela","2000","11","23","Atao","45",R.drawable.panela));*/

        AdapterAdminProductos mAdapter = new AdapterAdminProductos(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void VolverP_A(View view){

        Intent admin = new Intent(ProductosAdminActivity.this, VistaAdminActivity.class);
        startActivity(admin);
        finish();
    }

    public void crearProducto (View view){

        Intent C_P = new Intent(ProductosAdminActivity.this, CrearProductoActivity.class);
        startActivity(C_P);
    }

    public void editarProducto (View view){

        Intent E_P = new Intent(ProductosAdminActivity.this, EditarProductoActivity.class);
        startActivity(E_P);
    }

}
