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
public class Maas {
    private Integer pidmaas;
    private String  personeltc;
    private String maastarih;
    private String maasaciklama;
    private String maasmiktar;
   
    
    
    
    public Maas(){
    
    }

    public Maas(int pidmaas, String maastarih, String maasmiktar, String maasaciklama, String personeltc) {
        this.pidmaas=pidmaas;
        this.maastarih=maastarih;
        this.maasaciklama=maasaciklama;
        this.maasmiktar=maasmiktar;
        this.personeltc=personeltc;
        
    }

    /**
     * @return the pidmaas
     */
    public Integer getPidmaas() {
        return pidmaas;
    }

    /**
     * @param pidmaas the pidmaas to set
     */
    public void setPidmaas(Integer pidmaas) {
        this.pidmaas = pidmaas;
    }

    /**
     * @return the maastarih
     */
    public String getMaastarih() {
        return maastarih;
    }

    /**
     * @param maastarih the maastarih to set
     */
    public void setMaastarih(String maastarih) {
        this.maastarih = maastarih;
    }

    /**
     * @return the maasaciklama
     */
    public String getMaasaciklama() {
        return maasaciklama;
    }

    /**
     * @param maasaciklama the maasaciklama to set
     */
    public void setMaasaciklama(String maasaciklama) {
        this.maasaciklama = maasaciklama;
    }

    /**
     * @return the maasmiktar
     */
    public String getMaasmiktar() {
        return maasmiktar;
    }

    /**
     * @param maasmiktar the maasmiktar to set
     */
    public void setMaasmiktar(String maasmiktar) {
        this.maasmiktar = maasmiktar;
    }

    /**
     * @return the personeltc
     */
    public String getPersoneltc() {
        return personeltc;
    }

    /**
     * @param personeltc the personeltc to set
     */
    public void setPersoneltc(String personeltc) {
        this.personeltc = personeltc;
    }

    
    
}
