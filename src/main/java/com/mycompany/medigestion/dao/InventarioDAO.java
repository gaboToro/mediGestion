package com.mycompany.medigestion.dao;

import com.mycompany.medigestion.modelo.Medicamento;
import com.mycompany.medigestion.conexion.ConexionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author gabri
 */
public class InventarioDAO implements CRUD<Medicamento, Integer> {

    @Override
    public boolean insertar(Medicamento med) {
        // Omitimos id_producto porque es AUTO_INCREMENT
        String sql = "INSERT INTO inventario (nombre_prod, id_categoria, precio, stock, stock_minimo, fecha_vencimiento) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement consulta = conexion.prepareStatement(sql)) {
            
            consulta.setString(1, med.getNombreProd());
            consulta.setInt(2, med.getIdCategoria());
            consulta.setDouble(3, med.getPrecio());
            consulta.setInt(4, med.getStock());
            consulta.setInt(5, med.getStockMinimo());
            
            // Convertimos la fecha de String a SQL Date
            java.sql.Date fechaSQL = java.sql.Date.valueOf(med.getFechaVencimiento());
            consulta.setDate(6, fechaSQL); 
            
            consulta.execute();
            return true;
            
        } catch (Exception e) {
            System.out.println("ERROR al insertar en inventario: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Medicamento> listar() {
        List<Medicamento> lista = new ArrayList<>();
        // INNER JOIN usando ALIAS para diferenciar los 'nombre_prod'
        String sql = "SELECT i.id_producto, i.nombre_prod, i.id_categoria, i.precio, i.stock, i.stock_minimo, i.fecha_vencimiento, "
                + "c.nombre_prod AS nombre_categoria "
                + "FROM inventario i "
                + "INNER JOIN categoria_prod c ON i.id_categoria = c.id_categoria";

        try (Connection conexion = ConexionDB.getConexion(); PreparedStatement consulta = conexion.prepareStatement(sql); ResultSet resultado = consulta.executeQuery()) {

            while (resultado.next()) {
                Medicamento med = new Medicamento();
                med.setIdProducto(resultado.getInt("id_producto"));
                med.setNombreProd(resultado.getString("nombre_prod")); // El de la tabla inventario
                med.setIdCategoria(resultado.getInt("id_categoria"));
                med.setPrecio(resultado.getDouble("precio"));
                med.setStock(resultado.getInt("stock"));
                med.setStockMinimo(resultado.getInt("stock_minimo"));

                java.sql.Date fechaSQL = resultado.getDate("fecha_vencimiento");
                med.setFechaVencimiento(fechaSQL != null ? fechaSQL.toString() : "");

                med.setNombreCategoria(resultado.getString("nombre_categoria")); // El alias del JOIN

                lista.add(med);
            }
        } catch (Exception e) {
            System.out.println("ERROR al listar inventario: " + e.getMessage());
        }
        return lista;
    }

    // Métodos pendientes para la siguiente fase
    @Override
    public boolean modificar(Medicamento med) {
        String sql = "UPDATE inventario SET nombre_prod=?, id_categoria=?, precio=?, stock=?, stock_minimo=?, fecha_vencimiento=? WHERE id_producto=?";

        try (Connection conexion = ConexionDB.getConexion(); PreparedStatement consulta = conexion.prepareStatement(sql)) {

            consulta.setString(1, med.getNombreProd());
            consulta.setInt(2, med.getIdCategoria());
            consulta.setDouble(3, med.getPrecio());
            consulta.setInt(4, med.getStock());
            consulta.setInt(5, med.getStockMinimo());

            Date fechaSQL = Date.valueOf(med.getFechaVencimiento());
            consulta.setDate(6, fechaSQL);

            consulta.setInt(7, med.getIdProducto()); // El ID para el WHERE

            consulta.execute();
            return true;

        } catch (Exception e) {
            System.out.println("ERROR al modificar inventario: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(Integer id) {
        String sql = "DELETE FROM inventario WHERE id_producto=?";
        
        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement consulta = conexion.prepareStatement(sql)) {
            
            consulta.setInt(1, id);
            consulta.execute();
            return true;
            
        } catch (Exception e) {
            System.out.println("ERROR al eliminar del inventario: " + e.getMessage());
            return false;
        }
    }

    public Medicamento buscar(int id) {
        Medicamento med = null;
        String sql = "SELECT * FROM inventario WHERE id_producto = ?";

        try (Connection conexion = ConexionDB.getConexion(); PreparedStatement consulta = conexion.prepareStatement(sql)) {

            consulta.setInt(1, id);
            ResultSet resultado = consulta.executeQuery();

            if (resultado.next()) {
                med = new Medicamento();
                med.setIdProducto(resultado.getInt("id_producto"));
                med.setNombreProd(resultado.getString("nombre_prod"));
                med.setIdCategoria(resultado.getInt("id_categoria"));
                med.setPrecio(resultado.getDouble("precio"));
                med.setStock(resultado.getInt("stock"));
                med.setStockMinimo(resultado.getInt("stock_minimo"));

                java.sql.Date fechaSQL = resultado.getDate("fecha_vencimiento");
                med.setFechaVencimiento(fechaSQL != null ? fechaSQL.toString() : "");
            }
        } catch (Exception e) {
            System.out.println("ERROR al buscar medicamento: " + e.getMessage());
        }
        return med;
    }
}
