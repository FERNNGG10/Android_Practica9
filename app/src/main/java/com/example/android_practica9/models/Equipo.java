package com.example.android_practica9.models;

import java.io.Serializable;

public class Equipo implements Serializable {
    private String nombre;
    private String localidad;
    private int campeonatos;
     private int imagen;

    public Equipo(String nombre,String localidad,int campeonatos,int imagen){
        this.nombre=nombre;
        this.campeonatos=campeonatos;
        this.localidad=localidad;
        this.imagen=imagen;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getCampeonatos() {
        return campeonatos;
    }

    public void setCampeonatos(int campeonatos) {
        this.campeonatos = campeonatos;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }


}
