package vehhbiakdogan.com.gykvolley;

/**
 * Created by vehbiakdogan on 18.06.2017.
 */

public class Mesaj {
    private int gonderenId,durum;
    private String adSoyad,mesaj,resimUrl;

    public  Mesaj(int gonderenId, int durum, String adSoyad, String
                  mesaj, String resimUrl) {
        this.gonderenId = gonderenId;
        this.durum = durum;
        this.adSoyad = adSoyad;
        this.mesaj = mesaj;
        this.resimUrl = resimUrl;

    }

    public int getGonderenId() {
        return gonderenId;
    }

    public void setGonderenId(int gonderenId) {
        this.gonderenId = gonderenId;
    }

    public int getDurum() {
        return durum;
    }

    public void setDurum(int durum) {
        this.durum = durum;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public String getResimUrl() {
        return resimUrl;
    }

    public void setResimUrl(String resimUrl) {
        this.resimUrl = resimUrl;
    }
}
