/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fix_care;

/**
 *
 * @author erick
 */
public class Usuario {         
    private int id;
    private String nombre;
    private String username;
    private String password;    
    private String email;
    private String rol;
    private String matricula;
    private String numTel;
    
      public Usuario(int id, String username, String password, String nombre, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.email = email;
    }
}
