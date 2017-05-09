package com.example.heriberto.crash.vistas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.heriberto.crash.Adaptadores.AdapterVerProductos;
import com.example.heriberto.crash.R;
import com.example.heriberto.crash.clases.Productos;
import com.example.heriberto.crash.firebaseReferencias.Referencias;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class verProductos extends AppCompatActivity {

    FirebaseDatabase myDataBase = FirebaseDatabase.getInstance();
    DatabaseReference myRef = myDataBase.getReference(Referencias.ALMACENES_REFERENCIA).child(Referencias.PRODUCTOS_REFERENCIA);
    ArrayList<Productos> productos;
    AdapterVerProductos mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_productos);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerVerProductos);

        //mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        productos = new ArrayList<>();

        mAdapter = new AdapterVerProductos(productos);

        mRecyclerView.setAdapter(mAdapter);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                productos.removeAll(productos);

                for (DataSnapshot snapshot:
                        dataSnapshot.getChildren()) {

                    Productos producto = snapshot.getValue(Productos.class);

                        productos.add(producto);

                }
                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void atrasP_A(View view){

        onBackPressed();
    }


}


/*productos.add(new Productos("Azucar",2000,"11","23","500g","45",R.drawable.azucar));
        productos.add(new Productos("Sal","2000","11","23","500g","45",R.drawable.sal));
        productos.add(new Productos("Aceite","2000","11","23","500g","45",R.drawable.aceite));
        productos.add(new Productos("Arros Diana","2000","11","23","500g","45",R.drawable.arroz_diana));
        productos.add(new Productos("Frijol","2000","11","23","500g","45",R.drawable.frijoles));
        productos.add(new Productos("Cafe","2000","11","23","500g","45",R.drawable.cafe_));
        productos.add(new Productos("Lentejas","2000","11","23","500g","45",R.drawable.lentejas));
        productos.add(new Productos("Panela","2000","11","23","Atao","45",R.drawable.panela));*/