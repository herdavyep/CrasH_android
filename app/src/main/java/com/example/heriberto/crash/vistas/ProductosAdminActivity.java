package com.example.heriberto.crash.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.heriberto.crash.Adaptadores.AdapterAdminProductos;
import com.example.heriberto.crash.R;
import com.example.heriberto.crash.clases.Productos;
import com.example.heriberto.crash.clasesEstaticas.AlmacenSeleccionado;

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
        myDataset.add(new Productos("agua",2000,"11","23","500g","45",R.drawable.azucar));

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

        //TextView idProducto = (TextView) view.findViewById(R.id.nombreAdminProducto);

        //String id_almacenSeleccionado = idProducto.getText().toString();
        String id_almacenSeleccionado = "agua";
        AlmacenSeleccionado.setId_almacenSeleccionado(id_almacenSeleccionado);

        Intent E_P = new Intent(ProductosAdminActivity.this, EditarProductoActivity.class);
        startActivity(E_P);
    }

}
