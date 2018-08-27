/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapp;

import java.sql.ResultSet;
import java.sql.SQLException;
import javaapp.Model.Harcama;
import javaapp.Model.Person;
import javaapp.Model.Maas;
import javaapp.Model.Mutakabat;
import javaapp.Model.Odeme;

/**
 *
 * @author alihaydar
 */
public class DBData {

    //özel bir örnek kullancı şifre varsa dogrudur demek için
    public static boolean getLogin(String user,String psw) throws SQLException
    {
        String query="select * from kullanici where isim='"+user+"' and sifre='"+psw+"'";
        
        //dbhelper'a git benim bu sql querymi çalıştır.
        ResultSet rs = DBHelper.ExecuteScalar(query);
        return rs.next();
             
    }
   public static boolean insertPerson(Person person) {
       try {
           
       String query="insert into personel_kayit(personelisim,personelsoyad,personeltc,adres,telno,iban,giristarihi,cikistarihi)"
               +"values('"+person.getPersonelisim() +"','"+person.getPersonelsoyad()
               + "','"+person.getPersoneltc()+"','"+person.getAdres()+"','"+person.getTelno()
               +"','"+person.getIban()+"','"+person.getGiristarihi()+"','"+person.getCikistarihi()+"')";
  
       return  DBHelper.ExecuteNonQuery(query);
       } 
       catch (SQLException e) {
           System.out.println(e.getMessage());
           return false;
       }
   }
   public static boolean insertMaas(Maas maas) {
       try {
           
       String query1="insert into maas(maastarihi,maasmiktari,maasaciklama,personeltc)"
               +"values('"+maas.getMaastarih()+"','"+maas.getMaasmiktar()
               + "','"+maas.getMaasaciklama()+"','"+maas.getPersoneltc()+"')";
  
       return  DBHelper.ExecuteNonQuery(query1);
       } 
       catch (SQLException e) {
           System.out.println(e.getMessage());
           return false;
       }
   }
   
   public static boolean insertOdeme(Odeme odeme) {
       try {
           
       String query2="insert into odeme(odemetarihi,odememiktari,odemeaciklama)"
               +"values('"+odeme.getOdemetarihi()+"','"+odeme.getOdememiktari()
               + "','"+odeme.getOdemeaciklama()+"')";
  
       return  DBHelper.ExecuteNonQuery(query2);
       } 
       catch (SQLException e) {
           System.out.println(e.getMessage());
           return false;
       }
   }
   public static boolean insertHarcama(Harcama harcama) {
       try {
           
       String query4="insert into harcama(harcamatarihi,harcamamiktari,urun,harcamaaciklama)"
               +"values('"+harcama.getHarcamatarihi()+"','"+harcama.getHarcamamiktari()
               + "','"+harcama.getUrun()+"','"+harcama.getHarcamaaciklama()+"')";
  
       return  DBHelper.ExecuteNonQuery(query4);
       } 
       catch (SQLException e) {
           System.out.println(e.getMessage());
           return false;
       }
   }
   
   public static boolean insertMutakabat(Mutakabat mutakabat) {
       try {
           
       String query5="insert into mutakabat(mutakabattarihi,mutakabatbilgi,mutakabataciklama)"
               +"values('"+mutakabat.getMutakabattarih()
               + "','"+mutakabat.getMutakabatbilgi()
               +"','"+mutakabat.getMutakabataciklama()+"')";
  
       return  DBHelper.ExecuteNonQuery(query5);
       } 
       catch (SQLException e) {
           System.out.println(e.getMessage());
           return false;
       }
   }
   
   public static boolean updatePerson(Person person){
       try {
           String query="update personel_kayit "
                   + "set "
                   + "personeltc='"+person.getPersoneltc()
                   +"',personelisim='"+person.getPersonelisim()
                   +"',personelsoyad='"+person.getPersonelsoyad()
                   +"',adres='"+person.getAdres()
                   +"',telno='"+person.getTelno()
                   +"',iban='"+person.getIban()
                   +"',giristarihi='"+person.getGiristarihi()
                   +"',cikistarihi='"+person.getCikistarihi()
                   +"'where pid="+person.getPid()+"";
           return  DBHelper.ExecuteNonQuery(query);
       } catch (SQLException e) {
           System.out.println(e.getMessage());
           return false;
       }
   }
   public static boolean updateMaas(Maas maas){
       try {
           String query1="update maas "
                   + "set "
                   + "maastarihi='"+maas.getMaastarih()
                   +"',maasmiktari='"+maas.getMaasmiktar()
                   +"',maasaciklama='"+maas.getMaasaciklama() 
                   
                   +"'where pidmaas="+maas.getPidmaas()+"";
           return  DBHelper.ExecuteNonQuery(query1);
       } catch (SQLException e) {
           System.out.println(e.getMessage());
           return false;
       }
   }
   
