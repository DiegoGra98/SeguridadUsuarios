/*
 * Autor: Ing. José Félix
 * Descripción: Clase de conexión para base de datos
 * Fecha: dd/mm/YYYY
 */
package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {    
    
    private PreparedStatement preparar = null;    
    private  Connection coneccion=null;    
    private ResultSet resultado = null;
    private boolean respuesta = false;
     //Cadena de Conexion
    String stringConnectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;"+"databaseName=PROYECTOFINAL;";
    //Driver o controlador JDBC
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
    public Connection open() throws ClassNotFoundException{        
        try {  
                Class.forName(driver);
                coneccion = DriverManager.getConnection(stringConnectionUrl,"USR_UMG","123umg");
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);            
            System.out.println("Excepción: " + e.getMessage());
        }
        return coneccion;
    }
    
    public void close() throws Exception{
        //Connection coneccion = null;
        try {
            if (coneccion != null){
                coneccion.clearWarnings();
                coneccion.close();                
            }
        } catch (SQLException e) {
            coneccion = null;
            throw new Exception(e.getMessage());
        }

    }
    //INSERT, UPDATE, DELETE
    public boolean executeSql (String cmd) throws Exception{
            if (cmd != null)
            try {
                    this.preparar = this.coneccion.prepareStatement(cmd);
                    this.preparar.executeUpdate();
                    respuesta = true;
            } catch (SQLException e) {
                    throw new Exception(e.getMessage());
            }
            else
                    throw new Exception("El comando a ejecutar es nulo!");
            return respuesta;
    }
    //SELECT
    public ResultSet executeQuery (String strSQL){
        
            if (strSQL != null)
            try {        
                    
                    preparar = coneccion.prepareStatement(strSQL);                    
                    resultado = preparar.executeQuery();	
            } catch (SQLException e) {                    
                System.out.println("Error al ejecutar el query en Clase: Conexion: " + e.toString());
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            }
            //close();
            return resultado;
    }
    
}
