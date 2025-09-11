package com.example.proyectoandroid;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Esta clase gestiona el almacenamiento y recuperación
 * de datos de usuario usando SharedPreferences.
 * Aquí guardamos nombre, email, contraseña, etc.
 */
public class GestorUsuarios {

    // SharedPreferences para guardar los datos
    private SharedPreferences preferencias;
    private SharedPreferences.Editor editor;

    /**
     * Constructor que recibe el contexto para inicializar SharedPreferences.
     * @param context Contexto de la aplicación o actividad
     */
    public GestorUsuarios(Context context) {
        preferencias = context.getSharedPreferences("usuarios_prefs", Context.MODE_PRIVATE);
        editor = preferencias.edit();
    }

    /**
     * Guarda el nombre del usuario en SharedPreferences.
     * @param nombre Nombre del usuario
     */
    public void guardarNombre(String nombre) {
        editor.putString("nombre", nombre);
        editor.apply();
    }

    /**
     * Obtiene el nombre guardado en SharedPreferences.
     * @return Nombre del usuario o "No registrado" si no existe
     */
    public String obtenerNombre() {
        return preferencias.getString("nombre", "No registrado");
    }

    /**
     * Guarda el email del usuario en SharedPreferences.
     * @param email Correo electrónico del usuario
     */
    public void guardarEmail(String email) {
        editor.putString("email", email);
        editor.apply();
    }

    /**
     * Obtiene el email guardado en SharedPreferences.
     * @return Email del usuario o "No registrado" si no existe
     */
    public String obtenerEmail() {
        return preferencias.getString("email", "No registrado");
    }

    /**
     * Guarda la contraseña del usuario.
     * @param contrasena Contraseña del usuario
     */
    public void guardarContrasena(String contrasena) {
        editor.putString("contrasena", contrasena);
        editor.apply();
    }

    /**
     * Valida si el login es correcto comparando email y contraseña con lo guardado.
     * @param email Email ingresado para login
     * @param contrasena Contraseña ingresada para login
     * @return true si coinciden, false si no
     */
    public boolean loginValido(String email, String contrasena) {
        String emailGuardado = obtenerEmail();
        String contrasenaGuardada = preferencias.getString("contrasena", "");
        return email.equals(emailGuardado) && contrasena.equals(contrasenaGuardada);
    }

    /**
     * Actualiza el nombre del usuario en SharedPreferences.
     * @param nuevoNombre Nuevo nombre a guardar
     */
    public void actualizarNombre(String nuevoNombre) {
        guardarNombre(nuevoNombre);
    }

    /**
     * Verifica si un usuario con el correo dado ya está registrado.
     * @param correo El correo electrónico a buscar.
     * @return true si el correo ya existe, false si no.
     */
    public boolean usuarioExiste(String correo) {
        String correoGuardado = obtenerEmail();
        return correoGuardado != null && correoGuardado.equals(correo);
    }

    /**
     * Registra un nuevo usuario guardando correo, contraseña y nombre completo.
     * @param correo Correo electrónico del usuario
     * @param contrasena Contraseña del usuario
     * @param nombreCompleto Nombre completo del usuario
     */
    public void registrarUsuario(String correo, String contrasena, String nombreCompleto) {
        guardarEmail(correo);
        guardarContrasena(contrasena);
        guardarNombre(nombreCompleto);
    }
}
