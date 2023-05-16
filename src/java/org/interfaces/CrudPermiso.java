/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.ArrayList;
import org.models.ModeloPermiso;

/**
 *
 * @author Diego Gramajo
 */
public interface CrudPermiso {
    public ArrayList listar(int id);
    public ModeloPermiso list (int id);
    public boolean insertar(ModeloPermiso permiso);
    public boolean modificar(ModeloPermiso permiso);
    public boolean eliminar(int id);  
}
