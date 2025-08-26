
package fix_care.form;

import fix_care.clases.Admin_BD;
import fix_care.clases.ConexionBD;
import fix_care.clases.Edificios;
import fix_care.clases.EdificiosBD;
import fix_care.clases.InfoCards;
import fix_care.clases.Servicios;
import fix_care.clases.ServiciosBD;
import fix_care.clases.TecnicoBD;
import fix_care.clases.TicketBD;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Vinculacion extends javax.swing.JPanel {

    ArrayList<String> ticket = new ArrayList<>();//rrellenar el combo box de ticket  
    ArrayList<String> idticket = new ArrayList<>();//arreglo de ticket con ID  
    
    ArrayList<String> tecnico_list = new ArrayList<>();//rrellenar el combo box de tecnico  
    ArrayList<String> imagenes = new ArrayList<>();//rrellenar el combo box de tecnico  
    ArrayList<String> id_adm = new ArrayList<>();//rrellenar el combo box de tecnico  
    
    ConexionBD   objetoConexionBD = new ConexionBD();
    TicketBD objTicket = new TicketBD();
    TecnicoBD tecnico = new TecnicoBD();
    
    
    public Vinculacion() throws ClassNotFoundException {
        initComponents();
        inicializarTicket();
        inicializarTecnicos();
        rellenaTablaVinculacion();
    }

     public void inicializarTecnicos() throws ClassNotFoundException {
      Connection conn; // objeto de conexion
      PreparedStatement stmt = null;   // variable para la sentencia sql
      ResultSet rs = null;    //variable para resultado de consulta sql
    //aqui se conectara a la base de datos y se buscara el usuario en la tabla de usuarios del sistema para su comparacion
      try {          
            conn=  objetoConexionBD.conexionDataBase();                        
                 rs= tecnico.consultaTecCombo(conn);
                
            while (rs.next()) {
                   tecnico_list.add(rs.getString("nombre")+" "+rs.getString("apepat")+" "+rs.getString("apemat"));
                   imagenes.add(rs.getString("img"));
                   id_adm.add(rs.getInt("idUsuario")+"");
            }
            objetoConexionBD.cerrarConexion(conn);
        }

     catch (SQLException e) {
        e.printStackTrace();
    }
        
    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(tecnico_list.toArray(new String[0]));
    cmbTecnico.setModel(model);
    }
   
     
      public void inicializarTicket() throws ClassNotFoundException {
        Connection conn; // objeto de conexion
        PreparedStatement stmt = null;   // variable para la sentencia sql
        ResultSet rs = null;    //variable para resultado de consulta sql
        
    //aqui se conectara a la base de datos y se buscara el usuario en la tabla de usuarios del sistema para su comparacion
      try {          
            conn=  objetoConexionBD.conexionDataBase();                        
                 rs= objTicket.rellenaCmbTicket(conn);
                
            while (rs.next()) {
               ticket.add(rs.getString("folio"));   
               idticket.add(rs.getInt("idTicket")+"");   

            }
            objetoConexionBD.cerrarConexion(conn);
        }

     catch (SQLException e) {
        e.printStackTrace();
    }
        
    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(ticket.toArray(new String[0]));
    cmbTickets.setModel(model);
    }
    
      public void rellenaTablaVinculacion() throws ClassNotFoundException{
      table.fixTable(jScrollPane1);
      Connection conn; // objeto de conexion
        ConexionBD objetoConexionBD = new ConexionBD();
        PreparedStatement stmt = null;   // variable para la sentencia sql
        ResultSet rs = null;    //variable para resultado de consulta sql
       DefaultTableModel modelo = (DefaultTableModel) table.getModel();
    modelo.setRowCount(0); //Limpiar Tabla
         try {          
            conn=  objetoConexionBD.conexionDataBase();                        
                 rs= objTicket.rellenarvinculacionTabla(conn);                
            while (rs.next()) {
                table.addRow(new Object[]{rs.getString("folio"),rs.getString("solicitante"), rs.getString("edificio"), rs.getString("area"),  rs.getString("fecha"),rs.getString("servicio")});
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
        radio_white1 = new fix_care.menu.radio_white();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new fix_care.swing.table.Table();
        pruebagradiant3 = new fix_care.menu.pruebagradiant();
        logo_fix2 = new javax.swing.JLabel();
        titulo2 = new javax.swing.JLabel();
        cmbTickets = new javax.swing.JComboBox<>();
        userLabel1 = new javax.swing.JLabel();
        loginBtn = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JLabel();
        img_adm = new javax.swing.JLabel();
        cmbTecnico = new javax.swing.JComboBox<>();
        labelEdificio = new javax.swing.JLabel();

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "# Folio", "Edificio", "Área", "Fecha", "Servicio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout radio_white1Layout = new javax.swing.GroupLayout(radio_white1);
        radio_white1.setLayout(radio_white1Layout);
        radio_white1Layout.setHorizontalGroup(
            radio_white1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(radio_white1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1053, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        radio_white1Layout.setVerticalGroup(
            radio_white1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(radio_white1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                .addContainerGap())
        );

        logo_fix2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fix/care/images/text_logo.png"))); // NOI18N

        titulo2.setFont(new java.awt.Font("Roboto Light", 1, 24)); // NOI18N
        titulo2.setForeground(new java.awt.Color(255, 255, 255));
        titulo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fix/care/images/001-buscar.png"))); // NOI18N
        titulo2.setText("Vinculación");
        titulo2.setPreferredSize(new java.awt.Dimension(75, 18));

        cmbTickets.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbTickets.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTickets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTicketsActionPerformed(evt);
            }
        });

        userLabel1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel1.setForeground(new java.awt.Color(102, 102, 102));
        userLabel1.setText("Técnico");

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

        cmbTecnico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbTecnico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTecnicoActionPerformed(evt);
            }
        });

        labelEdificio.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        labelEdificio.setForeground(new java.awt.Color(102, 102, 102));
        labelEdificio.setText("Servicio");

        javax.swing.GroupLayout pruebagradiant3Layout = new javax.swing.GroupLayout(pruebagradiant3);
        pruebagradiant3.setLayout(pruebagradiant3Layout);
        pruebagradiant3Layout.setHorizontalGroup(
            pruebagradiant3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pruebagradiant3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logo_fix2)
                .addGap(26, 26, 26))
            .addGroup(pruebagradiant3Layout.createSequentialGroup()
                .addGroup(pruebagradiant3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pruebagradiant3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(labelEdificio)
                        .addGap(164, 164, 164)
                        .addComponent(userLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pruebagradiant3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cmbTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(img_adm, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
            .addGroup(pruebagradiant3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pruebagradiant3Layout.createSequentialGroup()
                    .addGap(0, 491, Short.MAX_VALUE)
                    .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 491, Short.MAX_VALUE)))
        );
        pruebagradiant3Layout.setVerticalGroup(
            pruebagradiant3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pruebagradiant3Layout.createSequentialGroup()
                .addGroup(pruebagradiant3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pruebagradiant3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(logo_fix2))
                    .addGroup(pruebagradiant3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(titulo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pruebagradiant3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pruebagradiant3Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(pruebagradiant3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelEdificio)
                            .addComponent(userLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pruebagradiant3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTickets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pruebagradiant3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(img_adm, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(pruebagradiant3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pruebagradiant3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pruebagradiant3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radio_white1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(209, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(pruebagradiant3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(radio_white1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
int index_tecnico=cmbTecnico.getSelectedIndex();
String id_tecnico =id_adm.get(index_tecnico);

int index_ticket=cmbTickets.getSelectedIndex();
        System.out.println(index_ticket);
String id_ticket =idticket.get(index_ticket);

        try {
            vinculacion_ticketTecnico(id_tecnico,id_ticket);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Vinculacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            
            rellenaTablaVinculacion();
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Vinculacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnGuardarMouseClicked

    public void vinculacion_ticketTecnico(String idTecnico,String idticket) throws ClassNotFoundException{
    Date objFecha = new Date();
      SimpleDateFormat formato = new SimpleDateFormat ("dd/MM/yyyy");
      
         Connection conn; // objeto de conexion
        ConexionBD objetoConexionBD = new ConexionBD();
        PreparedStatement stmt = null;   // variable para la sentencia sql
        ResultSet rs = null;    //variable para resultado de consulta sql
         try {          
            conn=  objetoConexionBD.conexionDataBase();                        
                 rs= objTicket.rellenarvinculacion(conn, idTecnico,idticket); 
                 boolean x= objTicket.actualizartablaticket(conn, idticket); 

             JOptionPane.showMessageDialog(null, "se asigno el técnico correctamente");
            objetoConexionBD.cerrarConexion(conn);
        }

     catch (SQLException e) {
        e.printStackTrace();
    }
         
    }
    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        
    }//GEN-LAST:event_btnGuardarMouseEntered

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
     
    }//GEN-LAST:event_btnGuardarMouseExited

    private void cmbTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTecnicoActionPerformed
      int i=cmbTecnico.getSelectedIndex();
        ImageIcon ii = new ImageIcon(imagenes.get(i));
         //Ajustamos la imagen
         Image image = ii.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
         img_adm.setIcon(new ImageIcon(image)); 
    }//GEN-LAST:event_cmbTecnicoActionPerformed

    private void cmbTicketsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTicketsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTicketsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnGuardar;
    private javax.swing.JComboBox<String> cmbTecnico;
    private javax.swing.JComboBox<String> cmbTickets;
    private javax.swing.JLabel img_adm;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelEdificio;
    private javax.swing.JPanel loginBtn;
    private javax.swing.JLabel logo_fix;
    private javax.swing.JLabel logo_fix1;
    private javax.swing.JLabel logo_fix2;
    private fix_care.menu.pruebagradiant pruebagradiant1;
    private fix_care.menu.pruebagradiant pruebagradiant2;
    private fix_care.menu.pruebagradiant pruebagradiant3;
    private fix_care.menu.radio_white radio_white1;
    private fix_care.swing.table.Table table;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel titulo1;
    private javax.swing.JLabel titulo2;
    private javax.swing.JLabel userLabel1;
    // End of variables declaration//GEN-END:variables
}
