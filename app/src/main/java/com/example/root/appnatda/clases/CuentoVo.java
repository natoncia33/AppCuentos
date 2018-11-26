package com.example.root.appnatda.clases;

import java.io.Serializable;

public class CuentoVo implements Serializable {

    private String cuento;
    private String info;
    private String contenido;
    private  int imagenId;
    private int imagenDetalle;


    public CuentoVo(String cuento, String contenido, String info, int imagenId, int imagenDetalle){
        this.cuento=cuento;
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

    public String getCuento() {
        return cuento;
    }

    public void setCuento(String cuento) {
        this.cuento = cuento;
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
