package com.example.heriberto.crash.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.heriberto.crash.MainActivity;
import com.example.heriberto.crash.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth firebaseConection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TextInputEditText edUsusario = (TextInputEditText) findViewById(R.id.nombreUsuario);
        final TextInputEditText edContrasena = (TextInputEditText) findViewById(R.id.contrasena);

        firebaseConection = FirebaseAuth.getInstance();

        Button inicio = (Button)findViewById(R.id.iniciarSesion);

        inicio.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"Cargando... ",Toast.LENGTH_SHORT).show();

                final String usuario = edUsusario.getText().toString().trim();
                String contrasena = edContrasena.getText().toString().trim();

                if (usuario.equals("")){
                    Toast.makeText(getApplicationContext(),"el usuario no puede ser vacio",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (contrasena.equals("")){
                    Toast.makeText(getApplicationContext(),"la contraseña no puede ser vacia",Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseConection.signInWithEmailAndPassword(usuario,contrasena)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (!task.isSuccessful()){

                                    Toast.makeText(getApplicationContext(),"ERROR de conexion"+task.getException(),Toast.LENGTH_SHORT).show();
                                    return;

                                }else {


                                    Intent Iralmacenes = new Intent(LoginActivity.this, verAlmacenes.class);
                                    startActivity(Iralmacenes);
                                    finish();

                                    Toast.makeText(getApplicationContext(),"BIENVENIDO "+usuario,Toast.LENGTH_SHORT).show();
                                    return;

                                }
                            }
                        });
            }
        });


        Button registro = (Button)findViewById(R.id.registrarse);

        registro.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent almacenes = new Intent(LoginActivity.this, RegistrarActivity.class);
                startActivity(almacenes);

            }
        });

    }



}
