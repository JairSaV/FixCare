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
 * @author jairs
 */
public class DepartamentoBD {
    public int actualizarDepartamento(Connection conn, Departamento departamento) throws SQLException {
        String sql = "insert departamentos set (idEdificio,area) VALUES (?,?)";
        System.out.println(sql);
        
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, departamento.getEncargado());
            stmt.setString(2, departamento.getEdificio());
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
}
