package com.mycompany.medigestion.modelo;

/**
 * @author gabri
 */
public class DetalleFactura {
    private int idDetalle;
    private int idFactura;
    private int idProducto;
    private int cantidad;
    private double precioUnitario;
    
    // Variables auxiliares para la vista (Carrito)
    private String nombreProducto; 
    private double totalFila;

    public DetalleFactura() {}

    public int getIdDetalle() { return idDetalle; }
    public void setIdDetalle(int idDetalle) { this.idDetalle = idDetalle; }

    public int getIdFactura() { return idFactura; }
    public void setIdFactura(int idFactura) { this.idFactura = idFactura; }

    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(double precioUnitario) { this.precioUnitario = precioUnitario; }

    public String getNombreProducto() { return nombreProducto; }
    public void setNombreProducto(String nombreProducto) { this.nombreProducto = nombreProducto; }

    public double getTotalFila() { return totalFila; }
    public void setTotalFila(double totalFila) { this.totalFila = totalFila; }
}
