package com.mycompany.medigestion.ventana;

import com.mycompany.medigestion.dao.CategoriaDAO;
import com.mycompany.medigestion.dao.InventarioDAO;
import com.mycompany.medigestion.modelo.Categoria;
import com.mycompany.medigestion.modelo.Medicamento;
import com.mycompany.medigestion.util.UsuarioSesion;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author gabri
 */
public class InventarioVentana extends javax.swing.JFrame {
    
    private int idProductoSeleccionado = -1;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(InventarioVentana.class.getName());
 
    public InventarioVentana() {
/*        if(!UsuarioSesion.isLogueado()){
            JOptionPane.showMessageDialog(null, "Acceso denegado. Por favor, inicie sesión", "Seguridad", JOptionPane.WARNING_MESSAGE);
            new LoginVentana().setVisible(true);
            this.dispose();
            return;
        }
        */
        initComponents();
        cargarTabla();
        cargarCategoria();
        
        try {
            //Imagen de fondo
            ImageIcon iconoFondo = new ImageIcon(getClass().getResource("/imagenes/fondo_mg.jpg"));
            Image imagenFondoEscalada = iconoFondo.getImage().getScaledInstance(950, 700, Image.SCALE_SMOOTH);
            l_fondo.setIcon(new ImageIcon(imagenFondoEscalada));
            
            //Imagen de logo
            ImageIcon iconoLogo = new ImageIcon(getClass().getResource("/imagenes/logo_mg.png"));
            Image imagenLogoEscalada = iconoLogo.getImage().getScaledInstance(140, 70, Image.SCALE_SMOOTH);
            l_logo.setIcon(new ImageIcon(imagenLogoEscalada));
            
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

        } catch (Exception e) {
            System.out.println("Error al cargar imagenes: " + e.getMessage());
        }
    }

    private void cargarCategoria() {
        jc_categoria.removeAllItems();
        CategoriaDAO dao = new CategoriaDAO();
        for (Categoria c : dao.listar()) {
            jc_categoria.addItem(c);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        l_titulo = new javax.swing.JLabel();
        l_logo = new javax.swing.JLabel();
        l_bienvenido = new javax.swing.JLabel();
        btn_cerrarsesion = new javax.swing.JButton();
        btn_volver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_inventario = new javax.swing.JTable();
        l_codigo = new javax.swing.JLabel();
        l_producto = new javax.swing.JLabel();
        l_categoria = new javax.swing.JLabel();
        l_precio = new javax.swing.JLabel();
        l_stock = new javax.swing.JLabel();
        l_fechaVencimiento = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_producto = new javax.swing.JTextField();
        jc_categoria = new javax.swing.JComboBox<>();
        txt_precio = new javax.swing.JTextField();
        txt_stock = new javax.swing.JTextField();
        jc_fechaVencimiento = new com.toedter.calendar.JDateChooser();
        btn_buscar = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        l_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventario - MediGestión");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        l_titulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        l_titulo.setForeground(new java.awt.Color(0, 102, 153));
        l_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_titulo.setText("INVENTARIO");
        jPanel1.add(l_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 930, 30));
        jPanel1.add(l_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 150, 80));

