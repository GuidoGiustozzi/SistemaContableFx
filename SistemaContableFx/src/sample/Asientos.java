package sample;

import java.util.Date;

public class Asientos {
    private int id;
    private Date fecha;
    private String descripcion;
    private int idusuario;

    public Asientos(int id, Date fecha, String descripcion, int idusuario) {
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.idusuario = idusuario;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }





}





