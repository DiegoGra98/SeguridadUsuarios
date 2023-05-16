/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao;

import config.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.interfaces.CrudModulo;
import org.models.ModeloModulo;

/**
 *
 * @author Diego Gramajo
 */
public class DaoModulo implements CrudModulo {

    ModeloModulo modulo = new ModeloModulo();
    //Variable para crear las sentencias SQL
    String strSql = "";
    String strSql2 = "";
    //Se crea un obejto de tipo conexión para manejar la persistencia hacia la base de datos
    Conexion conexion = new Conexion();
    //Obtiene el resultado de las consultas SQL
    ResultSet rs = null;
    //flag para retornar si la sentencia SQL fue satisfactorio o no
    boolean respuesta = false;

    @Override
    public ArrayList listar() {
        ArrayList<ModeloModulo> list = new ArrayList();
        try {
            strSql = "SELECT * FROM MODULO";
            conexion.open();
            rs = conexion.executeQuery(strSql);

            while (rs.next()) {
                ModeloModulo mod = new ModeloModulo();
                mod.setID(rs.getInt("ID_MODULO"));
                mod.setNombre(rs.getString("NOMBRE"));
                mod.setDescripcion(rs.getString("DESCRIPCION"));
                mod.setPath(rs.getString("PATH"));
                mod.setNivel(rs.getInt("NIVEL"));
                mod.setOrden(rs.getInt("ORDEN"));
                mod.setID_Modulo_Padre(rs.getInt("ID_MODULO_PADRE"));
                mod.setUsuario_Crea(rs.getString("USUARIO_CREA"));
                mod.setUsuario_Mod(rs.getString("USUARIO_MOD"));
                mod.setActivo(rs.getInt("ACTIVO"));
                list.add(mod);
            }
            rs.close();
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoModulo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoModulo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public ModeloModulo list(int id) {
        try {
            strSql = "SELECT * FROM MODULO WHERE ID_MODULO = " + id;
            conexion.open();
            rs = conexion.executeQuery(strSql);
            while (rs.next()) {
                modulo.setID(rs.getInt("ID_MODULO"));
                modulo.setNombre(rs.getString("NOMBRE"));
                modulo.setDescripcion(rs.getString("DESCRIPCION"));
                modulo.setPath(rs.getString("PATH"));
                modulo.setNivel(rs.getInt("NIVEL"));
                modulo.setOrden(rs.getInt("ORDEN"));
                modulo.setID_Modulo_Padre(rs.getInt("ID_MODULO_PADRE"));
                modulo.setUsuario_Crea(rs.getString("USUARIO_CREA"));
                modulo.setUsuario_Mod(rs.getString("USUARIO_MOD"));
                modulo.setActivo(rs.getInt("ACTIVO"));
            }

            rs.close();
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoModulo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoModulo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modulo;
    }

    @Override
    public boolean insertar(ModeloModulo modulo) {
        strSql = "INSERT INTO MODULO  "
                + "VALUES ( (SELECT ISNULL(MAX(ID_MODULO),0) + 1 FROM MODULO), "
                + "'" + modulo.getNombre() + "', '"
                + modulo.getDescripcion() + "', '"
                + modulo.getPath() + "', "
                + modulo.getNivel() + ", "
                + modulo.getOrden() + ", "
                + modulo.getID_Modulo_Padre() + ", "
                + "GETDATE(), "
                + "GETDATE(), '"
                + modulo.getUsuario_Crea() + "', '"
                + modulo.getUsuario_Mod() + "', "
                + modulo.getActivo()
                + ")";

        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoModulo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(DaoModulo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public boolean modificar(ModeloModulo modulo) {
        strSql = "UPDATE MODULO "
                + "SET  "
                + "NOMBRE = '" + modulo.getNombre() + "', "
                + "DESCRIPCION = '" + modulo.getDescripcion() + "', "
                + "PATH = '" + modulo.getPath() + "', "
                + "NIVEL = " + modulo.getNivel() + ", "
                + "ORDEN = " + modulo.getOrden() + ", "
                + "ID_MODULO_PADRE = " + modulo.getID_Modulo_Padre() + ", "
                + "FECHA_MOD = GETDATE(), "
                + "USUARIO_MOD = '" + modulo.getUsuario_Mod() + "', "
                + "ACTIVO = " + modulo.getActivo() + ", "
                + "WHERE ID_PRODUCTO = " + modulo.getID();

        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public boolean eliminar(int id) {
        strSql = "DELETE MODULO WHERE ID_MODULO = " + id;
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

}
