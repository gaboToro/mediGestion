package com.mycompany.medigestion.ventana;

import com.mycompany.medigestion.dao.MedicoDAO;
import com.mycompany.medigestion.dao.PacienteDAO;
import com.mycompany.medigestion.dao.SangreDAO;
import com.mycompany.medigestion.modelo.Especialidad;
import com.mycompany.medigestion.modelo.Medico;
import com.mycompany.medigestion.modelo.Paciente;
import com.mycompany.medigestion.modelo.Sangre;
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
public class PacienteVentana extends javax.swing.JFrame {
    
    private String cedulaMedicoSeleccionada = "";
    private String cedulaPacienteSeleccionada = "";
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PacienteVentana.class.getName());
 
    public PacienteVentana() {
        /*if(!UsuarioSesion.isLogueado()){
            JOptionPane.showMessageDialog(null, "Acceso denegado. Por favor, inicie sesión", "Seguridad", JOptionPane.WARNING_MESSAGE);
            new LoginVentana().setVisible(true);
            this.dispose();
            return;
        }*/
        
        
        initComponents();
        cargarTabla();
        cargarTiposSangre();
        
        try {
            //Imagen de fondo
            ImageIcon iconoFondo = new ImageIcon(getClass().getResource("/imagenes/fondo_mg.jpg"));
            Image imagenFondoEscalada = iconoFondo.getImage().getScaledInstance(1450, 700, Image.SCALE_SMOOTH);
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
                    
        }catch(Exception e){
            System.out.println("Error al cargar imagenes: " + e.getMessage());        
        }
    }
    
    private void cargarTiposSangre() {
        jc_sangre.removeAllItems();
        SangreDAO dao = new SangreDAO();
        for (Sangre s : dao.listar()) {
            jc_sangre.addItem(s);
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
        tabla_pacientes = new javax.swing.JTable();
        l_cedula = new javax.swing.JLabel();
        l_fechaNacimiento = new javax.swing.JLabel();
        l_nombre = new javax.swing.JLabel();
        l_telefono = new javax.swing.JLabel();
        l_sangre = new javax.swing.JLabel();
        l_sexo = new javax.swing.JLabel();
        l_numExpediente = new javax.swing.JLabel();
        l_direccion = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        jc_fechaNacimiento = new com.toedter.calendar.JDateChooser();
        txt_nombre = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        jc_sangre = new javax.swing.JComboBox<>();
        jc_sexo = new javax.swing.JComboBox<>();
        txt_expediente = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        l_seguroMedico1 = new javax.swing.JLabel();
        txt_seguroMed1 = new javax.swing.JTextField();
        l_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pacientes - MediGestión");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        l_titulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        l_titulo.setForeground(new java.awt.Color(0, 102, 153));
        l_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_titulo.setText("MÓDULO PACIENTES");
        jPanel1.add(l_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1120, 30));
        jPanel1.add(l_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 150, 80));

        l_bienvenido.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_bienvenido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_bienvenido.setText("Bienvenido/a");
        jPanel1.add(l_bienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1120, 40));

        btn_cerrarsesion.setBackground(new java.awt.Color(204, 204, 255));
        btn_cerrarsesion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_cerrarsesion.setForeground(new java.awt.Color(0, 102, 153));
        btn_cerrarsesion.setText("CERRAR SESIÓN");
        btn_cerrarsesion.addActionListener(this::btn_cerrarsesionActionPerformed);
        jPanel1.add(btn_cerrarsesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 40, -1, -1));

        btn_volver.setBackground(new java.awt.Color(204, 204, 255));
        btn_volver.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_volver.setForeground(new java.awt.Color(0, 102, 153));
        btn_volver.setText("VOLVER");
        btn_volver.addActionListener(this::btn_volverActionPerformed);
        jPanel1.add(btn_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 390, -1, -1));

        tabla_pacientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabla_pacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cédula", "Nombre", "F. Nacimiento", "Sangre", "Expediente", "Seguro Médico", "Teléfono", "Sexo", "Dirección"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_pacientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tabla_pacientes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 730, 230));

        l_cedula.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_cedula.setText("Cédula:");
        jPanel1.add(l_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        l_fechaNacimiento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_fechaNacimiento.setText("Fecha de Nacimiento");
        jPanel1.add(l_fechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, -1, -1));

        l_nombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_nombre.setText("Nombre:");
        jPanel1.add(l_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        l_telefono.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_telefono.setText("Teléfono: ");
        jPanel1.add(l_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, -1, -1));

        l_sangre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_sangre.setText("Sangre");
        jPanel1.add(l_sangre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        l_sexo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_sexo.setText("Sexo:");
        jPanel1.add(l_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, -1, -1));

        l_numExpediente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_numExpediente.setText("N° Expediente:");
        jPanel1.add(l_numExpediente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        l_direccion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_direccion.setText("Dirección");
        jPanel1.add(l_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, -1, -1));

        txt_cedula.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 140, -1));
        jPanel1.add(jc_fechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 140, -1));

        txt_nombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 140, -1));

        txt_telefono.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 140, -1));

        jc_sangre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(jc_sangre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 140, -1));

        jc_sexo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jc_sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        jc_sexo.setToolTipText("");
        jc_sexo.setName(""); // NOI18N
        jPanel1.add(jc_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 140, -1));

        txt_expediente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_expediente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_expedienteKeyTyped(evt);
            }
        });
        jPanel1.add(txt_expediente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 220, -1));

        txt_direccion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 140, -1));

        btn_buscar.setBackground(new java.awt.Color(204, 204, 255));
        btn_buscar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_buscar.setForeground(new java.awt.Color(0, 102, 153));
        btn_buscar.setText("BUSCAR");
        btn_buscar.addActionListener(this::btn_buscarActionPerformed);
        jPanel1.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 110, -1));

        btn_agregar.setBackground(new java.awt.Color(204, 204, 255));
        btn_agregar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_agregar.setForeground(new java.awt.Color(0, 102, 153));
        btn_agregar.setText("AGREGAR");
        btn_agregar.addActionListener(this::btn_agregarActionPerformed);
        jPanel1.add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 110, -1));

        btn_modificar.setBackground(new java.awt.Color(204, 204, 255));
        btn_modificar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_modificar.setForeground(new java.awt.Color(0, 102, 153));
        btn_modificar.setText("MODIFICAR");
        btn_modificar.addActionListener(this::btn_modificarActionPerformed);
        jPanel1.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 110, -1));

        btn_eliminar.setBackground(new java.awt.Color(204, 204, 255));
        btn_eliminar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(0, 102, 153));
        btn_eliminar.setText("ELIMINAR");
        btn_eliminar.addActionListener(this::btn_eliminarActionPerformed);
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 110, -1));

        btn_actualizar.setBackground(new java.awt.Color(204, 204, 255));
        btn_actualizar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_actualizar.setForeground(new java.awt.Color(0, 102, 153));
        btn_actualizar.setText("ACTUALIZAR");
        btn_actualizar.addActionListener(this::btn_actualizarActionPerformed);
        jPanel1.add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 90, -1, -1));

        l_seguroMedico1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_seguroMedico1.setText("Seguro Médico:");
        jPanel1.add(l_seguroMedico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        txt_seguroMed1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txt_seguroMed1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 140, -1));
        jPanel1.add(l_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
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
        String cedula = txt_cedula.getText();

        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(null, "INGRESE LA CÉDULA PARA BUSCAR", "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        PacienteDAO dao = new PacienteDAO();
        Paciente pac = dao.buscar(cedula);

        if (pac != null) {
            // 1. Cajas de texto normales (mostramos el expediente aunque esté bloqueado)
            txt_nombre.setText(pac.getFullName());
            txt_expediente.setText(String.valueOf(pac.getIdExpediente()));
            txt_telefono.setText(pac.getTelefono());
            txt_direccion.setText(pac.getDireccion());
            txt_seguroMed1.setText(pac.getNombreSeguroMed());

            //Convertir String a java.util.Date
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date fechaParseada = sdf.parse(pac.getFechaNacimiento());
                jc_fechaNacimiento.setDate(fechaParseada);
            } catch (Exception e) {
                jc_fechaNacimiento.setDate(null); // Si hay error, lo dejamos en blanco
            }

            //ComboBox de Sexo (Como es un String directo, solo le decimos que lo seleccione)
            String sexoBD = pac.getSexo();
            if (sexoBD != null) {
                for (int i = 0; i < jc_sexo.getItemCount(); i++) {
                    String opcionMenu = jc_sexo.getItemAt(i).toString();
                    if (opcionMenu.trim().equalsIgnoreCase(sexoBD.trim())) {
                        jc_sexo.setSelectedIndex(i);
                        break;
                    }
                }
            }

            //ComboBox Dinámico de Sangre (Buscamos por ID)
            for (int i = 0; i < jc_sangre.getItemCount(); i++) {
                Sangre s = (Sangre) jc_sangre.getItemAt(i);
                if (s.getIdTipo() == pac.getIdSangre()) {
                    jc_sangre.setSelectedIndex(i);
                    break;
                }
            }

            //Guardamos en memoria
            cedulaPacienteSeleccionada = pac.getIdPaciente();

        } else {
            JOptionPane.showMessageDialog(null, "NO SE ENCONTRO NINGÚN PACIENTE CON LA CÉDULA INGRESADA", "NO ENCONTRADO", JOptionPane.INFORMATION_MESSAGE);
            cedulaPacienteSeleccionada = "";
        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        String cedula = txt_cedula.getText();
        String nombre = txt_nombre.getText();
        String telefono = txt_telefono.getText();
        String direccion = txt_direccion.getText();
        String seguro = txt_expediente.getText();
        
        // Validación de fecha (JDateChooser)
        Date fechaSeleccionada = jc_fechaNacimiento.getDate();
        if (cedula.isEmpty() || nombre.isEmpty() || fechaSeleccionada == null || telefono == null || direccion == null) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, COMPLETE LOS CAMPOS (Cédula, Nombre, Expediente, Teléfono, Dirección y Fecha).");
            return;
        }

        // Formatear la fecha para MySQL
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String fechaSQL = sdf.format(fechaSeleccionada);

        // Extraer datos de los ComboBox
        String sexo = jc_sexo.getSelectedItem().toString();
        Sangre sangreSeleccionada = (Sangre) jc_sangre.getSelectedItem();
        int idSangre = sangreSeleccionada.getIdTipo();

        // Empaquetar
        Paciente nuevoPac = new Paciente();
        nuevoPac.setIdPaciente(cedula);
        nuevoPac.setFullName(nombre);
        nuevoPac.setFechaNacimiento(fechaSQL);
        nuevoPac.setSexo(sexo);
        nuevoPac.setTelefono(telefono);
        nuevoPac.setDireccion(direccion);
        nuevoPac.setIdSangre(idSangre);
        nuevoPac.setNombreSeguroMed(seguro);

        // Guardar
        PacienteDAO dao = new PacienteDAO();
        if (dao.insertar(nuevoPac)) {
            JOptionPane.showMessageDialog(null, "PACIENTE REGISTRADO EXITOSAMENTE");
            
            cargarTabla();
            txt_cedula.setText("");
            txt_nombre.setText("");
            txt_expediente.setText("");
            txt_telefono.setText("");
            txt_direccion.setText("");
            txt_seguroMed1.setText("");
            jc_fechaNacimiento.setDate(null);
            jc_sexo.setSelectedIndex(0);
            
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR. VERIFIQUE SI LA CÉDULA O EL EXPEDIENTE YA EXISTEN");
        }
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        if (cedulaPacienteSeleccionada.isEmpty()) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, BUSQUE UN PACIENTE ANTES DE MODIFICAR", "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String nombre = txt_nombre.getText();
        String telefono = txt_telefono.getText();
        String direccion = txt_direccion.getText();
        String seguro = txt_seguroMed1.getText();
        Date fechaSeleccionada = jc_fechaNacimiento.getDate();

        if (nombre.isEmpty() || fechaSeleccionada == null) {
            JOptionPane.showMessageDialog(null, "EL NOMBRE Y LA FECHA DE NACIMIENTO SON OBLIGATORIOS", "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaSQLString = sdf.format(fechaSeleccionada);

        String sexo = jc_sexo.getSelectedItem().toString();

        Sangre sangreSeleccionada = (Sangre) jc_sangre.getSelectedItem();
        int idSangre = sangreSeleccionada.getIdTipo();

        Paciente pacEditado = new Paciente();
        // Usamos la cédula en memoria para evitar que el usuario la altere y rompa el WHERE
        pacEditado.setIdPaciente(cedulaPacienteSeleccionada);
        pacEditado.setFullName(nombre);
        pacEditado.setFechaNacimiento(fechaSQLString);
        pacEditado.setSexo(sexo);
        pacEditado.setTelefono(telefono);
        pacEditado.setDireccion(direccion);
        pacEditado.setIdSangre(idSangre);
        pacEditado.setNombreSeguroMed(seguro);

        PacienteDAO dao = new PacienteDAO();
        if (dao.modificar(pacEditado)) {
            JOptionPane.showMessageDialog(null, "PACIENTE MODIFICADO EXITOSAMENTE");

            cedulaPacienteSeleccionada = "";
            txt_cedula.setText("");
            txt_nombre.setText("");
            txt_expediente.setText("");
            txt_telefono.setText("");
            txt_direccion.setText("");
            txt_seguroMed1.setText("");
            jc_fechaNacimiento.setDate(null);
            jc_sexo.setSelectedIndex(0);
            if (jc_sangre.getItemCount() > 0) {
                jc_sangre.setSelectedIndex(0);
            }

            cargarTabla();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL MODIFICAR EL PACIENTE", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        if (cedulaPacienteSeleccionada.isEmpty()) {
            JOptionPane.showMessageDialog(this, "POR FAVOR, BUSQUE UN PACIENTE ANTES DE ELIMINAR", "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String nombre = txt_nombre.getText();
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar permanentemente al paciente '" + nombre + "'?", "CONFIRMAR ELIMINACIÓN", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (respuesta == JOptionPane.YES_OPTION) {
            PacienteDAO dao = new PacienteDAO();

            if (dao.eliminar(cedulaPacienteSeleccionada)) {
                JOptionPane.showMessageDialog(null, "PACIENTE ELIMINADO EXITOSAMENTE");

                // Limpiar memoria y cajas
                cedulaPacienteSeleccionada = "";
                txt_cedula.setText("");
                txt_nombre.setText("");
                txt_expediente.setText("");
                txt_telefono.setText("");
                txt_direccion.setText("");
                txt_seguroMed1.setText("");
                jc_fechaNacimiento.setDate(null);
                jc_sexo.setSelectedIndex(0);
                if (jc_sangre.getItemCount() > 0) {
                    jc_sangre.setSelectedIndex(0);
                }

                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "O SE PUDO ELIMINAR EL PACIENTE. VERIFIQUE SI TIENE HISTORIAL CLÍNICO O CITAS VINCULADAS", "ACCIÓN DENEGADA", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
         cargarTabla();
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void txt_expedienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_expedienteKeyTyped
        // Si el carácter presionado NO es un número, se bloquea
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_expedienteKeyTyped

    private void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tabla_pacientes.getModel();

        modelo.setRowCount(0);

        PacienteDAO dao = new PacienteDAO();
        List<Paciente> lista = dao.listar();

        for (Paciente pac : lista) {
            Object[] fila = new Object[9];
            fila[0] = pac.getIdPaciente();         
            fila[1] = pac.getFullName();           
            fila[2] = pac.getFechaNacimiento();    
            fila[3] = pac.getNombreSangre();    
            fila[4] = pac.getIdExpediente();
            fila[5] = pac.getNombreSeguroMed();    
            fila[6] = pac.getTelefono();           
            fila[7] = pac.getSexo();               
            fila[8] = pac.getDireccion();          

            modelo.addRow(fila);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new PacienteVentana().setVisible(true));
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
    private com.toedter.calendar.JDateChooser jc_fechaNacimiento;
    private javax.swing.JComboBox<Sangre> jc_sangre;
    private javax.swing.JComboBox<String> jc_sexo;
    private javax.swing.JLabel l_bienvenido;
    private javax.swing.JLabel l_cedula;
    private javax.swing.JLabel l_direccion;
    private javax.swing.JLabel l_fechaNacimiento;
    private javax.swing.JLabel l_fondo;
    private javax.swing.JLabel l_logo;
    private javax.swing.JLabel l_nombre;
    private javax.swing.JLabel l_numExpediente;
    private javax.swing.JLabel l_sangre;
    private javax.swing.JLabel l_seguroMedico1;
    private javax.swing.JLabel l_sexo;
    private javax.swing.JLabel l_telefono;
    private javax.swing.JLabel l_titulo;
    private javax.swing.JTable tabla_pacientes;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_expediente;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_seguroMed1;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables

}