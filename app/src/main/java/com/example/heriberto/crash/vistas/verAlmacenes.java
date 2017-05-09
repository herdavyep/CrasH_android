package com.example.heriberto.crash.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.heriberto.crash.Adaptadores.AdapterVerAlmacenes;
import com.example.heriberto.crash.MainActivity;
import com.example.heriberto.crash.R;
import com.example.heriberto.crash.clases.Almacenes;
import com.example.heriberto.crash.firebaseReferencias.Referencias;
import com.example.heriberto.crash.modelos.Almacen;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class verAlmacenes extends AppCompatActivity {

    Button u;
    Button a;
    Button e;
    ArrayList<Almacenes> myDataset = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_almacenes);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerVerAlmacenes);

        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);



        myDataset.add(new Almacenes("ara","cra 7 # 13 - 111","3146487711","cartago",R.drawable.ara));
        myDataset.add(new Almacenes("D1","cra 10 # 13 - 111","3146487661","cartago",R.drawable.d1));
        myDataset.add(new Almacenes("Exito","cra 4 # 13 - 111","3146487711","cartago",R.drawable.exito));
        myDataset.add(new Almacenes("Super Inter","cra 11 # 13 - 111","3144487711","cartago",R.drawable.superinter));
        myDataset.add(new Almacenes("Olimpica","cra 9 # 13 - 111","3146487711","cartago",R.drawable.olimpica));
        myDataset.add(new Almacenes("Comfandi","cra 5 # 13 - 111","3146486611","cartago",R.drawable.comfandi));
        myDataset.add(new Almacenes("Colsubsidio","cra 1 # 13 - 111","3146007711","cartago",R.drawable.colsubsidio));
        myDataset.add(new Almacenes("Metro","cra 7 # 13 - 111","3146487121","cartago",R.drawable.metro));

        AdapterVerAlmacenes mAdapter = new AdapterVerAlmacenes(myDataset);
        mRecyclerView.setAdapter(mAdapter);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        TextView usuario = (TextView) findViewById(R.id.user);

        usuario.setText("hola "+ user.getUid());




        u = (Button) findViewById(R.id.crearProducto);
        u.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent productos = new Intent(verAlmacenes.this, VistaAdminActivity.class);
                startActivity(productos);
            }
        });

        /*a = (Button) findViewById(R.id.CerrarSesion);
        a.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext()," Sesion Terminada",Toast.LENGTH_SHORT).show();
                FirebaseAuth.getInstance().signOut();
                //Log.d("chad");
                Intent IrLogin = new Intent(verAlmacenes.this, LoginActivity.class);
                startActivity(IrLogin);
                finish();
            }
        });*/

        e = (Button) findViewById(R.id.IrProductos);
        e.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent productos = new Intent(verAlmacenes.this, verProductos.class);
                startActivity(productos);
            }
        });

        /*FirebaseDatabase myDataBase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = myDataBase.getReference(Referencias.TUTORIAL_REFERENCE);

        myRef.push().setValue(1);
        // tambien puede ser este si solo quiero cojer el valor una vez addListenerForSingleValueEvent
        ValueEventListener valueEventListener = new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                int valor = dataSnapshot.getValue(Integer.class);

                Log.e("DATOS", valor+"");


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Log.e("ERROR", databaseError.getMessage());

            }
        };

        myRef.addValueEventListener(valueEventListener);*/
    }

    public void cerrarSesion(View view){

        FirebaseAuth.getInstance().signOut();
        Toast.makeText(getApplicationContext(),"Sesion Terminada",Toast.LENGTH_SHORT).show();
        Intent IrLogin = new Intent(verAlmacenes.this, LoginActivity.class);
        startActivity(IrLogin);
        finish();
    }

    public void IrProductos (View view){

        Intent IrLogin = new Intent(verAlmacenes.this, verProductos.class);
        startActivity(IrLogin);
    }

}
