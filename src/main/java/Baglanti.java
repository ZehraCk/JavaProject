package javaprojeodevi.Yardim;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class Baglanti {
    private String kullanici_adi="root";
    private String parola="";
    private String db_ismi="javaproje";
    private String host="localhost";
    private int port=3306;
    private Connection con=null;
    private Statement statement=null;
    private PreparedStatement preparedStatement=null;
    public Baglanti(){
        String url="jdbc:mysql://"+host+":"+port+"/"+db_ismi;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException ex){
            System.out.println("Driver bulunmadi...");
        }
      try{
            con=DriverManager.getConnection(url,kullanici_adi,parola);
            System.out.println("Baglanti basarili...");
      }
      catch(SQLException ex){
          System.out.println("Baglanti basarisiz...");
      }}}

