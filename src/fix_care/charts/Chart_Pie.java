
package fix_care.charts;

import fix_care.clases.ConexionBD;
import fix_care.clases.info_chart;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author erick
 */
public class Chart_Pie extends javax.swing.JPanel {

    /**
     * Creates new form pie
     */
    public Chart_Pie() {
        initComponents();
        cargarGraficoPie3D();
    }
 private void cargarGraficoPie3D() {
      DefaultPieDataset dataset = new DefaultPieDataset();
      Connection conn;   // objeto de conexion
      PreparedStatement stmt = null;   // variable para la sentencia sql
        ResultSet rs = null;    //variable para resultado de consulta sql
     
     try {
            ConexionBD   objetoConexionBD = new ConexionBD();
            conn=  objetoConexionBD.conexionDataBase();                
            info_chart bd = new info_chart();
            rs= bd.pie(conn);
                 
             while (rs.next()) {  //encontro al menos 1 registro con los datos
               dataset.setValue(rs.getString("nombre"),rs.getInt("total"));   //accedemos al sistema
              
                            
            }   
              //se cierra la conexion
              objetoConexionBD.cerrarConexion(conn);
             
        } catch (HeadlessException | ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de conexión " +
                    ex.getMessage());
        }
        // 1. Crear dataset con datos
                 

        // 2. Crear gráfico 3D
        JFreeChart chart = ChartFactory.createPieChart3D(
            "Distribución de Servicios",  // Título
            dataset,                  // Datos
            true,                     // Leyenda
            true,                     // Tooltips
            false                     // URLs
        );

       
        // 4. Configurar el ChartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(
            jpl_pie.getWidth(), 
            jpl_pie.getHeight()
        ));

        // 5. Integrar en el JPanel (jpl_pie)
        jpl_pie.removeAll(); // Limpiar contenido previo
        jpl_pie.setLayout(new BorderLayout()); // Usar BorderLayout
        jpl_pie.add(chartPanel, BorderLayout.CENTER); // Centrar gráfico
        jpl_pie.revalidate(); // Actualizar interfaz
        jpl_pie.repaint();   // Redibujar
    }
    
       @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpl_pie = new javax.swing.JPanel();

        javax.swing.GroupLayout jpl_pieLayout = new javax.swing.GroupLayout(jpl_pie);
        jpl_pie.setLayout(jpl_pieLayout);
        jpl_pieLayout.setHorizontalGroup(
            jpl_pieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jpl_pieLayout.setVerticalGroup(
            jpl_pieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpl_pie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpl_pie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jpl_pie;
    // End of variables declaration//GEN-END:variables
}
