 
package tesaapp.utils;
 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale; 
  
 
  
public class SelisihDateTime {
    // Method menghitung selisih dua waktu
    public static String selisihDateTime(Date waktuSatu, Date waktuDua) {
        long selisihMS = Math.abs(waktuSatu.getTime() - waktuDua.getTime());
       // long selisihDetik = selisihMS / 1000 % 60;
        long selisihMenit = selisihMS / (60 * 1000) % 60;
        long selisihJam = selisihMS / ( 60 * 60 * 1000) % 24;
         long selisihHari = selisihMS / (24 * 60 * 60 *  1000);
        
        
        
      //  String selisih  =  selisihJam + " Jam "  ;
          
       /* String selisih = selisihHari + " hari " + selisihJam + " Jam "
                + selisihMenit + " Menit " + selisihDetik + " Detik"; */
    String selisih = selisihHari + "Hari " + selisihJam + "Jam "+ selisihMenit + "Menit" ;
      // String selisih = selisihHari + ":" + selisihJam + ":"+ selisihMenit + ":" ;
        return selisih; 
    }
  
    public static Date konversiStringkeDate(String tanggalDanWaktuStr,String pola, Locale lokal) {
        Date tanggalDate = null;
        SimpleDateFormat formatter;
        if (lokal == null) {
            formatter = new SimpleDateFormat(pola);
        } else {
            formatter = new SimpleDateFormat(pola, lokal);
        }
        try {
            tanggalDate = formatter.parse(tanggalDanWaktuStr);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return tanggalDate;
    }
  
    public static void main(String[] args) {
        Locale lokal = null;
        String pola = "dd/MM/yyyy HH:mm:ss";
        String waktuSatuStr = "12/01/2016 02:06:56";
        String waktuDuaStr = "15/01/2016 19:43:23";
        
        Date waktuSatu = SelisihDateTime.konversiStringkeDate(waktuSatuStr,pola, lokal);
        Date WaktuDua = SelisihDateTime.konversiStringkeDate(waktuDuaStr, pola,lokal);
        
        String hasilSelisih = SelisihDateTime.selisihDateTime(waktuSatu,WaktuDua);
        
        System.out.println("Selisih tanggal \""+waktuSatuStr+"\" dengan tanggal \""+waktuDuaStr+"\" adalah: ");
        System.out.println(hasilSelisih); 
    }
}