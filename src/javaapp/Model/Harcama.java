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
public class Harcama {
    private Integer pidharcama;
    private String harcamatarihi;
    private String harcamamiktari;
    private String urun;
    private String harcamaaciklama;
    
    public Harcama(){
    
    }
    public Harcama(int pidharcama, String harcamatarihi, String harcamamiktari, String urun, String harcamaaciklama)
    {
        this.pidharcama=pidharcama;
        this.harcamatarihi=harcamatarihi;
        this.harcamamiktari=harcamamiktari;
        this.urun=urun;
        this.harcamaaciklama=harcamaaciklama;
    }

    /**
     * @return the pidharcama
     */
    public Integer getPidharcama() {
        return pidharcama;
    }

    /**
     * @param pidharcama the pidharcama to set
     */
    public void setPidharcama(Integer pidharcama) {
        this.pidharcama = pidharcama;
    }

    /**
     * @return the harcamatarihi
     */
    public String getHarcamatarihi() {
        return harcamatarihi;
    }

    /**
     * @param harcamatarihi the harcamatarihi to set
     */
    public void setHarcamatarihi(String harcamatarihi) {
        this.harcamatarihi = harcamatarihi;
    }

    /**
     * @return the harcamamiktari
     */
    public String getHarcamamiktari() {
        return harcamamiktari;
    }

    /**
     * @param harcamamiktari the harcamamiktari to set
     */
    public void setHarcamamiktari(String harcamamiktari) {
        this.harcamamiktari = harcamamiktari;
    }

    /**
     * @return the urun
     */
    public String getUrun() {
        return urun;
    }

    /**
     * @param urun the urun to set
     */
    public void setUrun(String urun) {
        this.urun = urun;
    }

    /**
     * @return the harcamaaciklama
     */
    public String getHarcamaaciklama() {
        return harcamaaciklama;
    }

    /**
     * @param harcamaaciklama the harcamaaciklama to set
     */
    public void setHarcamaaciklama(String harcamaaciklama) {
        this.harcamaaciklama = harcamaaciklama;
    }
    
}
