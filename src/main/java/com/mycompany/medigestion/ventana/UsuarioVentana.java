package com.mycompany.medigestion.ventana;

import com.mycompany.medigestion.dao.UsuarioDAO;
import com.mycompany.medigestion.modelo.Estado;
import com.mycompany.medigestion.modelo.Rol;
import com.mycompany.medigestion.modelo.Usuario;
import com.mycompany.medigestion.util.UsuarioSesion;
import static com.mycompany.medigestion.util.UsuarioSesion.getUsername;
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
public class UsuarioVentana extends javax.swing.JFrame {
    
    private int idUsuarioSeleccionado = -1;
    private String hashPasswordSeleccionado = "";
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(UsuarioVentana.class.getName());
 
    public UsuarioVentana() {
        
        if(!UsuarioSesion.isLogueado()){
            JOptionPane.showMessageDialog(null, "Acceso denegado. Por favor, inicie sesión", "Seguridad", JOptionPane.WARNING_MESSAGE);
            new LoginVentana().setVisible(true);
            this.dispose();
            return;
        }
        
        initComponents();
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
        tabla_usuarios = new javax.swing.JTable();
        l_usuario = new javax.swing.JLabel();
        l_password = new javax.swing.JLabel();
        l_nombre = new javax.swing.JLabel();
        l_rol = new javax.swing.JLabel();
        l_estado = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        txt_nombre = new javax.swing.JTextField();
        jc_rol = new javax.swing.JComboBox<>();
        jc_estado = new javax.swing.JComboBox<>();
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
        l_titulo.setText("MÓDULO USUARIOS");
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

        tabla_usuarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabla_usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Usuario", "Contraseña", "Nombre", "Rol", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla_usuarios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 600, 230));

        l_usuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_usuario.setText("Usuario:");
        jPanel1.add(l_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        l_password.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_password.setText("Contraseña:");
        jPanel1.add(l_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        l_nombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_nombre.setText("Nombre:");
        jPanel1.add(l_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        l_rol.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_rol.setText("Rol: ");
        jPanel1.add(l_rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        l_estado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_estado.setText("Estado:");
        jPanel1.add(l_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        txt_usuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 140, -1));
        jPanel1.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 140, -1));

        txt_nombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 140, -1));

