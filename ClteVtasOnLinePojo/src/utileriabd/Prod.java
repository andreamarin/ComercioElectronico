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

public class Prod {
   private double unitPr;
   private String stockCode;
   private String prodDescription;
   
   public Prod(String stockCode, String prodDescription, double unitPr){
       this.stockCode = stockCode;
       this.prodDescription = prodDescription;
       this.unitPr = unitPr;
   }

    public double getUnitPr() {
        return unitPr;
    }

    public String getStockCode() {
        return stockCode;
    }

    public String getProdDescription() {
        return prodDescription;
    }
}
