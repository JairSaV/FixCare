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
public class info_chart {
    
     public ResultSet ChartBarra(Connection conn) throws SQLException {
        ResultSet rs;
        PreparedStatement stmt;        
        String sql = "SELECT count(*) total,e.nombre FROM `ticket` t JOIN edificio e on t.idEdificio=e.idEdificio GROUP BY t.idEdificio";   //se arma la sentencia de la consulta        
        stmt = conn.prepareStatement(sql);//se prepara la sentencia SQL mediante la variable statement--> stmt        
        rs = stmt.executeQuery(); //se ejecuta la consulta y se recibe en el result set --> rs        
        return rs;
    }
     
  public ResultSet pie(Connection conn) throws SQLException {
        ResultSet rs;
        PreparedStatement stmt;        
        String sql = "SELECT COUNT(*) total, s.nombre FROM ticket t JOIN servicios s on t.idServicio=s.idServicios GROUP BY t.idServicio";   //se arma la sentencia de la consulta        
        stmt = conn.prepareStatement(sql);//se prepara la sentencia SQL mediante la variable statement--> stmt        
        rs = stmt.executeQuery(); //se ejecuta la consulta y se recibe en el result set --> rs        
        return rs;
    }
     
}
