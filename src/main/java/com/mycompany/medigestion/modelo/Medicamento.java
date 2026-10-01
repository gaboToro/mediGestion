package com.mycompany.medigestion.modelo;

/**
 * @author gabri
 */
public class Medicamento {
    private int idProducto;
    private String nombreProd;
    private int idCategoria;
    private double precio;
    private int stock;
    private int stockMinimo;
    private String fechaVencimiento; // Se manejará con JDateChooser igual que los pacientes
    
    // Variable auxiliar para mostrar la categoría en el JTable
    private String nombreCategoria; 

    public Medicamento() {}

    // Getters y Setters
    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }

    public String getNombreProd() { return nombreProd; }
    public void setNombreProd(String nombreProd) { this.nombreProd = nombreProd; }

    public int getIdCategoria() { return idCategoria; }
    public void setIdCategoria(int idCategoria) { this.idCategoria = idCategoria; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public int getStockMinimo() { return stockMinimo; }
    public void setStockMinimo(int stockMinimo) { this.stockMinimo = stockMinimo; }

    public String getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(String fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public String getNombreCategoria() { return nombreCategoria; }
    public void setNombreCategoria(String nombreCategoria) { this.nombreCategoria = nombreCategoria; }
}
