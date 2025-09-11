package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// Esta actividad es la pantalla de inicio de sesión donde el usuario ingresa email y contraseña
public class ActividadPrincipal extends AppCompatActivity {

    private EditText edtCorreo, edtContrasena;
    private Button btnIniciarSesion, btnRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // diseño XML

        // Conectamos las variables con los elementos del XML
        edtCorreo = findViewById(R.id.edtCorreo);
        edtContrasena = findViewById(R.id.edtContrasena);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        btnRegistrarse = findViewById(R.id.btnRegistrarse);

        // Acción para iniciar sesión
        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtCorreo.getText().toString().trim();
                String contrasena = edtContrasena.getText().toString().trim();

                if(email.isEmpty() || contrasena.isEmpty()) {
                    Toast.makeText(ActividadPrincipal.this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                GestorUsuarios gestor = new GestorUsuarios(ActividadPrincipal.this);

                // Verificamos si los datos son correctos
                if(gestor.loginValido(email, contrasena)) {
                    Toast.makeText(ActividadPrincipal.this, "¡Bienvenido!", Toast.LENGTH_SHORT).show();

                    // Pasamos a la pantalla de bienvenida y enviamos el nombre
                    Intent intent = new Intent(ActividadPrincipal.this, ActividadBienvenida.class);
                    intent.putExtra("nombreUsuario", gestor.obtenerNombre());
                    startActivity(intent);
                    finish(); // Cerramos esta actividad para que no regrese con el botón atrás
                } else {
                    Toast.makeText(ActividadPrincipal.this, "Email o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Acción para ir a registro
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActividadPrincipal.this, ActividadRegistro.class);
                startActivity(intent);
            }
        });
    }
}
