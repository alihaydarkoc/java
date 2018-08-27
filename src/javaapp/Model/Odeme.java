/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapp.Model;

/**
 *
 * @author alihaydar
 */
public class Odeme {
    private Integer pidodeme;
    private String odemetarihi;
    private String odememiktari;
    private String odemeaciklama;
    
    
     public Odeme(){

    }
    public Odeme(int pidodeme,String odemetarihi,String odememiktari, String odemeaciklama){
        this.pidodeme=pidodeme;
        this.odemetarihi=odemetarihi;
        this.odememiktari=odememiktari;
        this.odemeaciklama=odemeaciklama;
    }

    /**
     * @return the pidodeme
     */
    public Integer getPidodeme() {
        return pidodeme;
    }

    /**
     * @param pidodeme the pidodeme to set
     */
    public void setPidodeme(Integer pidodeme) {
        this.pidodeme = pidodeme;
    }

    /**
     * @return the odemetarihi
     */
    public String getOdemetarihi() {
        return odemetarihi;
    }

    /**
     * @param odemetarihi the odemetarihi to set
     */
    public void setOdemetarihi(String odemetarihi) {
        this.odemetarihi = odemetarihi;
    }

    /**
     * @return the odememiktari
     */
    public String getOdememiktari() {
        return odememiktari;
    }

    /**
     * @param odememiktari the odememiktari to set
     */
    public void setOdememiktari(String odememiktari) {
        this.odememiktari = odememiktari;
    }

    /**
     * @return the odemeaciklama
     */
    public String getOdemeaciklama() {
        return odemeaciklama;
    }

    /**
     * @param odemeaciklama the odemeaciklama to set
     */
    public void setOdemeaciklama(String odemeaciklama) {
        this.odemeaciklama = odemeaciklama;
    }

    
}
   