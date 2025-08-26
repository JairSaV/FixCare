/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fix_care;

import java.util.ArrayList;


class Supervisor extends Usuario {
    public Supervisor(int id, String username, String password, String nombre, String email) {
        super(id, username, password, nombre, email);
    }

    public void reasignarTicket(Ticket ticket, Tecnico nuevoTecnico) {
        ticket.setTecnico(nuevoTecnico);
    }

    public void generarReporte(ArrayList<Ticket> tickets) {
        // Lógica para generar reportes
    }
}