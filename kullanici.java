package com.example.gamze.projeemineaycicek;

public class kullanici {
    private String Isım;
    private String Sifre;
    private String Email;

    public kullanici()
    {
    }

    public kullanici (String kullaniciadi, String sifresi, String emaili)
    {
        setIIsım(kullaniciadi);
        setSıfre(sifresi);
        setEmail(emaili);
    }

    public void setIIsım(String isim)
    {
        Isım=isim;
    }
    public  String getIsım() {

        return Isım;
    }
    public void setEmail(String email)
    {
        Email=email;
    }
    public  String getEmail()

    {
        return Email;
    }
    public void setSıfre(String sifre)
    {
        Sifre=sifre;
    }
    public  String getSifre()
    {
        return Sifre;
    }

}