   public static boolean updateOdeme(Odeme odeme){
       try {
           String query2="update odeme "
                   + "set "
                   + "odemetarihi='"+odeme.getOdemetarihi()
                   +"',odememiktari='"+odeme.getOdememiktari()
                   +"',odemeaciklama='"+odeme.getOdemeaciklama()
                   +"'where pidodeme="+odeme.getPidodeme()+"";
           return  DBHelper.ExecuteNonQuery(query2);
       } catch (SQLException e) {
           System.out.println(e.getMessage());
           return false;
       }
   }
   
   public static boolean updateHarcama(Harcama harcama){
       try {
           String query4="update harcama "
                   + "set "
                   + "harcamatarihi='"+harcama.getHarcamatarihi()
                   +"',harcamamiktari='"+harcama.getHarcamamiktari()
                   +"',urun='"+harcama.getUrun()
                   +"',harcamaaciklama='"+harcama.getHarcamaaciklama()
                   +"'where pidharcama="+harcama.getPidharcama()+"";
           return  DBHelper.ExecuteNonQuery(query4);
       } catch (SQLException e) {
           System.out.println(e.getMessage());
           return false;
       }
   }
   
   public static boolean updateMutakabat(Mutakabat mutakabat){
       try {
           String query5="update mutakabat "
                   + "set "
                   + "mutakabattarihi='"+mutakabat.getMutakabattarih()
                   +"',mutakabatbilgi='"+mutakabat.getMutakabatbilgi()
                   +"',mutakabataciklama='"+mutakabat.getMutakabataciklama()  
                   +"'where pidmutakabat="+mutakabat.getPidmutakabat()+"";
           return  DBHelper.ExecuteNonQuery(query5);
       } catch (SQLException e) {
           System.out.println(e.getMessage());
           return false;
       }
   }
   
   public static boolean deletePerson(Person person){
       try {
           String query="delete from personel_kayit where pid="+person.getPid()+"";
           return DBHelper.ExecuteNonQuery(query);
       } catch (SQLException e) {
           System.out.println(e.getMessage());
           return false;
       }
 
   }
   public static boolean deleteMaas(Maas maas){
       try {
           String query1="delete from maas where pidmaas="+maas.getPidmaas()+"";
           return DBHelper.ExecuteNonQuery(query1);
       } catch (SQLException e) {
           System.out.println(e.getMessage());
           return false;
       }
 
   }
   
   public static boolean deleteOdeme(Odeme odeme){
       try {
           String query2="delete from odeme where pidodeme="+odeme.getPidodeme()+"";
           return DBHelper.ExecuteNonQuery(query2);
       } catch (SQLException e) {
           System.out.println(e.getMessage());
           return false;
       }
 
   }
   
   public static boolean deleteHarcama(Harcama harcama){
       try {
           String query4="delete from harcama where pidharcama="+harcama.getPidharcama()+"";
           return DBHelper.ExecuteNonQuery(query4);
       } catch (SQLException e) {
           System.out.println(e.getMessage());
           return false;
       }
 
   }
   
   public static boolean deleteMutakabat(Mutakabat mutakabat){
       try {
           String query5="delete from mutakabat where pidmutakabat="+mutakabat.getPidmutakabat()+"";
           return DBHelper.ExecuteNonQuery(query5);
       } catch (SQLException e) {
           System.out.println(e.getMessage());
           return false;
       }
 
   }
   
   public static ResultSet displayPerson(){
       ResultSet rs = null;
       try {
           String query="select pid,personelisim,personelsoyad,personeltc,adres,telno,iban,giristarihi,cikistarihi from personel_kayit";
           rs=DBHelper.ExecuteScalar(query);
       } 
       catch (SQLException e) {
           System.out.println(e.getMessage());
            
       }
       return rs;
   }
   public static ResultSet displayMaas(){
       ResultSet rs = null;
       try {
           String query1="select pidmaas,maastarihi,maasmiktari,maasaciklama,personeltc from maas";
           rs=DBHelper.ExecuteScalar(query1);
       } 
       catch (SQLException e) {
           System.out.println(e.getMessage());
            
       }
       return rs;
   }
   public static ResultSet displayOdeme(){
       ResultSet rs = null;
       try {
           String query2="select pidodeme,odemetarihi,odememiktari,odemeaciklama from odeme";
           rs=DBHelper.ExecuteScalar(query2);
       } 
       catch (SQLException e) {
           System.out.println(e.getMessage());
            
       }
       return rs;
   }
   public static ResultSet displayHarcama(){
       ResultSet rs = null;
       try {
           String query4="select pidharcama,harcamatarihi,harcamamiktari,urun,harcamaaciklama from harcama";
           rs=DBHelper.ExecuteScalar(query4);
       } 
       catch (SQLException e) {
           System.out.println(e.getMessage());
            
       }
       return rs;
   }
   public static ResultSet displayMutakabat(){
       ResultSet rs = null;
       try {
           String query5="select pidmutakabat,mutakabattarihi,mutakabatbilgi,mutakabataciklama from mutakabat";
           rs=DBHelper.ExecuteScalar(query5);
       } 
       catch (SQLException e) {
           System.out.println(e.getMessage());
            
       }
       return rs;
   }
}
