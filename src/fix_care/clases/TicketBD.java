/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fix_care.clases;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author erick
 */
public class TicketBD {
     public int insertTicket(Connection conn, Ticket ticket, int id_user) throws SQLException {
        String sql = "INSERT INTO `ticket`(`idUsuario`, `idEdificio`, `fecha`, `idServicio`, `area`, `problematica`, `estado`, `img`) VALUES (?,?,?,?,?,?,?,?)";       
       
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            java.util.Date utilDate =ticket.getFecha();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            stmt.setInt(1, id_user);    
            stmt.setInt(2, ticket.getEdificio());    
            stmt.setDate(3, sqlDate);           
            stmt.setInt(4, ticket.getServicio());     
            stmt.setString(5, ticket.getArea());
            stmt.setString(6, ticket.getDescripcion());
            stmt.setString(7, ticket.getEstatus());
            stmt.setString(8, ticket.getFotos());
            
            
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
     
    public ResultSet rellenaTabla_usuaio(Connection conn, int id) throws SQLException {
        ResultSet rs;
        PreparedStatement stmt;    
        String sql = "SELECT t.idTicket, e.nombre as Edificio ,t.fecha,s.nombre as servicio ,t.area,t.problematica,t.estado FROM `ticket` t JOIN edificio e on " +
"t.idEdificio=e.idEdificio JOIN servicios s on s.idServicios=t.idServicio WHERE t.idUsuario=?";   //se arma la sentencia de la consulta        
        stmt = conn.prepareStatement(sql);//se prepara la sentencia SQL mediante la variable statement--> stmt
        stmt.setInt(1, id);       //se establecen los campos de consulta
        
        rs = stmt.executeQuery(); //se ejecuta la consulta y se recibe en el result set --> rs
        
        return rs;
    } 
    
    public ResultSet rellenarDash_Board(Connection conn) throws SQLException {
        ResultSet rs;
        PreparedStatement stmt;    
        String sql = "SELECT t.idTicket,CONCAT(u.nombre, ' ', u.apepat, ' ', u.apemat) as solicitante, e.nombre AS Edificio, t.fecha, s.nombre AS servicio, t.area, t.problematica, t.estado,CONCAT(u_tecnico.nombre, ' ', u_tecnico.apepat, ' ', u_tecnico.apemat) AS tecnico, se.bitacora " +
"FROM  `ticket` t JOIN edificio e ON t.idEdificio = e.idEdificio JOIN servicios s ON s.idServicios = t.idServicio JOIN "+
"usuario u ON u.idUsuario = t.idUsuario LEFT JOIN seguimiento se ON se.idTicket = t.idTicket LEFT JOIN usuario u_tecnico ON u_tecnico.idUsuario = se.idTecnico GROUP BY `idTicket` ";   //se arma la sentencia de la consulta        
        stmt = conn.prepareStatement(sql);//se prepara la sentencia SQL mediante la variable statement--> stmt        
        rs = stmt.executeQuery(); //se ejecuta la consulta y se recibe en el result set --> rs
        
        return rs;
    }
    public ResultSet rellenarSeguimiento(Connection conn) throws SQLException {
        ResultSet rs;
        PreparedStatement stmt;    
        String sql = "SELECT se.idTecnico, t.idTicket, CONCAT(u.nombre, ' ', u.apepat, ' ', u.apemat) AS solicitante, e.nombre AS Edificio, t.fecha, s.nombre AS servicio, t.area, t.problematica, t.estado, CONCAT(u_tecnico.nombre, ' ', u_tecnico.apepat, ' ', u_tecnico.apemat) AS tecnico, se.bitacora, t.img FROM `ticket` t INNER JOIN edificio e ON t.idEdificio = e.idEdificio INNER JOIN servicios s ON s.idServicios = t.idServicio INNER JOIN usuario u ON u.idUsuario = t.idUsuario LEFT JOIN seguimiento se ON se.idTicket = t.idTicket AND se.idSeguimiento = ( SELECT MAX(idSeguimiento) FROM seguimiento WHERE idTicket = t.idTicket ) LEFT JOIN usuario u_tecnico ON u_tecnico.idUsuario = se.idTecnico WHERE se.idTecnico IS NOT NULL AND t.estado != 'Completo'" ;   //se arma la sentencia de la consulta        
        stmt = conn.prepareStatement(sql);//se prepara la sentencia SQL mediante la variable statement--> stmt        
        rs = stmt.executeQuery(); //se ejecuta la consulta y se recibe en el result set --> rs
        
        return rs;
    }
     public ResultSet rellenarTablaConsulta(Connection conn, String combo, String variable) throws SQLException {
         ResultSet rs;
        PreparedStatement stmt;    
        String sql = "SELECT CONCAT('FXC_',t.`idTicket`) as folio,CONCAT(u.nombre, ' ', u.apepat, ' ', u.apemat) as solicitante, e.nombre AS Edificio, t.fecha, s.nombre AS servicio, t.area, t.problematica, t.estado,CONCAT(u_tecnico.nombre, ' ', u_tecnico.apepat, ' ', u_tecnico.apemat) AS tecnico, se.bitacora FROM  `ticket` t JOIN edificio e ON t.idEdificio = e.idEdificio JOIN servicios s ON s.idServicios = t.idServicio JOIN usuario u ON u.idUsuario = t.idUsuario LEFT JOIN seguimiento se ON se.idTicket = t.idTicket LEFT JOIN usuario u_tecnico ON u_tecnico.idUsuario = se.idTecnico ";   ///se arma la sentencia de la consulta              
         switch (combo){
             case "Departamento": 
                    sql += "where  e.nombre LIKE '%"+variable+"%'";
                    break;
             case "Tecnico":
                 sql += "where  u_tecnico.nombre LIKE '%"+variable+"%'";
                 break;
             case "Problematica":
                  sql += "where  t.problematica LIKE '%"+variable+"%'";             
                  break;
             case  "Folio":
                 if(variable.length()>4){                
                     String variableaux = variable.substring(0,4);
                         System.out.println(variableaux);
                 if(variableaux.equals("FXC_")){
                 variableaux=variable.substring(4,variable.length());
                     System.out.println(variableaux);
                  sql += "where t.idTicket='"+variableaux+"'";
                 } else {
                  sql += "where t.idTicket='"+variable+"'";
                 }              
                 } else {
                   sql += "where t.idTicket='"+variable+"'";
                 }
                
                 
                 break;
             case "Solicitante":
                 sql += "where  u.nombre LIKE '%"+variable+"%'";
                 
                 break;
             case "Servicio":
                 sql += "where  s.nombre LIKE '%"+variable+"%'";

                 default: sql+="";
                     
                     break;
         
         }
                
          stmt = conn.prepareStatement(sql);//se prepara la sentencia SQL mediante la variable statement--> stmt        
        rs = stmt.executeQuery(); //se ejecuta la consulta y se recibe en el result set --> rs
        
        return rs;
    }
    public ResultSet rellenaCmbTicket(Connection conn) throws SQLException{
         ResultSet rs;
        PreparedStatement stmt;    
        String sql = "SELECT `idTicket`,CONCAT('FXC_',`idTicket`) as folio FROM `ticket` WHERE `estado` ='Pendiente'";   //se arma la sentencia de la consulta        
        stmt = conn.prepareStatement(sql);//se prepara la sentencia SQL mediante la variable statement--> stmt        
        rs = stmt.executeQuery(); //se ejecuta la consulta y se recibe en el result set --> rs
        
        return rs;
     }
    
    public ResultSet rellenarvinculacionTabla(Connection conn) throws SQLException {
        ResultSet rs;
        PreparedStatement stmt;    
        String sql = "SELECT CONCAT('FXC_',t.`idTicket`) as folio, CONCAT(u.nombre,' ',u.apepat,' ',u.apemat) as solicitante,e.nombre as edificio," +
" t.area, t.fecha ,s.nombre as servicio FROM `ticket` t JOIN usuario u ON t.idUsuario=u.idUsuario JOIN edificio e on t.idEdificio=e.idEdificio JOIN servicios s on t.idServicio=s.idServicios WHERE `estado`='Pendiente'";   //se arma la sentencia de la consulta        
        stmt = conn.prepareStatement(sql);//se prepara la sentencia SQL mediante la variable statement--> stmt
       
        
        rs = stmt.executeQuery(); //se ejecuta la consulta y se recibe en el result set --> rs
        
        return rs;
    } 
    
    
    public ResultSet rellenarvinculacion(Connection conn,String id_tecnico,String id_ticket) throws SQLException {
       
        
        java.util.Date fecha=new java.util.Date();
        java.util.Date utilDate =fecha;
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        String sql = "INSERT INTO `seguimiento`( `idTecnico`, `idTicket`, `bitacora`, `fecha`, `img`) VALUES (?,?,?,?,?)"; 
        
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, id_tecnico);    
            stmt.setString(2, id_ticket);                          
            stmt.setString(3, "Asignado el Técnico");
            stmt.setDate(4, sqlDate);             
            stmt.setString(5, "");             
            int filas = stmt.executeUpdate();
           
            if (filas > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {// se obteniene el idGenerado
                    if (rs.next()) {
                        return rs;   
                    }
                }
            }
        }
         return null;
        
    } 
    
    public boolean actualizartablaticket(Connection conn, String id_ticket) throws SQLException {
        String sql = "UPDATE `ticket` SET `estado`='Proceso' WHERE `idTicket`=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {  //se prepara la sentencia SQL mediante la variable statement--> stmt
            stmt.setString(1, id_ticket); // Se establecen los parametros           
            return stmt.executeUpdate() > 0;  //se ejecuta la consulta y se recibe en el result set --> rs
        }
    }
    
    
}
