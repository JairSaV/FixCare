/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package fix_care.charts;

import fix_care.clases.ConexionBD;
import fix_care.clases.UsuarioBD;
import fix_care.clases.info_chart;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author erick
 */
public class Chart_Barra extends javax.swing.JPanel {

    /**
     * Creates new form Chart
     */
    public Chart_Barra() {
        initComponents();  
        cargarGrafico();
    }

    private void cargarGrafico() {
        
        
        //variables de clase 
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        Connection conn;   // objeto de conexion
        PreparedStatement stmt = null;   // variable para la sentencia sql
        ResultSet rs = null;    //variable para resultado de consulta sql
    //aqui se conectara a la base de datos y se buscara el usuario en la tabla de usuarios del sistema para su comparacion
      try {
            ConexionBD   objetoConexionBD = new ConexionBD();
            conn=  objetoConexionBD.conexionDataBase();                
            info_chart bd = new info_chart();
            rs= bd.ChartBarra(conn);
                 
             while (rs.next()) {  //encontro al menos 1 registro con los datos
                //accedemos al sistema
                 data.addValue(rs.getInt("total"), "Edificios", rs.getString("nombre"));               
            }   
              //se cierra la conexion
              objetoConexionBD.cerrarConexion(conn);
             
        } catch (HeadlessException | ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de conexión " +
                    ex.getMessage());
        }
  
            
        
        // 2. Crear gráfico de barras 3D
        JFreeChart barChart = ChartFactory.createBarChart3D(
            "Número de Tickets por Edificios",  // Título
            "Edificios",                 // Eje X
            "Cantidad",               // Eje Y
            data,                     // Dataset
            PlotOrientation.VERTICAL,  // Orientación
            true,                      // Leyenda
            true,                      // Tooltips
            false                      // URLs
        );
        // 3. Obtener el plot y el renderizador
        CategoryPlot plot = barChart.getCategoryPlot();
        BarRenderer3D renderer = (BarRenderer3D) plot.getRenderer();

      // Método CORRECTO (usar setBase en lugar de setDefault)
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator(
            "{2}", new java.text.DecimalFormat("0")
        ));
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBaseItemLabelFont(new Font("Arial", Font.BOLD, 12));

        // 3. Crear ChartPanel y configurarlo
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setPreferredSize(new Dimension(
            panel1.getWidth(),       // Ajustar al ancho del panel1
            panel1.getHeight()      // Ajustar al alto del panel1
        ));

        
        
        // 4. Limpiar panel1 y añadir el gráfico
        panel1.removeAll();                // Eliminar componentes previos
        panel1.setLayout(new BorderLayout()); // Usar BorderLayout
        panel1.add(chartPanel, BorderLayout.CENTER); // Centrar el gráfico
        panel1.revalidate();               // Actualizar la interfaz
        panel1.repaint();                  // Redibujar
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel1;
    // End of variables declaration//GEN-END:variables
}
