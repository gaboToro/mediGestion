package com.mycompany.medigestion.modelo;

/**
 *
 * @author gabri
 */
public class Usuario {
    private int id_user;
    private String username;
    private String password;
    private String full_name;
    private Rol rol;
    private Estado estado;
    
    public Usuario(){}
    
    public Usuario(int id_user, String username, String password, String full_name, Rol rol, Estado estado){
        this.id_user = id_user;
        this.username = username;
        this.password = password;
        this.full_name = full_name;
        this.rol = rol;
        this.estado = estado;
    }
    
    public int getId_User(){ return id_user; }
    public void setId_User(int id_user){ this.id_user = id_user; }
    
    public String getUsername(){ return username; }
    public void setUsername(String username){ this.username = username; }
    
    public String getPassword(){ return password; }
    public void  setPassword(String password){ this.password = password; }
    
    public String getFullname() { return full_name;}
    public void setFullname(String full_name){ this.full_name = full_name; }
    
    public Rol getRol() { return rol; }
    public void setRol (Rol rol){ this.rol = rol; }
    
    public Estado getEstado(){ return estado; }
    public void setEstado(Estado estado){ this.estado=estado; }
}
