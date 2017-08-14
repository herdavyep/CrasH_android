package com.example.heriberto.crash.vistas;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.heriberto.crash.R;
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

    String idProducto = AlmacenSeleccionado.getId_almacenSeleccionado();
    //String idProducto = "frijol";
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

                        final EditText EDnombreProducto = (EditText) findViewById(R.id.nombreEditarProducto);
                        EDnombreProducto.setText(ProductosEditar.getNombre(),TextView.BufferType.EDITABLE);
                        //final String nombreProducto = EDnombreProducto.getText().toString();

                        final EditText EDprecioProducto = (EditText) findViewById(R.id.precioEditarProducto);
                        EDprecioProducto.setText(ProductosEditar.getPrecio(),TextView.BufferType.EDITABLE);
                        //final String precioProducto = EDprecioProducto.getText().toString();
                        //int precio2 = Integer.parseInt(precioProducto);

                        final EditText EDpresentacionProducto = (EditText) findViewById(R.id.presentacionEditarProducto);
                        EDpresentacionProducto.setText(ProductosEditar.getPresentacion(),TextView.BufferType.EDITABLE);
                        // final String presentacionProducto = EDpresentacionProducto.getText().toString();

                        final EditText EDcantxClien = (EditText) findViewById(R.id.canxclie);
                        EDcantxClien.setText(ProductosEditar.getUnidxcliente(),TextView.BufferType.EDITABLE);
                        //final String vencimientoOferta = EDcantxClien.getText().toString();

                        final ImageButton subirImagen = (ImageButton) findViewById(R.id.imagenEditarProducto);
                        String descargarFoto = ProductosEditar.getImagen();

                        Glide.with(EditarProductoActivity.this)
                                .load(descargarFoto)
                                .fitCenter()
                                .centerCrop()
                                .into(subirImagen);

                        final EditText EDproductosDisponibles = (EditText) findViewById(R.id.productosEditarDisponibles);
                        EDproductosDisponibles.setText(ProductosEditar.getProductos_disponibles(),TextView.BufferType.EDITABLE);

                        //final String productosDisponibles = EDproductosDisponibles.getText().toString();

                        final EditText EDporcentajeDescuento = (EditText) findViewById(R.id.porcentajeEditarDescuento);
                        EDporcentajeDescuento.setText(ProductosEditar.getPorcentaje_descuento(),TextView.BufferType.EDITABLE);

                        // final String porcentajeDescuento = EDporcentajeDescuento.getText().toString();

                        final EditText EDidAlmacen = (EditText) findViewById(R.id.idEditarAlmacen);
                        EDidAlmacen.setText(ProductosEditar.getId_almacen(),TextView.BufferType.EDITABLE);

                        //final String idAlmacen = EDidAlmacen.getText().toString();

                    }

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        Toast.makeText(getApplicationContext(),ProductosEditar.getPrecio(), Toast.LENGTH_SHORT).show();




        /*final TextInputEditText EDproductosDisponibles = (TextInputEditText) findViewById(R.id.productosDisponibles);
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
