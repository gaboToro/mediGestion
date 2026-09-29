package com.mycompany.medigestion.ventana;

import com.mycompany.medigestion.dao.EspecialidadDAO;
import com.mycompany.medigestion.dao.MedicoDAO;
import com.mycompany.medigestion.modelo.Especialidad;
import com.mycompany.medigestion.modelo.Medico;
import com.mycompany.medigestion.util.UsuarioSesion;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gabri
 */
public class MedicoVentana extends javax.swing.JFrame {
    
    private int idUsuarioSeleccionado = -1;
    private String hashPasswordSeleccionado = "";
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MedicoVentana.class.getName());
 
    public MedicoVentana() {
        /*
        if(!UsuarioSesion.isLogueado()){
            JOptionPane.showMessageDialog(null, "Acceso denegado. Por favor, inicie sesión", "Seguridad", JOptionPane.WARNING_MESSAGE);
            new LoginVentana().setVisible(true);
            this.dispose();
            return;
        }
        */
        
        initComponents();
        cargarTabla();
        cargarEspecialidades();
        
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
    
    private void cargarEspecialidades() {
        jc_especialidad.removeAllItems();
        //Traemos la lista de la base de datos
        EspecialidadDAO espDAO = new EspecialidadDAO();
        List<Especialidad> lista = espDAO.listar();

        //Metemos los objetos completos al ComboBox
        for (Especialidad esp : lista) {
            jc_especialidad.addItem(esp);
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
        tabla_medicos = new javax.swing.JTable();
        l_cedula = new javax.swing.JLabel();
        l_nombre = new javax.swing.JLabel();
        l_especialidad = new javax.swing.JLabel();
        l_telefono = new javax.swing.JLabel();
        l_email = new javax.swing.JLabel();
        l_licenciaM = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        jc_especialidad = new javax.swing.JComboBox<>();
        txt_telefono = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_licenciaMedica = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        l_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Usuarios - MediGestión");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        l_titulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        l_titulo.setForeground(new java.awt.Color(0, 102, 153));
        l_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_titulo.setText("MÓDULO MÉDICOS");
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
        jPanel1.add(btn_cerrarsesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, -1, -1));

        btn_volver.setBackground(new java.awt.Color(204, 204, 255));
        btn_volver.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_volver.setForeground(new java.awt.Color(0, 102, 153));
        btn_volver.setText("VOLVER");
        btn_volver.addActionListener(this::btn_volverActionPerformed);
        jPanel1.add(btn_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 390, -1, -1));

        tabla_medicos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabla_medicos.setModel(new javax.swing.table.DefaultTableModel(
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
                "Cédula", "Nombre", "Especialidad", "Teléfono", "E-mail", "Licencia Médica"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tabla_medicos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tabla_medicos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 600, 230));

        l_cedula.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_cedula.setText("Cédula:");
        jPanel1.add(l_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        l_nombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_nombre.setText("Nombre:");
        jPanel1.add(l_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        l_especialidad.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_especialidad.setText("Especialidad:");
        jPanel1.add(l_especialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        l_telefono.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_telefono.setText("Teléfono: ");
        jPanel1.add(l_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        l_email.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_email.setText("E-mail:");
        jPanel1.add(l_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        l_licenciaM.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_licenciaM.setText("Licencia Médica:");
        jPanel1.add(l_licenciaM, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        txt_cedula.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 140, -1));

        txt_nombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 140, -1));

        jc_especialidad.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(jc_especialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 140, -1));

        txt_telefono.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 140, -1));

        txt_email.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 140, -1));

        txt_licenciaMedica.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_licenciaMedica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_licenciaMedicaKeyTyped(evt);
            }
        });
        jPanel1.add(txt_licenciaMedica, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 140, -1));

        btn_buscar.setBackground(new java.awt.Color(204, 204, 255));
        btn_buscar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_buscar.setForeground(new java.awt.Color(0, 102, 153));
        btn_buscar.setText("BUSCAR");
        btn_buscar.addActionListener(this::btn_buscarActionPerformed);
        jPanel1.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 110, -1));

        btn_agregar.setBackground(new java.awt.Color(204, 204, 255));
        btn_agregar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_agregar.setForeground(new java.awt.Color(0, 102, 153));
        btn_agregar.setText("AGREGAR");
        btn_agregar.addActionListener(this::btn_agregarActionPerformed);
        jPanel1.add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 110, -1));

        btn_modificar.setBackground(new java.awt.Color(204, 204, 255));
        btn_modificar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_modificar.setForeground(new java.awt.Color(0, 102, 153));
        btn_modificar.setText("MODIFICAR");
        btn_modificar.addActionListener(this::btn_modificarActionPerformed);
        jPanel1.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 110, -1));

        btn_eliminar.setBackground(new java.awt.Color(204, 204, 255));
        btn_eliminar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(0, 102, 153));
        btn_eliminar.setText("ELIMINAR");
        btn_eliminar.addActionListener(this::btn_eliminarActionPerformed);
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, 110, -1));

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
        /*String username = txt_cedula.getText();

        if (username.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "INGRESE EL USUARIO QUE DESEA BUSCAR", "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        UsuarioDAO dao = new UsuarioDAO();
        Usuario usrEncontrado = dao.buscarPorUsername(username);

        if (usrEncontrado != null) {
            //Se guarda la contraseña de forma invisible para usarla luego en "Modificar" o "Eliminar"
            hashPasswordSeleccionado = usrEncontrado.getPassword();
            //Se guarda el ID de forma invisible para usarlo luego en "Modificar" o "Eliminar"
            idUsuarioSeleccionado = usrEncontrado.getId_User();

            txt_nombre.setText(usrEncontrado.getFullname());
            txt_password.setText("");

            //Seleccionamos el valor correcto en el ComboBox de Rol
            if (usrEncontrado.getRol() == Rol.administrador) {
                jc_especialidad.setSelectedItem("Administrador");
            } else if (usrEncontrado.getRol() == Rol.medico) {
                jc_especialidad.setSelectedItem("Médico");
            } else if (usrEncontrado.getRol() == Rol.farmaceutico){
                jc_especialidad.setSelectedItem("Farmaceútico");
            }else{
                jc_especialidad.setSelectedItem("Recepcionista"); // O el texto exacto que tengas en tu diseño
            }

            //Seleccionamos el valor correcto en el ComboBox de Estado
            if (usrEncontrado.getEstado() == Estado.activo) {
                jc_estado.setSelectedItem("Activo");
            } else {
                jc_estado.setSelectedItem("Inactivo");
            }

        } else {
            JOptionPane.showMessageDialog(this, "EL USUARIO '" + username + "' NO EXISTE EN EL SISTEMA.", "NO ENCONTRADO", JOptionPane.INFORMATION_MESSAGE);
            // Reseteamos el ID porque no encontramos a nadie
            idUsuarioSeleccionado = -1;
        }*/
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        String cedula = txt_cedula.getText();
        String nombre = txt_nombre.getText();
        String licencia = txt_licenciaMedica.getText();
        String telefono = txt_telefono.getText();
        String email = txt_email.getText();

        if (cedula.isEmpty() || nombre.isEmpty() || licencia.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(null, "DEBE LLENAR TODOS LOS CAMPOS PARA CONTINUAR", "CAMPOS VACÍOS", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Especialidad espSeleccionada = (Especialidad) jc_especialidad.getSelectedItem();

        int idEspecialidad = espSeleccionada.getIdEspecialidad();

        Medico nuevoMedico = new Medico();
        nuevoMedico.setIdMedico(cedula);
        nuevoMedico.setFullName(nombre);
        nuevoMedico.setLicenciaMedica(licencia);
        nuevoMedico.setIdEspecialidad(idEspecialidad);
        nuevoMedico.setTelefono(telefono);
        nuevoMedico.setEmail(email);

        //Enviar a la base de datos
        MedicoDAO medDAO = new MedicoDAO();
        if (medDAO.insertar(nuevoMedico)) {
            JOptionPane.showMessageDialog(null, "MÉDICO REGISTRADO EXITOSAMENTE");

            txt_cedula.setText("");
            txt_nombre.setText("");
            txt_licenciaMedica.setText("");
            txt_telefono.setText("");
            txt_email.setText("");
            jc_especialidad.setSelectedIndex(0);

            cargarTabla();
        } else {
            // Como la cédula es Primary Key, si ponen una repetida, fallará y caerá aquí.
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR. YA EXISTE UN USUARIO CON ESA CÉDULA", "ERROR", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        /*if (idUsuarioSeleccionado == -1) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, BUSQUE UN USUARIO PRIMERO ANTES DE MODIFICARLO", "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        //Recolectar datos
        String username = txt_cedula.getText();
        String fullname = txt_nombre.getText();
        String passwordStr = new String(txt_password.getPassword());

        if (username.isEmpty() || fullname.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, "DEBE LLENAR LOS CAMPOS 'USUARIO' Y 'NOMBRE'", "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String passwordFinal;
        if (passwordStr.isEmpty()) {
            // Si dejó la caja vacía, le devolvemos el Hash viejo que guardamos en la memoria
            passwordFinal = hashPasswordSeleccionado;
        } else {
            // encriptamos la nueva contraseña
            passwordFinal = org.mindrot.jbcrypt.BCrypt.hashpw(passwordStr, org.mindrot.jbcrypt.BCrypt.gensalt());
        }

        //Convertir ComboBox a Enums
        String textoRol = jc_especialidad.getSelectedItem().toString();
        Rol rolEnum;
        if (textoRol.equals("Administrador")) {
            rolEnum = Rol.administrador;
        } else if (textoRol.equals("Médico")) {
            rolEnum = Rol.medico;
        } else if (textoRol.equals("Farmaceútico")){
            rolEnum = Rol.farmaceutico;
        }else{
            rolEnum = Rol.recepcionista;
        }

        String textoEstado = jc_estado.getSelectedItem().toString();
        Estado estadoEnum = textoEstado.equals("Activo") ? Estado.activo : Estado.inactivo;

        if (username.equals(getUsername())) {
            if (estadoEnum == Estado.inactivo) {
                JOptionPane.showMessageDialog(null, "NO PUEDE CAMBIAR SU PROPIA ESTADO A INACTIVO", "ACCIÓN DENEGADA", JOptionPane.WARNING_MESSAGE);
                // Forzamos a que en la interfaz visual vuelva a decir "Activo"
                jc_estado.setSelectedItem("Activo");
                return;
            }
        }
        
        //Empaquetar todo en el Objeto Usuario
        Usuario usrModificado = new Usuario();
        usrModificado.setId_User(idUsuarioSeleccionado); // Le pasamos el ID que teníamos escondido
        usrModificado.setUsername(username);
        usrModificado.setPassword(passwordFinal);
        usrModificado.setFullname(fullname);
        usrModificado.setRol(rolEnum);
        usrModificado.setEstado(estadoEnum);

        //Enviar al DAO para actualizar la BD
        UsuarioDAO dao = new UsuarioDAO();
        if (dao.modificar(usrModificado)) {
            javax.swing.JOptionPane.showMessageDialog(null, "USUARIO MODIFICADO EXITOSAMENTE");

            txt_cedula.setText("");
            txt_nombre.setText("");
            txt_password.setText("");
            jc_especialidad.setSelectedIndex(0);
            jc_estado.setSelectedIndex(0);

            // Borramos la memoria para evitar errores
            idUsuarioSeleccionado = -1;
            hashPasswordSeleccionado = "";

            // Actualizamos la tabla visual
            cargarTabla();
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "ERROR AL MODIFICAR AL USUARIO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }*/
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        /*if (idUsuarioSeleccionado == -1) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, BUSQUE UN USUARIO ANTES DE ELIMINARLO", "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validar que no sea el mismo usuario que tiene la sesión abierta
        String usernameAEliminar = txt_cedula.getText();
        if (usernameAEliminar.equals(getUsername())) {
            javax.swing.JOptionPane.showMessageDialog(null, "NO SE PUEDE ELIMINAR LA CUENTA MIENTRAS MANTIENE LA SESIÓN INICIADA", "ACCIÓN DENEGADA", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String username = txt_cedula.getText();
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar permanentemente al usuario '" + username + "'?\nEsta acción no se puede deshacer.",
                "CONFIRMAR ELIMINACIÓN", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (respuesta == JOptionPane.YES_OPTION) {
            UsuarioDAO dao = new UsuarioDAO();

            if (dao.eliminar(idUsuarioSeleccionado)) {
                JOptionPane.showMessageDialog(null, "USUARIO ELIMINADO EXITOSAMENTE");

                txt_cedula.setText("");
                txt_nombre.setText("");
                txt_password.setText("");
                jc_especialidad.setSelectedIndex(0);
                jc_estado.setSelectedIndex(0);

                //Borramos la memoria temporal
                idUsuarioSeleccionado = -1;
                hashPasswordSeleccionado = ""; 

                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR EL USUARIO", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }*/
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
         cargarTabla();
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void txt_licenciaMedicaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_licenciaMedicaKeyTyped
        // Si el carácter presionado NO es un número, se bloquea
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_licenciaMedicaKeyTyped

    private void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tabla_medicos.getModel();

        //Limpiamos la tabla por si tenia otros datos
        modelo.setRowCount(0);

        //Traemos la lista de médicos desde la base de datos
        MedicoDAO medDAO = new MedicoDAO();
        List<Medico> lista = medDAO.listar();

        // 4. Llenamos la tabla fila por fila
        for (Medico med : lista) {
            Object[] fila = new Object[6];
            fila[0] = med.getIdMedico();         
            fila[1] = med.getFullName();         
            fila[2] = med.getNombreEspecialidad(); 
            fila[3] = med.getTelefono();         
            fila[4] = med.getEmail();            
            fila[5] = med.getLicenciaMedica();   

            modelo.addRow(fila);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new MedicoVentana().setVisible(true));
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
    private javax.swing.JComboBox<Especialidad> jc_especialidad;
    private javax.swing.JLabel l_bienvenido;
    private javax.swing.JLabel l_cedula;
    private javax.swing.JLabel l_email;
    private javax.swing.JLabel l_especialidad;
    private javax.swing.JLabel l_fondo;
    private javax.swing.JLabel l_licenciaM;
    private javax.swing.JLabel l_logo;
    private javax.swing.JLabel l_nombre;
    private javax.swing.JLabel l_telefono;
    private javax.swing.JLabel l_titulo;
    private javax.swing.JTable tabla_medicos;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_licenciaMedica;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables

}