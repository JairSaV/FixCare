/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package fix_care.form;

import fix_care.clases.ConexionBD;
import fix_care.clases.EdificiosBD;
import fix_care.clases.Servicios;
import fix_care.clases.ServiciosBD;
import fix_care.clases.Ticket;
import fix_care.clases.TicketBD;
import fix_care.clases.Usuario;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;

public class DashBoard_Usuario extends javax.swing.JPanel {
      TicketBD objticket = new TicketBD();
      Font font = new Font("Verdana", Font.BOLD, 12);     
      ConexionBD   objetoConexionBD = new ConexionBD();     
      String selectedImagePath = "";
      Usuario user = new Usuario();
      Date objFecha = new Date();
      SimpleDateFormat formato = new SimpleDateFormat ("dd/MM/yyyy");
      
        
    public DashBoard_Usuario(Usuario usuario) throws ClassNotFoundException {
        initComponents();
        
        txtNombreUsuario.setOpaque(false); // This is essential for transparency
        txtNombreUsuario.setBackground(new Color(0, 0, 0, 0)); // RGBA with alpha 0
        txtNombreUsuario.setForeground(Color.WHITE);
        user= usuario; 
        txtNombreUsuario.setText(user.getNombre()+" "+ user.getApepat()+" "+ user.getApemat());
        txtCorreo.setText(user.getCorreo());
        int id=user.getIdUsuario();
        txtTelefono.setText(user.getTelefono());
        ImageIcon ii = new ImageIcon(user.getImg());
        System.out.println(user.getImg());
         //Ajustamos la imagen
        Image image = ii.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imgProfile.setIcon(new ImageIcon(image));
        // Set the font
        
        
       txtNombreUsuario.setFont(font);
        
        //para el otro txt 
        txtCorreo.setOpaque(false); // This is essential for transparency
        txtCorreo.setBackground(new Color(0, 0, 0, 0)); // RGBA with alpha 0
        txtCorreo.setForeground(Color.WHITE);

        // Set the font
        txtCorreo.setFont(font);
        
        //para otro txt
        txtTelefono.setOpaque(false); // This is essential for transparency
        txtTelefono.setBackground(new Color(0, 0, 0, 0)); // RGBA with alpha 0
        txtTelefono.setForeground(Color.WHITE);

        // Set the font
        txtTelefono.setFont(font);
        init(id);
    }


