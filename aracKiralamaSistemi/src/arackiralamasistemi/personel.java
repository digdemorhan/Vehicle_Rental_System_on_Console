/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arackiralamasistemi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Serdar
 */
public class personel {
    
    musteri MusteriGoruntule = new musteri();
    aracKiralama arac = new aracKiralama();
    
    
    public void giris(){
        System.out.println("Personel girisine hosgeldiniz. Lutfen kullanici adi ve sifreyi dogrulayiniz. ");
        System.out.println("Kullanici Adiniz: ");
        Scanner s = new Scanner(System.in);
        String kulAd = s.nextLine();
        System.out.println("Sifreniz: ");
        String sifre = s.nextLine();
        if(kulAd.equals("admin") && sifre.equals("admin")){
            
                
            System.out.println("Giris basarili. Yapmak istediginiz islem nedir?");
            System.out.println("1: Araclari goruntule");
            System.out.println("2: Musterileri goruntule");
            System.out.println("3: Arac ekle");
            System.out.println("4: Arac sil");
            System.out.println("5: Musteri ekle");
            System.out.println("6: Musteri sil");
            System.out.println("7: Cikis");
            int input = s.nextInt();

            switch(input){
                case 1: 
                    arac.aracGoruntule();
                    break;
                case 2:
                    System.out.println("Giris yapan musteriler icin 1, kayit yapan musteriler"
                            + "icin 2'ye basiniz.");
                    int input2 = s.nextInt();
                    switch(input2){
                        case 1: 
                            MusteriGoruntule.girisMusteriGoruntule();
                            break;
                        case 2:
                            MusteriGoruntule.kayitMusteriGoruntule();
                            break;
                        default:
                            System.out.println("Hatali deger girdiniz");
                    }
                    break;
                case 3:
                    arac.aracEkle();
                    break;
                case 4:
                    arac.aracSil();
                    break;
                case 5:
                    MusteriGoruntule.musteriEkle();
                case 6:
                    MusteriGoruntule.musteriSil();
                    break;
                case 7:
                    System.out.println("Basariyla cikis yapildi. Iyi gunler dileriz.");
                    break;
                default:
                    System.out.println("Hatali deger girdiniz.");
            }
            }else{
                System.out.println("Hatali deger.");
            }

    }
}
