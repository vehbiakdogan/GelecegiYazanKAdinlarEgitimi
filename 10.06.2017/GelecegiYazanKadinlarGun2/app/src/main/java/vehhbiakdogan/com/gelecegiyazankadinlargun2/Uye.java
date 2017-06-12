package vehhbiakdogan.com.gelecegiyazankadinlargun2;

/**
 * Created by vehbiakdogan on 11.06.2017.
 */

public class Uye {

    String adSoyad, sehir, facebookUrl, twitterUrl;
    int resimUrl;
    public Uye(String adSoyad, String sehir, String facebookUrl,String twitterUrl, int resimUrl){
        this.adSoyad = adSoyad;
        this.sehir = sehir;
        this.facebookUrl = facebookUrl;
        this.twitterUrl = twitterUrl;
        this.resimUrl = resimUrl;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public String getTwitterUrl() {
        return twitterUrl;
    }

    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }

    public int getResimUrl() {
        return resimUrl;
    }

    public void setResimUrl(int resimUrl) {
        this.resimUrl = resimUrl;
    }
}
