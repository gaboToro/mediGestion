package com.mycompany.medigestion.ventana;

import com.mycompany.medigestion.conexion.ConexionDB;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class LoginVentana extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoginVentana.class.getName());
    
    public LoginVentana() {
        initComponents();
        
        try {
            //Imagen de fondo
            ImageIcon iconoFondo = new ImageIcon(getClass().getResource("/imagenes/fondo_mg.jpg"));
            Image imagenFondoEscalada = iconoFondo.getImage().getScaledInstance(400, 470, Image.SCALE_SMOOTH);
            l_fondo.setIcon(new ImageIcon(imagenFondoEscalada));
            
            //Imagen de logo
            ImageIcon iconoLogo = new ImageIcon(getClass().getResource("/imagenes/logo_mg.png"));
            Image imagenLogoEscalada = iconoLogo.getImage().getScaledInstance(270, 110, Image.SCALE_SMOOTH);
            l_logo.setIcon(new ImageIcon(imagenLogoEscalada));
            
            //Imagen de icono
            Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/icono_mg.png"));
            setIconImage(icono);
            
            //Centrar pantalla, bloquear bordes, finalice con X
            setLocationRelativeTo(null);
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    
        }catch(Exception e){
            System.out.println("Error al cargar imagenes: " + e.getMessage());        
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        l_logo = new javax.swing.JLabel();
        l_user = new javax.swing.JLabel();
        l_password = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        btn_ingresar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        l_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MediGestion- Login");

        panel.setToolTipText("");
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel.add(l_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 270, 110));

        l_user.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        l_user.setForeground(new java.awt.Color(0, 102, 153));
        l_user.setText("Usuario:");
        panel.add(l_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        l_password.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        l_password.setForeground(new java.awt.Color(0, 102, 153));
        l_password.setText("Password:");
        panel.add(l_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, -1));
        panel.add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 250, -1));
        panel.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 250, -1));

        btn_ingresar.setBackground(new java.awt.Color(204, 204, 255));
        btn_ingresar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_ingresar.setForeground(new java.awt.Color(0, 102, 153));
        btn_ingresar.setText("INGRESAR");
        btn_ingresar.addActionListener(this::btn_ingresarActionPerformed);
        panel.add(btn_ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, -1, -1));

        btn_cancelar.setBackground(new java.awt.Color(204, 204, 255));
        btn_cancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(0, 102, 153));
        btn_cancelar.setText("CANCELAR");
        btn_cancelar.addActionListener(this::btn_cancelarActionPerformed);
        panel.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, -1, -1));
        panel.add(l_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 0, 400, 471));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    int intentos = 0;
    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed
        Connection conexion = ConexionDB.getConexion();
        String username = txt_user.getText();
        String pass = new String(txt_password.getPassword());
        PreparedStatement consulta;
        ResultSet resultado;
          
        try{
            if(username.equals("") || pass.equals("")){
                JOptionPane.showMessageDialog(null, "DEBE LLENAR TODOS LOS CAMPOS PARA CONTINUAR", "INFORMACION", JOptionPane.WARNING_MESSAGE);
            }else{
                String sql = "SELECT * FROM usuario WHERE username=? and password=?";
                consulta = conexion.prepareStatement(sql);
                consulta.setString(1, username);
                consulta.setString(2, pass);
                resultado = consulta.executeQuery();
                
                if(resultado.next()){
                    JOptionPane.showMessageDialog(null, "LOGIN EXITOSO, BIENVENIDO " + username, "BIENVENIDO", JOptionPane.INFORMATION_MESSAGE);
                    txt_user.setText("");
                    txt_password.setText("");
                }else{
                    intentos++;
                    JOptionPane.showMessageDialog(null, "USUARIO Y/O CONTRASEÑA INCORRECTOS", "INTENTO "+ intentos, JOptionPane.ERROR_MESSAGE);
                    txt_user.setText("");
                    txt_password.setText("");
                    
                    if(intentos == 3){
                        JOptionPane.showMessageDialog(null, "USUARIO BLOQUEADO POR DEMASIADOS INTENTOS, COMUNIQUESE CON SOPORTE", "BLOQUEO DE USUARIO",JOptionPane.ERROR_MESSAGE);
                        System.exit(0);
                    }
                }
            }
         
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);   
        }
    }//GEN-LAST:event_btn_ingresarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea salir?", "SALIR" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(respuesta == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_btn_cancelarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new LoginVentana().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JLabel l_fondo;
    private javax.swing.JLabel l_logo;
    private javax.swing.JLabel l_password;
    private javax.swing.JLabel l_user;
    private javax.swing.JPanel panel;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
