
package javaprojeodevi.Yardim;


public class yolcubilgi{
  
    private String ad;
    private String soyad;
    private String guzergah;
    private String plaka;
    private String gun;
    private String saat;
    private String koltuk;

    private String kaptanin_adi;
      private int yolcu_numarasi;
  
    
    public yolcubilgi(String ad, String soyad, String guzergah, String plaka, String gun, String saat, String koltuk, String kaptanin_adi, int yolcu_numarasi) {
       
        this.ad=ad;
        this.soyad=soyad;
        this.guzergah=guzergah;
        this.plaka=plaka;
        this.gun=gun;
        this.saat=saat;
        this.koltuk=koltuk;
        this.kaptanin_adi=kaptanin_adi;
        this.yolcu_numarasi=yolcu_numarasi;
    }
   
        public static void main(String[] args){
        }
    public String getAd() {
        return ad;
    }

    
    public void setAd(String ad) {
        this.ad = ad;
    }

    
    public String getSoyad() {
        return soyad;
    }

   
    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    /**
     * @return the guzergah
     */
    public String getGuzergah() {
        return guzergah;
    }

    
    public void setGuzergah(String guzergah) {
        this.guzergah = guzergah;
    }

    
    public String getPlaka() {
        return plaka;
    }

    
    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

  
    public String getGun() {
        return gun;
    }

   
    public void setGun(String gun) {
        this.gun = gun;
    }

    
    public String getSaat() {
        return saat;
    }
    public void setSaat(String saat) {
        this.saat = saat;
    }

    public String getKoltuk() {
        return koltuk;
    }
    
    public void setKoltuk(String koltuk) {
        this.koltuk = koltuk;
    }
    
    public String getKaptanin_adi() {
        return kaptanin_adi;
    }
    
    public void setKaptanin_adi(String kaptanin_adi) {
        this.kaptanin_adi = kaptanin_adi;
    }
    
    public int getYolcu_numarasi(){
        return yolcu_numarasi;
    }
    
    public void setYolcu_numarasi(int yolcu_numarasi){
        this.yolcu_numarasi=yolcu_numarasi;
        
    }        
}
