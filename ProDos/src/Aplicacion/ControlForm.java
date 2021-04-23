package Aplicacion;

/**
 *
 * @author fernando guiñazú
 */

import Datos.Ciudad;
import Datos.Pais;
import Datos.Provincia;
import Datos.Cliente;
import Datos.Proveedor;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControlForm {
    
    public DefaultComboBoxModel cargarComboPais(){
        
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Pais pais = new Pais();
        ResultSet res = pais.listar();
        
        try{
            while(res.next()){
                model.addElement(new Pais(res.getInt("id"),res.getString("nombre")));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null," Fallo la cargar del comboBox de paises");
        }
        
        return model;
    }
    
    public DefaultComboBoxModel cargarComboProvincia(int idpais){
        
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Provincia prov = new Provincia();
        ResultSet res =  prov.listar(idpais);
        
        try{
            while(res.next()){
                model.addElement(new Provincia(res.getInt("id"),res.getString("nombre")));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Fallo la cargar del combo de Provincias");
        }
        
        return model;
    }
    
    public DefaultComboBoxModel cargarComboCiudad(int idprov){
        
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Ciudad ciud = new Ciudad();
        ResultSet res = ciud.listar(idprov);
        
        try{
            while(res.next()){
                model.addElement(new Ciudad(res.getInt("id"),res.getString("nombre")));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Fallo la carga del combo de ciudades");
        }
        
        return model;
    }
    
    public DefaultTableModel cargarTabla(String dato,Object ob){
        
        DefaultTableModel modelo = new DefaultTableModel();
        ResultSet res = null;
        
        if(ob instanceof Pais){
            Pais pais = (Pais) ob;
            res = pais.buscar(dato);
        }else if(ob instanceof Provincia){
            Provincia prov = (Provincia) ob;
            res = prov.buscar(dato);
        }else if(ob instanceof Cliente){
            Cliente cli = (Cliente) ob;
            res = cli.buscar(dato);
        }else if(ob instanceof Proveedor){
            Proveedor prov = (Proveedor) ob;
            res = prov.buscar(dato);
        }else if(ob instanceof Ciudad){
            Ciudad ciu = (Ciudad) ob;
            res = ciu.buscar(dato);
        }
        
          
        try{
              
              ResultSetMetaData rsmd = res.getMetaData();
              
              int cantcols = rsmd.getColumnCount();
              
              for(int i = 1;i<=cantcols;i++){
                  modelo.addColumn(rsmd.getColumnLabel(i));
                  System.out.println(i);
              }
              
              while(res.next()){
                  Object fila[] = new Object[cantcols];
                  for(int i = 0;i<cantcols;i++){
                      fila[i] = res.getObject(i+1);
                  }
                  modelo.addRow(fila);
              }
              res.close();
          }catch(Exception ex){
              JOptionPane.showMessageDialog(null,"Fallo la carga de la tabla");
          }
          return modelo;
    }
    
    public void ocultarColumnas(int cant,JTable tabla){
         for(int i = 0;i<cant;i++){
              tabla.getColumnModel().getColumn(i).setMaxWidth(0);
              tabla.getColumnModel().getColumn(i).setMinWidth(0);
              tabla.getColumnModel().getColumn(i).setPreferredWidth(0);       
        }
    }
    
}
