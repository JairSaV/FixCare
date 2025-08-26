package fix_care.clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionBD {
    private String url;//contiene la direccion de la conexion
    private String user;//usuario de base de datos root
    private String password;//contraseña establecida
    private Connection conn;//contendra el atributo conexion


public ConexionBD(){    
    url="jdbc:mysql://localhost:3306/fix_care";
    user="root";
    password="";
    conn=null;
}

public Connection conexionDataBase()throws ClassNotFoundException{
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");        
        conn=DriverManager.getConnection(url,user,password);
        System.out.println("Conexion exitosa a la base de datos.");
    }
    catch(SQLException e){
        System.err.println("Error al conectar: "+e.getMessage());
    }
    return conn;
    }

public void  cerrarConexion (  Connection conn ) throws SQLException{
                      conn.close();  //se libera la conexión
        }
}