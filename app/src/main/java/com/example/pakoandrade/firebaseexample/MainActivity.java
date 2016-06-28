package com.example.pakoandrade.firebaseexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.client.authentication.Constants;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Firebase mRef;
    TextView tvFireB;
    private String FIREBASE_URL = "https://fir-example-41d16.firebaseio.com/";
    private String FIREBASE_CHILD = "pedido";
    Firebase firebase;
    Button btEnviar;

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        Firebase.setAndroidContext(this);
        mRef = new Firebase("https://fir-example-41d16.firebaseio.com/");

        firebase = new Firebase(FIREBASE_URL).child(FIREBASE_CHILD);
        editText = (EditText) findViewById(R.id.editText);
        btEnviar = (Button) findViewById(R.id.button);
        tvFireB = (TextView) findViewById(R.id.textView3);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String orden = bundle.getString("orden");
        tvFireB.setText(orden);

        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //writeToFirebase();
                //updateChildren();
               // createUser();
                crearPedidos();
            }
        });

    }

    public void writeToFirebase() {
        firebase.setValue(editText.getText().toString());
        editText.setText("");
        String datos = editText.getText().toString();
    }

    public void updateChildren(){
        Firebase alanRef = mRef.child("pedido");
        Map<String, Object> pedido = new HashMap<String, Object>();
        pedido.put("pedido", editText.getText().toString());
        alanRef.updateChildren(pedido);
    }

    public void crearPedidos(){

/**
 +             * Create Firebase references
 +             */
      Firebase listsRef = new Firebase(Constantes.FIREBASE_URL_ACTIVE_LISTS);
        Firebase newListRef = listsRef.push();
        String orderN = tvFireB.getText().toString();
        String nombre = editText.getText().toString();

                               // Save listsRef.push() to maintain same random Id
        final String listId = newListRef.getKey();

        //Agregamos el objeto pedido//
       // String nuevaOrden = "paco";
        //String ordenar = editText.getText().toString();
        OrderList orderList = new OrderList(orderN,nombre);
         // Add the shopping list
        newListRef.setValue(orderList);
        editText.setText("");
        tvFireB.setText("");
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
/*
    @Override
    public void onStart(){
        super.onStart();
        Firebase messagesRef = mRef.child("mensajes");
        Firebase nuevoPedido = messagesRef.push();
        messagesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String mensaje = dataSnapshot.getValue(String.class);
               // tvFireB.setText(mensaje);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }*/
}
