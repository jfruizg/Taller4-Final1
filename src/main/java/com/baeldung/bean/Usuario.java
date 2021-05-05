package com.baeldung.bean;

import java.io.Serializable;
import java.util.Date;
import com.google.gson.annotations.Expose;

public class Usuario implements Serializable {
    @Expose
    private String nombre;

    @Expose
    private Date fecha;

    @Expose
    private String imagen;

    public Usuario(String nombre, Date fecha,String imagen) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.imagen = imagen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String toString() {
        return "City{" + "nombre=" + nombre + ", fecha=" + fecha +
                ", imagen=" + imagen + '}';
    }
}
