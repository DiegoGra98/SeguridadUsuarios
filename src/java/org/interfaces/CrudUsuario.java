/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.ArrayList;
import org.models.ModeloUsuario;

/**
 *
 * @author migu3
 */
public interface CrudUsuario {
    public ArrayList listar();
    public ModeloUsuario list (int id,String usr);
    public boolean insertar(ModeloUsuario usuario);
    public boolean modificar(ModeloUsuario usuario);
    public boolean eliminar(int id);  
}
