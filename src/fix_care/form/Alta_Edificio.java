/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package fix_care.form;

import fix_care.clases.Admin_BD;
import fix_care.clases.ConexionBD;
import fix_care.clases.EdificiosBD;
import fix_care.clases.Servicios;
import fix_care.clases.UsuarioBD;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author erick
 */
public class Alta_Edificio extends javax.swing.JPanel {
    ArrayList<String> encargado = new ArrayList<>();//rrellenar el combo box de edificios  
    ArrayList<String> imagenes = new ArrayList<>();//rrellenar el combo box de edificios  
    ArrayList<String> id_adm = new ArrayList<>();//rrellenar el combo box de edificios  

    ConexionBD   objetoConexionBD = new ConexionBD();
    Admin_BD obj_infoCombo = new Admin_BD();
    String img;
    
    public Alta_Edificio() throws ClassNotFoundException {
        initComponents();
        inicializarAdministradores();
    }

    public void inicializarAdministradores() throws ClassNotFoundException {
      Connection conn; // objeto de conexion
      PreparedStatement stmt = null;   // variable para la sentencia sql
      ResultSet rs = null;    //variable para resultado de consulta sql
    //aqui se conectara a la base de datos y se buscara el usuario en la tabla de usuarios del sistema para su comparacion
      try {          
            conn=  objetoConexionBD.conexionDataBase();                        
                 rs= obj_infoCombo.consultaAdminCombo(conn);
                
            while (rs.next()) {
                   encargado.add(rs.getString("nombre")+" "+rs.getString("apepat")+" "+rs.getString("apemat"));
                   imagenes.add(rs.getString("img"));
                   id_adm.add(rs.getInt("idUsuario")+"");
            }
            objetoConexionBD.cerrarConexion(conn);
        }

     catch (SQLException e) {
        e.printStackTrace();
    }
     //
    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(encargado.toArray(new String[0]));
    cmbEncargado.setModel(model);
    
    }
   
    private void guardarDepartamento() {
    int encargadoid =cmbEncargado.getSelectedIndex();
    String departamentoTexto = txtEdificio.getText().trim();
     String id_admin=id_adm.get(encargadoid);
        // Validar que se haya seleccionado un encargado y se haya escrito un nombre de departamento
        if ( departamentoTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un encargado y escriba el nombre del departamento.", "Error de validación", JOptionPane.WARNING_MESSAGE);
            return;
        }
        else{
            insertarEdificio(id_admin,departamentoTexto);
        }
 
    }
    
    public void insertarEdificio(String x,String y){
        Connection conn;   // objeto de conexion
        PreparedStatement stmt = null;   // variable para la sentencia sql
        ResultSet rs = null;    
        
          try {
            ConexionBD   objetoConexionBD = new ConexionBD();
            conn=  objetoConexionBD.conexionDataBase();                
           EdificiosBD obj_bd_edificio=new EdificiosBD();
                 obj_bd_edificio.insertarEdicifio(conn,x,y);
                    
              //se cierra la conexion
              objetoConexionBD.cerrarConexion(conn);
             
        } catch (HeadlessException | ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de conexión " +
                    ex.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        radio_white1 = new fix_care.menu.radio_white();
        txtEdificio = new javax.swing.JTextField();
        loginBtn = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JLabel();
        cmbEncargado = new javax.swing.JComboBox<>();
        btnUbicacion = new javax.swing.JLabel();
        btnUbicacion1 = new javax.swing.JLabel();
        pruebagradiant1 = new fix_care.menu.pruebagradiant();
        titulo1 = new javax.swing.JLabel();
        logo_fix = new javax.swing.JLabel();
        img_adm = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 242, 242));

        jPanel1.setBackground(new java.awt.Color(242, 242, 242));

