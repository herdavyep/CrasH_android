package com.example.heriberto.crash.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.heriberto.crash.Adaptadores.AdapterAdminAlmacenes;
import com.example.heriberto.crash.R;
import com.example.heriberto.crash.clases.Almacenes;
import com.example.heriberto.crash.firebaseReferencias.Referencias;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AlmacenesAdminActivity extends AppCompatActivity {

    ArrayList<Almacenes> almacenes;

    FirebaseDatabase myDataBase = FirebaseDatabase.getInstance();
    DatabaseReference myRef = myDataBase.getReference(Referencias.ALMACEN_REFERENCIA).child(Referencias.ALMACENES_REFERENCIA);
    AdapterAdminAlmacenes mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_almacenes_admin);


        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerAdminVerAlmacenes);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        almacenes = new ArrayList<>();

        mAdapter = new AdapterAdminAlmacenes(almacenes,this);

        mRecyclerView.setAdapter(mAdapter);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                almacenes.removeAll(almacenes);

                for (DataSnapshot snapshot:
                        dataSnapshot.getChildren()) {

                    Almacenes almacen = snapshot.getValue(Almacenes.class);

                    almacenes.add(almacen);

                }
                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void crearAlmacenAdmin (View view){

        Intent C_A = new Intent(AlmacenesAdminActivity.this, CrearAlmacenesActivity.class);
        startActivity(C_A);
    }


}
