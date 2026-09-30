package com.mycompany.medigestion.modelo;

/**
 * @author gabri
 */
public class Sangre {
    private int idTipo;
    private String nombreTipo;

    public Sangre() {}

    public Sangre(int idTipo, String nombreTipo) {
        this.idTipo = idTipo;
        this.nombreTipo = nombreTipo;
    }

    public int getIdTipo() { return idTipo; }
    public void setIdTipo(int idTipo) { this.idTipo = idTipo; }

    public String getNombreTipo() { return nombreTipo; }
    public void setNombreTipo(String nombreTipo) { this.nombreTipo = nombreTipo; }

    // Fundamental para que el JComboBox muestre el texto legible
    @Override
    public String toString() {
        return this.nombreTipo;
    }
}