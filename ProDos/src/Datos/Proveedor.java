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


public class Proveedor {
    
    private int id;
    private String nombre;
    private String razonsoc;
    private String cuit;
    private String mail;
    private String telefono;
    private int idprovin;
    private Ejecutar ej;
    
    public Proveedor(){}

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

    public String getRazonsoc() {
        return razonsoc;
    }

    public void setRazonsoc(String razonsoc) {
        this.razonsoc = razonsoc;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdprovin() {
        return idprovin;
    }

    public void setIdprovin(int idprovin) {
        this.idprovin = idprovin;
    }

    public Ejecutar getEj() {
        return ej;
    }

    public void setEj(Ejecutar ej) {
        this.ej = ej;
    }
    
    public ResultSet buscar(String dato){
        String query = "SELECT t1.id as idproveedor,t2.id as idprovincia,t3.id as idpais,"
                     + "t1.nombre AS NomProv,t1.razonsoc AS RazonSocial,"
                     + "t1.cuit AS CUIT,t1.mail,t1.telefono,t2.nombre AS Provincia,t3.nombre AS Pais "
                     + "FROM proveedor t1 INNER JOIN provincia t2 "
                     + "ON t1.id_provincia = t2.id INNER JOIN Pais t3 ON t2.id_pais = t3.id "
                     + "WHERE t1.razonsoc like '%"+dato+"%' or t1.nombre like '%"+dato+"%' "
                     + "or t1.cuit like '%"+dato+"%' or t1.telefono like '%"+dato+"%' "
                     + "or mail like '%"+dato+"%' or t2.nombre like '%"+dato+"%'";
        ej = new Ejecutar();
        return ej.consulta(query);
    }
    
    public void insertar(String nombre,String razon,String cuit,String telefono,String mail,int idprov){
        String query = "INSERT INTO proveedor (nombre,razonsoc,mail,cuit,telefono,id_provincia) VALUES "
                       +" ('"+nombre+"','"+razon+"','"+mail+"','"+cuit+"','"+telefono+"',"+idprov+")";
        ej = new Ejecutar();
        ej.peticion(query);
    }
    
    public void modificar(String nombre,String razon,String cuit,String telefono,String mail,int idprov,int idproveedor){
        String query = "UPDATE proveedor SET nombre = '"+nombre+"' , razonsoc = '"+razon+"' , cuit = '"+cuit+"',"
                       +" telefono = '"+telefono+"' , mail = '"+mail+"' ,"
                       +" id_provincia = "+idprov+" WHERE id = "+idproveedor;
        ej = new Ejecutar();
        ej.peticion(query);
    }
    
    public void eliminar(int idproveedor){
        String query = "DELETE FROM proveedor WHERE id = "+idproveedor;
        ej = new Ejecutar();
        ej.peticion(query);
    }
    
  
}