        jc_rol.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jc_rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Médico", "Recepcionista", "Farmaceútico" }));
        jPanel1.add(jc_rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 140, -1));

        jc_estado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jc_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
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
        String username = txt_usuario.getText();

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
                jc_rol.setSelectedItem("Administrador");
            } else if (usrEncontrado.getRol() == Rol.medico) {
                jc_rol.setSelectedItem("Médico");
            } else if (usrEncontrado.getRol() == Rol.farmaceutico){
                jc_rol.setSelectedItem("Farmaceútico");
            }else{
                jc_rol.setSelectedItem("Recepcionista"); // O el texto exacto que tengas en tu diseño
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
        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        String username = txt_usuario.getText();
        String pass = new String(txt_password.getPassword());
        String fullname = txt_nombre.getText();
        
        if(username.isEmpty() || fullname.isEmpty() || pass.isEmpty()){
            JOptionPane.showMessageDialog(null, "DEBE LLENAR TODOS LOS CAMPOS PARA CONTINUAR", "CAMPOS VACÍOS", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        //Encriptar la contraseña
        String hashPassword = org.mindrot.jbcrypt.BCrypt.hashpw(pass, org.mindrot.jbcrypt.BCrypt.gensalt());
        
        //Mapeo texto de combBox a los ENUMS de java
        String rol = jc_rol.getSelectedItem().toString();
        Rol rolEnum = null;
        if(rol.equals("Administrador")){
            rolEnum = Rol.administrador;
        }else if(rol.equals("Médico")){
            rolEnum = Rol.medico;
        }else if(rol.equals("Recepcionista")){
            rolEnum = Rol.recepcionista;
        }else if(rol.equals("Farmaceútico")){
            rolEnum = Rol.farmaceutico;
        }
        
        String estado = jc_estado.getSelectedItem().toString();
        Estado estadoEnum = estado.equals("Activo") ? Estado.activo : Estado.inactivo;
        
        //Empaqueta todo en el Modelo usuario
        Usuario nuevoUser = new Usuario();
        nuevoUser.setUsername(username);
        nuevoUser.setPassword(hashPassword);
        nuevoUser.setFullname(fullname);
        nuevoUser.setRol(rolEnum);
        nuevoUser.setEstado(estadoEnum);
        
        //Entregar al objeto DAO para que lo guarde
        UsuarioDAO dao = new UsuarioDAO();
        if(dao.buscarPorUsername(username) != null){
            JOptionPane.showMessageDialog(this, "EL USUARIO: '" + username + "' YA ESTÁ EN USO. POR FAVOR, ELIJA OTRO", "USUARIO DUPLICADO", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(dao.insertar(nuevoUser)){
            JOptionPane.showMessageDialog(null, "USUARIO AGREGADO EXITOSAMENTE");
            
            txt_nombre.setText("");
            txt_usuario.setText("");
            txt_password.setText("");
            jc_rol.setSelectedIndex(0);
            jc_estado.setSelectedIndex(0);
            
            //Cargar tabla
            cargarTabla();
            
        }else{
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR AL USUARIO EN LA BASE DE DATOS", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        if (idUsuarioSeleccionado == -1) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, BUSQUE UN USUARIO PRIMERO ANTES DE MODIFICARLO", "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        //Recolectar datos
        String username = txt_usuario.getText();
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
        String textoRol = jc_rol.getSelectedItem().toString();
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

            txt_usuario.setText("");
            txt_nombre.setText("");
            txt_password.setText("");
            jc_rol.setSelectedIndex(0);
            jc_estado.setSelectedIndex(0);

            // Borramos la memoria para evitar errores
            idUsuarioSeleccionado = -1;
            hashPasswordSeleccionado = "";

            // Actualizamos la tabla visual
            cargarTabla();
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "ERROR AL MODIFICAR AL USUARIO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        if (idUsuarioSeleccionado == -1) {
            JOptionPane.showMessageDialog(null, "POR FAVOR, BUSQUE UN USUARIO ANTES DE ELIMINARLO", "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validar que no sea el mismo usuario que tiene la sesión abierta
        String usernameAEliminar = txt_usuario.getText();
        if (usernameAEliminar.equals(getUsername())) {
            javax.swing.JOptionPane.showMessageDialog(null, "NO SE PUEDE ELIMINAR LA CUENTA MIENTRAS MANTIENE LA SESIÓN INICIADA", "ACCIÓN DENEGADA", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String username = txt_usuario.getText();
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar permanentemente al usuario '" + username + "'?\nEsta acción no se puede deshacer.",
                "CONFIRMAR ELIMINACIÓN", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (respuesta == JOptionPane.YES_OPTION) {
            UsuarioDAO dao = new UsuarioDAO();

            if (dao.eliminar(idUsuarioSeleccionado)) {
                JOptionPane.showMessageDialog(null, "USUARIO ELIMINADO EXITOSAMENTE");

                txt_usuario.setText("");
                txt_nombre.setText("");
                txt_password.setText("");
                jc_rol.setSelectedIndex(0);
                jc_estado.setSelectedIndex(0);

                //Borramos la memoria temporal
                idUsuarioSeleccionado = -1;
                hashPasswordSeleccionado = ""; 

                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR EL USUARIO", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
         cargarTabla();
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void cargarTabla() {
        // Obtenemos el modelo visual de tu tabla (Cambia 'tablaUsuarios' por el nombre real de tu variable JTable)
        DefaultTableModel modelo = (DefaultTableModel) tabla_usuarios.getModel();
        // Limpiamos la tabla poniéndola en cero filas para evitar datos duplicados al recargar
        modelo.setRowCount(0);

        // Usamos el DAO para extraer la lista de la base de datos
        UsuarioDAO dao = new UsuarioDAO();
        List<Usuario> lista = dao.listar();

        for (Usuario u : lista) {
            Object[] fila = new Object[5];
            fila[0] = u.getUsername();
            fila[1] = u.getPassword();
            fila[2] = u.getFullname();
            fila[3] = u.getRol().name();
            fila[4] = u.getEstado().name();

            // Agregamos la fila terminada al modelo visual
            modelo.addRow(fila);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new UsuarioVentana().setVisible(true));
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
    private javax.swing.JComboBox<String> jc_rol;
    private javax.swing.JLabel l_bienvenido;
    private javax.swing.JLabel l_estado;
    private javax.swing.JLabel l_fondo;
    private javax.swing.JLabel l_logo;
    private javax.swing.JLabel l_nombre;
    private javax.swing.JLabel l_password;
    private javax.swing.JLabel l_rol;
    private javax.swing.JLabel l_titulo;
    private javax.swing.JLabel l_usuario;
    private javax.swing.JTable tabla_usuarios;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