    private void  init(int id) throws ClassNotFoundException{
        table.fixTable(jScrollPane);
        Connection conn; // objeto de conexion
        PreparedStatement stmt = null;   // variable para la sentencia sql
        ResultSet rs = null;    //variable para resultado de consulta sql
    //aqui se conectara a la base de datos y se buscara el usuario en la tabla de usuarios del sistema para su comparacion
      try {          
            conn=  objetoConexionBD.conexionDataBase();                        
                 rs= objticket.rellenaTabla_usuaio(conn,id);                
            while (rs.next()) {
                table.addRow(new Object[]{rs.getInt("idTicket"), rs.getString("Edificio"), rs.getString("area"), rs.getString("servicio"), rs.getString("fecha"),rs.getString("problematica"),rs.getString("estado")});
            }
            objetoConexionBD.cerrarConexion(conn);
        }

     catch (SQLException e) {
        e.printStackTrace();
    }
     
        
      
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        roundPanel1 = new fix_care.swing.RoundPanel();
        jScrollPane = new javax.swing.JScrollPane();
        table = new fix_care.swing.table.Table();
        card1 = new fix_care.cards.Card();
        card6 = new fix_care.cards.Card();
        pruebagradiant1 = new fix_care.menu.pruebagradiant();
        imgProfile = new javax.swing.JLabel();
        btn_editar = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JLabel();
        logo_fix = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        labelApeMat = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        labelApeMat1 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        labelApeMat2 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        txtTelefono = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(10);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "# Folio", "Edificio", "Area", "Servicio", "Fecha Alta", "Problema", "Estatus"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane.setViewportView(table);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1036, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        card1.setColor1(new java.awt.Color(51, 255, 102));
        card1.setColor2(new java.awt.Color(153, 255, 153));
        card1.setDescription("Tickets Completados");
        card1.setIcon(javaswingdev.GoogleMaterialDesignIcon.CHECK);

        card6.setColor1(new java.awt.Color(255, 0, 0));
        card6.setColor2(new java.awt.Color(255, 51, 51));
        card6.setDescription("Tickets en Proceso");
        card6.setIcon(javaswingdev.GoogleMaterialDesignIcon.TIMER);

        btn_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fix/care/images/003-nota.png"))); // NOI18N
        btn_editar.setText("Editar");

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fix/care/images/002-guardar-el-archivo_1.png"))); // NOI18N
        btn_guardar.setText("Guardar");

        logo_fix.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fix/care/images/text_logo.png"))); // NOI18N
        logo_fix.setText("jLabel2");

        txtNombreUsuario.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtNombreUsuario.setText("Dayana Custodio La Mera Mera");
        txtNombreUsuario.setBorder(null);
        txtNombreUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNombreUsuarioMousePressed(evt);
            }
        });
        txtNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUsuarioActionPerformed(evt);
            }
        });

        labelApeMat.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        labelApeMat.setForeground(new java.awt.Color(102, 102, 102));
        labelApeMat.setText("NOMBRE");

        jSeparator3.setBackground(new java.awt.Color(26, 104, 177));
        jSeparator3.setForeground(new java.awt.Color(26, 104, 177));

        labelApeMat1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        labelApeMat1.setForeground(new java.awt.Color(102, 102, 102));
        labelApeMat1.setText("CORREO");

        txtCorreo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCorreo.setText("Especifíca el área");
        txtCorreo.setBorder(null);
        txtCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCorreoMousePressed(evt);
            }
        });

        jSeparator4.setBackground(new java.awt.Color(26, 104, 177));
        jSeparator4.setForeground(new java.awt.Color(26, 104, 177));

        labelApeMat2.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        labelApeMat2.setForeground(new java.awt.Color(102, 102, 102));
        labelApeMat2.setText("TELEFONO");

        jSeparator5.setBackground(new java.awt.Color(26, 104, 177));
        jSeparator5.setForeground(new java.awt.Color(26, 104, 177));

        txtTelefono.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtTelefono.setText("Especifíca el área");
        txtTelefono.setBorder(null);
        txtTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtTelefonoMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pruebagradiant1Layout = new javax.swing.GroupLayout(pruebagradiant1);
        pruebagradiant1.setLayout(pruebagradiant1Layout);
        pruebagradiant1Layout.setHorizontalGroup(
            pruebagradiant1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pruebagradiant1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(imgProfile, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pruebagradiant1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pruebagradiant1Layout.createSequentialGroup()
                        .addGroup(pruebagradiant1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pruebagradiant1Layout.createSequentialGroup()
                                .addGroup(pruebagradiant1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelApeMat, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addComponent(logo_fix, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pruebagradiant1Layout.createSequentialGroup()
                                .addGroup(pruebagradiant1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelApeMat2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pruebagradiant1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_guardar))
                                .addGap(57, 57, 57)))
                        .addGap(35, 35, 35))
                    .addGroup(pruebagradiant1Layout.createSequentialGroup()
                        .addGroup(pruebagradiant1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelApeMat1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pruebagradiant1Layout.setVerticalGroup(
            pruebagradiant1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pruebagradiant1Layout.createSequentialGroup()
                .addGroup(pruebagradiant1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pruebagradiant1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(imgProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pruebagradiant1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(logo_fix, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_editar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_guardar)
                .addContainerGap())
            .addGroup(pruebagradiant1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(labelApeMat)
                .addGap(10, 10, 10)
                .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelApeMat1)
                .addGap(10, 10, 10)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelApeMat2)
                .addGap(10, 10, 10)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pruebagradiant1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(card6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pruebagradiant1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreUsuarioMousePressed
        if (txtNombreUsuario.getText().equals("Especifíca el área")) {
            txtNombreUsuario.setText("");
            txtNombreUsuario.setForeground(Color.black);
        }
        
    }//GEN-LAST:event_txtNombreUsuarioMousePressed

    private void txtCorreoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCorreoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoMousePressed

    private void txtTelefonoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefonoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoMousePressed

    private void txtNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_editar;
    private javax.swing.JLabel btn_guardar;
    private fix_care.cards.Card card1;
    private fix_care.cards.Card card6;
    private javax.swing.JLabel imgProfile;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel labelApeMat;
    private javax.swing.JLabel labelApeMat1;
    private javax.swing.JLabel labelApeMat2;
    private javax.swing.JLabel logo_fix;
    private fix_care.menu.pruebagradiant pruebagradiant1;
    private fix_care.swing.RoundPanel roundPanel1;
    private fix_care.swing.table.Table table;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
