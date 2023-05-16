/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.ArrayList;
import org.models.ModeloModulo;

/**
 *
 * @author Diego Gramajo
 */
public interface CrudModulo {
    public ArrayList listar();
    public ModeloModulo list (int id);
    public boolean insertar(ModeloModulo modulo);
    public boolean modificar(ModeloModulo modulo);
    public boolean eliminar(int id);  
}
