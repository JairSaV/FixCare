package fix_care.clases;

public class Usuario {

    private String nombre;
    private String apepat;
    private String apemat;   
    private String correo;
    private String rol;
    private String telefono;
    private String usuario;
    private String password;
    private String img; 

    public Usuario(){}
    public Usuario( String nombre, String apepat, String apemat, String correo, String  rol, String telefono, String usuario, String password, String img) {
        
        this.nombre = nombre;
        this.apepat = apepat;
        this.apemat = apemat;
        this.correo = correo;
        this.rol = rol;
        this.telefono = telefono;
        this.usuario = usuario;
        this.password = password;
        this.img = img; 
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    private int idUsuario;    

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApepat() {
        return apepat;
    }

    public void setApepat(String apepat) {
        this.apepat = apepat;
    }

    public String getApemat() {
        return apemat;
    }

    public void setApemat(String apemat) {
        this.apemat = apemat;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
  

}