package com.mycompany.medigestion.ventana;

import com.mycompany.medigestion.dao.FacturaDAO;
import com.mycompany.medigestion.dao.InventarioDAO;
import com.mycompany.medigestion.dao.PacienteDAO;
import com.mycompany.medigestion.modelo.DetalleFactura;
import com.mycompany.medigestion.modelo.Factura;
import com.mycompany.medigestion.modelo.Medicamento;
import com.mycompany.medigestion.modelo.Paciente;
import com.mycompany.medigestion.util.UsuarioSesion;
import java.awt.Image;
import java.awt.Toolkit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gabri
 */
public class FacturaVentana extends javax.swing.JFrame {
    
    private List<DetalleFactura> carrito = new ArrayList<>();
    private int filaSeleccionadaCarrito = -1;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FacturaVentana.class.getName());
 
    public FacturaVentana() {
        if(!UsuarioSesion.isLogueado()){
            JOptionPane.showMessageDialog(null, "Acceso denegado. Por favor, inicie sesión", "Seguridad", JOptionPane.WARNING_MESSAGE);
            new LoginVentana().setVisible(true);
            this.dispose();
            return;
        }
        
        initComponents();
        actualizarTablaCarrito();
        
        try {
            //Imagen de fondo
            ImageIcon iconoFondo = new ImageIcon(getClass().getResource("/imagenes/fondo_mg.jpg"));
            Image imagenFondoEscalada = iconoFondo.getImage().getScaledInstance(900, 700, Image.SCALE_SMOOTH);
            l_fondo.setIcon(new ImageIcon(imagenFondoEscalada));
            
            //Imagen de icono
            Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/icono_mg.png"));
            setIconImage(icono);
            
            //Imagenes iconos
            int anchoIcono = 40;
            int altoIcono = 40;
            
            ImageIcon iconoCerrarSesion = new ImageIcon(getClass().getResource("/imagenes/cerrar-sesion.png"));
            Image imagenSesionEscalada = iconoCerrarSesion.getImage().getScaledInstance(anchoIcono, altoIcono, Image.SCALE_SMOOTH);
            ImageIcon iconoFinalSesion = new ImageIcon(imagenSesionEscalada);
            btn_cerrarsesion.setIcon(iconoFinalSesion);
            
            ImageIcon iconoVolver = new ImageIcon(getClass().getResource("/imagenes/volver-flecha.png"));
            Image imagenVolverEscalada = iconoVolver.getImage().getScaledInstance(anchoIcono, altoIcono, Image.SCALE_SMOOTH);
            ImageIcon iconoFinalVolver = new ImageIcon(imagenVolverEscalada);
            btn_volver.setIcon(iconoFinalVolver);
            
            //Centrar pantalla, bloquear bordes, finalice con X
            setLocationRelativeTo(null);
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            l_bienvenido.setText("Bienvenido/a " + UsuarioSesion.getNombreCompleto());
                    
        }catch(Exception e){
            System.out.println("Error al cargar imagenes: " + e.getMessage());        
        }
    }
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_cerrarsesion = new javax.swing.JButton();
        l_titulo = new javax.swing.JLabel();
        l_bienvenido = new javax.swing.JLabel();
        btn_volver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_factura = new javax.swing.JTable();
        l_cedula = new javax.swing.JLabel();
        l_nombre = new javax.swing.JLabel();
        l_pago = new javax.swing.JLabel();
        l_codProducto = new javax.swing.JLabel();
        l_nombreProd = new javax.swing.JLabel();
        l_cantidad = new javax.swing.JLabel();
        l_totalPagar = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        jc_pago = new javax.swing.JComboBox<>();
        txt_codProducto = new javax.swing.JTextField();
        txt_nombreProd = new javax.swing.JTextField();
        js_cantidad = new javax.swing.JSpinner();
        txt_totalPagar = new javax.swing.JTextField();
        btn_generarFactura = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        l_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Facturación - MediGestión");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_cerrarsesion.setBackground(new java.awt.Color(204, 204, 255));
        btn_cerrarsesion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_cerrarsesion.setForeground(new java.awt.Color(0, 102, 153));
        btn_cerrarsesion.setText("CERRAR SESIÓN");
        btn_cerrarsesion.addActionListener(this::btn_cerrarsesionActionPerformed);
        jPanel1.add(btn_cerrarsesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, -1, -1));

        l_titulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        l_titulo.setForeground(new java.awt.Color(0, 102, 153));
        l_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_titulo.setText("FACTURACIÓN");
        jPanel1.add(l_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 790, 30));

        l_bienvenido.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_bienvenido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_bienvenido.setText("Bienvenido/a");
        jPanel1.add(l_bienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 790, 40));

        btn_volver.setBackground(new java.awt.Color(204, 204, 255));
        btn_volver.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_volver.setForeground(new java.awt.Color(0, 102, 153));
        btn_volver.setText("VOLVER");
        btn_volver.addActionListener(this::btn_volverActionPerformed);
        jPanel1.add(btn_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 370, -1, -1));

        tabla_factura.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabla_factura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cód. Producto", "Producto", "Cantidad", "P. Unitario", "P. Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_factura.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabla_factura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_facturaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_factura);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 750, 230));

        l_cedula.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_cedula.setText("Cédula:");
        jPanel1.add(l_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        l_nombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_nombre.setText("Nombre:");
        jPanel1.add(l_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        l_pago.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_pago.setText("Pago:");
        jPanel1.add(l_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));

        l_codProducto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_codProducto.setText("Código:");
        jPanel1.add(l_codProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, -1, -1));

        l_nombreProd.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_nombreProd.setText("Nombre:");
        jPanel1.add(l_nombreProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, -1, -1));

        l_cantidad.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_cantidad.setText("Cantidad:");
        jPanel1.add(l_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, -1));

        l_totalPagar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_totalPagar.setText("Total a pagar:");
        jPanel1.add(l_totalPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, -1));

        txt_cedula.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 110, -1));

        txt_nombre.setEditable(false);
        txt_nombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 140, -1));

        jc_pago.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jc_pago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Tarjeta", "Seguro Médico" }));
        jPanel1.add(jc_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 120, -1));

        txt_codProducto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_codProducto.addActionListener(this::txt_codProductoActionPerformed);
        jPanel1.add(txt_codProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 110, -1));

        txt_nombreProd.setEditable(false);
        txt_nombreProd.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txt_nombreProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, 140, -1));
        jPanel1.add(js_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 80, -1));

        txt_totalPagar.setEditable(false);
        txt_totalPagar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txt_totalPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 110, -1));

        btn_generarFactura.setBackground(new java.awt.Color(204, 204, 255));
        btn_generarFactura.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_generarFactura.setForeground(new java.awt.Color(0, 102, 153));
        btn_generarFactura.setText("GENERAR FACTURA");
        btn_generarFactura.addActionListener(this::btn_generarFacturaActionPerformed);
        jPanel1.add(btn_generarFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 160, 40));

        btn_buscar.setBackground(new java.awt.Color(204, 204, 255));
        btn_buscar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_buscar.setForeground(new java.awt.Color(0, 102, 153));
        btn_buscar.setText("BUSCAR");
        btn_buscar.addActionListener(this::btn_buscarActionPerformed);
        jPanel1.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 110, -1));

        btn_agregar.setBackground(new java.awt.Color(204, 204, 255));
        btn_agregar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_agregar.setForeground(new java.awt.Color(0, 102, 153));
        btn_agregar.setText("AGREGAR");
        btn_agregar.addActionListener(this::btn_agregarActionPerformed);
        jPanel1.add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 110, -1));

        btn_eliminar.setBackground(new java.awt.Color(204, 204, 255));
        btn_eliminar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(0, 102, 153));
        btn_eliminar.setText("ELIMINAR");
        btn_eliminar.addActionListener(this::btn_eliminarActionPerformed);
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, 90, -1));
        jPanel1.add(l_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 430));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarsesionActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea cerrar sesión?", "CERRAR SESIÓN", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(respuesta == JOptionPane.YES_OPTION){
            UsuarioSesion.cerrarSesion();
            new LoginVentana().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btn_cerrarsesionActionPerformed

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        new PrincipalVentana().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_volverActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        String cedula = txt_cedula.getText().trim();
        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese la cédula del paciente.");
            return;
        }

        PacienteDAO dao = new PacienteDAO();
        Paciente pac = dao.buscar(cedula);

        if (pac != null) {
            txt_nombre.setText(pac.getFullName());
        } else {
            JOptionPane.showMessageDialog(this, "Paciente no encontrado.");
            txt_nombre.setText("");
        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        String codigoStr = txt_codProducto.getText().trim();
        int cantidad = (int) js_cantidad.getValue();

        if (codigoStr.isEmpty() || cantidad <= 0) {
            JOptionPane.showMessageDialog(this, "Ingrese un código válido y una cantidad mayor a 0.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int idProducto = Integer.parseInt(codigoStr);
            InventarioDAO dao = new InventarioDAO();
            Medicamento med = dao.buscar(idProducto);

            if (med == null) {
                JOptionPane.showMessageDialog(this, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            //Validar Stock
            if (med.getStock() < cantidad) {
                JOptionPane.showMessageDialog(this, "Stock insuficiente. Solo quedan " + med.getStock() + " unidades.", "Stock Agotado", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Verificar si el producto ya está en el carrito para sumar la cantidad
            boolean existeEnCarrito = false;
            for (DetalleFactura det : carrito) {
                if (det.getIdProducto() == idProducto) {
                    if (det.getCantidad() + cantidad > med.getStock()) {
                        JOptionPane.showMessageDialog(this, "La cantidad total en el carrito supera el stock disponible.", "Límite Excedido", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    det.setCantidad(det.getCantidad() + cantidad);
                    det.setTotalFila(det.getCantidad() * det.getPrecioUnitario());
                    existeEnCarrito = true;
                    break;
                }
            }

            //Si no existe, lo creamos y lo añadimos al carrito
            if (!existeEnCarrito) {
                DetalleFactura nuevoDetalle = new DetalleFactura();
                nuevoDetalle.setIdProducto(med.getIdProducto());
                nuevoDetalle.setNombreProducto(med.getNombreProd());
                nuevoDetalle.setCantidad(cantidad);
                nuevoDetalle.setPrecioUnitario(med.getPrecio());
                nuevoDetalle.setTotalFila(cantidad * med.getPrecio());

                carrito.add(nuevoDetalle);
            }

            // 4. Limpiar cajitas de búsqueda y repintar tabla
            txt_codProducto.setText("");
            txt_nombreProd.setText("");
            js_cantidad.setValue(0);

            actualizarTablaCarrito();

        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "El código debe ser un número.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        if (filaSeleccionadaCarrito == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto del carrito para eliminarlo.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Eliminamos el objeto de nuestra lista global
        carrito.remove(filaSeleccionadaCarrito);

        // Limpiamos las cajitas de texto de producto
        txt_codProducto.setText("");
        txt_nombreProd.setText("");
        js_cantidad.setValue(0);

        // Refrescamos la tabla y el total
        actualizarTablaCarrito();
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void txt_codProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codProductoActionPerformed
        String codigoStr = txt_codProducto.getText().trim();
        if (codigoStr.isEmpty()) {
            return;
        }

        try {
            int idProducto = Integer.parseInt(codigoStr);
            InventarioDAO dao = new InventarioDAO();
            Medicamento med = dao.buscar(idProducto);

            if (med != null) {
                txt_nombreProd.setText(med.getNombreProd());
                js_cantidad.setValue(1); // Sugerir 1 por defecto
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Producto no existe en inventario.");
                txt_nombreProd.setText("");
            }
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "El código debe ser un número entero.");
        }
    }//GEN-LAST:event_txt_codProductoActionPerformed

    private void tabla_facturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_facturaMouseClicked
        filaSeleccionadaCarrito = tabla_factura.getSelectedRow();
        if (filaSeleccionadaCarrito == -1) {
            return;
        }

        // Extraer el producto del carrito global
        DetalleFactura detalle = carrito.get(filaSeleccionadaCarrito);

        txt_codProducto.setText(String.valueOf(detalle.getIdProducto()));
        txt_nombreProd.setText(detalle.getNombreProducto());
        js_cantidad.setValue(detalle.getCantidad());
    }//GEN-LAST:event_tabla_facturaMouseClicked

    private void btn_generarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generarFacturaActionPerformed
        String cedula = txt_cedula.getText().trim();
        String totalStr = txt_totalPagar.getText().replace(",", ".");

        if (cedula.isEmpty() || txt_nombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe buscar y seleccionar un paciente.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (carrito.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El carrito está vacío.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Preparar el formato del Tipo de Pago para el ENUM de MySQL
        String pagoSeleccionado = jc_pago.getSelectedItem().toString();
        String tipoPagoDB = "";
        if (pagoSeleccionado.equals("Efectivo")) {
            tipoPagoDB = "efectivo";
        } else if (pagoSeleccionado.equals("Tarjeta")) {
            tipoPagoDB = "tarjeta";
        } else if (pagoSeleccionado.equals("Seguro Medico")) {
            tipoPagoDB = "seguro_medico";
        }

        double totalPagar = Double.parseDouble(totalStr);

        // Obtener Fecha y Hora actual del sistema
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formatoSQL = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHoraEmision = ahora.format(formatoSQL);

        // Empaquetar la cabecera
        Factura nuevaFactura = new Factura();
        nuevaFactura.setIdPaciente(cedula);

        // EXTRAEMOS EL ID DEL USUARIO DESDE LA SESIÓN GLOBAL
        int idCajero = com.mycompany.medigestion.util.UsuarioSesion.getIdUser();
        nuevaFactura.setIdUser(idCajero);

        nuevaFactura.setFechaHoraEmision(fechaHoraEmision);
        nuevaFactura.setTipoPago(tipoPagoDB);
        nuevaFactura.setPorcentajeSeguro(0); // Oculto visualmente
        nuevaFactura.setSubtotal(totalPagar);
        nuevaFactura.setDescuentoTotal(0);   // Oculto visualmente
        nuevaFactura.setTotalPago(totalPagar);

        // Le pasamos nuestro carrito lleno
        nuevaFactura.setDetalles(carrito);

        // Guardar en Base de Datos
        FacturaDAO dao = new FacturaDAO();
        if (dao.registrarFactura(nuevaFactura)) {
            javax.swing.JOptionPane.showMessageDialog(this, "¡Factura generada y cobrada con éxito!");

            // Limpiar completamente la ventana
            txt_cedula.setText("");
            txt_nombre.setText("");
            jc_pago.setSelectedIndex(0);
            txt_codProducto.setText("");
            txt_nombreProd.setText("");
            js_cantidad.setValue(0);
            txt_totalPagar.setText("");

            carrito.clear();
            actualizarTablaCarrito();

        } else {
            JOptionPane.showMessageDialog(this, "Error al generar la factura. Revise la consola.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_generarFacturaActionPerformed

    private void actualizarTablaCarrito() {
        DefaultTableModel modelo = (DefaultTableModel) tabla_factura.getModel();
        modelo.setRowCount(0);

        double totalAcumulado = 0.0;

        for (DetalleFactura det : carrito) {
            Object[] fila = new Object[5];
            fila[0] = det.getIdProducto();
            fila[1] = det.getNombreProducto();
            fila[2] = det.getCantidad();
            fila[3] = det.getPrecioUnitario();
            fila[4] = det.getTotalFila();

            modelo.addRow(fila);

            totalAcumulado += det.getTotalFila();
        }

        // Mostramos el total en la caja de texto inferior
        txt_totalPagar.setText(String.format("%.2f", totalAcumulado));

        // Limpiamos la memoria de selección
        filaSeleccionadaCarrito = -1;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new FacturaVentana().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cerrarsesion;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_generarFactura;
    private javax.swing.JButton btn_volver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jc_pago;
    private javax.swing.JSpinner js_cantidad;
    private javax.swing.JLabel l_bienvenido;
    private javax.swing.JLabel l_cantidad;
    private javax.swing.JLabel l_cedula;
    private javax.swing.JLabel l_codProducto;
    private javax.swing.JLabel l_fondo;
    private javax.swing.JLabel l_nombre;
    private javax.swing.JLabel l_nombreProd;
    private javax.swing.JLabel l_pago;
    private javax.swing.JLabel l_titulo;
    private javax.swing.JLabel l_totalPagar;
    private javax.swing.JTable tabla_factura;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_codProducto;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_nombreProd;
    private javax.swing.JTextField txt_totalPagar;
    // End of variables declaration//GEN-END:variables

}