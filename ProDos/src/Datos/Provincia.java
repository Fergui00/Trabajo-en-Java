/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.ResultSet;

/**
 *
 * @author fernando guiñazú
 */
public class Provincia {
    
    
    private int id;
    private int idpais;
    private String nombre;
    private Ejecutar ej;
    
    public Provincia(){}
    
    public Provincia(int idprovincia,String nombre){
        this.id = idprovincia;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdpais() {
        return idpais;
    }

    public void setIdpais(int idpais) {
        this.idpais = idpais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ejecutar getEj() {
        return ej;
    }

    public void setEj(Ejecutar ej) {
        this.ej = ej;
    }
    
    public String toString(){
        return this.nombre;
    }
    
    public ResultSet listar(int idpais){
        String query = "SELECT id,nombre FROM provincia WHERE id_pais = "+idpais;
        ej = new Ejecutar();
        return ej.consulta(query);
    }
    
    public ResultSet buscar(String dato){
        String query = "SELECT t1.id AS idpais,t2.id AS idprov,t2.nombre AS Provincias,t1.nombre AS Paises "
                     + "FROM pais t1 INNER JOIN provincia t2 ON t1.id = t2.id_pais"
                     + " WHERE t1.nombre like '%"+dato+"%' or t2.nombre like '%"+dato+"%'";
        ej = new Ejecutar();
        return ej.consulta(query);
        
    }
    
    public void insertProvincia(String nombre,int idpais){
        String query = "INSERT INTO provincia (nombre,id_pais) VALUES ('"+nombre+"',"+idpais+")";
        ej = new Ejecutar();
        ej.peticion(query);
    }
    
    public void modifcarProvincia(String nombre,int idprov,int idpais){
        String query = "UPDATE provincia SET nombre = '"+nombre+"' , id_pais = "+idpais+" WHERE id = "+idprov;
        ej = new Ejecutar();
        ej.peticion(query);
    }
    
    public void eliminarProvincia(int idprov){
        String query = "DELETE FROM provincia WHERE id = "+idprov;
        ej = new Ejecutar();
        ej.peticion(query);
    }
}
