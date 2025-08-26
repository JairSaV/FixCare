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
public class EdificiosBD {
    public ResultSet consultaEdificios(Connection conn) throws SQLException {
        ResultSet rs;
        PreparedStatement stmt;        
        String sql = "SELECT * from edificio";   //se arma la sentencia de la consulta        
        stmt = conn.prepareStatement(sql);//se prepara la sentencia SQL mediante la variable statement--> stmt
        rs = stmt.executeQuery(); //se ejecuta la consulta y se recibe en el result set --> rs
        
        return rs;
    }

    public void insertarEdicifio(Connection conn, String id, String edificio) throws SQLException {
        String sql = "INSERT INTO `edificio`( `nombre`, `idUsuario`) VALUES (?,?)"; //se arma la sentencia de la consulta con parametros
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {   //se prepara la sentencia SQL mediante la variable statement--> stmt
                stmt.setString(1, edificio);   // Se establecen los parametros 
                stmt.setString(2, id);   // Se establecen los parametros 
       
            stmt.executeUpdate();
        }
    }
}
