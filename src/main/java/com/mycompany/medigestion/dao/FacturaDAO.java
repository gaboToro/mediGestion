package com.mycompany.medigestion.dao;

import com.mycompany.medigestion.modelo.DetalleFactura;
import com.mycompany.medigestion.modelo.Factura;
import com.mycompany.medigestion.conexion.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * @author gabri
 */
public class FacturaDAO {

    public boolean registrarFactura(Factura factura) {
        Connection conexion = null;
        
        try {
            conexion = ConexionDB.getConexion();
            // Desactivamos el auto-guardado para iniciar la TRANSACCIÓN
            conexion.setAutoCommit(false); 

            // Guardar la Cabecera (fac_dato)
            String sqlCabecera = "INSERT INTO fac_dato (id_paciente, id_user, fecha_hora_emision, tipo_pago, porcentaje_seguro, subtotal, descuento_total, total_pago) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            
            // RETURN_GENERATED_KEYS nos permite recuperar el ID que MySQL le asigne a esta factura
            PreparedStatement psCabecera = conexion.prepareStatement(sqlCabecera, Statement.RETURN_GENERATED_KEYS);
            psCabecera.setString(1, factura.getIdPaciente());
            psCabecera.setInt(2, factura.getIdUser()); 
            psCabecera.setTimestamp(3, java.sql.Timestamp.valueOf(factura.getFechaHoraEmision()));
            psCabecera.setString(4, factura.getTipoPago());
            psCabecera.setInt(5, factura.getPorcentajeSeguro());
            psCabecera.setDouble(6, factura.getSubtotal());
            psCabecera.setInt(7, factura.getDescuentoTotal());
            psCabecera.setDouble(8, factura.getTotalPago());
            
            psCabecera.executeUpdate();

            // Recuperar el ID de la factura generada
            ResultSet rs = psCabecera.getGeneratedKeys();
            int idFacturaGenerada = 0;
            if (rs.next()) {
                idFacturaGenerada = rs.getInt(1);
            }

            // Preparar consultas para Detalle e Inventario
            String sqlDetalle = "INSERT INTO fac_detalle (id_factura, id_producto, cantidad, precio_unitario) VALUES (?, ?, ?, ?)";
            String sqlStock = "UPDATE inventario SET stock = stock - ? WHERE id_producto = ?";
            
            PreparedStatement psDetalle = conexion.prepareStatement(sqlDetalle);
            PreparedStatement psStock = conexion.prepareStatement(sqlStock);

            // recorrer el carrito para ejecutar el detalle y restar stock
            for (DetalleFactura det : factura.getDetalles()) {
                // Insertar en fac_detalle
                psDetalle.setInt(1, idFacturaGenerada);
                psDetalle.setInt(2, det.getIdProducto());
                psDetalle.setInt(3, det.getCantidad());
                psDetalle.setDouble(4, det.getPrecioUnitario());
                psDetalle.addBatch(); // Lo añadimos al lote de tareas

                // Restar del inventario
                psStock.setInt(1, det.getCantidad());
                psStock.setInt(2, det.getIdProducto());
                psStock.addBatch();
            }
            
            // Ejecutamos todas las inserciones y actualizaciones en bloque
            psDetalle.executeBatch();
            psStock.executeBatch();

            // CONFIRMAR LA TRANSACCIÓN (Si todo salió bien, guardamos los cambios)
            conexion.commit(); 
            return true;

        } catch (Exception e) {
            // Si hubo CUALQUIER error, deshacemos todos los cambios
            try {
                if (conexion != null) conexion.rollback();
            } catch (Exception ex) {
                System.out.println("Error crítico al deshacer: " + ex.getMessage());
            }
            System.out.println("ERROR al registrar factura: " + e.getMessage());
            return false;
        } finally {
            // Restaurar el autoCommit por defecto para futuras consultas
            try {
                if (conexion != null) conexion.setAutoCommit(true);
                if (conexion != null) conexion.close();
            } catch (Exception e) {}
        }
    }
}