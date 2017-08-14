package com.example.heriberto.crash.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.heriberto.crash.Adaptadores.AdapterVerAlmacenes;
import com.example.heriberto.crash.R;
import com.example.heriberto.crash.clases.Almacenes;
import com.example.heriberto.crash.clases.Productos;
import com.example.heriberto.crash.clasesEstaticas.AlmacenSeleccionado;
import com.example.heriberto.crash.firebaseReferencias.Referencias;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class verAlmacenes extends AppCompatActivity {

    Button u;
    Button a;
    Button e;
    ArrayList<Almacenes> almacenes;

    FirebaseDatabase myDataBase = FirebaseDatabase.getInstance();
    DatabaseReference myRef = myDataBase.getReference(Referencias.ALMACEN_REFERENCIA).child(Referencias.ALMACENES_REFERENCIA);
    AdapterVerAlmacenes mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_almacenes);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerVerAlmacenes);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        almacenes = new ArrayList<>();

        mAdapter = new AdapterVerAlmacenes(almacenes,this);

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


        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final TextView usuario = (TextView) findViewById(R.id.user);
        String email = user.getEmail();

        usuario.setText("hola "+ email);

    }

    public void BotonOpcion(View view) {

        PopupMenu popup = new PopupMenu(this, view);
        popup.getMenuInflater().inflate(R.menu.menu_opciones, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.cerrar_sesion:
                        cerrarSesion();
                        return true;
                    case R.id.vistaAdmin:
                        ir_Admin();
                        return true;
                    default:
                        return false;
                }
            }
        });
        popup.show();
    }

    public void cerrarSesion(){

        FirebaseAuth.getInstance().signOut();
        LoginManager.getInstance().logOut();
        Toast.makeText(getApplicationContext(),"Sesion Terminada",Toast.LENGTH_SHORT).show();
        Intent IrLogin = new Intent(verAlmacenes.this, LoginActivity.class);
        startActivity(IrLogin);
        finish();
    }

    public void ir_Admin (){

        Intent IrLogin = new Intent(verAlmacenes.this, VistaAdminActivity.class);
        //IrLogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(IrLogin);
    }


    public void IrPromo (View view){

        TextView idAlmacen = (TextView) view.findViewById(R.id.id_almacenOculto);

        String id_almacenSeleccionado = idAlmacen.getText().toString();
        AlmacenSeleccionado.setId_almacenSeleccionado(id_almacenSeleccionado);

        Intent IrLogin = new Intent(verAlmacenes.this, verProductos.class);
        //IrLogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(IrLogin);
    }

}






/*almacenes.add(new Almacenes("ara","cra 7 # 13 - 111","3146487711","cartago",R.drawable.ara));
        almacenes.add(new Almacenes("D1","cra 10 # 13 - 111","3146487661","cartago",R.drawable.d1));
        almacenes.add(new Almacenes("Exito","cra 4 # 13 - 111","3146487711","cartago",R.drawable.exito));
        almacenes.add(new Almacenes("Super Inter","cra 11 # 13 - 111","3144487711","cartago",R.drawable.superinter));
        almacenes.add(new Almacenes("Olimpica","cra 9 # 13 - 111","3146487711","cartago",R.drawable.olimpica));
        almacenes.add(new Almacenes("Comfandi","cra 5 # 13 - 111","3146486611","cartago",R.drawable.comfandi));
        almacenes.add(new Almacenes("Colsubsidio","cra 1 # 13 - 111","3146007711","cartago",R.drawable.colsubsidio));
        almacenes.add(new Almacenes("Metro","cra 7 # 13 - 111","3146487121","cartago",R.drawable.metro));*/

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


      /*final String name="afuro";

        e = (Button) findViewById(R.id.IrProductos);
        e.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent productos = new Intent(verAlmacenes.this, CrearUsuariosActivity.class);
                startActivity(productos);



            }
        });*/

      /*u = (Button) findViewById(R.id.crearProducto);
        u.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent productos = new Intent(verAlmacenes.this, VistaAdminActivity.class);
                startActivity(productos);
            }
        });*/