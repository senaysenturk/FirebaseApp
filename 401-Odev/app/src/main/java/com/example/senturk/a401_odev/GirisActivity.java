package com.example.senturk.a401_odev;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

public class GirisActivity extends AppCompatActivity {

    private EditText ad,soyad,yas,sehir;
    private Button kaydet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);

        ad=(EditText) findViewById(R.id.etAd);
        soyad=(EditText)findViewById(R.id.etSoyad);
        yas=(EditText)findViewById(R.id.etYas);
        sehir=(EditText)findViewById(R.id.etSehir);

        kaydet=(Button)findViewById(R.id.btG_Kaydet);

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kisiEkle(ad.getText().toString(),soyad.getText().toString(),yas.getText().toString(),sehir.getText().toString());
            }
        });
    }

    public void kisiEkle(String ad,String soyad,String yas,String sehir){
        Kisi kisi=new Kisi();
        kisi.setAd(ad);
        kisi.setSoyad(soyad);
        kisi.setYas(yas);
        kisi.setSehir(sehir);

        DatabaseReference mRef= FirebaseDatabase.getInstance().getReference().child("Kisi");
        String uid=mRef.push().getKey();
        mRef.child(uid).setValue(kisi);
        onBackPressed();
    }
}
