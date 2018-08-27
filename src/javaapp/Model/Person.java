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
public class Person {

    private Integer pid;
    private String personeltc;
    private String personelisim;
    private String personelsoyad;
    private String adres;
    private String telno;
    private String iban;
    private String giristarihi;
    private String cikistarihi;
    
    public Person(){
    
    }
   
        public Person(int pid,String personeltc,String personelisim,String personelsoyad,
                String adres,String telno,String iban,String giristarihi,String cikistarihi)
        {
        
        this.pid=pid;
        this.personeltc=personeltc;
        this.personelisim=personelisim;
        this.personelsoyad=personelsoyad;
        this.adres=adres;
        this.telno=telno;
        this.iban=iban;
        this.giristarihi=giristarihi;
        this.cikistarihi=cikistarihi;
    }
     /**
     * @return the pid
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(Integer pid) {
        this.pid = pid;
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

    /**
     * @return the personelisim
     */
    public String getPersonelisim() {
        return personelisim;
    }

    /**
     * @param personelisim the personelisim to set
     */
    public void setPersonelisim(String personelisim) {
        this.personelisim = personelisim;
    }

    /**
     * @return the personelsoyad
     */
    public String getPersonelsoyad() {
        return personelsoyad;
    }

    /**
     * @param personelsoyad the personelsoyad to set
     */
    public void setPersonelsoyad(String personelsoyad) {
        this.personelsoyad = personelsoyad;
    }

    /**
     * @return the adres
     */
    public String getAdres() {
        return adres;
    }

    /**
     * @param adres the adres to set
     */
    public void setAdres(String adres) {
        this.adres = adres;
    }

    /**
     * @return the telno
     */
    public String getTelno() {
        return telno;
    }

    /**
     * @param telno the telno to set
     */
    public void setTelno(String telno) {
        this.telno = telno;
    }

    /**
     * @return the iban
     */
    public String getIban() {
        return iban;
    }

    /**
     * @param iban the iban to set
     */
    public void setIban(String iban) {
        this.iban = iban;
    }

    /**
     * @return the giristarihi
     */
    public String getGiristarihi() {
        return giristarihi;
    }

    /**
     * @param giristarihi the giristarihi to set
     */
    public void setGiristarihi(String giristarihi) {
        this.giristarihi = giristarihi;
    }

    /**
     * @return the cikistarihi
     */
    public String getCikistarihi() {
        return cikistarihi;
    }

    /**
     * @param cikistarihi the cikistarihi to set
     */
    public void setCikistarihi(String cikistarihi) {
        this.cikistarihi = cikistarihi;
    }
    
}
