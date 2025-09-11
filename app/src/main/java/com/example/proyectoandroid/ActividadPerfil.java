package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Esta actividad permite al usuario visualizar y actualizar su nombre
 * almacenado en SharedPreferences a través del GestorUsuarios.
 */
public class ActividadPerfil extends AppCompatActivity {

    // Campo de entrada para el nombre
    private EditText edtNombrePerfil;

    // Botones
    private Button btnGuardarNombre;
    private Button btnVolver;

    // Gestor para acceder a SharedPreferences
    private GestorUsuarios gestor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_perfil);

        // Enlazamos vistas con XML
        edtNombrePerfil = findViewById(R.id.edtNombrePerfil);
        btnGuardarNombre = findViewById(R.id.btnGuardarNombre);
        btnVolver = findViewById(R.id.btnVolverPerfil);

        // Inicializamos el gestor de usuarios
        gestor = new GestorUsuarios(this);

        // Mostramos el nombre actual guardado en el campo de texto
        edtNombrePerfil.setText(gestor.obtenerNombre());

        // Acción del botón Guardar
        btnGuardarNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nuevoNombre = edtNombrePerfil.getText().toString().trim();

                if (nuevoNombre.isEmpty()) {
                    Toast.makeText(ActividadPerfil.this, "El nombre no puede estar vacío", Toast.LENGTH_SHORT).show();
                    return;
                }

                gestor.actualizarNombre(nuevoNombre);
                Toast.makeText(ActividadPerfil.this, "Nombre actualizado con éxito", Toast.LENGTH_SHORT).show();
            }
        });

        // Acción del botón Volver
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra la actividad y vuelve a la anterior
            }
        });
    }
}

