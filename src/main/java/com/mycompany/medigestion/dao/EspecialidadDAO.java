package com.mycompany.medigestion.dao;

import com.mycompany.medigestion.modelo.Especialidad;
import com.mycompany.medigestion.conexion.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gabri
 */
public class EspecialidadDAO {
    
    // Solo necesitamos el método listar para llenar el ComboBox
    public List<Especialidad> listar() {
        List<Especialidad> lista = new ArrayList<>();
        String sql = "SELECT * FROM especialidad";
        
        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement consulta = conexion.prepareStatement(sql);
             ResultSet resultado = consulta.executeQuery()) {
            
            while(resultado.next()){
                Especialidad esp = new Especialidad();
                esp.setIdEspecialidad(resultado.getInt("id_especialidad"));
                esp.setNombre(resultado.getString("nombre"));
                
                lista.add(esp);
            }
        } catch(Exception e) {
            System.out.println("ERROR al listar especialidades: " + e.getMessage());
        }
        return lista;
    }
}
