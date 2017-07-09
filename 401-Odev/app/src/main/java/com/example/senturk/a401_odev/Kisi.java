package com.example.senturk.a401_odev;

/**
 * Created by Senturk on 9.7.2017.
 */

public class Kisi {
    private String ad;
    private String soyad;
    private String yas;
    private String sehir;

    public Kisi(){}

    public Kisi(String ad,String soyad,String yas,String sehir)
    {
        this.ad=ad;
        this.soyad=soyad;
        this.yas=yas;
        this.sehir=sehir;
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

    public String getYas() {
        return yas;
    }

    public void setYas(String yas) {
        this.yas = yas;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }
}
