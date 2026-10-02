package com.mycompany.medigestion.util;

/**
 * @author gabri
 */
public class UsuarioSesion {
    private static int idUser;
    private static String username;
    private static String nombreCompleto;
    private static String rol;
    private static boolean logueado = false;

    // Constructor privado para evitar que se instancie por error
    private UsuarioSesion() {}

    public static void iniciarSesion(int id, String user, String nombre, String rolUsuario) {
        idUser = id;
        username = user;
        nombreCompleto = nombre;
        rol = rolUsuario;
        logueado = true;
    }

    public static void cerrarSesion() {
        idUser=0;
        username = null;
        nombreCompleto = null;
        rol = null;
        logueado = false;
    }
    
    public static int getIdUser() {
        return idUser;
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
