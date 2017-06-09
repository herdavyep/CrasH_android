package com.example.heriberto.crash.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.heriberto.crash.R;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;

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

        Intent AdC = new Intent(VistaAdminActivity.this, PromocionesAdminActivity.class);
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

    public void BotonOpcionesAdmin(View view) {

        PopupMenu popup = new PopupMenu(this, view);
        popup.getMenuInflater().inflate(R.menu.menu_admin, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.cerrarSesionAdmin:
                        cerrarSesion();
                        return true;
                    case R.id.vistaCliente:
                        vista_clientes();
                        return true;
                    default:
                        return false;
                }
            }
        });
        popup.show();
    }

    public void vista_clientes(){

        Intent IrLogin = new Intent(VistaAdminActivity.this, verAlmacenes.class);
        IrLogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(IrLogin);
    }


    public void cerrarSesion(){

        FirebaseAuth.getInstance().signOut();
        LoginManager.getInstance().logOut();
        Toast.makeText(getApplicationContext(),"Sesion Terminada",Toast.LENGTH_SHORT).show();
        Intent IrLogin = new Intent(VistaAdminActivity.this, LoginActivity.class);
        startActivity(IrLogin);
        finish();
    }

}
