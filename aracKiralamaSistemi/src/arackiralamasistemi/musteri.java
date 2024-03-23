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

public class musteri {
    
    
    aracKiralama arac = new aracKiralama();
    
    //MUSTERİ GİRİS
    public void giris(){
        System.out.println("Giris ekranina hosgeldiniz. Lutfen giris yapiniz.");
        System.out.println("Kullanici Adiniz: ");
        Scanner s = new Scanner(System.in);
        String kulAd = s.nextLine();
        System.out.println("Sifreniz: ");
        String sifre = s.nextLine();

        Connection con = null;
        PreparedStatement statement = null;
        dbConnection dbcon = new dbConnection();
        
        try{
            con = dbcon.getConnection();
            String girisEkle = "INSERT INTO musterigiris (musteriKulAd, musteriSifre)"
                    + "VALUES (?, ?)";
            statement = con.prepareStatement(girisEkle);
            statement.setString(1, kulAd);
            statement.setString(2, sifre);
            statement.executeUpdate();
            System.out.println("Veritabanina giris eklendi.");
        }catch(SQLException ex){
            System.out.println("Bir hata olustu. " + ex);
        }
        
        System.out.println("Giris basarili. Yapmak istediginiz islem nedir?");
        System.out.println("1: Arac Kiralama");
        System.out.println("2: Cikis");
        int input = s.nextInt();
        
        switch(input){
            case 1: 
                arac.kirala();
                break;
            case 2:
                System.out.println("Basariyla cikis yapildi. Iyi gunler dileriz.");              
                break;
            default:
                System.out.println("Hatali deger girildi.");
        }
    }
    
    
    //MUSTERİ KAYİT
    public void kayit(){
        System.out.println("Kayit ekranina hosgeldiniz. Lutfen kayit yapiniz.");
        System.out.println("Kullanici Adiniz: ");
        Scanner s = new Scanner(System.in);
        String kulAd = s.nextLine();
        System.out.println("Sifreniz: ");
        String sifre = s.nextLine();
        System.out.println("Mail adresiniz: ");
        String mail = s.nextLine();
        Connection con = null;
        PreparedStatement statement = null;
        dbConnection dbcon = new dbConnection();
        
        try{
            con = dbcon.getConnection();
            String kayitEkle = "INSERT INTO musterikayit (musKulAd, musSif, musMail)"
                    + "VALUES (?, ?, ?)";
            statement = con.prepareStatement(kayitEkle);
            statement.setString(1, kulAd);
            statement.setString(2, sifre);
            statement.setString(3, mail);
            statement.executeUpdate();
            System.out.println("Veritabanina kayit eklendi.");
        }catch(SQLException ex){
            System.out.println("Bir hata olustu. " + ex);
        }
        
        System.out.println("Kayit basarili. Yapmak istediginiz islem nedir?");
        System.out.println("1: Arac Kiralama");
        System.out.println("2: Cikis");
        int input = s.nextInt();
        
        switch(input){
            case 1: 
                arac.kirala();
                break;
            case 2:
                System.out.println("Basariyla cikis yapildi. Iyi gunler dileriz.");              
                break;
            default:
                System.out.println("Hatali deger girildi.");
        }
    }
    
    //GİRİS YAPAN MUSTERİLERİ GORUNTULE
    public void girisMusteriGoruntule(){
        
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;
        dbConnection dbcon = new dbConnection();
        
        try{
            con = dbcon.getConnection();
            String goruntule = "SELECT * FROM musterigiris";
            stat = con.createStatement();
            rs = stat.executeQuery(goruntule);
            while(rs.next()){
                System.out.println("Id: " + rs.getInt(1));
                System.out.println("Kullanici Adi: " + rs.getString(2));
                System.out.println("Sifre: " + rs.getString(3));
                System.out.println("******************************************************");
            }
            System.out.println("Musteriler basariyla goruntulendi.");
        }catch(SQLException ex){
            System.out.println("Bir hata olustu. " + ex);
        }       
    }
    
    
    //KAYİT YAPAN MUSTERİLERİ GORUNTULE
    public void kayitMusteriGoruntule(){
        
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;
        dbConnection dbcon = new dbConnection();
        
        try{
            con = dbcon.getConnection();
            String goruntule = "SELECT * FROM musterikayit";
            stat = con.createStatement();
            rs = stat.executeQuery(goruntule);
            while(rs.next()){
                System.out.println("Id: " + rs.getInt(1));
                System.out.println("Kullanici Adi: " + rs.getString(2));
                System.out.println("Sifre: " + rs.getString(3));
                System.out.println("Mail: " + rs.getString(4));
                System.out.println("******************************************************");
            }
            System.out.println("Musteriler basariyla goruntulendi.");
        }catch(SQLException ex){
            System.out.println("Bir hata olustu. " + ex);
        }       
    }
    
    
    //MUSTERİ EKLE
    public void musteriEkle(){
        Scanner scann = new Scanner(System.in);
        System.out.println("Eklemek istediginiz musteriye ait kullanici adini giriniz: ");
        String kulAd = scann.nextLine();
        System.out.println("Eklemek istediginiz musteriye ait sifreyi giriniz: ");
        Scanner sca = new Scanner(System.in);
        String sifre = sca.nextLine();
        System.out.println("Eklemek istediginiz musteriye ait mail adresini giriniz: ");
        Scanner scanna = new Scanner(System.in);
        String mail = scanna.nextLine();
        
        Connection con = null;
        PreparedStatement ps = null;
        dbConnection dbcon = new dbConnection();

        try{
            con = dbcon.getConnection();
            String musteriEkle = "INSERT INTO musterikayit(musKulAd, musSif, musMail)"
                    + " VALUES (?, ?, ?)";
            ps = con.prepareStatement(musteriEkle);
            ps.setString(1, kulAd);
            ps.setString(2, sifre);
            ps.setString(3, mail);
            ps.executeUpdate();
            System.out.println("Kullanici basariyla eklendi.");
        }catch(SQLException ex){
            System.out.println("Bir hata olustu. " + ex);
        } 
    }
    
    //MUSTERİ SİL
    public void musteriSil(){
        Scanner s = new Scanner(System.in);
        System.out.println("Silmek istediginiz musterinin id'sini giriniz: ");
        int input = s.nextInt();
        
        try{
            Connection con = null;
            PreparedStatement ps = null;
            dbConnection dbcon = new dbConnection();
            
            con = dbcon.getConnection();
            String musteriSil = "DELETE FROM musterikayit WHERE idMusteri=?";
            ps = con.prepareStatement(musteriSil);
            ps.setInt(1, input);
            ps.executeUpdate();
            System.out.println("Musteri basariyla silindi.");
        }catch(SQLException ex){
            System.out.println("Bir hata olustu. " + ex);
        }
    }
    
}
