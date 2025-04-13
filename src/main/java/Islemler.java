
package javaprojeodevi.Yardim;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Islemler{
     private Connection con=null;
    private Statement statement=null;
    private PreparedStatement preparedStatement=null;
    public ArrayList<yolcubilgi> yolculariGetir(){
        ArrayList<yolcubilgi> cikti=new ArrayList<yolcubilgi>();
         try {
             statement=con.createStatement();
             String sorgu="Select * From otobus";
             ResultSet rs=statement.executeQuery(sorgu);
             while(rs.next()){
              
                 String ad=rs.getString("ad");
                 String soyad=rs.getString("soyad");
                 String guzergah=rs.getString("guzergah");
                 String plaka=rs.getString("plaka");
                 String gun=rs.getString("gun");
                 String saat=rs.getString("saat");
                 String koltuk=rs.getString("koltuk");
                
                 String kaptanin_adi=rs.getString("kaptanin_adi");
                  int yolcu_numarasi=rs.getInt("yolcu_numarasi");
                
                 
                 cikti.add(new yolcubilgi(ad,soyad,guzergah,plaka,gun,saat,koltuk,kaptanin_adi,yolcu_numarasi));        
             }
               return cikti;
         } catch (SQLException ex) {
             Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
         return null;
         }
    }
    public void yolcuGuncelle(String yeniAd,String yeniSoyad,String yeniGuzergah,String yeniPlaka,String yeniGun,String yeniSaat,String yeniKoltuk,String yeniKaptanin_adi,int yolcu_numarasi){
        String sorgu="Update otobus set ad=?, soyad=?,  guzergah=?, plaka=?, gun=?, saat=?, koltuk=?, kaptanin_adi=? Where yolcu_numarasi=?";
         try {
             preparedStatement=con.prepareStatement(sorgu);
             preparedStatement.setString(1,yeniAd);
             preparedStatement.setString(2,yeniSoyad);
             preparedStatement.setString(3, yeniGuzergah);
             preparedStatement.setString(4, yeniPlaka);
             preparedStatement.setString(5,yeniGun);
             preparedStatement.setString(6,yeniSaat);
             preparedStatement.setString(7,yeniKoltuk);
             preparedStatement.setString(8, yeniKaptanin_adi);
             preparedStatement.setInt(9,yolcu_numarasi);
             
             preparedStatement.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
         }
    
    }
    public void yolcuSil(int yolcu_numarasi){
        String sorgu="Delete From otobus Where yolcu_numarasi=?";
         try {
             preparedStatement=con.prepareStatement(sorgu);
             preparedStatement.setInt(1,yolcu_numarasi);
             preparedStatement.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
         }   
    }
    public void yolcuEkle(String ad,String soyad,String guzergah,String plaka,String gun,String saat,String koltuk,String kaptanin_adi){
     String sorgu="Insert Into otobus(ad,soyad,guzergah,plaka,gun,saat,koltuk,kaptanin_adi) VALUES(?,?,?,?,?,?,?,?)";
         try {
             preparedStatement=con.prepareStatement(sorgu);
             
             preparedStatement.setString(1,ad);
             preparedStatement.setString(2, soyad);
             preparedStatement.setString(3,guzergah);
             preparedStatement.setString(4,plaka);
             preparedStatement.setString(5,gun);
             preparedStatement.setString(6,saat);
             preparedStatement.setString(7, koltuk);
             preparedStatement.setString(8,kaptanin_adi);
             
             preparedStatement.executeUpdate();
             
         } catch (SQLException ex) {
             Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
         }
}

     public boolean girisYap(String PersonelTc,String parola){
         try {
             String sorgu="Select * From yolcubilgi where tc=? and sifre=?";
             preparedStatement =con.prepareStatement(sorgu);
             preparedStatement.setString(1,PersonelTc);
             preparedStatement.setString(2,parola);
             
             ResultSet rs=preparedStatement.executeQuery();
                return rs.next();
                     } catch (SQLException ex) {
             Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
         
         }
         return false;
    }
    public Islemler(){
          String url="jdbc:mysql://"+DataBAse.host+":"+DataBAse.port+"/"+DataBAse.db_ismi;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException ex){
            System.out.println("Driver bulunmadi...");
        }
      try{
            con=DriverManager.getConnection(url,DataBAse.kullanici_adi,DataBAse.parola);
            System.out.println("Baglanti basarili...");
      }
      catch(SQLException ex){
          System.out.println("Baglanti basarisiz...");
      }
    }
    public static void main(String[] args){
        Islemler islemler=new Islemler();
    }
}