package com.example.heriberto.crash.vistas;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.heriberto.crash.R;
import com.example.heriberto.crash.clases.Almacenes;
import com.example.heriberto.crash.firebaseReferencias.Referencias;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class CrearAlmacenesActivity extends AppCompatActivity {


    FirebaseDatabase myDataBase = FirebaseDatabase.getInstance();
    DatabaseReference myRef = myDataBase.getReference(Referencias.ALMACEN_REFERENCIA);
    private ImageButton subirImagen;
    private StorageReference referenciaStorage;
    private static final int GALLERIA_INTENT = 1;
    private ProgressDialog progresoFoto;
    private String urlFoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_almacenes);

        subirImagen = (ImageButton) findViewById(R.id.imagenCrearAlmacen);
        referenciaStorage = FirebaseStorage.getInstance().getReference();


        subirImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(getApplicationContext(),"boton presionado", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,GALLERIA_INTENT);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERIA_INTENT && resultCode == RESULT_OK){

            /*progresoFoto.setTitle("Subiendo ...");
            progresoFoto.setMessage("Subiendo a firebase");
            progresoFoto.setCancelable(false);
            progresoFoto.show();*/

            Uri uri = data.getData();

            StorageReference paqueteFotos = referenciaStorage.child("almacenes").child(uri.getLastPathSegment());

            paqueteFotos.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    //progresoFoto.dismiss();

                    Uri descargarFoto = taskSnapshot.getDownloadUrl();

                    urlFoto = descargarFoto.toString();

                    Glide.with(CrearAlmacenesActivity.this)
                            .load(descargarFoto)
                            .fitCenter()
                            .centerCrop()
                            .into(subirImagen);

                    //Toast.makeText(getApplicationContext(),"Se subio con exito la imagen del producto"+urlFoto, Toast.LENGTH_SHORT).show();

                }
            });

        }
    }

    public void cerrarCrearAlmacen (View view){

        onBackPressed();
    }

    public void CrearAlmacen (View view){

        final TextInputEditText EDnombre = (TextInputEditText) findViewById(R.id.nombreCrearAlmacen);
        final String nombre = EDnombre.getText().toString();

        final TextInputEditText EDdireccion = (TextInputEditText) findViewById(R.id.direccionCrearAlmacen);
        final String direccion = EDdireccion.getText().toString();

        final TextInputEditText EDtelefono = (TextInputEditText) findViewById(R.id.telefonoCrearAlmacen);
        final String telefono = EDtelefono.getText().toString();

        final TextInputEditText EDciudad = (TextInputEditText) findViewById(R.id.ciudadCrearAlmacen);
        final String ciudad = EDciudad.getText().toString();

        final TextInputEditText EDidAlmacen = (TextInputEditText) findViewById(R.id.idCrearAlmacen);
        final String idAlmacen = EDidAlmacen.getText().toString();

        Almacenes almacen = new Almacenes(nombre,direccion,telefono,ciudad,urlFoto,idAlmacen);
        //ProductosEditar producto = new ProductosEditar(nombreProducto,precioProducto,presentacionProducto);

        myRef.child(Referencias.ALMACENES_REFERENCIA).push().setValue(almacen);
        //myRef.push().setValue(producto);

        Toast.makeText(getApplicationContext(),"Guardado con exito", Toast.LENGTH_SHORT).show();


        onBackPressed();
    }

}
