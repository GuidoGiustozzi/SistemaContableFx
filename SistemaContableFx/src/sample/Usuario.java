package sample;

public class Usuario {
    private int id;
    private String nombre;
    private String rol;

    public Usuario(int id, String nombre,  String rol) {
        this.id = id;
        this.nombre = nombre;

        this.rol = rol;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }
}
