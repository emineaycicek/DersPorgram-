package com.example.gamze.projeemineaycicek;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class KayitOlActivity extends AppCompatActivity {

    EditText kayit_ad, kayit_email, kayit_sifre;

    String kullaniciadi;
    String sifresi;
    String emaili;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_ol);

        kayit_ad = (EditText) findViewById(R.id.edittextad);
        kayit_email = (EditText) findViewById(R.id.edittextemail);
        kayit_sifre = (EditText) findViewById(R.id.edittextsifre);

    }
    public void KayitIslemi(View v) {
        switch (v.getId())
        {
            case R.id.btnkayitol:

                kullaniciadi = kayit_ad.getText().toString();
                sifresi = kayit_sifre.getText().toString();
                emaili = kayit_email.getText().toString();


                try {

                    if (kullaniciadi.isEmpty()||sifresi.isEmpty()||emaili.isEmpty())
                        Toast.makeText(getApplicationContext(), "Alanlar boş geçilemez!!!", Toast.LENGTH_SHORT).show();

                    else
                    {

                        /*dbHelper = new DatabaseHelper(getApplicationContext());
                        dbHelper.createDatabase();
                        db = dbHelper.getReadableDatabase();
                        ContentValues values = new ContentValues();
                        values.put("kullanici_adi",kullaniciadi);
                        values.put("sifre",sifresi);
                        values.put("eposta",emaili);
                        db.insert("kullanici",null,values);
                        db.close();*/
                        Intent girisekrani2=new Intent(getApplicationContext(),OturumAcActivity.class);
                        girisekrani2.putExtra("kullaniciadi",kullaniciadi);
                        girisekrani2.putExtra("sifresi",sifresi);
                        girisekrani2.putExtra("emaili",emaili);
                        startActivity(girisekrani2);
                    }


                } catch (Exception e) {
                    Toast.makeText(KayitOlActivity.this, "Bilinmeyen Hata!\n" + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.btnGeri:

                //Kayıt işlemi için kayıt ol Intentine geçiş yapılıyor.
                Intent intent=new Intent(getApplicationContext(),OturumAcActivity.class);
                startActivity(intent);
                break;
        }
    }
}
