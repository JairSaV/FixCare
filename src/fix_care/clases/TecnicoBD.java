
package fix_care.clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TecnicoBD {
     public ResultSet consultaTecCombo(Connection conn) throws SQLException {
        ResultSet rs;
        PreparedStatement stmt;        
        String sql = "SELECT `idUsuario`,`nombre`,`apepat`,`apemat`,`img` FROM `usuario` WHERE `rol`='Tecnico'";   //se arma la sentencia de la consulta        
        stmt = conn.prepareStatement(sql);//se prepara la sentencia SQL mediante la variable statement--> stmt
        rs = stmt.executeQuery(); //se ejecuta la consulta y se recibe en el result set --> rs
        
        return rs;
    }
}
