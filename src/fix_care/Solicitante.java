
package fix_care;


class Solicitante extends Usuario {
    public Solicitante(int id, String username, String password, String nombre, String email) {
        super(id, username, password, nombre, email);
    }

    public void crearTicket(Controller controlador, String prioridad, Departamentos dep, 
                          Servicios serv, String descripcion, String fotos) {
        controlador.crearTicket(this, prioridad, dep, serv, descripcion, fotos);
    }
}