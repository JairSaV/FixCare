/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fix_care.clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author erick
 */
public class SeguimientoBD {
      public int insertarSeguimiento(Connection conn, String ticket, String idTecnico, String bitacora, String img) throws SQLException {
        String sql = "INSERT INTO `seguimiento`( `idTecnico`, `idTicket`, `bitacora`, `fecha`, `img`) VALUES (?,?,?,?,?)";       
       java.util.Date fecha=new java.util.Date();
        java.util.Date utilDate =fecha;
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
           
            stmt.setString(1, idTecnico);    
            stmt.setString(2, ticket);    
            stmt.setString(3, bitacora);           
            stmt.setDate(4, sqlDate);     
            stmt.setString(5, img);
            
            
            
            int filas = stmt.executeUpdate();
            System.out.println(filas);
            if (filas > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {// se obteniene el idGenerado
                    if (rs.next()) {
                        return rs.getInt(1);   
                    }
                }
            }
        }
        return -1;
    }
         public int finalizarSeguimiento(Connection conn, String ticket, String idTecnico, String bitacora, String img) throws SQLException {
        String sql = "INSERT INTO `seguimiento`( `idTecnico`, `idTicket`, `bitacora`, `fecha`, `img`) VALUES (?,?,?,?,?)";       
       java.util.Date fecha=new java.util.Date();
        java.util.Date utilDate =fecha;
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
           
            stmt.setString(1, idTecnico);    
            stmt.setString(2, ticket);    
            stmt.setString(3, bitacora);           
            stmt.setDate(4, sqlDate);     
            stmt.setString(5, img);
            
            
            
            int filas = stmt.executeUpdate();
            System.out.println(filas);
            if (filas > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {// se obteniene el idGenerado
                    if (rs.next()) {
                        updateTicket(conn,ticket);
                        return rs.getInt(1);   
                    }
                }
            }
        }
        return -1;
    }
        
         public boolean updateTicket(Connection conn, String ticket) throws SQLException{
          String update = "UPDATE `ticket` SET `estado`='Completo' WHERE `idTicket`=?"; //se arma la sentencia de la consulta
         try (PreparedStatement stmt = conn.prepareStatement(update)) {  //se prepara la sentencia SQL mediante la variable statement--> stmt
            stmt.setString(1, ticket); // Se establecen los parametros 
                        
            return stmt.executeUpdate() > 0;  //se ejecuta la consulta y se recibe en el result set --> rs
        }
         }
}
