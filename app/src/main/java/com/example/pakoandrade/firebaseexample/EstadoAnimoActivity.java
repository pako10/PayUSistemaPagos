package com.example.pakoandrade.firebaseexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class EstadoAnimoActivity extends AppCompatActivity {
    Firebase firebaseA;
    TextView mTextView;
    Button mButtonAlegre, mButtonTriste, mButtonEnojado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estado_animo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        firebaseA.setAndroidContext(this);

        mTextView = (TextView)findViewById(R.id.textView2);
        mButtonAlegre = (Button)findViewById(R.id.btAlegre);
        mButtonEnojado = (Button)findViewById(R.id.btEnojado);
        mButtonTriste = (Button)findViewById(R.id.btTriste);
        firebaseA = new Firebase("https://fir-example-41d16.firebaseio.com/estado");

    }

    @Override
    public void onStart(){
        super.onStart();
        //Firebase messagesRef = firebaseA.child("pedido");

        firebaseA.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String mensaje = dataSnapshot.getValue(String.class);
                mTextView.setText(mensaje);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mButtonAlegre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseA.setValue("Estoy Alegre! =)");
            }
        });

        mButtonTriste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseA.setValue("Estoy Triste! =(");
            }
        });

        mButtonEnojado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseA.setValue("Estoy Enojado! -.-");
            }
        });
    }

}
