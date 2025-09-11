package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Esta actividad muestra una lista simple con el usuario registrado.
 * En este caso sólo mostramos el nombre y email guardados.
 */
public class ActividadListaUsuarios extends AppCompatActivity {

    private TextView tvListaUsuarios;
    private GestorUsuarios gestor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_lista_usuarios);

        // Enlazamos el TextView con el XML
        tvListaUsuarios = findViewById(R.id.tvListaUsuarios);

        // Inicializamos el gestor para acceder a SharedPreferences
        gestor = new GestorUsuarios(this);

        // Obtenemos los datos guardados
        String nombre = gestor.obtenerNombre();
        String email = gestor.obtenerEmail();

        // Mostramos la información en el TextView
        String texto = "Usuarios registrados:\n\n" + nombre + " (" + email + ")";
        tvListaUsuarios.setText(texto);
    }
}
