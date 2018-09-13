/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utileriabd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sdist
 */
public class ClsGestorTienda {
    ClsConexion conexion;
    
    ClsGestorTienda(){
        
    }
    
    boolean conectate(String unUsr, String pwd){
        conexion = new ClsConexion("OnLineSales");
        return conexion.conectate(unUsr, pwd);
    }
    
    boolean desconectate(){
        conexion.cierraCon();
        return true;
    }
    
    boolean conectado(){
        return conexion.conectado();
    }
    
    Clte[] catalogoClientes(){
        ResultSet rs = conexion.obtenRS("Customers");
        
        String custID;
        String ctry;
        
        ArrayList<Clte> cltes = new ArrayList<>();
        
        try{
            while(rs.next()){
                custID = rs.getString("CustomerID");
                ctry = rs.getString("Country");
                
                cltes.add(new Clte(custID, ctry));
            }
        }catch(SQLException e){
            System.out.println("Error en la conexión");
        }
        
        return (Clte[])cltes.toArray();
    }
    
    Prod[] catalogoProductos(){
        ResultSet rs = conexion.obtenRS("Products");
        
        String stock;
        String prdDesc;
        double unit;
        
        ArrayList<Prod> prods = new ArrayList<>();
        
        try{
            while(rs.next()){
                stock = rs.getString("StockCode");
                prdDesc = rs.getString("ProdDescription");
                unit = rs.getDouble("UnitPr");
                
                prods.add(new Prod(stock, prdDesc, unit));
            }
        }catch(SQLException e){
            System.out.println("Error en la conexión");
        }
        
        return (Prod[])prods.toArray();
    }
    
    
    
    public static void main(String[] args) {
        Clte clientes[] = null;
        Prod productos[] = null;
        
        ClsGestorTienda gestor = new ClsGestorTienda();
        
        gestor.conectate("rafa", "rafa");
        
        if(gestor.conectado()){
            System.out.println("Conectado...");
            
            // aqui va la funcionalidad de prueba
            
            // solicitar el catalogo de clientes
            clientes = gestor.catalogoClientes();

            // solicitar el catalogo de productos
            productos = gestor.catalogoProductos();

            for(Clte c:clientes)
                System.out.println(c.getCustomerID()+" "+c.getCountry());
            
            // solicitar el catalogo de productos
            productos = gestor.catalogoProductos();
            for(Prod p:productos)
                System.out.println(p.getStockCode());
            
            gestor.desconectate();
            System.out.println("Desconectado");
        }else
            System.out.println("No se pudo conectar");

    }
}
