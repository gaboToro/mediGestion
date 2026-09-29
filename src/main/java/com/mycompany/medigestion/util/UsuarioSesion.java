package com.mycompany.medigestion.util;

/**
 *
 * @author gabri
 */
public class UsuarioSesion {
    private static String username;
    private static String nombreCompleto;
    private static String rol;
    private static boolean logueado = false;

    // Constructor privado para evitar que se instancie por error
    private UsuarioSesion() {}

    public static void iniciarSesion(String user, String nombre, String rolUsuario) {
        username = user;
        nombreCompleto = nombre;
        rol = rolUsuario;
        logueado = true;
    }

    public static void cerrarSesion() {
        nombreCompleto = null;
        rol = null;
        logueado = false;
    }
    
    public static String getUsername(){
        return username;
    }

    public static boolean isLogueado() { 
        return logueado; 
    }
    
    public static String getNombreCompleto() { 
        return nombreCompleto; 
    }
    
    public static String getRol() { 
        return rol; 
    }
}
