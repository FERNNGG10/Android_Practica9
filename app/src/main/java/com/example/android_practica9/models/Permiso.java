package com.example.android_practica9.models;

public class Permiso {
    private String nombre;
    private String permiso;
    private boolean isChecked;
    public Permiso(String nombre,String permiso){
        this.nombre=nombre;
        this.permiso=permiso;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }



}
