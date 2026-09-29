package com.mycompany.medigestion.dao;

import com.mycompany.medigestion.conexion.ConexionDB;
import com.mycompany.medigestion.modelo.Estado;
import com.mycompany.medigestion.modelo.Rol;
import com.mycompany.medigestion.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabri
 */
public class UsuarioDAO implements CRUD<Usuario> {
    
    @Override
    public boolean insertar(Usuario usr) {
        String sql = "INSERT INTO usuario (username, password, full_name, rol, state) VALUES (?, ?, ?, ?, ?)";
        
        try(Connection conexion = ConexionDB.getConexion();
             PreparedStatement consulta = conexion.prepareStatement(sql)){
            
            consulta.setString(1, usr.getUsername());
            consulta.setString(2, usr.getPassword());
            consulta.setString(3, usr.getFullname());
            consulta.setString(4, usr.getRol().name());
            consulta.setString(5, usr.getEstado().name());
            
            consulta.execute();
            return true;
            
        }catch(Exception exp){
            System.out.println("ERROR al insertar usuario: " + exp.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean modificar(Usuario usr) {
        String sql = "UPDATE usuario SET username=?, password=?, full_name=?, rol=?, state=? WHERE id_user=?";
        
        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement consulta = conexion.prepareStatement(sql)) {
            
            consulta.setString(1, usr.getUsername());
            consulta.setString(2, usr.getPassword());
            consulta.setString(3, usr.getFullname());
            consulta.setString(4, usr.getRol().name());
            consulta.setString(5, usr.getEstado().name());
            consulta.setInt(6, usr.getId_User());     
            
            consulta.execute();
            return true;
            
        } catch (Exception exp) {
            System.out.println("ERROR al modificar usuario: " + exp.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Usuario> listar() {
        String sql = "SELECT * FROM usuario";
        List<Usuario> lista = new ArrayList<>();
        try(Connection conexion = ConexionDB.getConexion();
                PreparedStatement consulta = conexion.prepareStatement(sql);
                ResultSet resultado = consulta.executeQuery()){
            
            while(resultado.next()){
                Usuario usr = new Usuario();
                usr.setId_User(resultado.getInt("id_user"));
                usr.setUsername(resultado.getString("username"));
                usr.setPassword(resultado.getString("password"));
                usr.setFullname(resultado.getString("full_name"));
                
                //Convertir el texto de la DB a enum de JAVA
                usr.setRol(Rol.valueOf(resultado.getString("rol")));
                usr.setEstado(Estado.valueOf(resultado.getString("state")));
                
                lista.add(usr);
            }
        }catch(SQLException e){
            System.out.println("ERROR al listar los usuarios: " + e.getMessage());
        }
        return lista;
    }
    
    public Usuario buscarPorUsername(String username) {
        String sql = "SELECT * FROM usuario WHERE username = ?";
        Usuario usr = null;
        
        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement consulta = conexion.prepareStatement(sql)) {
            
            consulta.setString(1, username);
            
            // Ejecutamos la consulta y metemos el ResultSet en el try
            try (ResultSet resultado = consulta.executeQuery()) {
                if (resultado.next()) {
                    usr = new Usuario();
                    usr.setId_User(resultado.getInt("id_user"));
                    usr.setUsername(resultado.getString("username"));
                    usr.setPassword(resultado.getString("password"));
                    usr.setFullname(resultado.getString("full_name"));
                    usr.setRol(Rol.valueOf(resultado.getString("rol")));
                    usr.setEstado(Estado.valueOf(resultado.getString("state")));
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR al buscar usuario: " + e.getMessage());
        }
        
        return usr;
    }
}
