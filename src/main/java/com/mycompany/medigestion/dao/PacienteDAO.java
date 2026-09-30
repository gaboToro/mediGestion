package com.mycompany.medigestion.dao;

import com.mycompany.medigestion.conexion.ConexionDB;
import com.mycompany.medigestion.modelo.Paciente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gabri
 */
public class PacienteDAO implements CRUD<Paciente, String> {

    @Override
    public boolean insertar(Paciente pac) {
        String sql = "INSERT INTO paciente (id_paciente, full_name, fecha_nacimiento, sexo, telefono, direccion, id_sangre, nombre_seguro_med) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement consulta = conexion.prepareStatement(sql)) {
            
            consulta.setString(1, pac.getIdPaciente());
            consulta.setString(2, pac.getFullName());
            
            java.sql.Date fechaSQL = java.sql.Date.valueOf(pac.getFechaNacimiento());
            consulta.setDate(3, fechaSQL); 
            
            consulta.setString(4, pac.getSexo());
            consulta.setString(5, pac.getTelefono());
            consulta.setString(6, pac.getDireccion());
            consulta.setInt(7, pac.getIdSangre());
            consulta.setString(8, pac.getNombreSeguroMed());
            
            consulta.execute();
            return true;
            
        } catch (Exception e) {
            System.out.println("ERROR al insertar paciente: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Paciente> listar() {
        List<Paciente> lista = new ArrayList<>();
        // INNER JOIN para traer el nombre del tipo de sangre
        String sql = "SELECT p.id_paciente, p.id_expediente, p.full_name, p.fecha_nacimiento, " +
                     "p.sexo, p.telefono, p.direccion, p.id_sangre, s.nombre_tipo, p.nombre_seguro_med " +
                     "FROM paciente p " +
                     "INNER JOIN sangre s ON p.id_sangre = s.id_tipo";
        
        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement consulta = conexion.prepareStatement(sql);
             ResultSet resultado = consulta.executeQuery()) {
            
            while(resultado.next()){
                Paciente pac = new Paciente();
                pac.setIdPaciente(resultado.getString("id_paciente"));
                pac.setIdExpediente(resultado.getInt("id_expediente"));
                pac.setFullName(resultado.getString("full_name"));
                
                Date fechaSQL = resultado.getDate("fecha_nacimiento");
                pac.setFechaNacimiento(fechaSQL != null ? fechaSQL.toString() : "");

                pac.setSexo(resultado.getString("sexo"));
                pac.setTelefono(resultado.getString("telefono"));
                pac.setDireccion(resultado.getString("direccion"));
                pac.setIdSangre(resultado.getInt("id_sangre"));
                pac.setNombreSangre(resultado.getString("nombre_tipo")); // Dato del JOIN
                pac.setNombreSeguroMed(resultado.getString("nombre_seguro_med"));
                
                lista.add(pac);
            }
        } catch(Exception e) {
            System.out.println("ERROR al listar pacientes: " + e.getMessage());
        }
        return lista;
    }

    public Paciente buscar(String cedula) {
        Paciente pac = null;
        String sql = "SELECT * FROM paciente WHERE id_paciente = ?";
        
        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement consulta = conexion.prepareStatement(sql)) {
            
            consulta.setString(1, cedula);
            ResultSet resultado = consulta.executeQuery();
            
            if (resultado.next()) {
                pac = new Paciente();
                pac.setIdPaciente(resultado.getString("id_paciente"));
                pac.setIdExpediente(resultado.getInt("id_expediente"));
                pac.setFullName(resultado.getString("full_name"));
                
                java.sql.Date fechaSQL = resultado.getDate("fecha_nacimiento");
                pac.setFechaNacimiento(fechaSQL != null ? fechaSQL.toString() : "");
                
                pac.setSexo(resultado.getString("sexo"));
                pac.setTelefono(resultado.getString("telefono"));
                pac.setDireccion(resultado.getString("direccion"));
                pac.setIdSangre(resultado.getInt("id_sangre"));
                pac.setNombreSeguroMed(resultado.getString("nombre_seguro_med"));
            }
        } catch (Exception e) {
            System.out.println("ERROR al buscar paciente: " + e.getMessage());
        }
        return pac;
    }
    
    // Deja modificar() y eliminar() retornando false por ahora
    @Override
    public boolean modificar(Paciente pac) { 
        String sql = "UPDATE paciente SET full_name=?, fecha_nacimiento=?, sexo=?, telefono=?, direccion=?, id_sangre=?, nombre_seguro_med=? WHERE id_paciente=?";
        
        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement consulta = conexion.prepareStatement(sql)) {
            
            consulta.setString(1, pac.getFullName());
            
            // Convertimos la fecha de String a SQL Date
            java.sql.Date fechaSQL = java.sql.Date.valueOf(pac.getFechaNacimiento());
            consulta.setDate(2, fechaSQL); 
            
            consulta.setString(3, pac.getSexo());
            consulta.setString(4, pac.getTelefono());
            consulta.setString(5, pac.getDireccion());
            consulta.setInt(6, pac.getIdSangre());
            consulta.setString(7, pac.getNombreSeguroMed());
            consulta.setString(8, pac.getIdPaciente()); 
            
            consulta.execute();
            return true;
            
        } catch (Exception e) {
            System.out.println("ERROR al modificar paciente: " + e.getMessage());
            return false;
        } 
    }

    @Override
    public boolean eliminar(String cedula) { 
        String sql = "DELETE FROM paciente WHERE id_paciente=?";
        
        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement consulta = conexion.prepareStatement(sql)) {
            
            consulta.setString(1, cedula);
            consulta.execute();
            return true;
            
        } catch (Exception e) {
            System.out.println("ERROR al eliminar paciente: " + e.getMessage());
            return false;
        }
    }
}