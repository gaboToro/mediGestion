package com.mycompany.medigestion.modelo;

/**
 * @author gabri
 */
public class Especialidad {
    private int id_especialidad;
    private String nombre;
    
    public Especialidad(){}
    
    public Especialidad(int id_especialidad, String nombre){
        this.id_especialidad = id_especialidad;
        this.nombre = nombre;
    }
    
    public int getIdEspecialidad(){ return id_especialidad; }
    public void setIdEspecialidad (int id_especialidad){ this.id_especialidad = id_especialidad; }
    
    public String getNombre(){ return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    @Override
    public String toString() {
        return this.nombre; 
    }
}
