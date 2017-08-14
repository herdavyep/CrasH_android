package com.example.heriberto.crash.vistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.heriberto.crash.Adaptadores.AdapterVerProductos;
import com.example.heriberto.crash.Adaptadores.AdapterVerProductos2;
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

public class VerProductos2Activity extends AppCompatActivity {

    FirebaseDatabase myDataBase = FirebaseDatabase.getInstance();
    DatabaseReference myRef = myDataBase.getReference(Referencias.ALMACEN_REFERENCIA).child(Referencias.PRODUCTOS_REFERENCIA);
    ArrayList<Productos> productos;
    AdapterVerProductos2 mAdapter;
    String idAlmacen = AlmacenSeleccionado.getId_almacenSeleccionado();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_productos2);


        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerVerProductos);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        productos = new ArrayList<>();

        mAdapter = new AdapterVerProductos2(productos,this);

        mRecyclerView.setAdapter(mAdapter);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                productos.removeAll(productos);

                for (DataSnapshot snapshot:
                        dataSnapshot.getChildren()) {

                    Productos producto = snapshot.getValue(Productos.class);

                    if (idAlmacen.equals(producto.getId_almacen())){

                        productos.add(producto);

                    }

                }
                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
