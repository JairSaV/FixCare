
package fix_care.form;

import fix_care.clases.ConexionBD;
import fix_care.clases.InfoCards;
import fix_care.clases.SeguimientoBD;
import fix_care.clases.TicketBD;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


public class Seguimiento extends javax.swing.JPanel {
    String idGeneralTecnico = "";
    String idGeneralTicket = "";
String selectedImagePath = "";
    TicketBD objticket = new TicketBD ();
    ArrayList <String> idTecnicos = new ArrayList<>();
    public Seguimiento() throws ClassNotFoundException {
        initComponents();
        init();               
    }
public void init() throws ClassNotFoundException{
table.fixTable(jScrollPane1);
        Connection conn; // objeto de conexion
        ConexionBD objetoConexionBD = new ConexionBD();
        PreparedStatement stmt = null;   // variable para la sentencia sql
        ResultSet rs = null;    //variable para resultado de consulta sql
        //Actualizar tabla 
    DefaultTableModel modelo = (DefaultTableModel) table.getModel();
    modelo.setRowCount(0); //Limpiar Tabla
         try {          
            conn=  objetoConexionBD.conexionDataBase();                        
                 rs= objticket.rellenarSeguimiento(conn);                
            while (rs.next()) {
                idTecnicos.add(rs.getString("idTecnico"));
                table.addRow(new Object[]{rs.getInt("idTicket"),rs.getString("solicitante"), rs.getString("Edificio"), rs.getString("area"), rs.getString("servicio"), rs.getString("fecha"),rs.getString("problematica"),rs.getString("estado"),rs.getString("tecnico"),rs.getString("bitacora"), rs.getString("img")});
            }
            objetoConexionBD.cerrarConexion(conn);
        }

     catch (SQLException e) {
        e.printStackTrace();
    }
         table.setModel(modelo);


}

public void llenarSeguimiento(){
    int fila = table.getSelectedRow();
    
    if (fila>=0) {
        txtFolio.setText(table.getValueAt(fila,0).toString());
        txtUsuario.setText((String) table.getValueAt(fila, 1));
        txtServicio.setText((String) table.getValueAt(fila, 4));
        txtEdificio.setText((String) table.getValueAt(fila, 2));
        txtArea.setText((String) table.getValueAt(fila, 3));
        txtProblematica.setText((String) table.getValueAt(fila, 6));
        ImageIcon ii = new ImageIcon((String) table.getValueAt(fila, 10));
         //Ajustamos la imagen
      //   txtImg.setText((String) table.getValueAt(fila, 10));
         Image image = ii.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
         txtImg.setIcon(new ImageIcon(image));
       idGeneralTecnico=idTecnicos.get(fila);
       idGeneralTicket=txtFolio.getText();
        
    }
    
    reporte.setTitle("Busqueda de usuarios");
       reporte.setSize(800,650);
       reporte.setLocationRelativeTo(this);
       this.reporte.setVisible(true);
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reporte = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        pruebagradiant2 = new fix_care.menu.pruebagradiant();
        titulo1 = new javax.swing.JLabel();
        LabelDatosSolicitantes = new javax.swing.JLabel();
        txtServicio = new javax.swing.JLabel();
        LabelServicioSolicitado = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JLabel();
        LabelProblematica = new javax.swing.JLabel();
        txtProblematica = new javax.swing.JLabel();
        LabelEdificio = new javax.swing.JLabel();
        txtEdificio = new javax.swing.JLabel();
        LabelArea = new javax.swing.JLabel();
        txtArea = new javax.swing.JLabel();
        LabelFolio = new javax.swing.JLabel();
        txtFolio = new javax.swing.JLabel();
        txtImg = new javax.swing.JLabel();
        radio_white2 = new fix_care.menu.radio_white();
        loginSeguimiento = new javax.swing.JPanel();
        SeguimientoBtnTxt = new javax.swing.JLabel();
        loginSeguimiento1 = new javax.swing.JPanel();
        finalizar = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtTrabajo = new javax.swing.JTextArea();
        btnUbicacion = new javax.swing.JLabel();
        browseBtn = new javax.swing.JPanel();
        btnBrowse = new javax.swing.JLabel();
        CheckUpLoader = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pruebagradiant1 = new fix_care.menu.pruebagradiant();
        titulo = new javax.swing.JLabel();
        logo_fix = new javax.swing.JLabel();
        radio_white1 = new fix_care.menu.radio_white();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new fix_care.swing.table.Table();

        titulo1.setFont(new java.awt.Font("Roboto Light", 1, 24)); // NOI18N
        titulo1.setForeground(new java.awt.Color(255, 255, 255));
        titulo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fix/care/images/001-buscar.png"))); // NOI18N
        titulo1.setText("SEGUIMIENTO TICKET");
        titulo1.setPreferredSize(new java.awt.Dimension(75, 18));

        LabelDatosSolicitantes.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        LabelDatosSolicitantes.setForeground(new java.awt.Color(255, 255, 255));
        LabelDatosSolicitantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fix/care/images/001-usuario.png"))); // NOI18N
        LabelDatosSolicitantes.setText("DATOS SOLICITANTE");
        LabelDatosSolicitantes.setPreferredSize(new java.awt.Dimension(75, 18));

        txtServicio.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        txtServicio.setForeground(new java.awt.Color(255, 255, 255));
        txtServicio.setText("USUARIO");
        txtServicio.setPreferredSize(new java.awt.Dimension(75, 18));

        LabelServicioSolicitado.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        LabelServicioSolicitado.setForeground(new java.awt.Color(255, 255, 255));
        LabelServicioSolicitado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fix/care/images/001-usuario.png"))); // NOI18N
        LabelServicioSolicitado.setText("SERVICIO SOLICITADO");
        LabelServicioSolicitado.setPreferredSize(new java.awt.Dimension(75, 18));

        txtUsuario.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setText("USUARIO");
        txtUsuario.setPreferredSize(new java.awt.Dimension(75, 18));

        LabelProblematica.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        LabelProblematica.setForeground(new java.awt.Color(255, 255, 255));
        LabelProblematica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fix/care/images/001-usuario.png"))); // NOI18N
        LabelProblematica.setText("PROBLEMATICA");
        LabelProblematica.setPreferredSize(new java.awt.Dimension(75, 18));

        txtProblematica.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        txtProblematica.setForeground(new java.awt.Color(255, 255, 255));
        txtProblematica.setText("USUARIO");
        txtProblematica.setPreferredSize(new java.awt.Dimension(75, 18));

        LabelEdificio.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        LabelEdificio.setForeground(new java.awt.Color(255, 255, 255));
        LabelEdificio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fix/care/images/001-usuario.png"))); // NOI18N
        LabelEdificio.setText("EDIFICIO");
        LabelEdificio.setPreferredSize(new java.awt.Dimension(75, 18));

        txtEdificio.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        txtEdificio.setForeground(new java.awt.Color(255, 255, 255));
        txtEdificio.setText("USUARIO");
        txtEdificio.setPreferredSize(new java.awt.Dimension(75, 18));

        LabelArea.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        LabelArea.setForeground(new java.awt.Color(255, 255, 255));
        LabelArea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fix/care/images/001-usuario.png"))); // NOI18N
        LabelArea.setText("AREA");
        LabelArea.setPreferredSize(new java.awt.Dimension(75, 18));

        txtArea.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        txtArea.setForeground(new java.awt.Color(255, 255, 255));
        txtArea.setText("USUARIO");
        txtArea.setPreferredSize(new java.awt.Dimension(75, 18));

        LabelFolio.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        LabelFolio.setForeground(new java.awt.Color(255, 255, 255));
        LabelFolio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fix/care/images/001-usuario.png"))); // NOI18N
        LabelFolio.setText("#FOLIO:");
        LabelFolio.setPreferredSize(new java.awt.Dimension(75, 18));

        txtFolio.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        txtFolio.setForeground(new java.awt.Color(255, 255, 255));
        txtFolio.setText("USUARIO");
        txtFolio.setPreferredSize(new java.awt.Dimension(75, 18));

        javax.swing.GroupLayout pruebagradiant2Layout = new javax.swing.GroupLayout(pruebagradiant2);
        pruebagradiant2.setLayout(pruebagradiant2Layout);
        pruebagradiant2Layout.setHorizontalGroup(
            pruebagradiant2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pruebagradiant2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pruebagradiant2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pruebagradiant2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136))
                    .addGroup(pruebagradiant2Layout.createSequentialGroup()
                        .addComponent(LabelDatosSolicitantes, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LabelFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(pruebagradiant2Layout.createSequentialGroup()
                        .addGroup(pruebagradiant2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pruebagradiant2Layout.createSequentialGroup()
                                .addComponent(LabelProblematica, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtProblematica, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pruebagradiant2Layout.createSequentialGroup()
                                .addComponent(LabelArea, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pruebagradiant2Layout.createSequentialGroup()
                                .addComponent(LabelServicioSolicitado, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pruebagradiant2Layout.createSequentialGroup()
                                .addComponent(LabelEdificio, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtEdificio, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addComponent(txtImg, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pruebagradiant2Layout.setVerticalGroup(
            pruebagradiant2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pruebagradiant2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pruebagradiant2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelDatosSolicitantes, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pruebagradiant2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pruebagradiant2Layout.createSequentialGroup()
                        .addGroup(pruebagradiant2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelServicioSolicitado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pruebagradiant2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelEdificio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEdificio, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(pruebagradiant2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelArea, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(pruebagradiant2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelProblematica, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProblematica, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );

        loginSeguimiento.setBackground(new java.awt.Color(8, 55, 116));

        SeguimientoBtnTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        SeguimientoBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        SeguimientoBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SeguimientoBtnTxt.setText("SEGUIMIENTO");
        SeguimientoBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SeguimientoBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SeguimientoBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SeguimientoBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SeguimientoBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout loginSeguimientoLayout = new javax.swing.GroupLayout(loginSeguimiento);
        loginSeguimiento.setLayout(loginSeguimientoLayout);
        loginSeguimientoLayout.setHorizontalGroup(
            loginSeguimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SeguimientoBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        loginSeguimientoLayout.setVerticalGroup(
            loginSeguimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SeguimientoBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        loginSeguimiento1.setBackground(new java.awt.Color(8, 55, 116));

        finalizar.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        finalizar.setForeground(new java.awt.Color(255, 255, 255));
        finalizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        finalizar.setText("FINALIZAR");
        finalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        finalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                finalizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                finalizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                finalizarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout loginSeguimiento1Layout = new javax.swing.GroupLayout(loginSeguimiento1);
        loginSeguimiento1.setLayout(loginSeguimiento1Layout);
        loginSeguimiento1Layout.setHorizontalGroup(
            loginSeguimiento1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(finalizar, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        loginSeguimiento1Layout.setVerticalGroup(
            loginSeguimiento1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(finalizar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        txtTrabajo.setColumns(20);
        txtTrabajo.setRows(5);
        txtTrabajo.setText("Escribe por favor los trabajos realizados...");
        txtTrabajo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTrabajoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(txtTrabajo);

        btnUbicacion.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        btnUbicacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnUbicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fix/care/images/002-marcador-de-posicion.png"))); // NOI18N
        btnUbicacion.setText("DETALLES DEL TRABAJO REALIZADO");
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

        browseBtn.setBackground(new java.awt.Color(8, 55, 116));

        btnBrowse.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        btnBrowse.setForeground(new java.awt.Color(255, 255, 255));
        btnBrowse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBrowse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fix/care/images/uploadIcon.png"))); // NOI18N
        btnBrowse.setText("SUBIR IMG");
        btnBrowse.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBrowse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBrowseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBrowseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBrowseMouseExited(evt);
            }
        });

        javax.swing.GroupLayout browseBtnLayout = new javax.swing.GroupLayout(browseBtn);
        browseBtn.setLayout(browseBtnLayout);
        browseBtnLayout.setHorizontalGroup(
            browseBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(browseBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        browseBtnLayout.setVerticalGroup(
            browseBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, browseBtnLayout.createSequentialGroup()
                .addComponent(btnBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        CheckUpLoader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fix/care/images/001-disco-flexible.png"))); // NOI18N

        javax.swing.GroupLayout radio_white2Layout = new javax.swing.GroupLayout(radio_white2);
        radio_white2.setLayout(radio_white2Layout);
        radio_white2Layout.setHorizontalGroup(
            radio_white2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, radio_white2Layout.createSequentialGroup()
                .addGroup(radio_white2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(radio_white2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(loginSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(radio_white2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(radio_white2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginSeguimiento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(radio_white2Layout.createSequentialGroup()
                        .addComponent(browseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CheckUpLoader, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
            .addGroup(radio_white2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnUbicacion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        radio_white2Layout.setVerticalGroup(
            radio_white2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, radio_white2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnUbicacion)
                .addGap(18, 18, 18)
                .addGroup(radio_white2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(radio_white2Layout.createSequentialGroup()
                        .addGap(0, 53, Short.MAX_VALUE)
                        .addGroup(radio_white2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(browseBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CheckUpLoader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addComponent(loginSeguimiento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(radio_white2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loginSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(radio_white2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pruebagradiant2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pruebagradiant2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radio_white2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout reporteLayout = new javax.swing.GroupLayout(reporte.getContentPane());
        reporte.getContentPane().setLayout(reporteLayout);
        reporteLayout.setHorizontalGroup(
            reporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        reporteLayout.setVerticalGroup(
            reporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Roboto Light", 1, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fix/care/images/001-buscar.png"))); // NOI18N
        titulo.setText("SEGUIMIENTO DE TICKETS");
        titulo.setPreferredSize(new java.awt.Dimension(75, 18));

        logo_fix.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fix/care/images/text_logo.png"))); // NOI18N

        javax.swing.GroupLayout pruebagradiant1Layout = new javax.swing.GroupLayout(pruebagradiant1);
        pruebagradiant1.setLayout(pruebagradiant1Layout);
        pruebagradiant1Layout.setHorizontalGroup(
            pruebagradiant1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pruebagradiant1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logo_fix)
                .addContainerGap())
        );
        pruebagradiant1Layout.setVerticalGroup(
            pruebagradiant1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pruebagradiant1Layout.createSequentialGroup()
                .addGroup(pruebagradiant1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pruebagradiant1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logo_fix))
                    .addGroup(pruebagradiant1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        radio_white1.setLayout(new javax.swing.BoxLayout(radio_white1, javax.swing.BoxLayout.LINE_AXIS));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "# Folio", "Solicitante", "Edificio", "Área", "Servicio", "Fecha", "Problematica", "Estado", "Técnico", "Bitácora", "Imagen Path"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        radio_white1.add(jScrollPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(radio_white1, javax.swing.GroupLayout.DEFAULT_SIZE, 1072, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pruebagradiant1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pruebagradiant1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(radio_white1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 581));
    }// </editor-fold>//GEN-END:initComponents

    private void SeguimientoBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeguimientoBtnTxtMouseClicked
    String seguimiento = txtTrabajo.getText();
    String imagen =  selectedImagePath;
     Connection conn; // objeto de conexion
        ConexionBD objetoConexionBD = new ConexionBD();
        PreparedStatement stmt = null;   // variable para la sentencia sql
        ResultSet rs = null;    //variable para resultado de consulta sql
      SeguimientoBD objSeguimiento = new SeguimientoBD(); 
    //aqui se conectara a la base de datos y se buscara el usuario en la tabla de usuarios del sistema para su comparacion
      try {          
            conn=  objetoConexionBD.conexionDataBase();    
            
                 int x= objSeguimiento.insertarSeguimiento(conn, idGeneralTicket, idGeneralTecnico,seguimiento,imagen);
                
            if (x>=0){
            JOptionPane.showMessageDialog(null,"El seguimiento se actualizo");
            this.reporte.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"Error");
            }
            objetoConexionBD.cerrarConexion(conn);
        }

     catch (SQLException e) {
        e.printStackTrace();
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(Seguimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SeguimientoBtnTxtMouseClicked

    private void SeguimientoBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeguimientoBtnTxtMouseEntered
        loginSeguimiento.setBackground(new Color(33,161,153));
    }//GEN-LAST:event_SeguimientoBtnTxtMouseEntered

    private void SeguimientoBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeguimientoBtnTxtMouseExited
        loginSeguimiento.setBackground(new Color(8, 55, 116));
    }//GEN-LAST:event_SeguimientoBtnTxtMouseExited

    private void finalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finalizarMouseClicked
    String seguimiento = txtTrabajo.getText();
    String imagen =  selectedImagePath;
     Connection conn; // objeto de conexion
        ConexionBD objetoConexionBD = new ConexionBD();
        PreparedStatement stmt = null;   // variable para la sentencia sql
        ResultSet rs = null;    //variable para resultado de consulta sql
      SeguimientoBD objSeguimiento = new SeguimientoBD(); 
    //aqui se conectara a la base de datos y se buscara el usuario en la tabla de usuarios del sistema para su comparacion
      try {          
            conn=  objetoConexionBD.conexionDataBase();    
            
                 int x= objSeguimiento.finalizarSeguimiento(conn, idGeneralTicket, idGeneralTecnico,seguimiento,imagen);
                
            if (x>=0){
            JOptionPane.showMessageDialog(null,"El seguimiento se actualizo");
            this.reporte.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"Error");
            }
            objetoConexionBD.cerrarConexion(conn);
        }

     catch (SQLException e) {
        e.printStackTrace();
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(Seguimiento.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }//GEN-LAST:event_finalizarMouseClicked

    private void finalizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finalizarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_finalizarMouseEntered

    private void finalizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finalizarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_finalizarMouseExited

    private void btnUbicacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbicacionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUbicacionMouseClicked

    private void btnUbicacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbicacionMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUbicacionMouseEntered

    private void btnUbicacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbicacionMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUbicacionMouseExited

    private void btnBrowseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBrowseMouseClicked
        JFileChooser browseImageFile = new JFileChooser();
        //Filtrar imagenes
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg"); //Tipo de archivos permisibles
        browseImageFile.addChoosableFileFilter(fnef);
        int showOpenDialogue = browseImageFile.showOpenDialog(null);
        if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
            File selectedImageFile = browseImageFile.getSelectedFile();
             selectedImagePath = selectedImageFile.getAbsolutePath();
             // JOptionPane.showMessageDialog(null, selectedImagePath);
            //Despliega las imagenes el el jlabel
          //  ImageIcon ii = new ImageIcon(selectedImagePath);
            //Ajustamos la imagen
            //Image image = ii.getImage().getScaledInstance(ProfileImage.getWidth(), ProfileImage.getHeight(), Image.SCALE_SMOOTH);
            //ProfileImage.setIcon(new ImageIcon(image));
     CheckUpLoader.setVisible(true);
        }
    }//GEN-LAST:event_btnBrowseMouseClicked

    private void btnBrowseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBrowseMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBrowseMouseEntered

    private void btnBrowseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBrowseMouseExited

    }//GEN-LAST:event_btnBrowseMouseExited

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
   llenarSeguimiento();
    }//GEN-LAST:event_tableMouseClicked

    private void txtTrabajoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTrabajoMouseClicked
       if (txtTrabajo.getText().equals("Escribe por favor los trabajos realizados...")) {
            txtTrabajo.setText("");
            txtTrabajo.setForeground(Color.black);
       }
    }//GEN-LAST:event_txtTrabajoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CheckUpLoader;
    private javax.swing.JLabel LabelArea;
    private javax.swing.JLabel LabelDatosSolicitantes;
    private javax.swing.JLabel LabelEdificio;
    private javax.swing.JLabel LabelFolio;
    private javax.swing.JLabel LabelProblematica;
    private javax.swing.JLabel LabelServicioSolicitado;
    private javax.swing.JLabel SeguimientoBtnTxt;
    private javax.swing.JPanel browseBtn;
    private javax.swing.JLabel btnBrowse;
    private javax.swing.JLabel btnUbicacion;
    private javax.swing.JLabel finalizar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel loginSeguimiento;
    private javax.swing.JPanel loginSeguimiento1;
    private javax.swing.JLabel logo_fix;
    private fix_care.menu.pruebagradiant pruebagradiant1;
    private fix_care.menu.pruebagradiant pruebagradiant2;
    private fix_care.menu.radio_white radio_white1;
    private fix_care.menu.radio_white radio_white2;
    private javax.swing.JDialog reporte;
    private fix_care.swing.table.Table table;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel titulo1;
    private javax.swing.JLabel txtArea;
    private javax.swing.JLabel txtEdificio;
    private javax.swing.JLabel txtFolio;
    private javax.swing.JLabel txtImg;
    private javax.swing.JLabel txtProblematica;
    private javax.swing.JLabel txtServicio;
    private javax.swing.JTextArea txtTrabajo;
    private javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables
}
