package com.example.pakoandrade.firebaseexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class PrincipalActivity extends AppCompatActivity {
    ImageButton imgPay,imgEstabl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imgEstabl = (ImageButton) findViewById(R.id.imageButton);
        imgPay = (ImageButton) findViewById(R.id.imageButton2);

        imgEstabl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PrincipalActivity.this,EstablecimientosActivity.class);
                startActivity(i);
            }
        });

        imgPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PrincipalActivity.this, PayUActivity.class);
                startActivity(i);
            }
        });


    }

}
