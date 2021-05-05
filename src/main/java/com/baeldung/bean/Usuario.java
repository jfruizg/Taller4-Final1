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
    private String descripcion;

    private String descripcionImagem;

    @Expose
    private String imagen;


    public Usuario(String nombre, Date fecha, String descripcion, String imagen, String descripcionImagem) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.descripcionImagem = descripcionImagem;
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

    public String getDescripcionImagem() {
        return descripcionImagem;
    }

    public void setDescripcionImagem(String descripcionImagem) {
        this.descripcionImagem = descripcionImagem;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String toString() {
        return "Usuario[" + "nombre=" + nombre + "| fecha=" + fecha +"| Descripcion"+descripcion+
                "| MetaData"+descripcionImagem +"| imagen=" + imagen + ']';
    }
}
