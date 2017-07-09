package com.example.senturk.a401_odev;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    ListView liste;
    FirebaseDatabase db;
    DatabaseReference mRef;

    ArrayAdapter arr;

    private List<String> listemiz=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        FloatingActionButton mFab=(FloatingActionButton)findViewById(R.id.btn_fb);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listemiz.clear();
                EditText mesaj=(EditText)findViewById(R.id.etMesaj);
                FirebaseDatabase.getInstance()
                        .getReference("Mesaj")
                        .push()
                        .setValue(new ChatMessage(mesaj.getText().toString(), FirebaseAuth.getInstance()
                        .getCurrentUser()
                        .getDisplayName()));
                mesaj.setText("");
            }
        });
        liste=(ListView)findViewById(R.id.lvList);
        arr=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listemiz);
        liste.setAdapter(arr);
        readUser();
    }
    private void readUser(){
        FirebaseDatabase mDb=FirebaseDatabase.getInstance();
        DatabaseReference dbRef=mDb.getReference().child("Mesaj");

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds:dataSnapshot.getChildren()){
                    String value=ds.getValue(ChatMessage.class).getMessageText();
                    listemiz.add(value);
                    arr.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
