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
import org.interfaces.CrudPermiso;
import org.models.ModeloPermiso;

/**
 *
 * @author Diego Gramajo
 */
public class DaoPermiso implements CrudPermiso {

    ModeloPermiso permiso = new ModeloPermiso();
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
    public ArrayList listar(int id) {
        ArrayList<ModeloPermiso> list = new ArrayList();
        try {
            strSql = "SELECT * FROM PERMISO WHERE ID_ROL = "+ id;
            conexion.open();
            rs = conexion.executeQuery(strSql);

            while (rs.next()) {
                ModeloPermiso per = new ModeloPermiso();
                per.setID(rs.getInt("ID_PERMISO"));
                per.setID_Modulo(rs.getInt("ID_MODULO"));
                 per.setID_Rol(rs.getInt("ID_ROL"));
                 per.setFecha_Crea(rs.getString("FECHA_CREA"));
                 per.setUsuario_Crea(rs.getString("USUARIO_CREA"));
                per.setActivo(rs.getInt("ACTIVO"));
                list.add(per);
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
    public ModeloPermiso list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertar(ModeloPermiso permiso) {
        strSql = "INSERT INTO PERMISO  "
                + "VALUES ( (SELECT ISNULL(MAX(ID_PERMISO),0) + 1 FROM PERMISO), "
                + permiso.getID_Modulo() + ", "
                + permiso.getID_Rol()+ ", "
                + "GETDATE(), "
                + "GETDATE(), '"
                + permiso.getUsuario_Crea() + "', '"
                + permiso.getUsuario_Mod() + "', "
                + permiso.getActivo()  
                + ")";

        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPermiso.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(DaoPermiso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public boolean modificar(ModeloPermiso permiso) {
        strSql = "UPDATE PERMISO "
                 + "SET  " +
                 "ID_ROL = " + permiso.getID_Rol()+ ", " +
                 "FECHA_MOD = GETDATE()," +
                 "USUARIO_MOD = '" + permiso.getUsuario_Mod()+ "', " +
                 "ACTIVO = " + permiso.getActivo() + 
                 "WHERE ID_PRODUCTO = "+permiso.getID();

        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPermiso.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoPermiso.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }

    @Override
    public boolean eliminar(int id) {
        strSql = "DELETE USUARIO WHERE ID_PERMISO = " + id;
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPermiso.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoPermiso.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }

}
