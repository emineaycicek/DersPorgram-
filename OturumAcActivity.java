package com.example.gamze.projeemineaycicek;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class OturumAcActivity extends AppCompatActivity {

    EditText et_ad,et_sifre;
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    Cursor c;
    String kullaniciadi;
    String sifresi;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oturum_ac);

        et_ad= (EditText) findViewById(R.id.edittextemailg);
        et_sifre= (EditText) findViewById(R.id.edittextsifreg);

    }


    public void buttonaktif(View v)
    {

        kullaniciadi = et_ad.getText().toString();
        sifresi = et_sifre.getText().toString();

        switch (v.getId())
        {
            case R.id.btngirisyap:

                if(sifresi.isEmpty()||kullaniciadi.isEmpty())
                {
                    Toast.makeText(OturumAcActivity.this, "Alanlar boş geçilemez!!!", Toast.LENGTH_SHORT).show();
                }
                try {
                    dbHelper = new DatabaseHelper(getApplicationContext());
                    dbHelper.createDatabase();
                    db = dbHelper.getReadableDatabase();
                    c = db.rawQuery("Select * from kullanici where kullanici_adi = ? AND sifre = ?", new String[]{String.valueOf(kullaniciadi), String.valueOf(sifresi)});

                    while (c.moveToNext()) {
                        Log.i("DB_LOG", c.getInt(0) + " " + c.getString(1));
                        if(c.getString(1).equals(kullaniciadi) && c.getString(
                                2).equals(sifresi))
                        {
                            Toast.makeText(OturumAcActivity.this, "Giriş yapıldı...", Toast.LENGTH_SHORT).show();

                            //Şifre doğruysa "Hoşgeldiniz" Intentine geçiliyor.
                            Intent girisekrani=new Intent(getApplicationContext(),AnasayfaActivity.class);
                            girisekrani.putExtra("kullaniciadi",kullaniciadi);
                            startActivity(girisekrani);
                        }else
                        {
                            Toast.makeText(OturumAcActivity.this, "Hatalı kullanıcı adı veya şifre!!!", Toast.LENGTH_SHORT).show();
                        }
                    }

                }catch(Exception e){
                    Log.e("DB_LOG",e.getMessage());
                    Log.e("DB_LOG","Veritabanı oluşturulamadı veya kopyalanamadı !");
                }
                break;

            case R.id.btnGeri:

                //Kayıt işlemi için kayıt ol Intentine geçiş yapılıyor.
                Intent intent=new Intent(getApplicationContext(),KayitOlActivity.class);
                startActivity(intent);
                break;
        }

    }
}
