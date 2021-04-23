/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLConnect {
    
    public MySQLConnect(){}
    
    public Connection conexionBD(){
        Connection con = null;// declaro una variable de tipo Connection llamada con y la inicializo en null;
        try{
            Class.forName("com.mysql.jdbc.Driver");// se registra el driver de conexion de la base de datos, 
                                                  //cada base de datos usa uno distinto en este caso mysql
            con = DriverManager.getConnection("jdbc:mysql://localhost/prodos","root","");
            // aca se realiza la conexion a la base de datos (despues de localhost/ va el nombre de la base de datos)
        }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE,null,ex);
        }
        return con;
    }
}
