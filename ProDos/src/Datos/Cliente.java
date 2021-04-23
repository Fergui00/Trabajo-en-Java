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

public class Cliente {
    
    
    private String nombre;
    private int edad;
    private String numdoc;
    private int idprovincia;
    private Ejecutar ej = new Ejecutar();
    
    public Cliente(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNumdoc() {
        return numdoc;
    }

    public void setNumdoc(String numdoc) {
        this.numdoc = numdoc;
    }

    public int getIdprovincia() {
        return idprovincia;
    }

    public void setIdprovincia(int idprovincia) {
        this.idprovincia = idprovincia;
    }

    public Ejecutar getEj() {
        return ej;
    }

    public void setEj(Ejecutar ej) {
        this.ej = ej;
    }
    
    public ResultSet buscar(String dato){
        String query = "SELECT t1.id,t2.id AS idciudad,t3.id AS idprovincia,t4.id as idpais,"
                     + "t1.nombre AS Cliente, t1.edad AS edad,t1.numdoc AS Documento,"
                     + "t2.nombre AS ciudad , "
                     + "t3.nombre AS Provincia, "
                     + "t4.nombre AS Pais FROM cliente t1 "
                     + "INNER JOIN ciudad t2 ON t1.idciudad = t2.id "
                     + "INNER JOIN provincia t3 ON t2.idprovincia = t3.id "
                     + "INNER JOIN pais t4 ON t3.id_pais = t4.id "
                     + "WHERE t1.nombre like '%"+dato+"%' or t1.edad like '%"+dato+"%' "
                     + "or t1.numdoc like '%"+dato+"%' or t2.nombre like '%"+dato+"%' "
                     + "or t3.nombre like '%"+dato+"%' or t4.nombre like '"+dato+"%'";
        return ej.consulta(query);
    }
    
    public void insertar(String nombre,int edad,String numdoc,int idciu){
        String query = "INSERT INTO cliente (nombre,edad,numdoc,idciudad)"
                     + "VALUES ('"+nombre+"',"+edad+",'"+numdoc+"',"+idciu+")";
        ej.peticion(query);
    }
    
    public void eliminar(int idcliente){
        String query = "DELETE FROM cliente WHERE id = "+idcliente;
        ej.peticion(query);
    }
    
    public void modificar(int idcliente,String nombre,int edad,String numdoc,int idciu){
        String query = "UPDATE cliente "
                     + "SET nombre = '"+nombre+"' , edad = "+edad+" , "
                     + "numdoc = '"+numdoc+"' , idciudad = "+idciu+" WHERE id = "+idcliente;
        ej.peticion(query);
    }

}
