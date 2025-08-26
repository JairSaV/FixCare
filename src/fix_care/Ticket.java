/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fix_care;

import java.util.Date;


class Ticket {
    private Date fecha;
    private int id;
    private String folio;
    private String prioridad;
    private Departamentos dep;
    private Servicios serv;    
    private Usuario user;
    private Tecnico tec;        
    private String descripcion;
    private String fotos;
    private String estatus;

    public Ticket(Date fecha, int id, String folio, String prioridad, Departamentos dep, 
                 Servicios serv, Usuario user, Tecnico tec, String descripcion, 
                 String fotos, String estatus) {
        this.fecha = fecha;
        this.id = id;
        this.folio = folio;
        this.prioridad = prioridad;
        this.dep = dep;
        this.serv = serv;
        this.user = user;
        this.tec = tec;
        this.descripcion = descripcion;
        this.fotos = fotos;
        this.estatus = estatus;
    }

    // Getters y setters
    public Date getFecha() { return fecha; }
    public int getId() { return id; }
    public String getFolio() { return folio; }
    public String getPrioridad() { return prioridad; }
    public Departamentos getDep() { return dep; }
    public Servicios getServ() { return serv; }
    public Usuario getUser() { return user; }
    public Tecnico getTec() { return tec; }
    public String getDescripcion() { return descripcion; }
    public String getFotos() { return fotos; }
    public String getEstatus() { return estatus; }

    public void setTecnico(Tecnico tec) { this.tec = tec; }
    public void setEstatus(String estatus) { this.estatus = estatus; }
}