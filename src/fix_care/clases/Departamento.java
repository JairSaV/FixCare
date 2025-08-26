/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fix_care.clases;

/**
 *
 * @author jairs
 */
public class Departamento {
    
    private String edificio;
    private String encargado;

    public Departamento(String edificio, String encargado) {
        this.edificio = edificio;
        this.encargado = encargado;
    }
    
    

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }
    
    
}
