package com.example.heriberto.crash.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.heriberto.crash.Adaptadores.AdapterAdminProductos;
import com.example.heriberto.crash.Adaptadores.AdapterVerProductos;
import com.example.heriberto.crash.R;
import com.example.heriberto.crash.clases.Productos;
import com.example.heriberto.crash.clasesEstaticas.AlmacenSeleccionado;
import com.example.heriberto.crash.firebaseReferencias.Referencias;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ProductosAdminActivity extends AppCompatActivity {

    FirebaseDatabase myDataBase = FirebaseDatabase.getInstance();
    DatabaseReference myRef = myDataBase.getReference(Referencias.ALMACEN_REFERENCIA).child(Referencias.PRODUCTOS_REFERENCIA);
    ArrayList<Productos> productos;
    AdapterAdminProductos mAdapter;
    String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_admin);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerAdminVerProductos);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        productos = new ArrayList<>();

        mAdapter = new AdapterAdminProductos(productos,this);

        mRecyclerView.setAdapter(mAdapter);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                productos.removeAll(productos);

                for (DataSnapshot snapshot:
                        dataSnapshot.getChildren()) {

                        Productos producto = snapshot.getValue(Productos.class);

                        productos.add(producto);
                        nombre=producto.getNombre();

                }
                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



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

        //editarProductoL();
    }

    public void editarProductoL (View view){

        TextView idProducto = (TextView) view.findViewById(R.id.nombreAdminProducto);

        //String id_almacenSeleccionado = idProducto.getText().toString();
        //String id_almacenSeleccionado = "agua";
        //AlmacenSeleccionado.setId_almacenSeleccionado(id_almacenSeleccionado);
        AlmacenSeleccionado.setId_almacenSeleccionado(idProducto.getText().toString());

        Intent E_P = new Intent(ProductosAdminActivity.this, EditarProductoActivity.class);
        startActivity(E_P);
    }

}
