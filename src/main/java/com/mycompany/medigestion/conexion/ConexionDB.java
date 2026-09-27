package com.mycompany.medigestion.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class ConexionDB {
    private static String db = "medigestion_db";
    private static String url = "jdbc:mysql://localhost:3306/"+db;
    private static String user = "root";
    private static String pass = "admin";
    
    public static Connection getConexion(){
        Connection conexion = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url,user, pass);
        
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR en la conexión con la BASE DE DATOS", "ERROR" , JOptionPane.ERROR_MESSAGE);
            System.out.println("ERROR en la conexión: " + ex.getMessage());
        }catch(ClassNotFoundException exp){
            JOptionPane.showMessageDialog(null, "ERROR al encontrar el driver de MySQL", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println("ERROR con el driver de MySQL: " + exp.getMessage());
        }
        
        return conexion;
    }
    
    public static void main (String[] args){
        Connection conex = ConexionDB.getConexion();
        
        if(conex != null){
            System.out.println("Conexión establecida");
            JOptionPane.showMessageDialog(null, "Conexión establecida");
            try{
                conex.close();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "No se pudo cerrar la conexión de la BASE DE DATOS", "ERROR", JOptionPane.ERROR_MESSAGE);
                System.out.println("ERROR al cerrar la conexion con la DB: " + e.getMessage());
            }
        }else{
            System.out.println("No se pudo establecer la conexión con la base de datos");
            JOptionPane.showMessageDialog(null, "Error al intentar la conexión con la BASE DE DATOS");
        }     
    }
}