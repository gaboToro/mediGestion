package com.mycompany.medigestion.modelo;

import java.util.ArrayList;
import java.util.List;
/**
 * @author gabri
 */

public class Factura {
    private int idFactura;
    private String idPaciente;
    private int idUser;
    private String fechaHoraEmision;
    private String tipoPago;
    private int porcentajeSeguro;
    private double subtotal;
    private int descuentoTotal;
    private double totalPago;
    
    // El "Carrito de compras"
    private List<DetalleFactura> detalles;

    public Factura() {
        this.detalles = new ArrayList<>();
    }

    public int getIdFactura() { return idFactura; }
    public void setIdFactura(int idFactura) { this.idFactura = idFactura; }

    public String getIdPaciente() { return idPaciente; }
    public void setIdPaciente(String idPaciente) { this.idPaciente = idPaciente; }

    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }

    public String getFechaHoraEmision() { return fechaHoraEmision; }
    public void setFechaHoraEmision(String fechaHoraEmision) { this.fechaHoraEmision = fechaHoraEmision; }

    public String getTipoPago() { return tipoPago; }
    public void setTipoPago(String tipoPago) { this.tipoPago = tipoPago; }

    public int getPorcentajeSeguro() { return porcentajeSeguro; }
    public void setPorcentajeSeguro(int porcentajeSeguro) { this.porcentajeSeguro = porcentajeSeguro; }

    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }

    public int getDescuentoTotal() { return descuentoTotal; }
    public void setDescuentoTotal(int descuentoTotal) { this.descuentoTotal = descuentoTotal; }

    public double getTotalPago() { return totalPago; }
    public void setTotalPago(double totalPago) { this.totalPago = totalPago; }

    public List<DetalleFactura> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleFactura> detalles) { this.detalles = detalles; }
}