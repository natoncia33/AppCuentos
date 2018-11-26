package com.example.root.appnatda.entidades;

import java.io.Serializable;

public class CuentoVo implements Serializable {
    private String nombre;
    private String contenido;
    private int imagenId;

    private String info;
    private int imagenDetalle;

    public CuentoVo(){

    }

    public CuentoVo(String nombre, String info, String contenido, int imagenId, int imagenDetalle){
        this.nombre=nombre;
        this.contenido=contenido;
        this.imagenId=imagenId;
        this.info=info;
        this.imagenDetalle=imagenDetalle;
    }


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getImagenDetalle() {
        return imagenDetalle;
    }

    public void setImagenDetalle(int imagenDetalle) {
        this.imagenDetalle = imagenDetalle;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }
}
