/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arackiralamasistemi;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    
    public static void main(String[] args) {
        
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        dbConnection connect = new dbConnection();
        
        System.out.println("HOSGELDINIZ. YAPMAK ISTEDIGINIZ ISLEM NEDIR?");
        System.out.println("1: Musteri Girisi");
        System.out.println("2: Musteri Yeni Kayit");
        System.out.println("3: Personel Girisi");
        System.out.println("----------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        aracKiralama arac = new aracKiralama();
        musteri girisMusteri = new musteri();
        musteri kayitMusteri = new musteri();
        personel personelGiris = new personel();
        switch(input){
            case 1:
                girisMusteri.giris();
                break;
            case 2: 
                kayitMusteri.kayit();
                break;
            case 3:
                personelGiris.giris();
                break;
            default:
                System.out.println("Hatali deger girdiniz. Lutfen yeniden deneyin.");
        }
        
        //resultset<--statement<--con<--connect
     /*  try{
            con = connect.getConnection();
            statement = con.createStatement();
            String sql = "SELECT * FROM personel";
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1)+ " " + 
                resultSet.getString(2)+ " " + resultSet.getString(3) + 
                " " + resultSet.getString(4) + " " + resultSet.getString(5));
            }
        }catch(SQLException ex){
            System.out.println("Baglanti basarisiz oldu. " + ex);
        }*/
        
    }
}
