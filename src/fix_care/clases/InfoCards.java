/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fix_care.clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author erick
 */
public class InfoCards {
    public ResultSet rellenarCards(Connection conn) throws SQLException {
         ResultSet rs;
        PreparedStatement stmt; 
        String sql = "SELECT count(idTicket) as 'total', estado from ticket group by estado;";  //se arma la sentencia de la consulta con parametros
       stmt = conn.prepareStatement(sql);//se prepara la sentencia SQL mediante la variable statement--> stmt
       
        rs = stmt.executeQuery(); //se ejecuta la consulta y se recibe en el result set --> rs
        
        return rs;
    }
    public ResultSet rellenarCards2(Connection conn) throws SQLException {
         ResultSet rs;
        PreparedStatement stmt; 
        String sql = "SELECT COUNT(*) as 'total' FROM usuario where rol='Tecnico';" ; //se arma la sentencia de la consulta con parametros
       stmt = conn.prepareStatement(sql);//se prepara la sentencia SQL mediante la variable statement--> stmt
       
        rs = stmt.executeQuery(); //se ejecuta la consulta y se recibe en el result set --> rs
        
        return rs;
    }
    
}
