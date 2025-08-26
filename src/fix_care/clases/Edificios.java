
package fix_care.clases;


public class Edificios {
    int id;
    String nombre;
    Usuario usuario;
    
    
    public Edificios(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;       
    }
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