        l_bienvenido.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_bienvenido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_bienvenido.setText("Bienvenido/a");
        jPanel1.add(l_bienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 930, 40));

        btn_cerrarsesion.setBackground(new java.awt.Color(204, 204, 255));
        btn_cerrarsesion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_cerrarsesion.setForeground(new java.awt.Color(0, 102, 153));
        btn_cerrarsesion.setText("CERRAR SESIÓN");
        btn_cerrarsesion.addActionListener(this::btn_cerrarsesionActionPerformed);
        jPanel1.add(btn_cerrarsesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, -1, -1));

        btn_volver.setBackground(new java.awt.Color(204, 204, 255));
        btn_volver.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_volver.setForeground(new java.awt.Color(0, 102, 153));
        btn_volver.setText("VOLVER");
        btn_volver.addActionListener(this::btn_volverActionPerformed);
        jPanel1.add(btn_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 380, -1, -1));

        tabla_inventario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabla_inventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Producto", "Categoría", "Precio", "Stock", "Fecha Vencimiento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Double.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_inventario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tabla_inventario);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 730, 230));

        l_codigo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_codigo.setText("Código:");
        jPanel1.add(l_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        l_producto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_producto.setText("Producto:");
        jPanel1.add(l_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        l_categoria.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_categoria.setText("Categoría: ");
        jPanel1.add(l_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        l_precio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_precio.setText("Precio:");
        jPanel1.add(l_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        l_stock.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_stock.setText("Stock:");
        jPanel1.add(l_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        l_fechaVencimiento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_fechaVencimiento.setText("Fecha Vencimiento:");
        jPanel1.add(l_fechaVencimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        txt_codigo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txt_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 140, -1));

        txt_producto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txt_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 140, -1));

        jc_categoria.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(jc_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 140, -1));

        txt_precio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 140, -1));

        txt_stock.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txt_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 140, -1));
        jPanel1.add(jc_fechaVencimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 140, -1));

        btn_buscar.setBackground(new java.awt.Color(204, 204, 255));
        btn_buscar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_buscar.setForeground(new java.awt.Color(0, 102, 153));
        btn_buscar.setText("BUSCAR");
        btn_buscar.addActionListener(this::btn_buscarActionPerformed);
        jPanel1.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, 110, -1));

        btn_agregar.setBackground(new java.awt.Color(204, 204, 255));
        btn_agregar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_agregar.setForeground(new java.awt.Color(0, 102, 153));
        btn_agregar.setText("AGREGAR");
        btn_agregar.addActionListener(this::btn_agregarActionPerformed);
        jPanel1.add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 110, -1));

        btn_modificar.setBackground(new java.awt.Color(204, 204, 255));
        btn_modificar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_modificar.setForeground(new java.awt.Color(0, 102, 153));
        btn_modificar.setText("MODIFICAR");
        btn_modificar.addActionListener(this::btn_modificarActionPerformed);
        jPanel1.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, 110, -1));

        btn_eliminar.setBackground(new java.awt.Color(204, 204, 255));
        btn_eliminar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(0, 102, 153));
        btn_eliminar.setText("ELIMINAR");
        btn_eliminar.addActionListener(this::btn_eliminarActionPerformed);
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, 110, -1));

        btn_actualizar.setBackground(new java.awt.Color(204, 204, 255));
        btn_actualizar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_actualizar.setForeground(new java.awt.Color(0, 102, 153));
        btn_actualizar.setText("ACTUALIZAR");
        btn_actualizar.addActionListener(this::btn_actualizarActionPerformed);
        jPanel1.add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 80, -1, -1));
        jPanel1.add(l_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
        if (respuesta == JOptionPane.YES_OPTION) {
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
        String codigoStr = txt_codigo.getText();

        if (codigoStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el Código del medicamento para buscar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idBusqueda = 0;
        try {
            idBusqueda = Integer.parseInt(codigoStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El Código debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        InventarioDAO dao = new InventarioDAO();
        Medicamento med = dao.buscar(idBusqueda);

        if (med != null) {
            txt_producto.setText(med.getNombreProd());
            txt_precio.setText(String.valueOf(med.getPrecio()));
            txt_stock.setText(String.valueOf(med.getStock()));

            //Convertir String a Date
            try {
                SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                Date fechaParseada = sdf.parse(med.getFechaVencimiento());
                jc_fechaVencimiento.setDate(fechaParseada);
            } catch (Exception e) {
                jc_fechaVencimiento.setDate(null);
            }

            //ComboBox Dinámico de Categoría
            for (int i = 0; i < jc_categoria.getItemCount(); i++) {
                Categoria cat = (Categoria) jc_categoria.getItemAt(i);
                if (cat.getIdCategoria() == med.getIdCategoria()) {
                    jc_categoria.setSelectedIndex(i);
                    break;
                }
            }

            //Guardamos en memoria el ID encontrado
            idProductoSeleccionado = med.getIdProducto();

        } else {
            JOptionPane.showMessageDialog(this, "No se encontró ningún medicamento con ese código.", "No Encontrado", JOptionPane.INFORMATION_MESSAGE);
            idProductoSeleccionado = -1;
        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        String producto = txt_producto.getText();
        String precioStr = txt_precio.getText();
        String stockStr = txt_stock.getText();

        //Extraemos la fecha del JDateChooser
        Date fechaSeleccionada = jc_fechaVencimiento.getDate();

        //Validación de campos vacíos
        if (producto.isEmpty() || precioStr.isEmpty() || stockStr.isEmpty() || fechaSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos obligatorios.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        double precio = 0;
        int stock = 0;

        // Validación numérica: Evitamos que el programa colapse si escriben letras
        try {
            precio = Double.parseDouble(precioStr);
            stock = Integer.parseInt(stockStr);
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "El Precio y el Stock deben ser valores numéricos válidos.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Formatear la fecha para MySQL
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaSQLString = sdf.format(fechaSeleccionada);

        //Extraer categoría seleccionada
        Categoria catSeleccionada = (Categoria) jc_categoria.getSelectedItem();
        if (catSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Seleccione una categoría válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int idCategoria = catSeleccionada.getIdCategoria();

        Medicamento nuevoMed = new Medicamento();
        nuevoMed.setNombreProd(producto);
        nuevoMed.setIdCategoria(idCategoria);
        nuevoMed.setPrecio(precio);
        nuevoMed.setStock(stock);
        nuevoMed.setStockMinimo(5); //Stock  mínimo definido
        nuevoMed.setFechaVencimiento(fechaSQLString);

        //Guardar
        InventarioDAO dao = new InventarioDAO();
        if (dao.insertar(nuevoMed)) {
            JOptionPane.showMessageDialog(this, "Medicamento registrado exitosamente.");

            txt_producto.setText("");
            txt_precio.setText("");
            txt_stock.setText("");
            jc_fechaVencimiento.setDate(null);
            if (jc_categoria.getItemCount() > 0) {
                jc_categoria.setSelectedIndex(0);
            }

            cargarTabla(); // Refrescamos la vista
        } else {
            JOptionPane.showMessageDialog(this, "Error al guardar el medicamento en la base de datos.");
        }
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        if (idProductoSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, busque un medicamento primero.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String producto = txt_producto.getText();
        String precioStr = txt_precio.getText();
        String stockStr = txt_stock.getText();
        Date fechaSeleccionada = jc_fechaVencimiento.getDate();

        if (producto.isEmpty() || precioStr.isEmpty() || stockStr.isEmpty() || fechaSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        double precio = 0;
        int stock = 0;
        try {
            precio = Double.parseDouble(precioStr);
            stock = Integer.parseInt(stockStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El Precio y el Stock deben ser números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaSQLString = sdf.format(fechaSeleccionada);

        Categoria catSeleccionada = (Categoria) jc_categoria.getSelectedItem();
        int idCategoria = catSeleccionada.getIdCategoria();

        Medicamento medEditado = new Medicamento();
        medEditado.setIdProducto(idProductoSeleccionado); 
        medEditado.setNombreProd(producto);
        medEditado.setIdCategoria(idCategoria);
        medEditado.setPrecio(precio);
        medEditado.setStock(stock);
        medEditado.setStockMinimo(5); 
        medEditado.setFechaVencimiento(fechaSQLString);

        InventarioDAO dao = new InventarioDAO();
        if (dao.modificar(medEditado)) {
            JOptionPane.showMessageDialog(this, "Medicamento modificado exitosamente.");

            idProductoSeleccionado = -1;
            txt_codigo.setText("");
            txt_producto.setText("");
            txt_precio.setText("");
            txt_stock.setText("");
            jc_fechaVencimiento.setDate(null);
            if (jc_categoria.getItemCount() > 0) {
                jc_categoria.setSelectedIndex(0);
            }

            cargarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al modificar el medicamento.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        if (idProductoSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, busque un medicamento primero.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String producto = txt_producto.getText();
        int respuesta = JOptionPane.showConfirmDialog(this,
                "¿Está seguro que desea eliminar el medicamento '" + producto + "' del inventario?",
                "Confirmar Eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
            InventarioDAO dao = new InventarioDAO();

            if (dao.eliminar(idProductoSeleccionado)) {
                JOptionPane.showMessageDialog(this, "Medicamento eliminado exitosamente.");

                idProductoSeleccionado = -1;
                txt_codigo.setText("");
                txt_producto.setText("");
                txt_precio.setText("");
                txt_stock.setText("");
                jc_fechaVencimiento.setDate(null);
                if (jc_categoria.getItemCount() > 0) {
                    jc_categoria.setSelectedIndex(0);
                }

                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(this,
                        "No se pudo eliminar el medicamento.",
                        "Error",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
         cargarTabla();
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tabla_inventario.getModel();
        modelo.setRowCount(0);

        InventarioDAO dao = new InventarioDAO();
        List<Medicamento> lista = dao.listar();

        for (com.mycompany.medigestion.modelo.Medicamento med : lista) {
            Object[] fila = new Object[6];
            fila[0] = med.getIdProducto();         
            fila[1] = med.getNombreProd();         
            fila[2] = med.getNombreCategoria();    
            fila[3] = med.getPrecio();             
            fila[4] = med.getStock();              
            fila[5] = med.getFechaVencimiento();   

            modelo.addRow(fila);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new InventarioVentana().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cerrarsesion;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<com.mycompany.medigestion.modelo.Categoria> jc_categoria;
    private com.toedter.calendar.JDateChooser jc_fechaVencimiento;
    private javax.swing.JLabel l_bienvenido;
    private javax.swing.JLabel l_categoria;
    private javax.swing.JLabel l_codigo;
    private javax.swing.JLabel l_fechaVencimiento;
    private javax.swing.JLabel l_fondo;
    private javax.swing.JLabel l_logo;
    private javax.swing.JLabel l_precio;
    private javax.swing.JLabel l_producto;
    private javax.swing.JLabel l_stock;
    private javax.swing.JLabel l_titulo;
    private javax.swing.JTable tabla_inventario;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_precio;
    private javax.swing.JTextField txt_producto;
    private javax.swing.JTextField txt_stock;
    // End of variables declaration//GEN-END:variables

}