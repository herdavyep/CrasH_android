package com.example.heriberto.crash.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.heriberto.crash.Adaptadores.AdapterVerPromo;
import com.example.heriberto.crash.R;
import com.example.heriberto.crash.clases.Promociones;
import com.example.heriberto.crash.clasesEstaticas.AlmacenSeleccionado;
import com.example.heriberto.crash.firebaseReferencias.Referencias;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class VerPromoActivity extends AppCompatActivity {

    ArrayList<Promociones> promociones;

    FirebaseDatabase myDataBase = FirebaseDatabase.getInstance();
    DatabaseReference myRef = myDataBase.getReference(Referencias.ALMACEN_REFERENCIA).child(Referencias.PROMOCIONES_REFERENCE);
    AdapterVerPromo mAdapter;
    String idAlmacen = AlmacenSeleccionado.getId_almacenSeleccionado();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_promo);


        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerVerPromo);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        promociones = new ArrayList<>();

        mAdapter = new AdapterVerPromo(promociones,this);

        mRecyclerView.setAdapter(mAdapter);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                promociones.removeAll(promociones);

                for (DataSnapshot snapshot:
                        dataSnapshot.getChildren()) {

                    Promociones promocion = snapshot.getValue(Promociones.class);

                    if (idAlmacen.equals(promocion.getId_almacen())){

                        promociones.add(promocion);
                    }

                }
                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }

    public void IrProductos (View view){

        TextView idAlmacen = (TextView) view.findViewById(R.id.id_almacenOcultoPromo);

        String id_almacenSeleccionado = idAlmacen.getText().toString();
        AlmacenSeleccionado.setId_almacenSeleccionado(id_almacenSeleccionado);

        Intent IrLogin = new Intent(VerPromoActivity.this, verProductos.class);
        //Toast.makeText(getApplicationContext(),id_almacenSeleccionado,Toast.LENGTH_SHORT).show();
        startActivity(IrLogin);
    }

    public void atrasPromo_A(View view){

        onBackPressed();
    }

}
