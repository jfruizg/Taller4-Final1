package com.baeldung.bean;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import com.google.gson.annotations.Expose;

public class Usuario implements Serializable {
    @Expose
    private String nombre;

    @Expose
    private Date fecha;

    @Expose
    private String descripcion;

    @Expose
    private String imagen;


    public Usuario(String nombre, Date fecha, String descripcion, String imagen) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
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


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String toString() {
        return "Usuario[" + "nombre=" + nombre + "| fecha=" + fecha +"| Descripcion"+descripcion+" | Imagen"+imagen;

    }
}
