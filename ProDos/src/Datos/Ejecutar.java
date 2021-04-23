package Datos;

/**
 *
 * @author fernando guiñazú
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Ejecutar {
    
    private MySQLConnect conectar;
    private Connection conexion;
    private Statement stmt = null;
    
    public ResultSet consulta(String query){
        
        conectar = new MySQLConnect();//aca se crea una instancia de la clase MySQLConnect
        conexion = conectar.conexionBD();//aca se convoca a ejecucion al metodo de instancia 
                                       //conexionBD de la clase MySQLConnect que me va a retornar la conexion a la BD
        ResultSet res = null;// aca se va a almacenar la matriz resultado , en una variable de tipo ResultSet llamada res
        
        try{
            if(conexion != null){
                stmt = conexion.createStatement();//el objeto Statement se usa para enviar sentencias sql simples
                res = stmt.executeQuery(query);/* stmt.executeQuery(query) Sirve para realizar la consulta a la base de datos
                y me retorna una matriz resultado*/
                return res;//retorno la matriz resultado
            }
            }catch(SQLException ex){//aca se captura la excepcion
                    JOptionPane.showMessageDialog(null,ex);// aca se muestra la excepcion
            }
        return res;// se retorna un null ya que no se obtubo una matriz resultado
    }
    
    public void peticion(String query){
        
        conectar = new MySQLConnect();//aca se crea una instancia de la clase MySQLConnect 
                                     // y se la almacena en el atributo conectar de tipo MySQLConnect
        conexion = conectar.conexionBD();//aca se realiza la conexion a la base de 
                                        //datos convocando a ejecucion al metodo de instancia conexionBD
        
        try{
            if(conexion != null){
                stmt = conexion.createStatement();// aca se crea un objeto de tipo statement y 
                                                 //se lo almacena el el atributo stmt
                stmt.execute(query);// aca se realiza la peticion a la base de datos , en esta caso no hay una variable ResultSet
                                    //porque yo no quiero traer datos ;
            }
        }catch(SQLException ex){
            try{
                if(stmt == null){
                    conexion.rollback();
                    JOptionPane.showMessageDialog(null,"Fallo en la actualizacion");
                }
            }catch(SQLException es){
                JOptionPane.showMessageDialog(null,"rollback realizado");
            }
        }
    }
    
}
