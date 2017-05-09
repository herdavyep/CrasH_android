package com.example.heriberto.crash.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.heriberto.crash.R;

public class VistaAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_admin);

    }

    public void IrAdminProductos(View view){

        Intent AdP = new Intent(VistaAdminActivity.this, ProductosAdminActivity.class);
        startActivity(AdP);
    }

    public void IrAdminCategorias(View view){

        Intent AdC = new Intent(VistaAdminActivity.this, CategoriasAdminActivity.class);
        startActivity(AdC);

    }

    public void IrAdminUsuarios(View view){

        Intent AdU = new Intent(VistaAdminActivity.this, UsuariosAdminActivity.class);
        startActivity(AdU);

    }

    public void IrAdminAlmacenes(View view){

        Intent AdA = new Intent(VistaAdminActivity.this, AlmacenesAdminActivity.class);
        startActivity(AdA);
    }

}
