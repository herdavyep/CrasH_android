package com.example.heriberto.crash.vistas;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.heriberto.crash.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrarActivity extends AppCompatActivity {

    private FirebaseAuth firebaseConection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        final TextInputEditText RegUsusario = (TextInputEditText) findViewById(R.id.RegistrarNombreUsuario);
        final TextInputEditText RegContrasena = (TextInputEditText) findViewById(R.id.RegistrarContrasena);


        firebaseConection = FirebaseAuth.getInstance();

        Button registrar = (Button)findViewById(R.id.registrarse);
        registrar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Cargando... ",Toast.LENGTH_SHORT).show();


                final String usuario = RegUsusario.getText().toString().trim();
                final String contrasena = RegContrasena.getText().toString().trim();

                if (usuario.equals("")){
                    Toast.makeText(getApplicationContext(),"el usuario no puede ser vacio",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (contrasena.equals("")){
                    Toast.makeText(getApplicationContext(),"la contraseña no puede ser vacia",Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseConection.createUserWithEmailAndPassword(usuario,contrasena)
                        .addOnCompleteListener(RegistrarActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (!task.isSuccessful()){

                                    Toast.makeText(getApplicationContext(),"ERROR de conexion"+task.getException(),Toast.LENGTH_SHORT).show();
                                    return;

                                }else {

                                    firebaseConection.signInWithEmailAndPassword(usuario,contrasena)
                                            .addOnCompleteListener(RegistrarActivity.this, new OnCompleteListener<AuthResult>() {
                                                @Override
                                                public void onComplete(@NonNull Task<AuthResult> task) {


                                                    if (!task.isSuccessful()){

                                                        Toast.makeText(getApplicationContext(),"ERROR de conexion"+task.getException(),Toast.LENGTH_SHORT).show();
                                                        return;

                                                    }else {


                                                        Intent IrAlmacenes = new Intent(RegistrarActivity.this, verAlmacenes.class);
                                                        startActivity(IrAlmacenes);
                                                        Toast.makeText(getApplicationContext(),"Registro Exitoso!!!  BIENVENIDO "+usuario,Toast.LENGTH_SHORT).show();
                                                        return;
                                                    }
                                                }
                                            });
                                }
                            }
                        });

            }
        });

        ImageButton cancel = (ImageButton) findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent IrLogin = new Intent(RegistrarActivity.this, LoginActivity.class);
                startActivity(IrLogin);
                finish();
            }
        });

    }
}
