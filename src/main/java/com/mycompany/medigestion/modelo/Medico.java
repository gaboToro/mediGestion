package com.mycompany.medigestion.modelo;

/**
 * @author gabri
 */
public class Medico {
    private String idMedico;
    private String fullName;
    private String licenciaMedica;
    private int idEspecialidad;         
    private String nombreEspecialidad;  
    private String telefono;
    private String email;

    public Medico() {}
    
    public Medico(String idMedico, String fullName, String licenciaMedica, int idEspecialidad, String nombreEspecialidad, String telefono, String email) {
        this.idMedico = idMedico;
        this.fullName = fullName;
        this.licenciaMedica = licenciaMedica;
        this.idEspecialidad = idEspecialidad;
        this.nombreEspecialidad = nombreEspecialidad;
        this.telefono = telefono;
        this.email = email;
    }
    
    public String getIdMedico(){ return idMedico; }
    public void setIdMedico(String idMedico){ this.idMedico = idMedico; }
    
    public String getFullName(){ return fullName; }
    public void setFullName(String fullName){ this.fullName = fullName; }
    
    public String getLicenciaMedica(){ return licenciaMedica; }
    public void setLicenciaMedica(String licenciaMedica){ this.licenciaMedica = licenciaMedica; }
    
    public int getIdEspecialidad(){ return idEspecialidad; }
    public void setIdEspecialidad(int idEspecialidad){ this.idEspecialidad = idEspecialidad; }
    
    public String getNombreEspecialidad(){ return nombreEspecialidad; }
    public void setNombreEspecialidad(String nombreEspecialidad){ this.nombreEspecialidad = nombreEspecialidad; }
    
    public String getTelefono(){ return telefono; }
    public void setTelefono(String telefono){ this.telefono = telefono; }
    
    public String getEmail(){ return email; }
    public void setEmail(String email){ this.email = email; }
    
}