package com.example.heriberto.crash.vistas;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.heriberto.crash.R;
import com.example.heriberto.crash.clases.Productos;
import com.example.heriberto.crash.firebaseReferencias.Referencias;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CrearProductoActivity extends AppCompatActivity {

    FirebaseDatabase myDataBase = FirebaseDatabase.getInstance();
    DatabaseReference myRef = myDataBase.getReference(Referencias.ALMACEN_REFERENCIA);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_producto);


    }

    public void cerrarCrearProducto (View view){

        onBackPressed();
    }


    public void CrearProducto (View view){

        final TextInputEditText EDnombreProducto = (TextInputEditText) findViewById(R.id.nombreProducto);
        final String nombreProducto = EDnombreProducto.getText().toString();

        final TextInputEditText EDprecioProducto = (TextInputEditText) findViewById(R.id.precioProducto);
        final String precioProducto = EDprecioProducto.getText().toString();
        int precio2 = Integer.parseInt(precioProducto);

        final TextInputEditText EDpresentacionProducto = (TextInputEditText) findViewById(R.id.presentacionProducto);
        final String presentacionProducto = EDpresentacionProducto.getText().toString();

        final TextInputEditText EDvencimientoOferta = (TextInputEditText) findViewById(R.id.vencimientoOferta);
        final String vencimientoOferta = EDvencimientoOferta.getText().toString();

        final TextInputEditText EDproductosDisponibles = (TextInputEditText) findViewById(R.id.productosDisponibles);
        final String productosDisponibles = EDproductosDisponibles.getText().toString();

        final TextInputEditText EDporcentajeDescuento = (TextInputEditText) findViewById(R.id.porcentajeDescuento);
        final String porcentajeDescuento = EDporcentajeDescuento.getText().toString();

        final TextInputEditText EDidAlmacen = (TextInputEditText) findViewById(R.id.idAlmacen);
        final String idAlmacen = EDidAlmacen.getText().toString();

        Productos producto = new Productos(nombreProducto,precio2,vencimientoOferta,productosDisponibles,presentacionProducto,porcentajeDescuento,idAlmacen);
        //Productos producto = new Productos(nombreProducto,precioProducto,presentacionProducto);

        myRef.child(Referencias.PRODUCTOS_REFERENCIA).push().setValue(producto);
        //myRef.push().setValue(producto);

        onBackPressed();

    }
}


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
