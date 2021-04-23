/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author fernando guiñazú
 */
import java.sql.ResultSet;


public class Ciudad {
    private int id;
    private String nombre;
    private int idprovincia;
    private Ejecutar ej = new Ejecutar();
    
    public Ciudad(){}
    
    public Ciudad(int idciudad,String ciudad){
        
        this.id = idciudad;
        this.nombre = ciudad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdprovincia() {
        return idprovincia;
    }

    public void setIdprovincia(int idprovincia) {
        this.idprovincia = idprovincia;
    }
    
    public String toString(){
        return this.nombre;
    }
    
    public ResultSet listar(int idprovincia){
        String query = "SELECT * FROM ciudad WHERE idprovincia = "+idprovincia+"";
        return ej.consulta(query);
    }
    
    public ResultSet buscar(String datodebusqueda){
        String query = "SELECT t1.id AS idenciu, t2.id AS idenprov,t3.id AS idenpai,"
                     + "t1.nombre AS ciudad,t2.nombre AS provincia ,t3.nombre AS Pais " 
                     + "FROM ciudad t1 INNER JOIN provincia t2 ON t1.idprovincia = t2.id "
                     + "INNER JOIN pais t3 ON t2.id_pais = t3.id "
                     + "WHERE t1.nombre like '%"+datodebusqueda+"%' "
                     + "or t2.nombre like '%"+datodebusqueda+"%' "
                     + "or t3.nombre like '%"+datodebusqueda+"%'";
        return ej.consulta(query);
    }
    
    public void insertCiudad(String nombre,int idprov){
        String query = "INSERT INTO ciudad(nombre,idprovincia) VALUES ('"+nombre+"',"+idprov+")";
        ej.peticion(query);
    } 
    
    public void modificarCiudad(int id,String nombre,int idprov){
        String query = "UPDATE ciudad SET nombre = '"+nombre+"' , idprovincia = "+idprov+" WHERE id = "+id;
        ej.peticion(query);
    }
    
    public void eliminarCiudad(int id){
        String query = "DELETE FROM ciudad WHERE id = "+id;
        ej.peticion(query);
    }
}
