package com.example.senturk.a401_odev;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import static android.R.attr.password;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText sifre;
    private Button giris;
    private Button kayit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FirebaseDatabase database=FirebaseDatabase.getInstance();
        final FirebaseAuth mAuth = FirebaseAuth.getInstance();
        final DatabaseReference myRef=database.getReference("Users");

        email=(EditText)findViewById(R.id.etMail);
        sifre=(EditText)findViewById(R.id.etSifre);
        giris=(Button)findViewById(R.id.btGiris);
        kayit=(Button)findViewById(R.id.btKaydol);


        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(email.getText().toString())|| TextUtils.isEmpty(sifre.getText().toString())){
                    Toast.makeText(MainActivity.this,"Bütün alanları doldurun!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String mail=email.getText().toString();
                    String pass=sifre.getText().toString();

                    mAuth.signInWithEmailAndPassword(mail,pass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(MainActivity.this,"Giriş Başarılı",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(MainActivity.this,GirisActivity.class));
                            }
                            else{
                                Toast.makeText(MainActivity.this,"Giriş Hatası!",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,KayitActivity.class));
            }
        });
}
}