        txtEdificio.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtEdificio.setText("Ingrese el nombre del Edificio");
        txtEdificio.setBorder(null);
        txtEdificio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtEdificioMousePressed(evt);
            }
        });
        txtEdificio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdificioActionPerformed(evt);
            }
        });

        loginBtn.setBackground(new java.awt.Color(8, 55, 116));

        btnGuardar.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGuardar.setText("GUARDAR");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout loginBtnLayout = new javax.swing.GroupLayout(loginBtn);
        loginBtn.setLayout(loginBtnLayout);
        loginBtnLayout.setHorizontalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        loginBtnLayout.setVerticalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        cmbEncargado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbEncargado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbEncargado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEncargadoActionPerformed(evt);
            }
        });

        btnUbicacion.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        btnUbicacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnUbicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fix/care/images/002-marcador-de-posicion.png"))); // NOI18N
        btnUbicacion.setText("EDIFICIO");
        btnUbicacion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnUbicacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUbicacionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUbicacionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUbicacionMouseExited(evt);
            }
        });

        btnUbicacion1.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        btnUbicacion1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnUbicacion1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fix/care/images/002-marcador-de-posicion.png"))); // NOI18N
        btnUbicacion1.setText("ENCARGADO");
        btnUbicacion1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnUbicacion1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUbicacion1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUbicacion1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUbicacion1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout radio_white1Layout = new javax.swing.GroupLayout(radio_white1);
        radio_white1.setLayout(radio_white1Layout);
        radio_white1Layout.setHorizontalGroup(
            radio_white1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(radio_white1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(radio_white1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(radio_white1Layout.createSequentialGroup()
                        .addComponent(btnUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(radio_white1Layout.createSequentialGroup()
                        .addGroup(radio_white1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEdificio, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(radio_white1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUbicacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(406, Short.MAX_VALUE))))
        );
        radio_white1Layout.setVerticalGroup(
            radio_white1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(radio_white1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(radio_white1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUbicacion)
                    .addComponent(btnUbicacion1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(radio_white1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEdificio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );

        titulo1.setFont(new java.awt.Font("Roboto Light", 1, 24)); // NOI18N
        titulo1.setForeground(new java.awt.Color(255, 255, 255));
        titulo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fix/care/images/001-buscar.png"))); // NOI18N
        titulo1.setText("ALTA EDIFICIO");
        titulo1.setPreferredSize(new java.awt.Dimension(75, 18));

        logo_fix.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fix/care/images/text_logo.png"))); // NOI18N
        logo_fix.setText("jLabel2");

        javax.swing.GroupLayout pruebagradiant1Layout = new javax.swing.GroupLayout(pruebagradiant1);
        pruebagradiant1.setLayout(pruebagradiant1Layout);
        pruebagradiant1Layout.setHorizontalGroup(
            pruebagradiant1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pruebagradiant1Layout.createSequentialGroup()
                .addContainerGap(414, Short.MAX_VALUE)
                .addGroup(pruebagradiant1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pruebagradiant1Layout.createSequentialGroup()
                        .addComponent(logo_fix, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(200, 200, 200)
                        .addComponent(img_adm, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pruebagradiant1Layout.createSequentialGroup()
                        .addComponent(titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(420, 420, 420))))
        );
        pruebagradiant1Layout.setVerticalGroup(
            pruebagradiant1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pruebagradiant1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(pruebagradiant1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo_fix, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(img_adm, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(radio_white1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pruebagradiant1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(0, 14, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 647, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pruebagradiant1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)
                    .addComponent(radio_white1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(51, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 44, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbEncargadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEncargadoActionPerformed
        int i=cmbEncargado.getSelectedIndex();
        ImageIcon ii = new ImageIcon(imagenes.get(i));
         //Ajustamos la imagen
         Image image = ii.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
         img_adm.setIcon(new ImageIcon(image));        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEncargadoActionPerformed

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        guardarDepartamento();
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        loginBtn.setBackground(new Color(33,161,153));
    }//GEN-LAST:event_btnGuardarMouseEntered

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        loginBtn.setBackground(new Color(8, 55, 116));
    }//GEN-LAST:event_btnGuardarMouseExited

    private void txtEdificioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEdificioMousePressed
        if (txtEdificio.getText().equals("Ingrese su nombre de usuario")) {
            txtEdificio.setText("");
            txtEdificio.setForeground(Color.black);
        }
       
    }//GEN-LAST:event_txtEdificioMousePressed

    private void txtEdificioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdificioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdificioActionPerformed

    private void btnUbicacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbicacionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUbicacionMouseClicked

    private void btnUbicacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbicacionMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUbicacionMouseEntered

    private void btnUbicacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbicacionMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUbicacionMouseExited

    private void btnUbicacion1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbicacion1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUbicacion1MouseClicked

    private void btnUbicacion1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbicacion1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUbicacion1MouseEntered

    private void btnUbicacion1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbicacion1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUbicacion1MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnGuardar;
    private javax.swing.JLabel btnUbicacion;
    private javax.swing.JLabel btnUbicacion1;
    private javax.swing.JComboBox<String> cmbEncargado;
    private javax.swing.JLabel img_adm;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel loginBtn;
    private javax.swing.JLabel logo_fix;
    private fix_care.menu.pruebagradiant pruebagradiant1;
    private fix_care.menu.radio_white radio_white1;
    private javax.swing.JLabel titulo1;
    private javax.swing.JTextField txtEdificio;
    // End of variables declaration//GEN-END:variables
}
