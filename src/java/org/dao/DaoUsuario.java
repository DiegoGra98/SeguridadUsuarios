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
import org.models.ModeloUsuario;
import org.interfaces.CrudUsuario;

/**
 *
 * @author migu3
 */
public class DaoUsuario implements CrudUsuario {

    ModeloUsuario usuario = new ModeloUsuario();
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
        ArrayList<ModeloUsuario> list = new ArrayList();
        try {
            strSql = "SELECT * FROM USUARIO";
            conexion.open();
            rs = conexion.executeQuery(strSql);

            while (rs.next()) {
                ModeloUsuario usr = new ModeloUsuario();
                usr.setID(rs.getInt("ID_USUARIO"));
                usr.setNombre(rs.getString("NOMBRE"));
                usr.setApellido(rs.getString("APELLIDO"));
                usr.setUsuario(rs.getString("USUARIO"));
                usr.setPassword(rs.getString("PASSWORD"));
                usr.setID_Rol(rs.getInt("ID_ROL"));
                usr.setCodigo(rs.getInt("CODIGO"));
                usr.setActivo(rs.getInt("ACTIVO"));
                
                list.add(usr);
            }
            rs.close();
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public ModeloUsuario list(int id, String usr) {
        try {
            if (id==0) {
                 strSql = "SELECT * FROM USUARIO WHERE USUARIO ='" + usr + "'";
            } else {
               
                strSql = "SELECT * FROM USUARIO WHERE ID_USUARIO =" + id;
            }
            conexion.open();
            rs = conexion.executeQuery(strSql);

            while (rs.next()) {
                usuario.setID(rs.getInt("ID_USUARIO"));
                usuario.setNombre(rs.getString("NOMBRE"));
                usuario.setApellido(rs.getString("APELLIDO"));
                usuario.setUsuario(rs.getString("USUARIO"));
                usuario.setPassword(rs.getString("PASSWORD"));
                usuario.setID_Rol(rs.getInt("ID_ROL"));
                usuario.setCodigo(rs.getInt("CODIGO"));
                usuario.setActivo(rs.getInt("ACTIVO"));
            }
            rs.close();
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;
    }

    @Override
    public boolean insertar(ModeloUsuario usuario) {
        strSql = "INSERT INTO USUARIO  "
                + "VALUES ( (SELECT ISNULL(MAX(ID_USUARIO),0) + 1 FROM USUARIO), '"
                + usuario.getNombre() + "', '"
                + usuario.getApellido() + "', '"
                + usuario.getUsuario() + "', '"
                + usuario.getPassword() + "', '"
                + usuario.getID_Rol() + "', '"
                + usuario.getCodigo() + "', "
                + "GETDATE(), "
                + "GETDATE(), '"
               +  usuario.getNombre() + "','"
                +  usuario.getNombre() + "','"
                + usuario.getActivo() + "'"
                + ")";

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
    public boolean modificar(ModeloUsuario usuario) {
        strSql = "UPDATE USUARIO "
                + "SET  "
                + "NOMBRE = '" + usuario.getNombre() + "', "
                + "APELLIDO = '" + usuario.getApellido() + "', "
                + "PASSWORD = '" + usuario.getPassword() + "', "
                + "ID_ROL = " + usuario.getID_Rol() + ", "
                + "FECHA_MOD = GETDATE(), " 
                + "USUARIO_MOD = '" + usuario.getUsuario_Mod() + "', "
                + "ACTIVO = " + usuario.getActivo() + ", "
                + "WHERE ID_PRODUCTO = " + usuario.getID();

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
        strSql = "DELETE USUARIO WHERE ID_USUARIO = " + id;
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
