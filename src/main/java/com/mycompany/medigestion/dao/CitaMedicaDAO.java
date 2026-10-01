package com.mycompany.medigestion.dao;

import com.mycompany.medigestion.modelo.CitaMedica;
import com.mycompany.medigestion.conexion.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
/**
 * @author gabri
 */
public class CitaMedicaDAO implements CRUD<CitaMedica, Integer> {

    @Override
    public boolean insertar(CitaMedica cita) {
        String sql = "INSERT INTO cita_medica (id_paciente, id_medico, fecha_hora, motivo, estado) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement consulta = conexion.prepareStatement(sql)) {
            
            consulta.setString(1, cita.getIdPaciente());
            consulta.setString(2, cita.getIdMedico());
            
            // Convertimos el String "YYYY-MM-DD HH:MM:SS" a Timestamp de SQL
            Timestamp fechaHoraSQL = Timestamp.valueOf(cita.getFechaHora());
            consulta.setTimestamp(3, fechaHoraSQL);
            
            consulta.setString(4, cita.getMotivo());
            consulta.setString(5, cita.getEstado());
            
            consulta.execute();
            return true;
            
        } catch (Exception e) {
            System.out.println("ERROR al insertar cita: " + e.getMessage());
            return false;
        }
    }

    public List<CitaMedica> buscarPorCedula(String cedulaPaciente) {
        List<CitaMedica> lista = new ArrayList<>();
        String sql = "SELECT c.id_cita, c.id_paciente, p.full_name AS nombre_paciente, " +
                     "c.id_medico, m.full_name AS nombre_medico, " +
                     "c.fecha_hora, c.motivo, c.estado " +
                     "FROM cita_medica c " +
                     "INNER JOIN paciente p ON c.id_paciente = p.id_paciente " +
                     "INNER JOIN medico m ON c.id_medico = m.id_medico " +
                     "WHERE c.id_paciente = ?";
        
        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement consulta = conexion.prepareStatement(sql)) {
            
            consulta.setString(1, cedulaPaciente);
            try (ResultSet resultado = consulta.executeQuery()) {
                while(resultado.next()){
                    CitaMedica cita = new CitaMedica();
                    cita.setIdCita(resultado.getInt("id_cita"));
                    cita.setIdPaciente(resultado.getString("id_paciente"));
                    cita.setNombrePaciente(resultado.getString("nombre_paciente")); 
                    cita.setIdMedico(resultado.getString("id_medico"));
                    cita.setNombreMedico(resultado.getString("nombre_medico"));     
                    
                    Timestamp fechaHoraSQL = resultado.getTimestamp("fecha_hora");
                    cita.setFechaHora(fechaHoraSQL != null ? fechaHoraSQL.toString() : "");
                    
                    cita.setMotivo(resultado.getString("motivo"));
                    cita.setEstado(resultado.getString("estado"));
                    
                    lista.add(cita);
                }
            }
        } catch(Exception e) {
            System.out.println("ERROR al buscar citas por paciente: " + e.getMessage());
        }
        return lista;
    }
    
    @Override
    public List<CitaMedica> listar() {
        List<CitaMedica> lista = new ArrayList<>();
        // Doble INNER JOIN para obtener nombres en lugar de IDs
        String sql = "SELECT c.id_cita, c.id_paciente, p.full_name AS nombre_paciente, " +
                     "c.id_medico, m.full_name AS nombre_medico, " +
                     "c.fecha_hora, c.motivo, c.estado " +
                     "FROM cita_medica c " +
                     "INNER JOIN paciente p ON c.id_paciente = p.id_paciente " +
                     "INNER JOIN medico m ON c.id_medico = m.id_medico";
        
        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement consulta = conexion.prepareStatement(sql);
             ResultSet resultado = consulta.executeQuery()) {
            
            while(resultado.next()){
                CitaMedica cita = new CitaMedica();
                cita.setIdCita(resultado.getInt("id_cita"));
                cita.setIdPaciente(resultado.getString("id_paciente"));
                cita.setNombrePaciente(resultado.getString("nombre_paciente")); // Del JOIN
                cita.setIdMedico(resultado.getString("id_medico"));
                cita.setNombreMedico(resultado.getString("nombre_medico"));     // Del JOIN
                
                // Extraemos como Timestamp y pasamos a String para el modelo
                Timestamp fechaHoraSQL = resultado.getTimestamp("fecha_hora");
                cita.setFechaHora(fechaHoraSQL != null ? fechaHoraSQL.toString() : "");
                
                cita.setMotivo(resultado.getString("motivo"));
                cita.setEstado(resultado.getString("estado"));
                
                lista.add(cita);
            }
        } catch(Exception e) {
            System.out.println("ERROR al listar citas: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public boolean modificar(CitaMedica cita) {
        String sql = "UPDATE cita_medica SET id_paciente=?, id_medico=?, fecha_hora=?, motivo=?, estado=? WHERE id_cita=?";
        
        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement consulta = conexion.prepareStatement(sql)) {
            
            consulta.setString(1, cita.getIdPaciente());
            consulta.setString(2, cita.getIdMedico());
            
            Timestamp fechaHoraSQL = Timestamp.valueOf(cita.getFechaHora());
            consulta.setTimestamp(3, fechaHoraSQL);
            
            consulta.setString(4, cita.getMotivo());
            consulta.setString(5, cita.getEstado());
            consulta.setInt(6, cita.getIdCita()); // El ID capturado para el WHERE
            
            consulta.execute();
            return true;
            
        } catch (Exception e) {
            System.out.println("ERROR al modificar cita: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(Integer id) {
        String sql = "DELETE FROM cita_medica WHERE id_cita=?";
        
        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement consulta = conexion.prepareStatement(sql)) {
            
            consulta.setInt(1, id);
            consulta.execute();
            return true;
            
        } catch (Exception e) {
            System.out.println("ERROR al eliminar cita: " + e.getMessage());
            return false;
        }
    }
}
