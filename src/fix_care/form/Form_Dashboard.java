package fix_care.form;
import fix_care.cards.ModelCard;
import fix_care.clases.ConexionBD;
import fix_care.clases.InfoCards;
import fix_care.clases.TicketBD;
import fix_care.clases.UsuarioBD;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Form_Dashboard extends javax.swing.JPanel {
 TicketBD objticket = new TicketBD();
  ConexionBD   objetoConexionBD = new ConexionBD();   
    public Form_Dashboard() throws ClassNotFoundException {
        initComponents();
        init();
    }

    private void init() throws ClassNotFoundException {
        table.fixTable(jScrollPane1);
        Connection conn; // objeto de conexion
        ConexionBD objetoConexionBD = new ConexionBD();
        PreparedStatement stmt = null;   // variable para la sentencia sql
        ResultSet rs = null;    //variable para resultado de consulta sql
        InfoCards objCards = new InfoCards();
         try {          
            conn=  objetoConexionBD.conexionDataBase();                        
                 rs= objticket.rellenarDash_Board(conn);                
            while (rs.next()) {
                table.addRow(new Object[]{rs.getInt("idTicket"),rs.getString("solicitante"), rs.getString("Edificio"), rs.getString("area"), rs.getString("servicio"), rs.getString("fecha"),rs.getString("problematica"),rs.getString("estado"),rs.getString("tecnico"),rs.getString("bitacora")});
            }
            objetoConexionBD.cerrarConexion(conn);
        }

     catch (SQLException e) {
        e.printStackTrace();
    }
   

        ArrayList<String> dataList = new ArrayList<>(); //Se crea un array para agregar la información de las cards
        dataList.add("0");    //card1 posicion 0       
        dataList.add("0");    //card2 posicion1 
        dataList.add("0");    //card 3 posicion2
        dataList.add("0");   //card 4 cantidad de tecnicos 
        //aqui se conectara a la base de datos y se buscara el usuario en la tabla de usuarios del sistema para su comparacion
        try {
            conn = objetoConexionBD.conexionDataBase();
            rs = objCards.rellenarCards(conn);

            while (rs.next()) {
                int total = rs.getInt("total");
                String estado = rs.getString("estado");
                if (estado.equals("Completo")) {
                    dataList.set(0, total + "");
                }
                if (estado.equals("Pendiente")) {
                    dataList.set(1, total + "");
                }
                if (estado.equals("Proceso")) {
                    dataList.set(2, total + "");
                }

            }
            objetoConexionBD.cerrarConexion(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            conn = objetoConexionBD.conexionDataBase();
            rs = objCards.rellenarCards2(conn);

            if (rs.next()) {  //encontro al menos 1 registro con los datos
                int noTecnico = rs.getInt("total");
                //accedemos al sistema
                dataList.set(3, noTecnico + "");
            }
            objetoConexionBD.cerrarConexion(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //  init card data
        card1.setData(new ModelCard(null, null, null, dataList.get(0), "Tickets Completados"));
        card5.setData(new ModelCard(null, null, null, dataList.get(1), "Tickets Pendientes"));
        card6.setData(new ModelCard(null, null, null, dataList.get(2), "Tickets Trabajando"));
        card2.setData(new ModelCard(null, null, null, dataList.get(3), "Técnicos"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new fix_care.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new fix_care.swing.table.Table();
        card1 = new fix_care.cards.Card();
        card5 = new fix_care.cards.Card();
        card6 = new fix_care.cards.Card();
        card2 = new fix_care.cards.Card();
        chart2 = new fix_care.charts.Chart_Barra();
        chart_Pie2 = new fix_care.charts.Chart_Pie();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1360, 850));

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(10);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "# Folio", "Solicitante", "Edificio", "Área", "Servicio", "Fecha", "Problematica", "Estado", "Técnico", "Bitácora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        card1.setColor1(new java.awt.Color(51, 255, 102));
        card1.setColor2(new java.awt.Color(153, 255, 153));
        card1.setDescription("Tickets Completados");
        card1.setIcon(javaswingdev.GoogleMaterialDesignIcon.CHECK);

        card5.setColor1(new java.awt.Color(255, 51, 51));
        card5.setColor2(new java.awt.Color(255, 0, 0));
        card5.setDescription("Tickets Pendientes");
        card5.setDoubleBuffered(false);
        card5.setIcon(javaswingdev.GoogleMaterialDesignIcon.ASSIGNMENT_LATE);

        card6.setDescription("Tickets en Proceso");
        card6.setIcon(javaswingdev.GoogleMaterialDesignIcon.TIMER);

        card2.setColor1(new java.awt.Color(0, 0, 255));
        card2.setColor2(new java.awt.Color(0, 51, 255));
        card2.setIcon(javaswingdev.GoogleMaterialDesignIcon.BUILD);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(chart2, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(chart_Pie2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(card5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(card6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chart2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chart_Pie2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private fix_care.cards.Card card1;
    private fix_care.cards.Card card2;
    private fix_care.cards.Card card5;
    private fix_care.cards.Card card6;
    private fix_care.charts.Chart_Barra chart2;
    private fix_care.charts.Chart_Pie chart_Pie2;
    private javax.swing.JScrollPane jScrollPane1;
    private fix_care.swing.RoundPanel roundPanel1;
    private fix_care.swing.table.Table table;
    // End of variables declaration//GEN-END:variables
}
