package com.mycompany.medigestion.ventana;

import com.mycompany.medigestion.dao.CitaMedicaDAO;
import com.mycompany.medigestion.dao.MedicoDAO;
import com.mycompany.medigestion.modelo.CitaMedica;
import com.mycompany.medigestion.modelo.Medico;
import com.mycompany.medigestion.util.UsuarioSesion;

import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gabri
 */
public class CitaVentana extends javax.swing.JFrame {
    
    private int idCitaSeleccionada = -1;
    private java.util.List<com.mycompany.medigestion.modelo.CitaMedica> listaCitasGlobal;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CitaVentana.class.getName());
 
    public CitaVentana() {
       /* 
        if(!UsuarioSesion.isLogueado()){
            JOptionPane.showMessageDialog(null, "Acceso denegado. Por favor, inicie sesión", "Seguridad", JOptionPane.WARNING_MESSAGE);
            new LoginVentana().setVisible(true);
            this.dispose();
            return;
        }*/
        
        initComponents();
        // Configurar JSpinner para que solo maneje horas y minutos (formato 24h)
        js_hora.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY));
        js_hora.setEditor(new JSpinner.DateEditor(js_hora, "HH:mm"));
        cargarMedicos();
        cargarTabla();
        
        try {
            //Imagen de fondo
            ImageIcon iconoFondo = new ImageIcon(getClass().getResource("/imagenes/fondo_mg.jpg"));
            Image imagenFondoEscalada = iconoFondo.getImage().getScaledInstance(900, 700, Image.SCALE_SMOOTH);
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
        tabla_citasMedicas = new javax.swing.JTable();
        l_cedulaP = new javax.swing.JLabel();
        l_medico = new javax.swing.JLabel();
        l_fechaHora = new javax.swing.JLabel();
        l_motivo = new javax.swing.JLabel();
        l_estado = new javax.swing.JLabel();
        txt_cedulaP = new javax.swing.JTextField();
        jc_medico = new javax.swing.JComboBox<>();
        jd_fecha = new com.toedter.calendar.JDateChooser();
        js_hora = new javax.swing.JSpinner();
        txt_motivo = new javax.swing.JTextField();
        jc_estado = new javax.swing.JComboBox<>();
        btn_buscar = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        l_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cita Médica - MediGestión");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        l_titulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        l_titulo.setForeground(new java.awt.Color(0, 102, 153));
        l_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_titulo.setText("CITA MÉDICA");
        jPanel1.add(l_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 750, 30));
        jPanel1.add(l_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 150, 80));

        l_bienvenido.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_bienvenido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_bienvenido.setText("Bienvenido/a");
        jPanel1.add(l_bienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 750, 40));

        btn_cerrarsesion.setBackground(new java.awt.Color(204, 204, 255));
        btn_cerrarsesion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_cerrarsesion.setForeground(new java.awt.Color(0, 102, 153));
        btn_cerrarsesion.setText("CERRAR SESIÓN");
        btn_cerrarsesion.addActionListener(this::btn_cerrarsesionActionPerformed);
        jPanel1.add(btn_cerrarsesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 390, -1, -1));

        btn_volver.setBackground(new java.awt.Color(204, 204, 255));
        btn_volver.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_volver.setForeground(new java.awt.Color(0, 102, 153));
        btn_volver.setText("VOLVER");
        btn_volver.addActionListener(this::btn_volverActionPerformed);
        jPanel1.add(btn_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 390, -1, -1));

        tabla_citasMedicas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabla_citasMedicas.setModel(new javax.swing.table.DefaultTableModel(
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
                "Paciente", "Médico", "Fecha y Hora", "Motivo", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tabla_citasMedicas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_citasMedicasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_citasMedicas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 600, 230));

        l_cedulaP.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_cedulaP.setText("Cédula Paciente:");
        jPanel1.add(l_cedulaP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        l_medico.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_medico.setText("Médico: ");
        jPanel1.add(l_medico, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        l_fechaHora.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_fechaHora.setText("Fecha y Hora:");
        jPanel1.add(l_fechaHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        l_motivo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_motivo.setText("Motivo:");
        jPanel1.add(l_motivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        l_estado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_estado.setText("Estado:");
        jPanel1.add(l_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        txt_cedulaP.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txt_cedulaP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 140, -1));

        jc_medico.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(jc_medico, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 140, -1));
        jPanel1.add(jd_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 90, -1));
        jPanel1.add(js_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, -1, -1));

        txt_motivo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txt_motivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 140, -1));

        jc_estado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jc_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "Atendida", "Cancelada" }));
        jc_estado.addActionListener(this::jc_estadoActionPerformed);
        jPanel1.add(jc_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 140, -1));

        btn_buscar.setBackground(new java.awt.Color(204, 204, 255));
        btn_buscar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_buscar.setForeground(new java.awt.Color(0, 102, 153));
        btn_buscar.setText("BUSCAR");
        btn_buscar.addActionListener(this::btn_buscarActionPerformed);
        jPanel1.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 110, -1));

        btn_agregar.setBackground(new java.awt.Color(204, 204, 255));
        btn_agregar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_agregar.setForeground(new java.awt.Color(0, 102, 153));
        btn_agregar.setText("AGREGAR");
        btn_agregar.addActionListener(this::btn_agregarActionPerformed);
        jPanel1.add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 110, -1));

        btn_modificar.setBackground(new java.awt.Color(204, 204, 255));
        btn_modificar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_modificar.setForeground(new java.awt.Color(0, 102, 153));
        btn_modificar.setText("MODIFICAR");
        btn_modificar.addActionListener(this::btn_modificarActionPerformed);
        jPanel1.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 110, -1));

        btn_eliminar.setBackground(new java.awt.Color(204, 204, 255));
        btn_eliminar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(0, 102, 153));
        btn_eliminar.setText("ELIMINAR");
        btn_eliminar.addActionListener(this::btn_eliminarActionPerformed);
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 110, -1));

        btn_actualizar.setBackground(new java.awt.Color(204, 204, 255));
        btn_actualizar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_actualizar.setForeground(new java.awt.Color(0, 102, 153));
        btn_actualizar.setText("ACTUALIZAR");
        btn_actualizar.addActionListener(this::btn_actualizarActionPerformed);
        jPanel1.add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, -1, -1));
        jPanel1.add(l_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 460));

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

    private void cargarMedicos() {
        jc_medico.removeAllItems();
        MedicoDAO dao = new MedicoDAO();
        for (Medico m : dao.listar()) {
            jc_medico.addItem(m);
        }
    }

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
        String cedulaBuscada = txt_cedulaP.getText().trim();

        if (cedulaBuscada.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese la Cédula del paciente para ver su historial de citas.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        CitaMedicaDAO dao = new CitaMedicaDAO();

        //Sobrescribimos nuestra memoria global con la lista filtrada
        listaCitasGlobal = dao.buscarPorCedula(cedulaBuscada);

        if (listaCitasGlobal.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron citas registradas para este paciente.", "Sin Resultados", JOptionPane.INFORMATION_MESSAGE);
        }

        //Repintamos la tabla basándonos en la nueva lista (tenga datos o esté vacía)
        DefaultTableModel modelo = (DefaultTableModel) tabla_citasMedicas.getModel();
        modelo.setRowCount(0);

        for (CitaMedica cita : listaCitasGlobal) {
            Object[] fila = new Object[5];
            fila[0] = cita.getNombrePaciente();
            fila[1] = cita.getNombreMedico();
            fila[2] = cita.getFechaHora();
            fila[3] = cita.getMotivo();
            fila[4] = cita.getEstado();

            modelo.addRow(fila);
        }

        // Limpiamos la selección en memoria por seguridad
        idCitaSeleccionada = -1;

    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        String cedulaP = txt_cedulaP.getText();
        String motivo = txt_motivo.getText();

        // Convertimos a minúsculas para que coincida con el ENUM de la base de datos
        String estadoVisual = jc_estado.getSelectedItem().toString();
        String estadoDB = estadoVisual.toLowerCase();

        Date fecha = jd_fecha.getDate();
        Date horaSpinner = (java.util.Date) js_hora.getValue();

        if (cedulaP.isEmpty() || motivo.isEmpty() || fecha == null) {
            JOptionPane.showMessageDialog(this, "Complete Cédula, Fecha y Motivo.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 1. Extraer el Médico Seleccionado
        Medico medSeleccionado = (Medico) jc_medico.getSelectedItem();
        if (medSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un médico válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String idMedico = medSeleccionado.getIdMedico();

        // 2. FUSIONAR FECHA Y HORA
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

        String fechaStr = formatoFecha.format(fecha);
        String horaStr = formatoHora.format(horaSpinner);
        String fechaHoraMySQL = fechaStr + " " + horaStr; // Resultado ej: "2026-10-15 14:30:00"

        // 3. Empaquetar y Guardar
        CitaMedica nuevaCita = new CitaMedica();
        nuevaCita.setIdPaciente(cedulaP);
        nuevaCita.setIdMedico(idMedico);
        nuevaCita.setFechaHora(fechaHoraMySQL);
        nuevaCita.setMotivo(motivo);
        nuevaCita.setEstado(estadoDB);

        CitaMedicaDAO dao = new CitaMedicaDAO();
        if (dao.insertar(nuevaCita)) {
            JOptionPane.showMessageDialog(this, "Cita agendada exitosamente.");

            txt_cedulaP.setText("");
            txt_motivo.setText("");
            jd_fecha.setDate(null);
            if (jc_medico.getItemCount() > 0) {
                jc_medico.setSelectedIndex(0);
            }
            jc_estado.setSelectedIndex(0);

            cargarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al guardar. Verifique que la cédula del paciente exista.", "Error DB", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        if (idCitaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una cita de la tabla primero.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String cedulaP = txt_cedulaP.getText();
        String motivo = txt_motivo.getText();
        String estadoDB = jc_estado.getSelectedItem().toString().toLowerCase();

        Date fecha = jd_fecha.getDate();
        Date horaSpinner = (Date) js_hora.getValue();

        if (cedulaP.isEmpty() || motivo.isEmpty() || fecha == null) {
            JOptionPane.showMessageDialog(this, "Complete Cédula, Fecha y Motivo.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Medico medSeleccionado = (Medico) jc_medico.getSelectedItem();
        String idMedico = medSeleccionado.getIdMedico();

        // FUSIONAR FECHA Y HORA
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        String fechaHoraMySQL = formatoFecha.format(fecha) + " " + formatoHora.format(horaSpinner);

        CitaMedica citaEditada = new CitaMedica();
        citaEditada.setIdCita(idCitaSeleccionada); // Usamos el ID guardado en memoria
        citaEditada.setIdPaciente(cedulaP);
        citaEditada.setIdMedico(idMedico);
        citaEditada.setFechaHora(fechaHoraMySQL);
        citaEditada.setMotivo(motivo);
        citaEditada.setEstado(estadoDB);

        CitaMedicaDAO dao = new CitaMedicaDAO();
        if (dao.modificar(citaEditada)) {
            JOptionPane.showMessageDialog(this, "Cita modificada exitosamente.");

            idCitaSeleccionada = -1;
            txt_cedulaP.setText("");
            txt_motivo.setText("");
            jd_fecha.setDate(null);
            if (jc_medico.getItemCount() > 0) {
                jc_medico.setSelectedIndex(0);
            }
            jc_estado.setSelectedIndex(0);

            cargarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al modificar. Verifique la cédula del paciente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        if (idCitaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una cita de la tabla primero.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int respuesta = javax.swing.JOptionPane.showConfirmDialog(this,
                "¿Está seguro que desea cancelar y eliminar esta cita médica de los registros?",
                "Confirmar Eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
            CitaMedicaDAO dao = new CitaMedicaDAO();

            if (dao.eliminar(idCitaSeleccionada)) {
                JOptionPane.showMessageDialog(this, "Cita eliminada exitosamente.");

                idCitaSeleccionada = -1;
                txt_cedulaP.setText("");
                txt_motivo.setText("");
                jd_fecha.setDate(null);
                if (jc_medico.getItemCount() > 0) {
                    jc_medico.setSelectedIndex(0);
                }
                jc_estado.setSelectedIndex(0);

                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar la cita.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        txt_cedulaP.setText("");
        txt_motivo.setText("");
        jd_fecha.setDate(null);
        if (jc_medico.getItemCount() > 0) {
            jc_medico.setSelectedIndex(0);
        }
        jc_estado.setSelectedIndex(0);
        idCitaSeleccionada = -1;

        cargarTabla();
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void jc_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jc_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jc_estadoActionPerformed

    private void tabla_citasMedicasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_citasMedicasMouseClicked
        int fila = tabla_citasMedicas.getSelectedRow();
        if (fila == -1) {
            return; // Si no hay fila seleccionada, no hace nada
        }
        //Obtenemos la cita exacta usando nuestra lista global
        com.mycompany.medigestion.modelo.CitaMedica cita = listaCitasGlobal.get(fila);

        // Guardamos el ID invisible en memoria
        idCitaSeleccionada = cita.getIdCita();

        //Llenamos los textos básicos
        txt_cedulaP.setText(cita.getIdPaciente());
        txt_motivo.setText(cita.getMotivo());

        //Seleccionamos el Estado (ignorando mayúsculas/minúsculas)
        String estadoDB = cita.getEstado();
        if (estadoDB != null) {
            for (int i = 0; i < jc_estado.getItemCount(); i++) {
                if (jc_estado.getItemAt(i).toString().trim().equalsIgnoreCase(estadoDB.trim())) {
                    jc_estado.setSelectedIndex(i);
                    break;
                }
            }
        }

        //Seleccionamos el Médico
        for (int i = 0; i < jc_medico.getItemCount(); i++) {
            Medico m = (Medico) jc_medico.getItemAt(i);
            if (m.getIdMedico().equals(cita.getIdMedico())) {
                jc_medico.setSelectedIndex(i);
                break;
            }
        }

        //Separar DATETIME (ej: "2026-10-15 14:30:00") para JDateChooser y JSpinner
        try {
            SimpleDateFormat formatoCompleto = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date fechaHoraUtil = formatoCompleto.parse(cita.getFechaHora());

            // Le pasamos el mismo objeto Date a ambos componentes, ellos extraerán lo que necesitan
            jd_fecha.setDate(fechaHoraUtil);
            js_hora.setValue(fechaHoraUtil);
        } catch (Exception e) {
            jd_fecha.setDate(null);
        }
    }//GEN-LAST:event_tabla_citasMedicasMouseClicked

    private void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tabla_citasMedicas.getModel();
        modelo.setRowCount(0);

        CitaMedicaDAO dao = new CitaMedicaDAO();
        listaCitasGlobal = dao.listar();

        for (CitaMedica cita : listaCitasGlobal) {
            Object[] fila = new Object[5];
            fila[0] = cita.getNombrePaciente(); // Mostramos el nombre, no la cédula
            fila[1] = cita.getNombreMedico();   // Mostramos el nombre del médico
            fila[2] = cita.getFechaHora();      // Formato YYYY-MM-DD HH:MM:SS
            fila[3] = cita.getMotivo();
            fila[4] = cita.getEstado();         // Pendiente, atendida...

            modelo.addRow(fila);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new CitaVentana().setVisible(true));
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
    private javax.swing.JComboBox<String> jc_estado;
    private javax.swing.JComboBox<com.mycompany.medigestion.modelo.Medico> jc_medico;
    private com.toedter.calendar.JDateChooser jd_fecha;
    private javax.swing.JSpinner js_hora;
    private javax.swing.JLabel l_bienvenido;
    private javax.swing.JLabel l_cedulaP;
    private javax.swing.JLabel l_estado;
    private javax.swing.JLabel l_fechaHora;
    private javax.swing.JLabel l_fondo;
    private javax.swing.JLabel l_logo;
    private javax.swing.JLabel l_medico;
    private javax.swing.JLabel l_motivo;
    private javax.swing.JLabel l_titulo;
    private javax.swing.JTable tabla_citasMedicas;
    private javax.swing.JTextField txt_cedulaP;
    private javax.swing.JTextField txt_motivo;
    // End of variables declaration//GEN-END:variables
}