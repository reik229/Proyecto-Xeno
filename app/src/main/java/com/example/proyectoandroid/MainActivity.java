// Declaramos el paquete en el que está nuestra app
package com.example.proyectoandroid;

// Importamos las librerías necesarias para Android
import androidx.appcompat.app.AppCompatActivity; // Para usar AppCompatActivity (clase base de las pantallas/activities)
import android.content.Intent; // Para poder movernos de una pantalla a otra (Login -> Registro)
import android.os.Bundle; // Para guardar y restaurar datos de la Activity cuando se abre
import android.view.View; // Para poder manejar los clics de botones
import android.widget.Button; // Para crear botones
import android.widget.EditText; // Para los campos de texto como Email y Contraseña
import android.widget.Toast; // Para mostrar mensajes cortos en pantalla (tipo aviso)

// Nuestra clase MainActivity, que representa la primera pantalla (Login)
public class MainActivity extends AppCompatActivity {

    // Declaramos los elementos de la interfaz que vamos a usar en el Login
    private EditText editTextEmail;    // Campo donde el usuario escribe su correo
    private EditText editTextPassword; // Campo donde el usuario escribe su contraseña
    private Button buttonLogin;        // Botón para iniciar sesión
    private Button buttonRegister;     // Botón para ir a la pantalla de registro

    //Método que se ejecuta automáticamente al iniciar la pantalla
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Llamamos al método padre para inicializar la pantalla
        setContentView(R.layout.activity_main); // Decimos qué archivo de diseño XML debe mostrarse (activity_main.xml)

        // Conectamos las variables de Java con los elementos gráficos del XML usando su ID
        editTextEmail = findViewById(R.id.edtCorreo); // Conecta el campo de email
        editTextPassword = findViewById(R.id.edtPassword); // Conecta el campo de contraseña
        buttonLogin = findViewById(R.id.btnIniciarSesion); // Conecta el botón de iniciar sesión
        buttonRegister = findViewById(R.id.btnRegistrate); // Conecta el botón de registrarse

        // Programamos qué pasa cuando se presiona el botón de "Iniciar Sesión"
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtenemos lo que el usuario escribió en el email y contraseña
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                // Verificamos si los campos están vacíos
                if(email.isEmpty() || password.isEmpty()) {
                    // Si falta algo, mostramos un mensaje de aviso
                    Toast.makeText(MainActivity.this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Si no están vacíos, mostramos un mensaje simulando un login exitoso
                    Toast.makeText(MainActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();

                    // Aquí podrías abrir otra pantalla (ejemplo Ventana.java)
                    Intent intent = new Intent(MainActivity.this, Ventana.class); // Creamos el "puente" para ir a la otra pantalla
                    startActivity(intent); // Cambiamos a la pantalla Ventana
                }
            }
        });

        // Programamos qué pasa cuando se presiona el botón de "Registrarse"
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando el usuario presiona "Registrarse", lo mandamos a la pantalla Ventana
                Intent intent = new Intent(MainActivity.this, Ventana.class);
                startActivity(intent);
            }
        });
    }
}
