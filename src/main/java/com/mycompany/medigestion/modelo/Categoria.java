package com.mycompany.medigestion.modelo;

/**
 * @author gabri
 */
public class Categoria {
    private int idCategoria;
    private String nombreCategoria; // Mapea a la columna 'nombre_prod' de tu tabla de categorías

    public Categoria() {}

    public Categoria(int idCategoria, String nombreCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
    }

    public int getIdCategoria() { return idCategoria; }
    public void setIdCategoria(int idCategoria) { this.idCategoria = idCategoria; }

    public String getNombreCategoria() { return nombreCategoria; }
    public void setNombreCategoria(String nombreCategoria) { this.nombreCategoria = nombreCategoria; }

    @Override
    public String toString() {
        return this.nombreCategoria;
    }
}