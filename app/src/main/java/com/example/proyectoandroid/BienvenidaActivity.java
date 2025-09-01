package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;
public class BienvenidaActivity extends AppCompatActivity {

    TextView tvBienvenida, tvUsuario;
    ImageView ivPerfil;
    Button btnQuienesSomos, btnVerTabla;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        // Vinculación con el XML
        tvBienvenida = findViewById(R.id.tvBienvenida);
        tvUsuario = findViewById(R.id.tvUsuario);
        ivPerfil = findViewById(R.id.ivPerfil);
        btnQuienesSomos = findViewById(R.id.btnQuienesSomos);
        btnVerTabla = findViewById(R.id.btnVerTabla);

        //Simulamos que recibimos el nombre de usuario
        String usuario = getIntent().getStringExtra("usuario");
        if (usuario == null || usuario.isEmpty()){
            usuario = "Usuario";
        }

        //Mostramos el Nombre en el TextView
        tvUsuario.setText(usuario);
    }
}