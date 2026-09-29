package com.mycompany.medigestion.dao;

import com.mycompany.medigestion.conexion.ConexionDB;
import com.mycompany.medigestion.modelo.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gabri
 */
public class MedicoDAO implements CRUD<Medico> {

    @Override
    public boolean insertar(Medico med) {
        String sql = "INSERT INTO medico (id_medico, full_name, licencia_medica, id_especialidad, telefono, email) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionDB.getConexion(); 
                PreparedStatement consulta = conexion.prepareStatement(sql)) {

            consulta.setString(1, med.getIdMedico()); // La cédula
            consulta.setString(2, med.getFullName());
            consulta.setString(3, med.getLicenciaMedica());
            consulta.setInt(4, med.getIdEspecialidad());
            consulta.setString(5, med.getTelefono());
            consulta.setString(6, med.getEmail());

            consulta.execute();
            return true;

        } catch (Exception exp) {
            System.out.println("ERROR al insertar médico: " + exp.getMessage());
            return false;
        }
    }

    @Override
    public boolean modificar(Medico objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Medico> listar() {
        List<Medico> lista = new ArrayList<>();
        // El INNER JOIN trae el nombre de la especialidad
        String sql = "SELECT m.id_medico, m.full_name, m.licencia_medica, " +
                     "m.id_especialidad, e.nombre, " + 
                     "m.telefono, m.email " +
                     "FROM medico m " +
                     "INNER JOIN especialidad e ON m.id_especialidad = e.id_especialidad";
        
        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement consulta = conexion.prepareStatement(sql);
             java.sql.ResultSet resultado = consulta.executeQuery()) {
            
            while(resultado.next()){
                Medico med = new Medico();
                med.setIdMedico(resultado.getString("id_medico"));
                med.setFullName(resultado.getString("full_name"));
                med.setLicenciaMedica(resultado.getString("licencia_medica"));
                med.setTelefono(resultado.getString("telefono"));
                med.setEmail(resultado.getString("email"));
                
                // Guardamos el ID y el Nombre de la especialidad
                med.setIdEspecialidad(resultado.getInt("id_especialidad"));
                med.setNombreEspecialidad(resultado.getString("nombre"));
                
                lista.add(med);
            }
        } catch(Exception e) {
            System.out.println("ERROR al listar médicos: " + e.getMessage());
        }
        return lista;
    }
    
}
