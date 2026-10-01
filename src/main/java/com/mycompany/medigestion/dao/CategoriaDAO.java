package com.mycompany.medigestion.dao;

import com.mycompany.medigestion.modelo.Categoria;
import com.mycompany.medigestion.conexion.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabri
 */

public class CategoriaDAO {
    public List<Categoria> listar() {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categoria_prod";
        
        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement consulta = conexion.prepareStatement(sql);
             ResultSet resultado = consulta.executeQuery()) {
            
            while(resultado.next()){
                Categoria c = new Categoria();
                c.setIdCategoria(resultado.getInt("id_categoria"));
                c.setNombreCategoria(resultado.getString("nombre_prod")); 
                lista.add(c);
            }
        } catch(Exception e) {
            System.out.println("ERROR al listar categorías: " + e.getMessage());
        }
        return lista;
    }
}
