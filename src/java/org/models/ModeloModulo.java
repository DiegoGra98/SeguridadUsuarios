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
public class ModeloModulo {
    private int ID;
    private String Nombre;
    private String Descripcion;
    private String Path;
    private int Nivel;
    private int Orden;
    private int ID_Modulo_Padre;
    private String Fecha_Crea;
    private String Fecha_Mod;
    private String Usuario_Crea;
    private String Usuario_Mod;
    private int Activo;

    public ModeloModulo() {
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

    public String getPath() {
        return Path;
    }

    public void setPath(String Path) {
        this.Path = Path;
    }

    public int getNivel() {
        return Nivel;
    }

    public void setNivel(int Nivel) {
        this.Nivel = Nivel;
    }

    public int getOrden() {
        return Orden;
    }

    public void setOrden(int Orden) {
        this.Orden = Orden;
    }

    public int getID_Modulo_Padre() {
        return ID_Modulo_Padre;
    }

    public void setID_Modulo_Padre(int ID_Modulo_Padre) {
        this.ID_Modulo_Padre = ID_Modulo_Padre;
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
