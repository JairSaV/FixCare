/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fix_care;
class Tecnico extends Usuario {
    private Departamentos departamento;

    public Tecnico(int id, String username, String password, String nombre, String email, Departamentos departamento) {
        super(id, username, password, nombre, email);
        this.departamento = departamento;
    }

    public void asignarTicket(Ticket ticket) {
        ticket.setTecnico(this);
        ticket.setEstatus("En proceso");
    }

    public void actualizarTicket(Ticket ticket, String estatus, String comentarios) {
        ticket.setEstatus(estatus);
        // Aquí se podrían agregar los comentarios al historial del ticket
    }

    // Getters y setters
    public Departamentos getDepartamento() { return departamento; }
}

