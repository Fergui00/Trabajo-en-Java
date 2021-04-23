/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import javax.swing.DefaultComboBoxModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Pais {
    
    private int id;
    private String nombre;
    private Ejecutar ej;
    
    public Pais(){}
    
    public Pais(int id,String nombre){
        this.id = id;
        this.nombre = nombre;
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
    
    public String toString(){
        return this.nombre;
    }
    
    public ResultSet listar(){
        String query = "SELECT * FROM pais";
        ej = new Ejecutar();
        return ej.consulta(query);
    }
    
    public ResultSet buscar(String dato){
        String query = "SELECT * FROM pais WHERE nombre like '%"+dato+"%'";
        ej = new Ejecutar();
        return ej.consulta(query);
    }
    
    public void insertarPais(String nombre){
        String query = "INSERT INTO pais(nombre) values ('"+nombre+"')";
        ej = new Ejecutar();
        ej.peticion(query);
    }
    
    public void modificarPais(int idpais,String nombre){
        String query = "UPDATE pais SET nombre = '"+nombre+"' WHERE id = "+idpais;
        ej = new Ejecutar();
        ej.peticion(query);
    }
    
    public void eliminarPais(int idpais){
        String query = "DELETE FROM pais WHERE id ="+idpais;
        ej = new Ejecutar();
        ej.peticion(query);
    }
}
