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
public class Clte {
    
    private String customerID = null;
    private String country = null;
    
    public Clte(String customerID, String country){
        this.customerID = customerID;
        this.country = country;
    }
    
    public String getCustomerID(){
        return customerID;
    }
    
    public String getCountry(){
        return country;
    }
}
