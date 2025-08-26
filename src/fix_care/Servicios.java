
package fix_care;

public class Servicios {
        private int id;
        private String nombre;
        private String descripcion;
    

    public Servicios(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion=descripcion;
    }

    // Getters y setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
}
