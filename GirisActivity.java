package com.example.gamze.projeemineaycicek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GirisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);
    }
    public void kayitOl(View view){
        startActivity(new Intent(GirisActivity.this,KayitOlActivity.class));

    }

    public void girisYap(View view){
        startActivity(new Intent(GirisActivity.this,OturumAcActivity.class));

    }

}
