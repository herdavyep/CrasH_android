package com.example.heriberto.crash.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.heriberto.crash.R;
import com.example.heriberto.crash.clases.Almacenes;
import com.example.heriberto.crash.clases.Productos;
import com.example.heriberto.crash.clasesEstaticas.AlmacenSeleccionado;
import com.example.heriberto.crash.edicion.ProductosEditar;
import com.example.heriberto.crash.firebaseReferencias.Referencias;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditarProductoActivity extends AppCompatActivity {

    //String idProducto = AlmacenSeleccionado.getId_almacenSeleccionado();
    String idProducto = "aaaa";
    FirebaseDatabase myDataBase = FirebaseDatabase.getInstance();
    DatabaseReference myRef = myDataBase.getReference(Referencias.ALMACEN_REFERENCIA).child(Referencias.PRODUCTOS_REFERENCIA);
    //Productos productoE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_producto);

        //productoE = new Productos();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot:
                        dataSnapshot.getChildren()) {

                    Productos producto = snapshot.getValue(Productos.class);

                    if (idProducto.equals(producto.getNombre())){

                         ProductosEditar.ProductosEditar(producto);

                    }

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        Toast.makeText(getApplicationContext(),ProductosEditar.getNombre(), Toast.LENGTH_SHORT).show();


        final EditText EDnombreProducto = (EditText) findViewById(R.id.nombreEditarProducto);
        EDnombreProducto.setText(ProductosEditar.getNombre(),TextView.BufferType.EDITABLE);
        //final String nombreProducto = EDnombreProducto.getText().toString();

        /*final TextInputEditText EDprecioProducto = (TextInputEditText) findViewById(R.id.precioProducto);
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
        final String idAlmacen = EDidAlmacen.getText().toString();*/



    }

    public void cerrarEditarProducto (View view){

        onBackPressed();
    }

    public void GuardarEditar (View view){


    }

}
