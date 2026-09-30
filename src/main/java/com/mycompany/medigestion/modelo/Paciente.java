package com.mycompany.medigestion.modelo;

/**
 * @author gabri
 */
public class Paciente {
    private String idPaciente;
    private int idExpediente;
    private String fullName;
    private String fechaNacimiento; // Guardado como String por el formato DD/MM/YYYY
    private String sexo;
    private String telefono;
    private String direccion;
    private int idSangre;
    private String nombreSangre;    // Para mostrar en el JTable visual
    private String nombreSeguroMed;

    public Paciente() {}

    // Getters y Setters
    public String getIdPaciente() { return idPaciente; }
    public void setIdPaciente(String idPaciente) { this.idPaciente = idPaciente; }

    public int getIdExpediente() { return idExpediente; }
    public void setIdExpediente(int idExpediente) { this.idExpediente = idExpediente; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public int getIdSangre() { return idSangre; }
    public void setIdSangre(int idSangre) { this.idSangre = idSangre; }

    public String getNombreSangre() { return nombreSangre; }
    public void setNombreSangre(String nombreSangre) { this.nombreSangre = nombreSangre; }

    public String getNombreSeguroMed() { return nombreSeguroMed; }
    public void setNombreSeguroMed(String nombreSeguroMed) { this.nombreSeguroMed = nombreSeguroMed; }
}