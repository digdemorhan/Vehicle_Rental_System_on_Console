/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arackiralamasistemi;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class aracKiralama {
    
    
    //KİRALAMA
    public void kirala(){
        System.out.println("Arac kiralama sistemine hosgeldiniz.");
        System.out.println("Araclarimiz en az 1, en fazla 10 gun kiralanabilir.");
        System.out.println("Asagida elimizde mevcut bulunan araclar listelenmistir.");
        System.out.println("--------------------------------------------------------");
        
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        dbConnection dbcon = new dbConnection();
        
        try{
            con = dbcon.getConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM araba";
            resultSet = statement.executeQuery(sql);
            System.out.println("Id" + " " + "Yil" + " " + "Marka" + " " + "Model" + " " + "Fiyat");
            System.out.println("---------------------------------------------------------");
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1) + " - " + 
                resultSet.getString(2) + " - " + resultSet.getString(3) + " " +
                resultSet.getString(4) + " - " + resultSet.getString(5) + "TL");
            }
        }catch(SQLException ex){
            System.out.println("Bir hata olustu. " + ex);
        }
        
        System.out.println("---------------------------------------------------------"); 
        
        gunSayisi();

    }
    
    //GÜN HESABI
    public void gunSayisi(){
        Scanner s = new Scanner(System.in);
        
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        dbConnection dbcon = new dbConnection();

        try{
           con = dbcon.getConnection();
            System.out.println("Lutfen kiralamak istediginiz aracin id numarasini giriniz.");
            int id = s.nextInt();
            int gun;
            do{
                System.out.println("Arac kac gun kiralanacak?");
                gun = s.nextInt();
                if(gun<1 || gun>10){
                    System.out.println("Hatali deger girdiniz.");
                }
            }while(gun<1 || gun>10);
            
            String sql = "SELECT arabaFiyat FROM araba WHERE idaraba= ?";
            statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                int fiyat = resultSet.getInt("arabaFiyat");
                int toplamFiyat = fiyat * gun;
                System.out.println(id + " nolu araciniz " + gun + " gun " + toplamFiyat + " TL'ye kiralanmistir. Iyi gunler.");
            }
            
        }catch(SQLException ex){
            System.out.println("Bir hata olustu. " + ex);
        }
    }
    
    
    //VERİTABANINDAKİ ARAÇLARIN HEPSİNİ GÖRÜNTÜLEME
    public void aracGoruntule(){
        
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;
        dbConnection dbcon = new dbConnection();
        
        try{
            con = dbcon.getConnection();
            String goruntule = "SELECT * FROM araba";
            stat = con.createStatement();
            rs = stat.executeQuery(goruntule);
            while(rs.next()){
                System.out.println("Id: " + rs.getInt(1));
                System.out.println("Yil: " + rs.getInt(2));
                System.out.println("Marka: " + rs.getString(3));
                System.out.println("Model: " + rs.getString(4));
                System.out.println("Fiyat: " + rs.getString(5));
                System.out.println("******************************************************");
            }
            System.out.println("Mevcut araclar basariyla goruntulendi.");
        }catch(SQLException ex){
            System.out.println("Bir hata olustu. " + ex);
        } 
    }
    
    
    //VERİTABANINA ARAÇ EKLEME
    public void aracEkle(){
        
        Scanner scann = new Scanner(System.in);
        System.out.println("Eklemek istediginiz aracin yilini giriniz: ");
        int yil = scann.nextInt();
        System.out.println("Eklemek istediginiz aracin markasini giriniz: ");
        Scanner sca = new Scanner(System.in);
        String marka = sca.nextLine();
        System.out.println("Eklemek istediginiz aracin modelini giriniz: ");
        Scanner scanna = new Scanner(System.in);
        String model = scanna.nextLine();
        System.out.println("Eklemek istediginiz aracin fiyatini giriniz: ");
        int fiyat = sca.nextInt();
        
        Connection con = null;
        PreparedStatement ps = null;
        dbConnection dbcon = new dbConnection();

        try{
            con = dbcon.getConnection();
            String aracEkle = "INSERT INTO araba(arabaYil, arabaMarka, arabaModel, arabaFiyat)"
                    + " VALUES (?, ?, ?, ?)";
            ps = con.prepareStatement(aracEkle);
            ps.setInt(1, yil);
            ps.setString(2, marka);
            ps.setString(3, model);
            ps.setInt(4, fiyat);
            ps.executeUpdate();
            System.out.println("Arac basariyla eklendi.");
        }catch(SQLException ex){
            System.out.println("Bir hata olustu. " + ex);
        }     
    }
    
    
    //VERİTABANINDAN ARAÇ SİLME
    public void aracSil(){
        Scanner s = new Scanner(System.in);
        System.out.println("Silmek istediginiz aracin id'sini giriniz: ");
        int input = s.nextInt();
        
        try{
            Connection con = null;
            PreparedStatement ps = null;
            dbConnection dbcon = new dbConnection();
            
            con = dbcon.getConnection();
            String aracSil = "DELETE FROM araba WHERE idaraba=?";
            ps = con.prepareStatement(aracSil);
            ps.setInt(1, input);
            ps.executeUpdate();
            System.out.println("Arac basariyla silindi.");
        }catch(SQLException ex){
            System.out.println("Bir hata olustu. " + ex);
        }
    }
      
}
