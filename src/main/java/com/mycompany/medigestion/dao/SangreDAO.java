package com.mycompany.medigestion.dao;

import com.mycompany.medigestion.conexion.ConexionDB;
import com.mycompany.medigestion.modelo.Sangre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gabri
 */
public class SangreDAO {
    
    // Solo necesitamos el método listar para llenar el ComboBox
    public List<Sangre> listar() {
        List<Sangre> lista = new ArrayList<>();
        String sql = "SELECT * FROM sangre";
        
        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement consulta = conexion.prepareStatement(sql);
             ResultSet resultado = consulta.executeQuery()) {
            
            while(resultado.next()){
                Sangre sangre = new Sangre();
                sangre.setIdTipo(resultado.getInt("id_tipo"));
                sangre.setNombreTipo(resultado.getString("nombre_tipo"));
                
                lista.add(sangre);
            }
        } catch(Exception e) {
            System.out.println("ERROR al listar tipos de sangre: " + e.getMessage());
        }
        return lista;
    }    
}