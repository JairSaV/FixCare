
package fix_care.clases;

import java.util.Date;


public class Ticket {
    private Date fecha;    
    private String folio;
    private String prioridad;    
    private int servicio;    
    private int edificio;    
    private String descripcion;
    private String fotos;
    private String estatus;
    private String area;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

  

    public Ticket(Date fecha, String folio, String prioridad, int servicio, int edificio, String descripcion, String fotos, String estatus, String area) {
        this.fecha = fecha;
        this.folio = folio;
        this.prioridad = prioridad;
        this.servicio = servicio;
        this.edificio = edificio;
        this.descripcion = descripcion;
        this.fotos = fotos;
        this.estatus = estatus;
        this.area = area;
    }
    
  
    
    
    

    // Getters y setters

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public int getServicio() {
        return servicio;
    }

    public void setServicio(int servicio) {
        this.servicio = servicio;
    }

    public int getEdificio() {
        return edificio;
    }

    public void setEdificio(int edificio) {
        this.edificio = edificio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFotos() {
        return fotos;
    }

    public void setFotos(String fotos) {
        this.fotos = fotos;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
  
}