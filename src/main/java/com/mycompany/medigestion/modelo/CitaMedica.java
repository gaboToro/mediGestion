package com.mycompany.medigestion.modelo;

/**
 * @author gabri
 */
public class CitaMedica {
    private int idCita;
    private String idPaciente;
    private String idMedico;
    private String fechaHora; // Mantenemos String para la vista, convertiremos a Timestamp en el DAO
    private String motivo;
    private String estado;
    
    // Variables auxiliares para mostrar en el JTable (obtenidas mediante INNER JOIN)
    private String nombrePaciente;
    private String nombreMedico;

    public CitaMedica() {}

    // Getters y Setters base
    public int getIdCita() { return idCita; }
    public void setIdCita(int idCita) { this.idCita = idCita; }

    public String getIdPaciente() { return idPaciente; }
    public void setIdPaciente(String idPaciente) { this.idPaciente = idPaciente; }

    public String getIdMedico() { return idMedico; }
    public void setIdMedico(String idMedico) { this.idMedico = idMedico; }
    
    public String getFechaHora() { return fechaHora; }
    public void setFechaHora(String fechaHora) { this.fechaHora = fechaHora; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    // Getters y Setters auxiliares
    public String getNombrePaciente() { return nombrePaciente; }
    public void setNombrePaciente(String nombrePaciente) { this.nombrePaciente = nombrePaciente; }

    public String getNombreMedico() { return nombreMedico; }
    public void setNombreMedico(String nombreMedico) { this.nombreMedico = nombreMedico; }
}