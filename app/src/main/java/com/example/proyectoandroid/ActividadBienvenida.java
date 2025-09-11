package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Esta actividad muestra un mensaje de bienvenida personalizado al usuario
 * que ha iniciado sesión, y ofrece acceso a las pantallas de Perfil y Lista de Usuarios.
 */
public class ActividadBienvenida extends AppCompatActivity {

    private TextView tvBienvenida;
    private Button btnPerfil, btnListaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        // Inicializamos vistas
        tvBienvenida = findViewById(R.id.tvBienvenida);
        btnPerfil = findViewById(R.id.btnPerfil);
        btnListaUsuarios = findViewById(R.id.btnListaUsuarios);

        // Obtenemos el nombre del usuario desde SharedPreferences usando GestorUsuarios
        GestorUsuarios gestor = new GestorUsuarios(this);
        String nombreUsuario = gestor.obtenerNombre();

        // Mostramos el mensaje de bienvenida con el nombre del usuario
        tvBienvenida.setText("¡Bienvenido, " + nombreUsuario + "!");

        // Botón para ir a la pantalla de perfil
        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActividadBienvenida.this, ActividadPerfil.class);
                startActivity(intent);
            }
        });

        // Botón para ir a la lista de usuarios
        btnListaUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActividadBienvenida.this, ActividadListaUsuarios.class);
                startActivity(intent);
            }
        });
    }
}
