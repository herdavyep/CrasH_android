package com.example.heriberto.crash.vistas;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.heriberto.crash.R;
import com.example.heriberto.crash.clases.Productos;
import com.example.heriberto.crash.firebaseReferencias.Referencias;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.net.URI;

public class CrearProductoActivity extends AppCompatActivity {

    FirebaseDatabase myDataBase = FirebaseDatabase.getInstance();
    DatabaseReference myRef = myDataBase.getReference(Referencias.ALMACEN_REFERENCIA);
    private ImageButton subirImagen;
    private StorageReference referenciaStorage;
    private static final int GALLERY_INTENT = 1;
    private ProgressDialog progresoFoto;
    private String urlFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_producto);

        subirImagen = (ImageButton) findViewById(R.id.imagenProducto);
        referenciaStorage = FirebaseStorage.getInstance().getReference();
        progresoFoto = new ProgressDialog(this);

        subirImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"boton presionado", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,GALLERY_INTENT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_INTENT && resultCode == RESULT_OK){

            /*progresoFoto.setTitle("Subiendo ...");
            progresoFoto.setMessage("Subiendo a firebase");
            progresoFoto.setCancelable(false);
            progresoFoto.show();*/

            Uri uri = data.getData();

            StorageReference paqueteFotos = referenciaStorage.child("productos").child(uri.getLastPathSegment());

            paqueteFotos.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    //progresoFoto.dismiss();

                    Uri descargarFoto = taskSnapshot.getDownloadUrl();

                    urlFoto = descargarFoto.toString();

                    Glide.with(CrearProductoActivity.this)
                            .load(descargarFoto)
                            .fitCenter()
                            .centerCrop()
                            .into(subirImagen);

                    Toast.makeText(getApplicationContext(),"Se subio con exito la imagen del producto"+urlFoto, Toast.LENGTH_SHORT).show();

                }
            });

        }
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

        Productos producto = new Productos(nombreProducto,precio2,vencimientoOferta,productosDisponibles,presentacionProducto,porcentajeDescuento,idAlmacen,urlFoto);
        //ProductosEditar producto = new ProductosEditar(nombreProducto,precioProducto,presentacionProducto);

        myRef.child(Referencias.PRODUCTOS_REFERENCIA).push().setValue(producto);
        //myRef.push().setValue(producto);

        Toast.makeText(getApplicationContext(),"Guardado con exito", Toast.LENGTH_SHORT).show();


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
