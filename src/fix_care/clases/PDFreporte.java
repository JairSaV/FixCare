
package fix_care.clases;


import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.SQLException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import javax.swing.table.TableModel;


public class PDFreporte {
    
    public void reporteHistorial() {                                                 
    try {
        ConexionBD objConexion = new ConexionBD();
        try (java.sql.Connection conn = objConexion.conexionDataBase()) {
            String sql = "SELECT idTicket, area, problematica, fecha, user, idServicio FROM ticket JOIN usuario ON ticket.idusuario=usuario.idusuario";
            try (java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
                 java.sql.ResultSet rs = stmt.executeQuery();
                 PDDocument documento = new PDDocument()) {

                PDPage pagina = new PDPage(PDRectangle.A4);
                documento.addPage(pagina);

                float margin = 40;
                float yStart = pagina.getMediaBox().getHeight() - margin;
                float rowHeight = 20;
                float tableWidth = pagina.getMediaBox().getWidth() - 2 * margin;
                float[] colWidths = {40, 80, 180, 70, 50, 60}; // Área +5, Usuario -5
                String[] headers = {"ID", "Área", "Problema", "Fecha", "Usuario", "Servicio"};

                try (PDPageContentStream contenido = new PDPageContentStream(documento, pagina)) {
                    // Título
                    contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_BOLD, 16);
                    contenido.newLineAtOffset(margin, yStart);
                    contenido.showText("Reporte de Tickets");
                    contenido.endText();

                    // Tabla
                    float y = yStart - 30;
                    // Encabezados
                    float x = margin;
                    contenido.setFont(PDType1Font.TIMES_BOLD, 12);
                    for (int i = 0; i < headers.length; i++) {
                        contenido.beginText();
                        contenido.newLineAtOffset(x + 2, y - 15);
                        contenido.showText(headers[i]);
                        contenido.endText();
                        x += colWidths[i];
                    }
                    // Línea debajo de encabezados
                    contenido.moveTo(margin, y - rowHeight);
                    contenido.lineTo(margin + tableWidth, y - rowHeight);
                    contenido.stroke();

                    // Datos
                    contenido.setFont(PDType1Font.TIMES_ROMAN, 11);
                    y -= rowHeight;
                    while (rs.next()) {
                        x = margin;
                        // ID
                        contenido.beginText();
                        contenido.newLineAtOffset(x + 2, y - 15);
                        contenido.showText(String.valueOf(rs.getInt("idTicket")));
                        contenido.endText();
                        x += colWidths[0];

                        // Área
                        contenido.beginText();
                        contenido.newLineAtOffset(x + 2, y - 15);
                        contenido.showText(rs.getString("area"));
                        contenido.endText();
                        x += colWidths[1];

                        // Problema (salto de línea si es largo)
                        String problema = rs.getString("problematica");
                        int maxProblemaLength = 40;
                        String[] problemaLineas = problema.split("(?<=\\G.{" + maxProblemaLength + "})");
                        contenido.beginText();
                        contenido.newLineAtOffset(x + 2, y - 15);
                        contenido.showText(problemaLineas[0]);
                        contenido.endText();
                        x += colWidths[2];

                        // Fecha
                        contenido.beginText();
                        contenido.newLineAtOffset(x + 2, y - 15);
                        contenido.showText(rs.getString("fecha"));
                        contenido.endText();
                        x += colWidths[3];

                        // Usuario
                        contenido.beginText();
                        contenido.newLineAtOffset(x + 2, y - 15);
                        contenido.showText(rs.getString("user"));
                        contenido.endText();
                        x += colWidths[4];

                        // Servicio
                        contenido.beginText();
                        contenido.newLineAtOffset(x + 2, y - 15);
                        contenido.showText(String.valueOf(rs.getInt("idServicio")));
                        contenido.endText();

                        // Líneas verticales
                        float xLine = margin;
                        for (int i = 0; i < colWidths.length + 1; i++) {
                            contenido.moveTo(xLine, y);
                            contenido.lineTo(xLine, y - rowHeight);
                            contenido.stroke();
                            if (i < colWidths.length) xLine += colWidths[i];
                        }
                        // Línea horizontal
                        contenido.moveTo(margin, y - rowHeight);
                        contenido.lineTo(margin + tableWidth, y - rowHeight);
                        contenido.stroke();

                        // Si hay más líneas en "Problema", dibújalas debajo
                        for (int i = 1; i < problemaLineas.length; i++) {
                            y -= rowHeight;
                            x = margin + colWidths[0] + colWidths[1];
                            contenido.beginText();
                            contenido.newLineAtOffset(x + 2, y - 15);
                            contenido.showText(problemaLineas[i]);
                            contenido.endText();
                            // Líneas verticales para la fila extra
                            xLine = margin;
                            for (int j = 0; j < colWidths.length + 1; j++) {
                                contenido.moveTo(xLine, y);
                                contenido.lineTo(xLine, y - rowHeight);
                                contenido.stroke();
                                if (j < colWidths.length) xLine += colWidths[j];
                            }
                            // Línea horizontal
                            contenido.moveTo(margin, y - rowHeight);
                            contenido.lineTo(margin + tableWidth, y - rowHeight);
                            contenido.stroke();
                        }
                        y -= rowHeight;
                        if (y < 60) break; // Evita escribir fuera de la página
                    }
                } catch (IOException ex) {
                    System.getLogger(PDFreporte.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
                documento.save("C:\\Users\\jairs\\Documents\\reporte_tickets.pdf");
            } catch (IOException ex) {
                System.getLogger(PDFreporte.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
            javax.swing.JOptionPane.showMessageDialog(null, "Reporte generado correctamente.");
        } catch (ClassNotFoundException ex) {
            System.getLogger(PDFreporte.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    } catch (HeadlessException | SQLException x) {
        System.out.println("Error: " + x.getMessage());
        javax.swing.JOptionPane.showMessageDialog(null, "Error al generar el reporte.");
    }
}                                      
    
    
    public void reporteTicket(TableModel modelo, int rowIndex) {
        try {
            // 1. Obtén los datos de la fila seleccionada
            String folio      = modelo.getValueAt(rowIndex, 0) != null ? modelo.getValueAt(rowIndex, 0).toString() : "";
            String solicitante= modelo.getValueAt(rowIndex, 1) != null ? modelo.getValueAt(rowIndex, 1).toString() : "";
            String edificio   = modelo.getValueAt(rowIndex, 2) != null ? modelo.getValueAt(rowIndex, 2).toString() : "";
            String area       = modelo.getValueAt(rowIndex, 3) != null ? modelo.getValueAt(rowIndex, 3).toString() : "";
            String servicio   = modelo.getValueAt(rowIndex, 4) != null ? modelo.getValueAt(rowIndex, 4).toString() : "";
            String fecha      = modelo.getValueAt(rowIndex, 5) != null ? modelo.getValueAt(rowIndex, 5).toString() : "";
            String estado     = modelo.getValueAt(rowIndex, 6) != null ? modelo.getValueAt(rowIndex, 6).toString() : "";
            String problematica = modelo.getValueAt(rowIndex, 7) != null ? modelo.getValueAt(rowIndex, 7).toString() : "";
            String tecnico    = modelo.getValueAt(rowIndex, 8) != null ? modelo.getValueAt(rowIndex, 8).toString() : "";

            // 2. Consulta el seguimiento en la base de datos
            String bitacora = "";
            ConexionBD objConexion = new ConexionBD();
            try (java.sql.Connection conn = objConexion.conexionDataBase()) {
                String sql = "SELECT se.bitacora FROM ticket t LEFT JOIN seguimiento se ON se.idTicket = t.idTicket WHERE CONCAT('FXC_',t.idTicket) = ?";
                try (java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, folio);
                    try (java.sql.ResultSet rs = stmt.executeQuery()) {
                        if (rs.next()) {
                            bitacora = rs.getString("bitacora");
                        }
                    }
                }

                // 3. Genera el PDF
                try (PDDocument documento = new PDDocument()) {
                    PDPage pagina = new PDPage(PDRectangle.A4);
                    documento.addPage(pagina);

                    try (PDPageContentStream contenido = new PDPageContentStream(documento, pagina)) {
                        float margin = 40;
                        float y = pagina.getMediaBox().getHeight() - margin;

                        contenido.beginText();
                        contenido.setFont(PDType1Font.TIMES_BOLD, 16);
                        contenido.newLineAtOffset(margin, y);
                        contenido.showText("Ticket " + folio);
                        contenido.endText();

                        y -= 30;
                        contenido.beginText();
                        contenido.setFont(PDType1Font.TIMES_ROMAN, 12);
                        contenido.newLineAtOffset(margin, y);
                        contenido.showText("Solicitante: " + solicitante);
                        contenido.endText();

                        y -= 20;
                        contenido.beginText();
                        contenido.newLineAtOffset(margin, y);
                        contenido.showText("Edificio: " + edificio);
                        contenido.endText();

                        y -= 20;
                        contenido.beginText();
                        contenido.newLineAtOffset(margin, y);
                        contenido.showText("Área: " + area);
                        contenido.endText();

                        y -= 20;
                        contenido.beginText();
                        contenido.newLineAtOffset(margin, y);
                        contenido.showText("Servicio: " + servicio);
                        contenido.endText();

                        y -= 20;
                        contenido.beginText();
                        contenido.newLineAtOffset(margin, y);
                        contenido.showText("Fecha: " + fecha);
                        contenido.endText();

                        y -= 20;
                        contenido.beginText();
                        contenido.newLineAtOffset(margin, y);
                        contenido.showText("Estado: " + estado);
                        contenido.endText();

                        y -= 20;
                        contenido.beginText();
                        contenido.newLineAtOffset(margin, y);
                        contenido.showText("Problematica: " + problematica);
                        contenido.endText();

                        y -= 20;
                        contenido.beginText();
                        contenido.newLineAtOffset(margin, y);
                        contenido.showText("Técnico: " + tecnico);
                        contenido.endText();

                        y -= 30;
                        contenido.beginText();
                        contenido.setFont(PDType1Font.TIMES_BOLD, 13);
                        contenido.newLineAtOffset(margin, y);
                        contenido.showText("Seguimiento:");
                        contenido.endText();

                        y -= 20;
                        contenido.beginText();
                        contenido.setFont(PDType1Font.TIMES_ROMAN, 12);
                        contenido.newLineAtOffset(margin, y);
                        contenido.showText(bitacora != null ? bitacora : "Sin seguimiento");
                        contenido.endText();
                    }
                    
                    documento.save("C:\\Users\\jairs\\Documents\\ticket "+folio+solicitante+".pdf");
                }
                javax.swing.JOptionPane.showMessageDialog(null, "PDF generado correctamente.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "Error al generar el PDF.");
        }
    }
}
