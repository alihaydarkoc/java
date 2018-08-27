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
public class Mutakabat {
    private Integer pidmutakabat;
    private String mutakabattarih;
    private String mutakabatbilgi;
    private String mutakabataciklama;
    
    
   
    
    
    
    public Mutakabat(){
    
    }

    public Mutakabat(int pidmutakabat, String mutakabattarihi,String mutakabatbilgi, String mutakabataciklama ) {
        this.pidmutakabat=pidmutakabat;
        this.mutakabattarih=mutakabattarihi;
        this.mutakabatbilgi=mutakabatbilgi;
        this.mutakabataciklama=mutakabataciklama;
        
        
    }

    /**
     * @return the pidmutakabat
     */
    public Integer getPidmutakabat() {
        return pidmutakabat;
    }

    /**
     * @param pidmutakabat the pidmutakabat to set
     */
    public void setPidmutakabat(Integer pidmutakabat) {
        this.pidmutakabat = pidmutakabat;
    }

    /**
     * @return the mutakabattarih
     */
    public String getMutakabattarih() {
        return mutakabattarih;
    }

    /**
     * @param mutakabattarih the mutakabattarih to set
     */
    public void setMutakabattarih(String mutakabattarih) {
        this.mutakabattarih = mutakabattarih;
    }

    /**
     * @return the mutakabataciklama
     */
    public String getMutakabataciklama() {
        return mutakabataciklama;
    }

    /**
     * @param mutakabataciklama the mutakabataciklama to set
     */
    public void setMutakabataciklama(String mutakabataciklama) {
        this.mutakabataciklama = mutakabataciklama;
    }

    /**
     * @return the mutakabatbilgi
     */
    public String getMutakabatbilgi() {
        return mutakabatbilgi;
    }

    /**
     * @param mutakabatbilgi the mutakabatbilgi to set
     */
    public void setMutakabatbilgi(String mutakabatbilgi) {
        this.mutakabatbilgi = mutakabatbilgi;
    }

   

    
    
}