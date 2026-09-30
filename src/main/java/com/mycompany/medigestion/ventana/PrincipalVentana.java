package com.mycompany.medigestion.ventana;

import com.mycompany.medigestion.util.UsuarioSesion;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class PrincipalVentana extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PrincipalVentana.class.getName());
    
    private void configurarPermisos(String rol){
        if(rol.equalsIgnoreCase("recepcionista")){
            btn_stock.setVisible(false);
            btn_usuario.setVisible(false);
            btn_medicos.setVisible(false);
        }else if(rol.equalsIgnoreCase("medico")){
            btn_facturacion.setVisible(false);
            btn_usuario.setVisible(false);
            btn_medicos.setVisible(false);
        }else if(rol.equalsIgnoreCase("farmaceutico")){
            btn_facturacion.setVisible(false);
            btn_usuario.setVisible(false);
            btn_medicos.setVisible(false);
            btn_citasmed.setVisible(false);
            btn_pacientes.setVisible(false);            
        }else if(rol.equalsIgnoreCase("administrador")){
            
        }else{
            System.out.println("El rol no existe");
        }
    }
    
    public PrincipalVentana() {
        
        if(!UsuarioSesion.isLogueado()){
            JOptionPane.showMessageDialog(null, "Acceso denegado. Por favor, inicie sesión", "Seguridad", JOptionPane.WARNING_MESSAGE);
            new LoginVentana().setVisible(true);
            this.dispose();
            return;
        }
        
        initComponents();
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
            
            ImageIcon iconoPacientes = new ImageIcon(getClass().getResource("/imagenes/paciente.png"));
            Image imagenPacienteEscalada = iconoPacientes.getImage().getScaledInstance(anchoIcono, altoIcono, Image.SCALE_SMOOTH);
            ImageIcon iconoFinalPaciente = new ImageIcon(imagenPacienteEscalada);
            btn_pacientes.setIcon(iconoFinalPaciente);
            
            ImageIcon iconoCitas = new ImageIcon(getClass().getResource("/imagenes/cita.png"));
            Image imagenCitaEscalada = iconoCitas.getImage().getScaledInstance(anchoIcono, altoIcono, Image.SCALE_SMOOTH);
            ImageIcon iconoFinalCita = new ImageIcon(imagenCitaEscalada);
            btn_citasmed.setIcon(iconoFinalCita);
            
            ImageIcon iconoMedicos = new ImageIcon(getClass().getResource("/imagenes/medico.png"));
            Image imagenMedicoEscalada = iconoMedicos.getImage().getScaledInstance(anchoIcono, altoIcono, Image.SCALE_SMOOTH);
            ImageIcon iconoFinalMedico = new ImageIcon(imagenMedicoEscalada);
            btn_medicos.setIcon(iconoFinalMedico);
                       
            ImageIcon iconoStockMed = new ImageIcon(getClass().getResource("/imagenes/medicamento.png"));
            Image imagenStockEscalada = iconoStockMed.getImage().getScaledInstance(anchoIcono, altoIcono, Image.SCALE_SMOOTH);
            ImageIcon iconoFinalStock = new ImageIcon(imagenStockEscalada);
            btn_stock.setIcon(iconoFinalStock);
            
            ImageIcon iconoFacturacion = new ImageIcon(getClass().getResource("/imagenes/factura.png"));
            Image imagenFacturaEscalada = iconoFacturacion.getImage().getScaledInstance(anchoIcono, altoIcono, Image.SCALE_SMOOTH);
            ImageIcon iconoFinalFactura = new ImageIcon(imagenFacturaEscalada);
            btn_facturacion.setIcon(iconoFinalFactura);
            
            ImageIcon iconoUsuarios = new ImageIcon(getClass().getResource("/imagenes/usuario.png"));
            Image imagenUsuarioEscalada = iconoUsuarios.getImage().getScaledInstance(anchoIcono, altoIcono, Image.SCALE_SMOOTH);
            ImageIcon iconoFinalUsuario = new ImageIcon(imagenUsuarioEscalada);
            btn_usuario.setIcon(iconoFinalUsuario);
            
            ImageIcon iconoEmail = new ImageIcon(getClass().getResource("/imagenes/email.png"));
            Image imagenEmailEscalada = iconoEmail.getImage().getScaledInstance(anchoIcono, altoIcono, Image.SCALE_SMOOTH);
            ImageIcon iconoFinalEmail = new ImageIcon(imagenEmailEscalada);
            btn_email.setIcon(iconoFinalEmail);
            
            ImageIcon iconoCerrarSesion = new ImageIcon(getClass().getResource("/imagenes/cerrar-sesion.png"));
            Image imagenSesionEscalada = iconoCerrarSesion.getImage().getScaledInstance(anchoIcono, altoIcono, Image.SCALE_SMOOTH);
            ImageIcon iconoFinalSesion = new ImageIcon(imagenSesionEscalada);
            btn_cerrarsesion.setIcon(iconoFinalSesion);
            
            ImageIcon iconoSalir = new ImageIcon(getClass().getResource("/imagenes/volver-flecha.png"));
            Image imagenSalirEscalada = iconoSalir.getImage().getScaledInstance(anchoIcono, altoIcono, Image.SCALE_SMOOTH);
            ImageIcon iconoFinalSalir = new ImageIcon(imagenSalirEscalada);
            btn_salir.setIcon(iconoFinalSalir);
            
            //Centrar pantalla, bloquear bordes, finalice con X
            setLocationRelativeTo(null);
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            l_bienvenido.setText("Bienvenido/a " + UsuarioSesion.getNombreCompleto());
            configurarPermisos(UsuarioSesion.getRol());
                    
        }catch(Exception e){
            System.out.println("Error al cargar imagenes: " + e.getMessage());        
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_pacientes = new javax.swing.JButton();
        btn_citasmed = new javax.swing.JButton();
        btn_medicos = new javax.swing.JButton();
        btn_stock = new javax.swing.JButton();
        btn_facturacion = new javax.swing.JButton();
        btn_usuario = new javax.swing.JButton();
        btn_cerrarsesion = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        btn_email = new javax.swing.JButton();
        l_logo = new javax.swing.JLabel();
        l_bienvenido = new javax.swing.JLabel();
        l_fondo = new javax.swing.JLabel();
        menu_bar = new javax.swing.JMenuBar();
        m_opciones = new javax.swing.JMenu();
        sb_abrir = new javax.swing.JMenuItem();
        sb_guardar = new javax.swing.JMenuItem();
        sb_salir = new javax.swing.JMenuItem();
        m_ayuda = new javax.swing.JMenu();
        sb_acercade = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú Principal - MediGestión");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_pacientes.setBackground(new java.awt.Color(204, 204, 255));
        btn_pacientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_pacientes.setForeground(new java.awt.Color(0, 102, 153));
        btn_pacientes.setText("PACIENTES");
        btn_pacientes.addActionListener(this::btn_pacientesActionPerformed);
        jPanel1.add(btn_pacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        btn_citasmed.setBackground(new java.awt.Color(204, 204, 255));
        btn_citasmed.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_citasmed.setForeground(new java.awt.Color(0, 102, 153));
        btn_citasmed.setText("CITAS MÉDICAS");
        jPanel1.add(btn_citasmed, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, -1, -1));

        btn_medicos.setBackground(new java.awt.Color(204, 204, 255));
        btn_medicos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_medicos.setForeground(new java.awt.Color(0, 102, 153));
        btn_medicos.setText("MÉDICOS");
        btn_medicos.addActionListener(this::btn_medicosActionPerformed);
        jPanel1.add(btn_medicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        btn_stock.setBackground(new java.awt.Color(204, 204, 255));
        btn_stock.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_stock.setForeground(new java.awt.Color(0, 102, 153));
        btn_stock.setText("STOCK MEDICAMENTOS");
        jPanel1.add(btn_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, -1, -1));

        btn_facturacion.setBackground(new java.awt.Color(204, 204, 255));
        btn_facturacion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_facturacion.setForeground(new java.awt.Color(0, 102, 153));
        btn_facturacion.setText("FACTURACIÓN");
        jPanel1.add(btn_facturacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, -1, -1));

        btn_usuario.setBackground(new java.awt.Color(204, 204, 255));
        btn_usuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_usuario.setForeground(new java.awt.Color(0, 102, 153));
        btn_usuario.setText("USUARIOS");
        btn_usuario.addActionListener(this::btn_usuarioActionPerformed);
        jPanel1.add(btn_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, -1, -1));

        btn_cerrarsesion.setBackground(new java.awt.Color(204, 204, 255));
        btn_cerrarsesion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_cerrarsesion.setForeground(new java.awt.Color(0, 102, 153));
        btn_cerrarsesion.setText("CERRAR SESIÓN");
        btn_cerrarsesion.addActionListener(this::btn_cerrarsesionActionPerformed);
        jPanel1.add(btn_cerrarsesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));

        btn_salir.setBackground(new java.awt.Color(204, 204, 255));
        btn_salir.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_salir.setForeground(new java.awt.Color(0, 102, 153));
        btn_salir.setText("SALIR");
        btn_salir.addActionListener(this::btn_salirActionPerformed);
        jPanel1.add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 370, -1, -1));

        btn_email.setBackground(new java.awt.Color(204, 204, 255));
        btn_email.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_email.setForeground(new java.awt.Color(0, 102, 153));
        btn_email.setText("E-MAIL");
        jPanel1.add(btn_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, -1, -1));
        jPanel1.add(l_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 140, 80));

        l_bienvenido.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        l_bienvenido.setText("Bienvenido/a ");
        jPanel1.add(l_bienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, -1));
        jPanel1.add(l_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 840, 440));

        m_opciones.setText("Opciones");

        sb_abrir.setText("Abrir");
        sb_abrir.addActionListener(this::sb_abrirActionPerformed);
        m_opciones.add(sb_abrir);

        sb_guardar.setText("Guardar como");
        m_opciones.add(sb_guardar);

        sb_salir.setText("Salir");
        m_opciones.add(sb_salir);

        menu_bar.add(m_opciones);

        m_ayuda.setText("Ayuda");

        sb_acercade.setText("Acerca de...");
        m_ayuda.add(sb_acercade);

        menu_bar.add(m_ayuda);

        setJMenuBar(menu_bar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sb_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sb_abrirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sb_abrirActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea salir del programa?", "SALIDA", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(respuesta == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_cerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarsesionActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea cerrar sesión?", "CERRAR SESIÓN", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(respuesta == JOptionPane.YES_OPTION){
            UsuarioSesion.cerrarSesion();
            new LoginVentana().setVisible(true);
            this.dispose();
        }
        
    }//GEN-LAST:event_btn_cerrarsesionActionPerformed

    private void btn_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_usuarioActionPerformed
        new UsuarioVentana().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_usuarioActionPerformed

    private void btn_medicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_medicosActionPerformed
        new MedicoVentana().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_medicosActionPerformed

    private void btn_pacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pacientesActionPerformed
        new PacienteVentana().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_pacientesActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new PrincipalVentana().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cerrarsesion;
    private javax.swing.JButton btn_citasmed;
    private javax.swing.JButton btn_email;
    private javax.swing.JButton btn_facturacion;
    private javax.swing.JButton btn_medicos;
    private javax.swing.JButton btn_pacientes;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btn_stock;
    private javax.swing.JButton btn_usuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel l_bienvenido;
    private javax.swing.JLabel l_fondo;
    private javax.swing.JLabel l_logo;
    private javax.swing.JMenu m_ayuda;
    private javax.swing.JMenu m_opciones;
    private javax.swing.JMenuBar menu_bar;
    private javax.swing.JMenuItem sb_abrir;
    private javax.swing.JMenuItem sb_acercade;
    private javax.swing.JMenuItem sb_guardar;
    private javax.swing.JMenuItem sb_salir;
    // End of variables declaration//GEN-END:variables
}
