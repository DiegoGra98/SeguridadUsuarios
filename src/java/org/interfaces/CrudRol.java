/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.ArrayList;
import org.models.ModeloRol;

/**
 *
 * @author Diego Gramajo
 */
public interface CrudRol {
    public ArrayList listar();
    public ModeloRol List (int id);
    public boolean insertar(ModeloRol rol);
    public boolean modificar(ModeloRol rol);
    public boolean eliminar(int id);  
}
