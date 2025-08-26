/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fix_care;

import java.util.ArrayList;
import java.util.Date;

class Controller {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Ticket> tickets;
    private ArrayList<Departamentos> departamentos;
    private ArrayList<Servicios> servicios;
    private ArrayList<Edificio> edificios;
    private Usuario usuarioActual;

    public Controller() {
        usuarios = new ArrayList<>();
        tickets = new ArrayList<>();
        departamentos = new ArrayList<>();
        servicios = new ArrayList<>();
        edificios = new ArrayList<>();
        inicializarDatos();
    }

    private void inicializarDatos() {
        // Datos de ejemplo
        departamentos.add(new Departamentos(1, "TI"));
        departamentos.add(new Departamentos(2, "Mantenimiento"));
       
        
        edificios.add(new Edificio(1, "Edificio A"));
        edificios.add(new Edificio(2, "Edificio B"));
        
        usuarios.add(new Solicitante(1, "user1", "pass1", "Juan Pérez", "user1@empresa.com"));
        usuarios.add(new Tecnico(2, "tec1", "pass2", "Carlos López", "tec1@empresa.com", departamentos.get(0)));
        usuarios.add(new Supervisor(3, "sup1", "pass3", "Ana García", "sup1@empresa.com"));
    }

    public void iniciarSistema() {      
        System.out.println("Sistema de Tickets de Mantenimiento iniciado");
    }

    // Métodos para gestionar tickets, usuarios, etc.
    public void crearTicket(Usuario usuario, String prioridad, Departamentos dep, Servicios serv, 
                          String descripcion, String fotos) {
        Ticket nuevoTicket = new Ticket(
            new Date(), 
            tickets.size() + 1, 
            "TKT-" + (tickets.size() + 1000),
            prioridad,
            dep,
            serv,
            usuario,
            null, // Tecnico se asigna después
            descripcion,
            fotos,
            "Abierto"
        );
        tickets.add(nuevoTicket);
    }

    // Getters y setters
    public ArrayList<Usuario> getUsuarios() { return usuarios; }
    public ArrayList<Ticket> getTickets() { return tickets; }
    public ArrayList<Departamentos> getDepartamentos() { return departamentos; }
    public ArrayList<Servicios> getServicios() { return servicios; }
    public ArrayList<Edificio> getEdificios() { return edificios; }
    public Usuario getUsuarioActual() { return usuarioActual; }
    public void setUsuarioActual(Usuario usuarioActual) { this.usuarioActual = usuarioActual; }
}
