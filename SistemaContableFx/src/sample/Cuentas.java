package sample;

public class Cuentas {
    private String nombre;
    private int codigo;
    private String tipo;
    private String recibe_saldo;


    public Cuentas( int codigo, String nombre, String tipo, String recibe_saldo) {

        this.nombre = nombre;
        this.codigo = codigo;
        this.tipo = tipo;
        this.recibe_saldo = recibe_saldo;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String cuenta) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRecibe_saldo() {
        return recibe_saldo;
    }

    public void setRecibe_saldo(String recibe_saldo) {
        this.recibe_saldo = recibe_saldo;
    }


}
