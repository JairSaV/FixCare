package fix_care.system;

import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import fix_care.clases.ConexionBD;
import fix_care.clases.UsuarioBD;
import fix_care.clases.Usuario;
import fix_care.system.Dashboard;
import fix_care.system.Dashboard;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Login extends javax.swing.JFrame {
    
    int xMouse, yMouse;
    
    public Login() {
        initComponents();
        txtPassword.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(txtPassword.getPassword()).equals("********")) {
            txtPassword.setText("");
            txtPassword.setForeground(Color.black);
        }
            }

            @Override
            public void focusLost(FocusEvent e) {
              if (String.valueOf(txtPassword.getPassword()).equals("********")) {
            //txtPassword.setText("");
            txtPassword.setForeground(Color.black);
        }
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        citybg = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        passLabel = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        loginBtn = new javax.swing.JPanel();
        loginBtnTxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fix/care/images/logo_circulo.png"))); // NOI18N
        bg.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 230, 180));

        citybg.setBackground(new java.awt.Color(0, 134, 190));
        citybg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fix/care/images/bg1.jpg"))); // NOI18N
        bg.add(citybg, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 360, 500));

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        exitBtn.setBackground(new java.awt.Color(255, 255, 255));

        exitTxt.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        exitTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        exitTxt.setPreferredSize(new java.awt.Dimension(40, 40));
        exitTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout exitBtnLayout = new javax.swing.GroupLayout(exitBtn);
        exitBtn.setLayout(exitBtnLayout);
        exitBtnLayout.setHorizontalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exitBtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        exitBtnLayout.setVerticalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exitBtnLayout.createSequentialGroup()
                .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(exitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        title.setBackground(new java.awt.Color(51, 51, 51));
        title.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(102, 102, 102));
        title.setText("INICIAR SESIÓN");
        bg.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        userLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel.setForeground(new java.awt.Color(102, 102, 102));
        userLabel.setText("USUARIO");
        bg.add(userLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        txtUsuario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtUsuario.setText("Ingrese su nombre de usuario");
        txtUsuario.setBorder(null);
        txtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUsuarioMousePressed(evt);
            }
        });
        bg.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 410, 30));

        jSeparator1.setBackground(new java.awt.Color(26, 104, 177));
        jSeparator1.setForeground(new java.awt.Color(26, 104, 177));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 410, 20));

        passLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        passLabel.setForeground(new java.awt.Color(102, 102, 102));
        passLabel.setText("CONTRASEÑA");
        bg.add(passLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        txtPassword.setText("********");
        txtPassword.setBorder(null);
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPasswordMousePressed(evt);
            }
        });
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        bg.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 410, 30));

        jSeparator2.setBackground(new java.awt.Color(26, 104, 177));
        jSeparator2.setForeground(new java.awt.Color(26, 104, 177));
        bg.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 410, 20));

        loginBtn.setBackground(new java.awt.Color(8, 55, 116));

        loginBtnTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        loginBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        loginBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginBtnTxt.setText("ENTRAR");
        loginBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        loginBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout loginBtnLayout = new javax.swing.GroupLayout(loginBtn);
        loginBtn.setLayout(loginBtnLayout);
        loginBtnLayout.setHorizontalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        loginBtnLayout.setVerticalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        bg.add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 130, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitTxtMouseClicked

    private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseEntered
        exitBtn.setBackground(Color.red);
        exitTxt.setForeground(Color.white);
    }//GEN-LAST:event_exitTxtMouseEntered

    private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseExited
        exitBtn.setBackground(Color.white);
        exitTxt.setForeground(Color.black);
    }//GEN-LAST:event_exitTxtMouseExited

    private void loginBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseEntered
        loginBtn.setBackground(new Color(33,161,153));
    }//GEN-LAST:event_loginBtnTxtMouseEntered

    private void loginBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseExited
        loginBtn.setBackground(new Color(8, 55, 116));
    }//GEN-LAST:event_loginBtnTxtMouseExited

    private void txtUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMousePressed
        if (txtUsuario.getText().equals("Ingrese su nombre de usuario")) {
            txtUsuario.setText("");
            txtUsuario.setForeground(Color.black);
        }
        if (String.valueOf(txtPassword.getPassword()).isEmpty()) {
            txtPassword.setText("********");
            txtPassword.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtUsuarioMousePressed

    private void txtPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMousePressed
        if (String.valueOf(txtPassword.getPassword()).equals("********")) {
            txtPassword.setText("");
            txtPassword.setForeground(Color.black);
        }
        if (txtUsuario.getText().isEmpty()) {
            txtUsuario.setText("Ingrese su nombre de usuario");
            txtUsuario.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtPasswordMousePressed

    private void loginBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseClicked
        Usuario  objUsuario = new Usuario(); //Crea un nuevo objeto de la clase usuario 
        objUsuario.setUsuario( txtUsuario.getText());
        objUsuario.setPassword( new String(txtPassword.getPassword()));
       
        //validando al usuario contra la base de datos
        if (validarUsuario(objUsuario)) {
            //si el usuario es valido
            //JOptionPane.showMessageDialog(this, "Bienvenido " + objUsuario.getUsuario());
            // Se oculta esta ventana
            Dashboard dash = new Dashboard();           
            dash.setUsuario(objUsuario); //Inicializamos el objeto dashboard y le asignamos el objeto usuario 
            dash.show();
            this.setVisible(false);
            //Se construye el objeto de la nueva ventana
            //frmMenuPrincipal menuPrincipal = new frmMenuPrincipal();
            //menuPrincipal.setUsuarioActual(usuario, rol);
            //se visualiza la pantalla del menu principal
            //menuPrincipal.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
        }
    }//GEN-LAST:event_loginBtnTxtMouseClicked

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code  here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    
    public boolean validarUsuario(Usuario objUsuario){
      //variables de clase 
        boolean accesoPermitido = false;  //variable de retorno en caso de ser falso o verdadero
        Connection conn;   // objeto de conexion
        PreparedStatement stmt = null;   // variable para la sentencia sql
        ResultSet rs = null;    //variable para resultado de consulta sql
    //aqui se conectara a la base de datos y se buscara el usuario en la tabla de usuarios del sistema para su comparacion
      try {
            ConexionBD   objetoConexionBD = new ConexionBD();
            conn=  objetoConexionBD.conexionDataBase();                
            UsuarioBD bd = new UsuarioBD();
                 rs= bd.consultarUsuarioLogin(conn,objUsuario.getUsuario(), objUsuario.getPassword());
                 
             if (rs.next()) {  //encontro al menos 1 registro con los datos
                //accedemos al sistema
                accesoPermitido = true;
                //estas son variables de inicio de sesión obtenidas de la base de datos
                objUsuario.setIdUsuario(rs.getInt("idUsuario"));
                objUsuario.setNombre(rs.getString("nombre"));
                objUsuario.setApepat(rs.getString("apepat"));
                objUsuario.setApemat(rs.getString("apemat"));
                objUsuario.setRol(rs.getString("rol"));
                objUsuario.setImg(rs.getString("img"));
                objUsuario.setTelefono(rs.getString("telefono"));
                objUsuario.setCorreo(rs.getString("correo"));
            }   
              //se cierra la conexion
              objetoConexionBD.cerrarConexion(conn);
             
        } catch (HeadlessException | ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de conexión " +
                    ex.getMessage());
        }
    //regresamos si el usuario se localizo
    return accesoPermitido;
            
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JLabel citybg;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JPanel header;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel loginBtn;
    private javax.swing.JLabel loginBtnTxt;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel passLabel;
    private javax.swing.JLabel title;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
