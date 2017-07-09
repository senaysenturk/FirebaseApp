package com.example.senturk.a401_odev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectActivity extends AppCompatActivity {

    private Button sohbet;
    private Button kisiekle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        sohbet=(Button)findViewById(R.id.btnChat);

        sohbet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SelectActivity.this,ChatActivity.class);
                startActivity(intent);
            }
        });

        kisiekle=(Button)findViewById(R.id.btnEkle);

        kisiekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SelectActivity.this,GirisActivity.class);
                startActivity(intent);
            }
        });
    }
}
