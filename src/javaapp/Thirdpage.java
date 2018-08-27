/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapp;

import Util.Formatter;
import Util.ViewTools;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;

import java.util.ArrayList;
import javaapp.Model.Harcama;

import javaapp.Model.Person;
import javaapp.Model.Maas;
import javaapp.Model.Mutakabat;
import javaapp.Model.Odeme;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author alihaydar
 */
public class Thirdpage extends javax.swing.JFrame {

    
    int pid;
    int pidmaas;
    int pidodeme;
    int pidharcama;
    int pidmutakabat;
    
    /**
     * Creates new form SecondPage
     */
    public Thirdpage() {
        initComponents();
        showPerson();
        showMaas();
        showOdeme();
        showHarcama();
        showMutakabat();
        
       // myTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
    }
    public ArrayList<Person> personList(){
         ArrayList<Person> personList=new ArrayList<>();

        try {
        ResultSet mydata=DBData.displayPerson();
         
        while (mydata.next())
         {   
              personList.add(new Person(mydata.getInt("pid"),mydata.getString("Personelisim"),
                                 mydata.getString("Personelsoyad"),mydata.getString("Personeltc"),
                                 mydata.getString("Adres"),mydata.getString("Telno"),mydata.getString("Iban"),
                                 mydata.getString("Giristarihi"),mydata.getString("Cikistarihi")));
         }
            
        } catch (Exception e) 
        {
        }
        return personList;  
    }
    public ArrayList<Maas> maasList(){
         ArrayList<Maas> maasList=new ArrayList<>();

        try {
        ResultSet mydata=DBData.displayMaas();
         
        while (mydata.next())
         {   
              maasList.add(new Maas(mydata.getInt("pidmaas"),
                      mydata.getString("maastarihi"),
                      mydata.getString("maasmiktari"),
                      mydata.getString("maasaciklama"),
                      mydata.getString("personeltc")));
         }
            
        } catch (Exception e) 
        {
        }
        return maasList;  
    }
    public ArrayList<Odeme> odemeList(){
         ArrayList<Odeme> odemeList=new ArrayList<>();

        try {
        ResultSet mydata=DBData.displayOdeme();
         
        while (mydata.next())
         {   
              odemeList.add(new Odeme(mydata.getInt("pidodeme"),
                      mydata.getString("odemetarihi"),
                      mydata.getString("odememiktari"),
                      mydata.getString("odemeaciklama")));
         }
            
        } catch (Exception e) 
        {
        }
        return odemeList;  
    }
    public ArrayList<Harcama> harcamaList(){
         ArrayList<Harcama> harcamaList=new ArrayList<>();

        try {
        ResultSet mydata=DBData.displayHarcama();
         
        while (mydata.next())
         {   
              harcamaList.add(new Harcama(mydata.getInt("pidharcama"),mydata.getString("harcamatarihi"),
                                 mydata.getString("harcamamiktari"),mydata.getString("urun"),
                                 mydata.getString("harcamaaciklama")));
         }
            
        } catch (Exception e) 
        {
        }
        return harcamaList;  
    }
    public ArrayList<Mutakabat> mutakabatList(){
         ArrayList<Mutakabat> mutakabatList=new ArrayList<>();

        try {
        ResultSet mydata=DBData.displayMutakabat();
         
        while (mydata.next())
         {   
              mutakabatList.add(new Mutakabat(mydata.getInt("pidmutakabat"),mydata.getString("mutakabattarihi"),
                                 mydata.getString("mutakabatbilgi"),mydata.getString("mutakabataciklama")));
         }
            
        } catch (Exception e) 
        {
        }
        return mutakabatList;  
    }
    public void showMaas(){
        ArrayList<Maas> list=maasList();
        
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        model.setRowCount(0);
        
        Object[] row=new Object[5];
        for(int i=0;i<list.size();i++){
            
            row[0]=list.get(i).getPidmaas().toString(); 
            row[1]=list.get(i).getMaastarih();
            row[2]=list.get(i).getMaasmiktar();
            row[3]=list.get(i).getMaasaciklama();
            row[4]=list.get(i).getPersoneltc();
           
            model.addRow(row);
        }
        ViewTools.hideColumn(jTable1, "pidmaas");
        //myTable.removeColumn(myTable.getColumnModel().getColumn(0));
    }
    public void showHarcama(){
        ArrayList<Harcama> list=harcamaList();
        
        DefaultTableModel model=(DefaultTableModel)jTable3.getModel();
        model.setRowCount(0);
        
        Object[] row=new Object[5];
        for(int i=0;i<list.size();i++){
            
            row[0]=list.get(i).getPidharcama().toString(); 
            row[1]=list.get(i).getHarcamatarihi();
            row[2]=list.get(i).getHarcamamiktari();
            row[3]=list.get(i).getUrun(); 
            row[4]=list.get(i).getHarcamaaciklama();
           
            model.addRow(row);
        }
        ViewTools.hideColumn(jTable3, "pidharcama");
        //myTable.removeColumn(myTable.getColumnModel().getColumn(0));
    }
    public void showMutakabat(){
        ArrayList<Mutakabat> list=mutakabatList();
        
        DefaultTableModel model=(DefaultTableModel)jTable4.getModel();
        model.setRowCount(0);
        
        Object[] row=new Object[4];
        for(int i=0;i<list.size();i++){
            
            row[0]=list.get(i).getPidmutakabat().toString(); 
            row[1]=list.get(i).getMutakabattarih();
            row[2]=list.get(i).getMutakabatbilgi();
            row[3]=list.get(i).getMutakabataciklama();
                    
           
            model.addRow(row);
        }
        ViewTools.hideColumn(jTable4, "pidmutakabat");
        //myTable.removeColumn(myTable.getColumnModel().getColumn(0));
    }
    public void Clear()
    {
        txtad.setText("");
        txtsoyad.setText(""); 
        txttc.setText("");
        txtadres.setText("");
        txtadres.setText("");
        txttelno.setText("");
        txtiban.setText("");
        datGiristarihi.setDate(null);
        datCikistarihi.setDate(null);
      
    }
    public void Clear2()
    {
        txtmaasaciklama.setText("");
        txtmaasmiktari.setText("");
        txtmaaspersoneltc.setText("");
        datmaastarih.setDate(null);
  
    }
     public void Clear3()
    {
        txtodemeaciklama.setText("");
        txtodememiktari.setText("");
        datodemetarih.setDate(null);
  
    }
     public void Clear4()
    {
        txtharcamaaciklama.setText("");
        txtharcamamiktari.setText("");
        txturun.setText("");
        datharcamatarih.setDate(null);
  
    }
     public void Clear5()
    {
        txtmutakabataciklama.setText("");
        txtmutakabat.setText("");
        datmutakabattarih.setDate(null);
  
    }
    public void showPerson(){
        ArrayList<Person> list=personList();
        
        DefaultTableModel model=(DefaultTableModel)myTable.getModel();
        model.setRowCount(0);
        
        Object[] row=new Object[9];
        for(int i=0;i<list.size();i++){
            
            row[0]=list.get(i).getPid().toString(); 
            row[2]=list.get(i).getPersonelisim();
            row[3]=list.get(i).getPersonelsoyad();
            row[1]=list.get(i).getPersoneltc();
            row[4]=list.get(i).getAdres();
            row[5]=list.get(i).getTelno();
            row[6]=list.get(i).getIban();
            row[7]=list.get(i).getGiristarihi();
            row[8]=list.get(i).getCikistarihi();
           
            model.addRow(row);
        }
        ViewTools.hideColumn(myTable, "pid");
        //myTable.removeColumn(myTable.getColumnModel().getColumn(0));
    }
    
