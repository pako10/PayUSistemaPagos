package com.example.pakoandrade.firebaseexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MenuActivity extends AppCompatActivity {
    CheckBox chbHamburguesa,chbHotdog,chbPaquete;
    Button btEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
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

        chbHamburguesa = (CheckBox) findViewById(R.id.checkBox);
        chbHotdog = (CheckBox) findViewById(R.id.checkBox2);
        chbPaquete = (CheckBox) findViewById(R.id.checkBox3);
        btEnviar = (Button) findViewById(R.id.button2);

        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chbHamburguesa.isChecked()){
                    Intent i = new Intent(MenuActivity.this,MainActivity.class);
                    i.putExtra("orden","Hamburguesa");
                    startActivity(i);

                }
                if(chbPaquete.isChecked()){
                    Intent i = new Intent(MenuActivity.this,MainActivity.class);
                    i.putExtra("orden","Paquete fiesta");
                    startActivity(i);

                }
                if(chbHotdog.isChecked()){
                    Intent i = new Intent(MenuActivity.this,MainActivity.class);
                    i.putExtra("orden","Hot dog");
                    startActivity(i);

                }
            }
        });



    }

}
