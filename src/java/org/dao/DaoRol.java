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
import org.interfaces.CrudRol;
import org.models.ModeloRol;

/**
 *
 * @author Diego Gramajo
 */
public class DaoRol implements CrudRol {

    ModeloRol rol = new ModeloRol();
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
        ArrayList<ModeloRol> list = new ArrayList();
        try {
            strSql = "SELECT * FROM ROL";
            conexion.open();
            rs = conexion.executeQuery(strSql);

            while (rs.next()) {
                ModeloRol Rol = new ModeloRol();
                Rol.setID(rs.getInt("ID_ROL"));
                Rol.setNombre(rs.getString("NOMBRE"));
                Rol.setDescripcion(rs.getString("DESCRIPCION"));
                Rol.setActivo(rs.getInt("ACTIVO"));
                Rol.setFecha_Crea((rs.getString("FECHA_CREA")));
                Rol.setUsuario_Crea((rs.getString("USUARIO_CREA")));
                list.add(Rol);
            }
            rs.close();
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoRol.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoRol.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public ModeloRol List(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertar(ModeloRol rol) {
        strSql = "INSERT INTO ROL  "
                + "VALUES ( (SELECT ISNULL(MAX(ID_ROL),0) + 1 FROM ROL), "
                + "'" + rol.getNombre() + "', '"
                + rol.getDescripcion() + "', "
                + "GETDATE(), "
                + "GETDATE(), '"
                + rol.getUsuario_Crea() + "', '"
                + rol.getUsuario_Mod() + "', "
                + rol.getActivo()
                + ")";

        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoRol.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(DaoRol.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public boolean modificar(ModeloRol rol) {
        strSql = "UPDATE ROL "
                + "SET  "
                + "NOMBRE = '" + rol.getNombre() + "', "
                + "DESCRIPCION = '" + rol.getDescripcion() + "', "
                + "FECHA_MOD = GETDATE(), " 
                + "USUARIO_MOD = '" + rol.getUsuario_Mod() + "', "
                + "ACTIVO = " + rol.getActivo() + ", "
                + "WHERE ID_PRODUCTO = " + rol.getID();

        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoRol.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(DaoRol.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public boolean eliminar(int id) {
        strSql = "DELETE USUARIO WHERE ID_ROL = " + id;
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