    public void showOdeme(){
        ArrayList<Odeme> list=odemeList();
        
        DefaultTableModel model=(DefaultTableModel)jTable2.getModel();
        model.setRowCount(0);
        
        Object[] row=new Object[4];
        for(int i=0;i<list.size();i++){
            
            row[0]=list.get(i).getPidodeme().toString(); 
            row[1]=list.get(i).getOdemetarihi();
            row[2]=list.get(i).getOdememiktari();
            row[3]=list.get(i).getOdemeaciklama();        
           
            model.addRow(row);
        }
        ViewTools.hideColumn(jTable2, "pidodeme");
        //myTable.removeColumn(myTable.getColumnModel().getColumn(0));
    }
    

 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        pnlFiields = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txttc = new javax.swing.JTextField();
        txtad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtsoyad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtadres = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txttelno = new javax.swing.JTextField();
        txtiban = new javax.swing.JTextField();
        datGiristarihi = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        datCikistarihi = new com.toedter.calendar.JDateChooser();
        btnSecim = new javax.swing.JButton();
        btnEkle = new javax.swing.JButton();
        btnGuncelle = new javax.swing.JButton();
        btnSil = new javax.swing.JButton();
        btnTemizle = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        myTable = new javax.swing.JTable();
        pnlButons = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        datmaastarih = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtmaasaciklama = new javax.swing.JTextField();
        jLabelmaas = new javax.swing.JLabel();
        txtmaasmiktari = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtmaaspersoneltc = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pnlButtons2 = new javax.swing.JPanel();
        btnEkle2 = new javax.swing.JButton();
        btnGuncelle2 = new javax.swing.JButton();
        btnSil2 = new javax.swing.JButton();
        btnTemizle2 = new javax.swing.JButton();
        btnSecim2 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        datodemetarih = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtodemeaciklama = new javax.swing.JTextField();
        jlabelodeme1 = new javax.swing.JLabel();
        txtodememiktari = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        pnlButtons3 = new javax.swing.JPanel();
        btnEkle3 = new javax.swing.JButton();
        btnGuncelle3 = new javax.swing.JButton();
        btnSil3 = new javax.swing.JButton();
        btnTemizle3 = new javax.swing.JButton();
        btnSecim3 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        datharcamatarih = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jlabelürün2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtharcamaaciklama = new javax.swing.JTextField();
        txturun = new javax.swing.JTextField();
        jlabelharcama2 = new javax.swing.JLabel();
        txtharcamamiktari = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        pnlButtons4 = new javax.swing.JPanel();
        btnEkle4 = new javax.swing.JButton();
        btnGuncelle4 = new javax.swing.JButton();
        btnSil4 = new javax.swing.JButton();
        btnTemizle4 = new javax.swing.JButton();
        btnSecim4 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        datmutakabattarih = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jlabelmütakabat3 = new javax.swing.JLabel();
        txtmutakabataciklama = new javax.swing.JTextField();
        txtmutakabat = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        pnlButtons5 = new javax.swing.JPanel();
        btnEkle5 = new javax.swing.JButton();
        btnGuncelle5 = new javax.swing.JButton();
        btnSil5 = new javax.swing.JButton();
        btnTemizle5 = new javax.swing.JButton();
        btnSecim5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new java.awt.CardLayout());

        jPanel7.setBackground(new java.awt.Color(255, 153, 51));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Adi");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TC");

        txttc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttcActionPerformed(evt);
            }
        });
        txttc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttcKeyTyped(evt);
            }
        });

        txtad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtadActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Soyadi");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Adres");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Giriş Tarihi");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Telefon");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("İban");

        txttelno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelnoActionPerformed(evt);
            }
        });

        txtiban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtibanActionPerformed(evt);
            }
        });

        datGiristarihi.setDateFormatString("yyyy.MM.dd");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Çıkış Tarihi");

        datCikistarihi.setDateFormatString("yyyy.MM.dd");

        btnSecim.setText("Seçim");
        btnSecim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSecimActionPerformed(evt);
            }
        });

        btnEkle.setText("Kaydet");
        btnEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEkleActionPerformed(evt);
            }
        });

        btnGuncelle.setText("Güncelle");
        btnGuncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuncelleActionPerformed(evt);
            }
        });

        btnSil.setText("Sil");
        btnSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSilActionPerformed(evt);
            }
        });

        btnTemizle.setText("Temizle");
        btnTemizle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTemizleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFiieldsLayout = new javax.swing.GroupLayout(pnlFiields);
        pnlFiields.setLayout(pnlFiieldsLayout);
        pnlFiieldsLayout.setHorizontalGroup(
            pnlFiieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiieldsLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlFiieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlFiieldsLayout.createSequentialGroup()
                        .addGroup(pnlFiieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSecim))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlFiieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFiieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(pnlFiieldsLayout.createSequentialGroup()
                                    .addComponent(txttelno, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(17, 17, 17)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(pnlFiieldsLayout.createSequentialGroup()
                                    .addComponent(txtad, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnlFiieldsLayout.createSequentialGroup()
                                    .addComponent(txttc, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(pnlFiieldsLayout.createSequentialGroup()
                                .addComponent(btnEkle)
                                .addGap(18, 18, 18)
                                .addComponent(btnGuncelle)
                                .addGap(18, 18, 18)
                                .addComponent(btnSil, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnTemizle)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFiieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFiieldsLayout.createSequentialGroup()
                        .addComponent(txtiban, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFiieldsLayout.createSequentialGroup()
                        .addGroup(pnlFiieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtsoyad)
                            .addComponent(txtadres, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                        .addGap(57, 57, 57)
                        .addGroup(pnlFiieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFiieldsLayout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(datCikistarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlFiieldsLayout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(datGiristarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(460, 460, 460))))
        );
        pnlFiieldsLayout.setVerticalGroup(
            pnlFiieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFiieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlFiieldsLayout.createSequentialGroup()
                        .addGroup(pnlFiieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFiieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(txtad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(txtsoyad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10))
                            .addComponent(datGiristarihi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFiieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txttc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtadres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)))
                    .addComponent(datCikistarihi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFiieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(txttelno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtiban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(pnlFiieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSecim)
                    .addComponent(btnEkle)
                    .addComponent(btnGuncelle)
                    .addComponent(btnSil)
                    .addComponent(btnTemizle))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        myTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "pid", "İsim", "Soyad", "Tc", "Adres", "Telno", "İban", "GirisTarihi", "ÇıkışTarihi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        myTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(myTable);

        javax.swing.GroupLayout pnlButonsLayout = new javax.swing.GroupLayout(pnlButons);
        pnlButons.setLayout(pnlButonsLayout);
        pnlButonsLayout.setHorizontalGroup(
            pnlButonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 839, Short.MAX_VALUE)
        );
        pnlButonsLayout.setVerticalGroup(
            pnlButonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(pnlFiields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(131, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(pnlButons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jScrollPane1)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(pnlButons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFiields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 857, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PERSONEL EKLE", jPanel5);

        datmaastarih.setDateFormatString("yyyy.MM.dd");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("İşlem Tarihi");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Açiklama");

        jLabelmaas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelmaas.setText("Maaş");

        jLabel6.setText("Personeltc");

        txtmaaspersoneltc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmaaspersoneltcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(datmaastarih, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabelmaas, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtmaasmiktari, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtmaasaciklama, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(txtmaaspersoneltc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(datmaastarih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelmaas)
                        .addComponent(txtmaasmiktari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(txtmaasaciklama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(txtmaaspersoneltc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 48, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "pidmaas", "maastarihi", "maasmiktari", "maasaciklama", "personeltc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        btnEkle2.setText("Kaydet");
        btnEkle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEkle2ActionPerformed(evt);
            }
        });

        btnGuncelle2.setText("Güncelle");
        btnGuncelle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuncelle2ActionPerformed(evt);
            }
        });

        btnSil2.setText("Sil");
        btnSil2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSil2ActionPerformed(evt);
            }
        });

        btnTemizle2.setText("Temizle");
        btnTemizle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTemizle2ActionPerformed(evt);
            }
        });

        btnSecim2.setText("Seçim");
        btnSecim2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSecim2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtons2Layout = new javax.swing.GroupLayout(pnlButtons2);
        pnlButtons2.setLayout(pnlButtons2Layout);
        pnlButtons2Layout.setHorizontalGroup(
            pnlButtons2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtons2Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(btnEkle2)
                .addGap(44, 44, 44)
                .addComponent(btnGuncelle2)
                .addGap(34, 34, 34)
                .addComponent(btnSil2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnSecim2)
                .addGap(27, 27, 27)
                .addComponent(btnTemizle2)
                .addContainerGap(985, Short.MAX_VALUE))
        );
        pnlButtons2Layout.setVerticalGroup(
            pnlButtons2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlButtons2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlButtons2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEkle2)
                    .addComponent(btnGuncelle2)
                    .addComponent(btnSil2)
                    .addComponent(btnSecim2)
                    .addComponent(btnTemizle2))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1568, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlButtons2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlButtons2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 274, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("MAAŞ İŞLEMLERİ", jPanel6);

        datodemetarih.setDateFormatString("yyyy.MM.dd");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("İşlem Tarihi");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Açiklama");

        jlabelodeme1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelodeme1.setText("Ödeme");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(datodemetarih, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jlabelodeme1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtodememiktari, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtodemeaciklama, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlabelodeme1)
                        .addComponent(txtodememiktari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtodemeaciklama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel7)
                        .addComponent(datodemetarih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 55, Short.MAX_VALUE))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "pidodeme", "Ödeme Tarih", "Ödeme Miktarı", "Açıklama"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        btnEkle3.setText("Kaydet");
        btnEkle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEkle3ActionPerformed(evt);
            }
        });

        btnGuncelle3.setText("Güncelle");
        btnGuncelle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuncelle3ActionPerformed(evt);
            }
        });

        btnSil3.setText("Sil");
        btnSil3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSil3ActionPerformed(evt);
            }
        });

        btnTemizle3.setText("Temizle");
        btnTemizle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTemizle3ActionPerformed(evt);
            }
        });

        btnSecim3.setText("Seçim");
        btnSecim3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSecim3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtons3Layout = new javax.swing.GroupLayout(pnlButtons3);
        pnlButtons3.setLayout(pnlButtons3Layout);
        pnlButtons3Layout.setHorizontalGroup(
            pnlButtons3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtons3Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(btnEkle3)
                .addGap(44, 44, 44)
                .addComponent(btnGuncelle3)
                .addGap(34, 34, 34)
                .addComponent(btnSil3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnSecim3)
                .addGap(27, 27, 27)
                .addComponent(btnTemizle3)
                .addContainerGap(985, Short.MAX_VALUE))
        );
        pnlButtons3Layout.setVerticalGroup(
            pnlButtons3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlButtons3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlButtons3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEkle3)
                    .addComponent(btnGuncelle3)
                    .addComponent(btnSil3)
                    .addComponent(btnSecim3)
                    .addComponent(btnTemizle3))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1568, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlButtons3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlButtons3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 248, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ÖDEME İŞLEMLERİ", jPanel8);

        datharcamatarih.setDateFormatString("yyyy.MM.dd");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("İşlem Tarihi");

        jlabelürün2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelürün2.setText("Ürün");

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Açiklama");

        jlabelharcama2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelharcama2.setText("Harcama");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(datharcamatarih, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlabelharcama2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(txtharcamamiktari, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtharcamaaciklama, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jlabelürün2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txturun, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(datharcamatarih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(txtharcamaaciklama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtharcamamiktari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlabelharcama2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabelürün2)
                    .addComponent(txturun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "pidharcama", "harcamatarihi", "harcamamiktari", "urun", "harcamaaciklama"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable3);

        btnEkle4.setText("Kaydet");
        btnEkle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEkle4ActionPerformed(evt);
            }
        });

        btnGuncelle4.setText("Güncelle");
        btnGuncelle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuncelle4ActionPerformed(evt);
            }
        });

        btnSil4.setText("Sil");
        btnSil4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSil4ActionPerformed(evt);
            }
        });

        btnTemizle4.setText("Temizle");
        btnTemizle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTemizle4ActionPerformed(evt);
            }
        });

        btnSecim4.setText("Seçim");
        btnSecim4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSecim4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtons4Layout = new javax.swing.GroupLayout(pnlButtons4);
        pnlButtons4.setLayout(pnlButtons4Layout);
        pnlButtons4Layout.setHorizontalGroup(
            pnlButtons4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtons4Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(btnEkle4)
                .addGap(44, 44, 44)
                .addComponent(btnGuncelle4)
                .addGap(34, 34, 34)
                .addComponent(btnSil4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnSecim4)
                .addGap(27, 27, 27)
                .addComponent(btnTemizle4)
                .addContainerGap(965, Short.MAX_VALUE))
        );
        pnlButtons4Layout.setVerticalGroup(
            pnlButtons4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlButtons4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlButtons4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEkle4)
                    .addComponent(btnGuncelle4)
                    .addComponent(btnSil4)
                    .addComponent(btnSecim4)
                    .addComponent(btnTemizle4))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1568, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlButtons4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlButtons4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 248, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("HARCAMA İŞLEMLERİ", jPanel11);

        datmutakabattarih.setDateFormatString("yyyy.MM.dd");

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("İşlem Tarihi");

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Açiklama");

        jlabelmütakabat3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelmütakabat3.setText("Mütakabat");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(datmutakabattarih, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jlabelmütakabat3)
                .addGap(35, 35, 35)
                .addComponent(txtmutakabat, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtmutakabataciklama, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(datmutakabattarih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlabelmütakabat3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtmutakabat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20)
                        .addComponent(txtmutakabataciklama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 23, Short.MAX_VALUE))
        );

        jScrollPane5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane5MouseClicked(evt);
            }
        });

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "pidmutakabat", "mutakabattarihi", "mutakabatbilgi", "mutakabataciklama"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable4);

        btnEkle5.setText("Kaydet");
        btnEkle5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEkle5ActionPerformed(evt);
            }
        });

        btnGuncelle5.setText("Güncelle");
        btnGuncelle5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuncelle5ActionPerformed(evt);
            }
        });

        btnSil5.setText("Sil");
        btnSil5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSil5ActionPerformed(evt);
            }
        });

        btnTemizle5.setText("Temizle");
        btnTemizle5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTemizle5ActionPerformed(evt);
            }
        });

        btnSecim5.setText("Seçim");
        btnSecim5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSecim5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtons5Layout = new javax.swing.GroupLayout(pnlButtons5);
        pnlButtons5.setLayout(pnlButtons5Layout);
        pnlButtons5Layout.setHorizontalGroup(
            pnlButtons5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtons5Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(btnEkle5)
                .addGap(44, 44, 44)
                .addComponent(btnGuncelle5)
                .addGap(34, 34, 34)
                .addComponent(btnSil5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnSecim5)
                .addGap(27, 27, 27)
                .addComponent(btnTemizle5)
                .addContainerGap(965, Short.MAX_VALUE))
        );
        pnlButtons5Layout.setVerticalGroup(
            pnlButtons5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlButtons5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlButtons5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEkle5)
                    .addComponent(btnGuncelle5)
                    .addComponent(btnSil5)
                    .addComponent(btnSecim5)
                    .addComponent(btnTemizle5))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1568, Short.MAX_VALUE)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlButtons5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlButtons5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 251, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("MÜTAKABAT İŞLEMLERİ", jPanel13);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void myTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myTableMouseClicked
        if (evt.getClickCount() == 2)
        {
            JTable target = (JTable)evt.getSource();
            int row = target.getSelectedRow();
            pid =Integer.parseInt(target.getModel().getValueAt(row, 0).toString());
            String ad =target.getModel().getValueAt(row, 1).toString();
            String soyad = target.getModel().getValueAt(row, 2).toString();
            String tc = target.getModel().getValueAt(row, 3).toString();
            String adres = target.getModel().getValueAt(row, 4).toString();
            String telno=target.getModel().getValueAt(row, 5).toString();
            String iban=target.getModel().getValueAt(row, 6).toString();
            String giristarihi=target.getModel().getValueAt(row, 7).toString();
            String cikistarihi=target.getModel().getValueAt(row, 8).toString();                      

            txtad.setText(ad);
            txtsoyad.setText(soyad);
            txttc.setText(tc);
            txtadres.setText(adres);
            txttelno.setText(telno);
            txtiban.setText(iban);
            datGiristarihi.setDate(Formatter.dateFormat(giristarihi));
            datCikistarihi.setDate(Formatter.dateFormat(cikistarihi));

        }
    }//GEN-LAST:event_myTableMouseClicked

    private void btnEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkleActionPerformed
        Person person=new Person();
        try {

            person.setPersoneltc(txttc.getText());
            person.setPersonelisim(txtad.getText());
            person.setPersonelsoyad(txtsoyad.getText());
            person.setAdres(txtadres.getText());
            person.setTelno(txttelno.getText());
            person.setIban(txtiban.getText());
            person.setGiristarihi(Formatter.dateFormat(datGiristarihi.getDate()));
            person.setCikistarihi(Formatter.dateFormat(datCikistarihi.getDate()));

            boolean isSucces = DBData.insertPerson(person);
            Util.HandleMessage.ShowCustomMessage(isSucces, "Veri Ekleme İşlemi", "");
            if (isSucces) Clear();

        } catch (HeadlessException e) {
            Util.HandleMessage.ShowCustomMessage(false, "Veri Ekleme İşlemi", "");
        }
        showPerson();
        
        
    }//GEN-LAST:event_btnEkleActionPerformed
    
    private void txttcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttcKeyTyped
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)
            || (vChar == KeyEvent.VK_BACK_SPACE)
            || (vChar == KeyEvent.VK_DELETE))) {
        evt.consume();
        }
    }//GEN-LAST:event_txttcKeyTyped

    private void txttcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttcActionPerformed

    private void txtadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadActionPerformed

    }//GEN-LAST:event_txtadActionPerformed

    private void btnTemizleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTemizleActionPerformed
      Clear();
    }//GEN-LAST:event_btnTemizleActionPerformed

    private void btnSecimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSecimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSecimActionPerformed

    private void btnGuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuncelleActionPerformed
        Person person=new Person();
        try {
           
            person.setPid(pid);
            person.setPersoneltc(txttc.getText());
            person.setPersonelisim(txtad.getText());
            person.setPersonelsoyad(txtsoyad.getText());
            person.setAdres(txtadres.getText());
            person.setTelno(txttelno.getText());
            person.setIban(txtiban.getText());
            person.setGiristarihi(Formatter.dateFormat(datGiristarihi.getDate()));
            person.setCikistarihi(Formatter.dateFormat(datCikistarihi.getDate())); 

            boolean isSucces = DBData.updatePerson(person);
            Util.HandleMessage.ShowCustomMessage(isSucces, "Veri Güncelleme İşlemi", "");
            if (isSucces) Clear();

        } catch (HeadlessException e) {
            Util.HandleMessage.ShowCustomMessage(false, "Veri Güncelleme İşlemi", "");
        }
        showPerson();
    }//GEN-LAST:event_btnGuncelleActionPerformed

    private void btnSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilActionPerformed
       Person person=new Person();
        try {
            
           //person.setPersoneltc(txttc.getText());
            //person.setPersonelisim(txtad.getText());
            //person.setPersonelsoyad(txtsoyad.getText());
            //person.setPersoneldogumyeri(txtdogumyeri.getText());
            person.setPid(pid);
            boolean isSucces = DBData.deletePerson(person);
            Util.HandleMessage.ShowCustomMessage(isSucces, "Veri silme İşlemi", "");
            if (isSucces) Clear();

        } catch (HeadlessException e) {
            Util.HandleMessage.ShowCustomMessage(false, "Veri silme İşlemi", "");
        }
        showPerson();
    }//GEN-LAST:event_btnSilActionPerformed

    private void btnEkle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkle2ActionPerformed
       Maas maas=new Maas();
        try {

            maas.setMaastarih(Formatter.dateFormat(datmaastarih.getDate()));
            maas.setMaasmiktar(txtmaasmiktari.getText());
            maas.setMaasaciklama(txtmaasaciklama.getText());
            maas.setPersoneltc(txtmaaspersoneltc.getText());

            boolean isSucces = DBData.insertMaas(maas);
            Util.HandleMessage.ShowCustomMessage(isSucces, "Veri Ekleme İşlemi", "");
            if (isSucces) Clear2();

        } catch (HeadlessException e) {
            Util.HandleMessage.ShowCustomMessage(false, "Veri Ekleme İşlemi", "");
        }
        showMaas();
    }//GEN-LAST:event_btnEkle2ActionPerformed

    private void btnGuncelle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuncelle2ActionPerformed
      Maas maas=new Maas();
        try{
           
            maas.setPidmaas(pidmaas);
            maas.setMaastarih(Formatter.dateFormat(datmaastarih.getDate()));
            maas.setMaasmiktar(txtmaasmiktari.getText());
            maas.setMaasaciklama(txtmaasaciklama.getText());
            
            

            boolean isSucces = DBData.updateMaas(maas);
            Util.HandleMessage.ShowCustomMessage(isSucces, "Veri Güncelleme İşlemi", "");
            if (isSucces) Clear2();

        } catch (HeadlessException e) {
            Util.HandleMessage.ShowCustomMessage(false, "Veri Güncelleme İşlemi", "");
        }
        showMaas();
    }//GEN-LAST:event_btnGuncelle2ActionPerformed

    private void btnSil2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSil2ActionPerformed
        Maas maas=new Maas();
        try {

            maas.setPidmaas(pidmaas);
            boolean isSucces = DBData.deleteMaas(maas);
            Util.HandleMessage.ShowCustomMessage(isSucces, "Veri silme İşlemi", "");
            if (isSucces) Clear2();

        } catch (HeadlessException e) {
            Util.HandleMessage.ShowCustomMessage(false, "Veri silme İşlemi", "");
        }
        showMaas();
    }//GEN-LAST:event_btnSil2ActionPerformed

    private void btnSecim2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSecim2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSecim2ActionPerformed

    private void btnTemizle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTemizle2ActionPerformed
        Clear2();
    }//GEN-LAST:event_btnTemizle2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       if (evt.getClickCount() == 2)
        {
            JTable target = (JTable)evt.getSource();
            int row = target.getSelectedRow();
            pidmaas =Integer.parseInt(target.getModel().getValueAt(row, 0).toString());
            String maastarihi = target.getModel().getValueAt(row, 1).toString();
            String maasmiktari=target.getModel().getValueAt(row, 2).toString();
            String maasaciklama=target.getModel().getValueAt(row, 3).toString();
            String personeltc=target.getModel().getValueAt(row, 4).toString();
            
           /* String ad =target.getModel().getValueAt(row, 2).toString();
            String soyad = target.getModel().getValueAt(row, 3).toString();
            String dogumyeri = target.getModel().getValueAt(row, 4).toString();
            String dogumtarihi=target.getModel().getValueAt(row, 5).toString();*/
            
            datmaastarih.setDate(Formatter.dateFormat(maastarihi));
            txtmaasmiktari.setText(maasmiktari);
            txtmaasaciklama.setText(maasaciklama);
            txtmaaspersoneltc.setText(personeltc);
            
            
           /* txtad.setText(ad);
            txtsoyad.setText(soyad);
            txtdogumyeri.setText(dogumyeri);
            datDogum.setDate(Formatter.dateFormat(dogumtarihi));*/

        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void txttelnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelnoActionPerformed

    private void txtibanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtibanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtibanActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
       if (evt.getClickCount() == 2)
        {
            JTable target = (JTable)evt.getSource();
            int row = target.getSelectedRow();
            pidodeme =Integer.parseInt(target.getModel().getValueAt(row, 0).toString());
            String odemetarihi =target.getModel().getValueAt(row, 1).toString();   
            String odememiktari = target.getModel().getValueAt(row, 2).toString();
            String odemeaciklama = target.getModel().getValueAt(row, 3).toString();
                  
            datodemetarih.setDate(Formatter.dateFormat(odemetarihi));
            txtodememiktari.setText(odememiktari);
            txtodemeaciklama.setText(odemeaciklama);
             
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void btnEkle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkle3ActionPerformed
        Odeme odeme=new Odeme();
        try {

            odeme.setOdemetarihi(Formatter.dateFormat(datodemetarih.getDate()));
            odeme.setOdememiktari(txtodememiktari.getText());
            odeme.setOdemeaciklama(txtodemeaciklama.getText());

            boolean isSucces = DBData.insertOdeme(odeme);
            Util.HandleMessage.ShowCustomMessage(isSucces, "Veri Ekleme İşlemi", "");
            if (isSucces) Clear3();

        } catch (HeadlessException e) {
            Util.HandleMessage.ShowCustomMessage(false, "Veri Ekleme İşlemi", "");
        }
        showOdeme();
    }//GEN-LAST:event_btnEkle3ActionPerformed

    private void btnGuncelle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuncelle3ActionPerformed
        Odeme odeme=new Odeme();
        try{
           
            odeme.setPidodeme(pidodeme);
            odeme.setOdemetarihi(Formatter.dateFormat(datodemetarih.getDate()));
            odeme.setOdememiktari(txtodememiktari.getText());
            odeme.setOdemeaciklama(txtodemeaciklama.getText());
            

            boolean isSucces = DBData.updateOdeme(odeme);
            Util.HandleMessage.ShowCustomMessage(isSucces, "Veri Güncelleme İşlemi", "");
            if (isSucces) Clear3();

        } catch (HeadlessException e) {
            Util.HandleMessage.ShowCustomMessage(false, "Veri Güncelleme İşlemi", "");
        }
        showOdeme();
    }//GEN-LAST:event_btnGuncelle3ActionPerformed

    private void btnSil3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSil3ActionPerformed
       Odeme odeme=new Odeme();
        try {

            odeme.setPidodeme(pidodeme);
            boolean isSucces = DBData.deleteOdeme(odeme);
            Util.HandleMessage.ShowCustomMessage(isSucces, "Veri silme İşlemi", "");
            if (isSucces) Clear3();

        } catch (HeadlessException e) {
            Util.HandleMessage.ShowCustomMessage(false, "Veri silme İşlemi", "");
        }
        showOdeme();
    }//GEN-LAST:event_btnSil3ActionPerformed

    private void btnTemizle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTemizle3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTemizle3ActionPerformed

    private void btnSecim3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSecim3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSecim3ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        if (evt.getClickCount() == 2)
        {
            JTable target = (JTable)evt.getSource();
            int row = target.getSelectedRow();
            pidharcama =Integer.parseInt(target.getModel().getValueAt(row, 0).toString());
            String harcamatarihi =target.getModel().getValueAt(row, 1).toString();   
            String harcamamiktari = target.getModel().getValueAt(row, 2).toString();
            String urun=target.getModel().getValueAt(row, 3).toString();
            String harcamaaciklama = target.getModel().getValueAt(row, 4).toString();
                  
            datharcamatarih.setDate(Formatter.dateFormat(harcamatarihi));
            txtharcamamiktari.setText(harcamamiktari);
            txturun.setText(urun);
            txtharcamaaciklama.setText(harcamaaciklama);
             
        }
    }//GEN-LAST:event_jTable3MouseClicked

    private void btnEkle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkle4ActionPerformed
        Harcama harcama=new Harcama();
        try {

            harcama.setHarcamatarihi(Formatter.dateFormat(datharcamatarih.getDate()));
            harcama.setHarcamamiktari(txtharcamamiktari.getText());
            harcama.setUrun(txturun.getText());
            harcama.setHarcamaaciklama(txtharcamaaciklama.getText());

            boolean isSucces = DBData.insertHarcama(harcama);
            Util.HandleMessage.ShowCustomMessage(isSucces, "Veri Ekleme İşlemi", "");
            if (isSucces) Clear4();

        } catch (HeadlessException e) {
            Util.HandleMessage.ShowCustomMessage(false, "Veri Ekleme İşlemi", "");
        }
        showHarcama();
    }//GEN-LAST:event_btnEkle4ActionPerformed

    private void btnGuncelle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuncelle4ActionPerformed
        Harcama harcama=new Harcama();
        try{
           
            harcama.setPidharcama(pidharcama);
            harcama.setHarcamatarihi(Formatter.dateFormat(datharcamatarih.getDate()));
            harcama.setHarcamamiktari(txtharcamamiktari.getText());
            harcama.setUrun(txturun.getText());
            harcama.setHarcamaaciklama(txtharcamaaciklama.getText());
            

            boolean isSucces = DBData.updateHarcama(harcama);
            Util.HandleMessage.ShowCustomMessage(isSucces, "Veri Güncelleme İşlemi", "");
            if (isSucces) Clear4();

        } catch (HeadlessException e) {
            Util.HandleMessage.ShowCustomMessage(false, "Veri Güncelleme İşlemi", "");
        }
        showHarcama();
    }//GEN-LAST:event_btnGuncelle4ActionPerformed

    private void btnSil4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSil4ActionPerformed
        Harcama harcama=new Harcama();
        try {

            harcama.setPidharcama(pidharcama);
            boolean isSucces = DBData.deleteHarcama(harcama);
            Util.HandleMessage.ShowCustomMessage(isSucces, "Veri silme İşlemi", "");
            if (isSucces) Clear4();

        } catch (HeadlessException e) {
            Util.HandleMessage.ShowCustomMessage(false, "Veri silme İşlemi", "");
        }
        showHarcama();
    }//GEN-LAST:event_btnSil4ActionPerformed

    private void btnTemizle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTemizle4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTemizle4ActionPerformed

    private void btnSecim4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSecim4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSecim4ActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        if (evt.getClickCount() == 2)
        {
            JTable target = (JTable)evt.getSource();
            int row = target.getSelectedRow();
            pidmutakabat =Integer.parseInt(target.getModel().getValueAt(row, 0).toString());
            String mutakabattarihi =target.getModel().getValueAt(row, 1).toString();   
            String mutakabatbilgi = target.getModel().getValueAt(row, 2).toString();
            String mutakabataciklama = target.getModel().getValueAt(row, 3).toString();
                  
            datmutakabattarih.setDate(Formatter.dateFormat(mutakabattarihi));
            txtmutakabat.setText(mutakabatbilgi);
            txtmutakabataciklama.setText(mutakabataciklama);
             
        }
    }//GEN-LAST:event_jTable4MouseClicked

    private void btnEkle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkle5ActionPerformed
        Mutakabat mutakabat=new Mutakabat();
        try {

            mutakabat.setMutakabattarih(Formatter.dateFormat(datmutakabattarih.getDate()));
            mutakabat.setMutakabatbilgi(txtmutakabat.getText());
            mutakabat.setMutakabataciklama(txtmutakabataciklama.getText());

            boolean isSucces = DBData.insertMutakabat(mutakabat);
            Util.HandleMessage.ShowCustomMessage(isSucces, "Veri Ekleme İşlemi", "");
            if (isSucces) Clear5();

        } catch (HeadlessException e) {
            Util.HandleMessage.ShowCustomMessage(false, "Veri Ekleme İşlemi", "");
        }
        showMutakabat();
    }//GEN-LAST:event_btnEkle5ActionPerformed

    private void btnGuncelle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuncelle5ActionPerformed
        Mutakabat mutakabat=new Mutakabat();
         try{
           
            mutakabat.setPidmutakabat(pidmutakabat);
            mutakabat.setMutakabattarih(Formatter.dateFormat(datmutakabattarih.getDate()));
            mutakabat.setMutakabatbilgi(txtmutakabat.getText());
            mutakabat.setMutakabataciklama(txtmutakabataciklama.getText());

            boolean isSucces = DBData.updateMutakabat(mutakabat);
            Util.HandleMessage.ShowCustomMessage(isSucces, "Veri Güncelleme İşlemi", "");
            if (isSucces) Clear5();

        } catch (HeadlessException e) {
            Util.HandleMessage.ShowCustomMessage(false, "Veri Güncelleme İşlemi", "");
        }
        showMutakabat();
    }//GEN-LAST:event_btnGuncelle5ActionPerformed

    private void btnSil5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSil5ActionPerformed
        Mutakabat mutakabat=new Mutakabat();
        try {

            mutakabat.setPidmutakabat(pidmutakabat);
            boolean isSucces = DBData.deleteMutakabat(mutakabat);
            Util.HandleMessage.ShowCustomMessage(isSucces, "Veri silme İşlemi", "");
            if (isSucces) Clear5();

        } catch (HeadlessException e) {
            Util.HandleMessage.ShowCustomMessage(false, "Veri silme İşlemi", "");
        }
        showMutakabat();
    }//GEN-LAST:event_btnSil5ActionPerformed

    private void btnTemizle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTemizle5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTemizle5ActionPerformed

    private void btnSecim5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSecim5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSecim5ActionPerformed

    private void jScrollPane5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane5MouseClicked

    private void txtmaaspersoneltcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmaaspersoneltcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmaaspersoneltcActionPerformed
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Thirdpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Thirdpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Thirdpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Thirdpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Thirdpage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEkle;
    private javax.swing.JButton btnEkle2;
    private javax.swing.JButton btnEkle3;
    private javax.swing.JButton btnEkle4;
    private javax.swing.JButton btnEkle5;
    private javax.swing.JButton btnGuncelle;
    private javax.swing.JButton btnGuncelle2;
    private javax.swing.JButton btnGuncelle3;
    private javax.swing.JButton btnGuncelle4;
    private javax.swing.JButton btnGuncelle5;
    private javax.swing.JButton btnSecim;
    private javax.swing.JButton btnSecim2;
    private javax.swing.JButton btnSecim3;
    private javax.swing.JButton btnSecim4;
    private javax.swing.JButton btnSecim5;
    private javax.swing.JButton btnSil;
    private javax.swing.JButton btnSil2;
    private javax.swing.JButton btnSil3;
    private javax.swing.JButton btnSil4;
    private javax.swing.JButton btnSil5;
    private javax.swing.JButton btnTemizle;
    private javax.swing.JButton btnTemizle2;
    private javax.swing.JButton btnTemizle3;
    private javax.swing.JButton btnTemizle4;
    private javax.swing.JButton btnTemizle5;
    private com.toedter.calendar.JDateChooser datCikistarihi;
    private com.toedter.calendar.JDateChooser datGiristarihi;
    private com.toedter.calendar.JDateChooser datharcamatarih;
    private com.toedter.calendar.JDateChooser datmaastarih;
    private com.toedter.calendar.JDateChooser datmutakabattarih;
    private com.toedter.calendar.JDateChooser datodemetarih;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelmaas;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JLabel jlabelharcama2;
    private javax.swing.JLabel jlabelmütakabat3;
    private javax.swing.JLabel jlabelodeme1;
    private javax.swing.JLabel jlabelürün2;
    private javax.swing.JTable myTable;
    private javax.swing.JPanel pnlButons;
    private javax.swing.JPanel pnlButtons2;
    private javax.swing.JPanel pnlButtons3;
    private javax.swing.JPanel pnlButtons4;
    private javax.swing.JPanel pnlButtons5;
    private javax.swing.JPanel pnlFiields;
    private javax.swing.JTextField txtad;
    private javax.swing.JTextField txtadres;
    private javax.swing.JTextField txtharcamaaciklama;
    private javax.swing.JTextField txtharcamamiktari;
    private javax.swing.JTextField txtiban;
    private javax.swing.JTextField txtmaasaciklama;
    private javax.swing.JTextField txtmaasmiktari;
    private javax.swing.JTextField txtmaaspersoneltc;
    private javax.swing.JTextField txtmutakabat;
    private javax.swing.JTextField txtmutakabataciklama;
    private javax.swing.JTextField txtodemeaciklama;
    private javax.swing.JTextField txtodememiktari;
    private javax.swing.JTextField txtsoyad;
    private javax.swing.JTextField txttc;
    private javax.swing.JTextField txttelno;
    private javax.swing.JTextField txturun;
    // End of variables declaration//GEN-END:variables
}
