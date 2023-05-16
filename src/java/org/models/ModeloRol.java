/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.models;

/**
 *
 * @author Diego Gramajo
 */
public class ModeloRol {
    private int ID;
    private String Nombre;
    private String Descripcion;
    private String Fecha_Crea;
    private String Fecha_Mod;
    private String Usuario_Crea;
    private String Usuario_Mod;
    private int Activo;

    public ModeloRol() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getFecha_Crea() {
        return Fecha_Crea;
    }

    public void setFecha_Crea(String Fecha_Crea) {
        this.Fecha_Crea = Fecha_Crea;
    }

    public String getFecha_Mod() {
        return Fecha_Mod;
    }

    public void setFecha_Mod(String Fecha_Mod) {
        this.Fecha_Mod = Fecha_Mod;
    }

    public String getUsuario_Crea() {
        return Usuario_Crea;
    }

    public void setUsuario_Crea(String Usuario_Crea) {
        this.Usuario_Crea = Usuario_Crea;
    }

    public String getUsuario_Mod() {
        return Usuario_Mod;
    }

    public void setUsuario_Mod(String Usuario_Mod) {
        this.Usuario_Mod = Usuario_Mod;
    }

    public int getActivo() {
        return Activo;
    }

    public void setActivo(int Activo) {
        this.Activo = Activo;
    }
    
}
