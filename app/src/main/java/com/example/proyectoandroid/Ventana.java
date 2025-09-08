package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity; // Importa la clase base para actividades
import android.content.Intent; // Sirve para navegar entre pantallas (activities)
import android.os.Bundle; // Sirve para manejar el estado de la aplicación
import android.view.View; // Necesario para manejar clicks en botones
import android.widget.Button; // Clase para los botones
import android.widget.EditText; // Clase para los campos de texto (entradas de usuario)
import android.widget.Toast; // Para mostrar mensajes rápidos en pantalla

public class Ventana extends AppCompatActivity {

    // Declaración de los campos de texto del registro
    private EditText etNombre;    // Campo para ingresar el nombre
    private EditText etApellido;  // Campo para ingresar el apellido
    private EditText etCorreo;    // Campo para ingresar el correo
    private EditText etEdad;      // Campo para ingresar la edad
    private EditText etPassword;       // Campo para ingresar Contraseña

    // Declaración de los botones
    private Button btnVolver;     // Botón que regresa al Login
    private Button btnRegistrarse; // Botón que confirma el registro

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Llama al método de la clase padre para iniciar la Activity
        setContentView(R.layout.activity_ventana2); // Asocia esta clase con su diseño XML (Register)

        // Relacionamos los campos de texto con los elementos del XML usando sus IDs
        etNombre = findViewById(R.id.edtNombre);         // Nombre
        etApellido = findViewById(R.id.edtApellido);     // Apellido
        etCorreo = findViewById(R.id.edtCorreoRegister);         // Correo electrónico
        etEdad = findViewById(R.id.edtEdad);             // Edad
        etPassword = findViewById(R.id.edtRut);               // Contraseña

        // Relacionamos los botones con los elementos del XML
        btnVolver = findViewById(R.id.btnVolver);       // Botón "Volver"
        btnRegistrarse = findViewById(R.id.btnRegistrarse); // Botón "Registrarse"

        // Configuramos el botón "Volver" para regresar al Login
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creamos un Intent para ir desde esta ventana al Login (MainActivity)
                Intent intent = new Intent(Ventana.this, MainActivity.class);
                startActivity(intent); // Ejecutamos el cambio de pantalla
                finish(); // Cerramos la ventana actual para que no quede abierta en segundo plano
            }
        });

        // Configuramos el botón "Registrarse" para validar los datos ingresados
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtenemos los textos escritos por el usuario
                String nombre = etNombre.getText().toString().trim();   // Nombre ingresado
                String apellido = etApellido.getText().toString().trim(); // Apellido ingresado
                String correo = etCorreo.getText().toString().trim();   // Correo ingresado
                String edad = etEdad.getText().toString().trim();       // Edad ingresada
                String password = etPassword.getText().toString().trim();         // Contraseña ingresada

                // Validamos que no queden campos vacíos

                if (nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || edad.isEmpty() || password.isEmpty()) {
                    // Mostramos un mensaje en pantalla avisando al usuario
                    Toast.makeText(Ventana.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Si todos los campos están completos, mostramos un mensaje de éxito
                    Toast.makeText(Ventana.this, "Registro exitoso", Toast.LENGTH_SHORT).show();

                    // Aquí se podría guardar la información en una base de datos,
                    // pero como pediste sin SQL, solo simulamos el registro exitoso.

                    // Redirigimos al Login (MainActivity) después de registrarse
                    Intent intent = new Intent(Ventana.this, MainActivity.class);
                    startActivity(intent); // Volvemos al login
                    finish(); // Cerramos esta ventana
                }
            }
        });
    }
}
