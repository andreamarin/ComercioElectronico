/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utileriabd;

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
        return null;
    }
    
    Prod[] catalogoProductos(){
        return null;
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
            
            gestor.desconectate();
            System.out.println("Desconectado");
        }else
            System.out.println("No se pudo conectar");

    }
}
