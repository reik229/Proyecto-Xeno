package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Esta actividad permite registrar un nuevo usuario con nombre, apellido, correo, edad y rut.
 * Se valida que todos los campos estén llenos y que el correo no esté registrado antes de guardar.
 */
public class ActividadRegistro extends AppCompatActivity {

    // Declaración de campos del formulario
    private EditText edtNombre, edtApellido, edtCorreo, edtEdad, edtRut;
    private Button btnRegistrarse, btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Cargamos el layout que contiene el formulario de registro
        setContentView(R.layout.actividad_registro);

        // Asociamos las variables con los elementos del layout por sus IDs
        edtNombre = findViewById(R.id.edtNombre);
        edtApellido = findViewById(R.id.edtApellido);
        edtCorreo = findViewById(R.id.edtCorreoRegister);
        edtEdad = findViewById(R.id.edtEdad);
        edtRut = findViewById(R.id.edtRut);

        btnRegistrarse = findViewById(R.id.btnRegistrarse);
        btnVolver = findViewById(R.id.btnVolver);

        // Creamos una instancia del gestor de usuarios para manejar el registro
        GestorUsuarios gestor = new GestorUsuarios(this);

        // Configuramos la acción al hacer clic en el botón "Registrarse"
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtenemos el texto ingresado por el usuario en cada campo, eliminando espacios en blanco
                String nombre = edtNombre.getText().toString().trim();
                String apellido = edtApellido.getText().toString().trim();
                String correo = edtCorreo.getText().toString().trim();
                String edad = edtEdad.getText().toString().trim();
                String rut = edtRut.getText().toString().trim();

                // Validamos que ninguno de los campos esté vacío
                if(nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || edad.isEmpty() || rut.isEmpty()) {
                    Toast.makeText(ActividadRegistro.this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                    return;  // Salimos para que el usuario corrija el formulario
                }

                // Validamos que el correo no esté ya registrado en el sistema
                if(gestor.usuarioExiste(correo)) {
                    Toast.makeText(ActividadRegistro.this, "Este correo ya está registrado", Toast.LENGTH_SHORT).show();
                } else {
                    // Guardamos el usuario en el sistema
                    // Nota: Aquí combino nombre y apellido para guardarlos juntos en el gestor
                    // Puedes modificar GestorUsuarios para guardar también edad y rut si quieres
                    gestor.registrarUsuario(correo, rut, nombre + " " + apellido);

                    Toast.makeText(ActividadRegistro.this, "Registro exitoso", Toast.LENGTH_SHORT).show();

                    // Después del registro, volvemos a la actividad principal (login)
                    Intent intent = new Intent(ActividadRegistro.this, ActividadPrincipal.class);
                    startActivity(intent);
                    finish();  // Cerramos esta actividad para que no se regrese con el botón atrás
                }
            }
        });

        // Configuramos la acción del botón "Volver" para regresar a la pantalla principal sin registrar
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActividadRegistro.this, ActividadPrincipal.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
