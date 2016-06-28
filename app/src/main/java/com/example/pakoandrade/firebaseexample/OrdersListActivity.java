package com.example.pakoandrade.firebaseexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pakoandrade.firebaseexample.firebaseui.FirebaseListAdapter;
import com.firebase.client.Firebase;

public class OrdersListActivity extends AppCompatActivity {

    FirebaseListAdapter<OrderList> mShoppingListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Firebase.setAndroidContext(this);
        final Firebase rootRef = new Firebase("https://fir-example-41d16.firebaseio.com/ordenes");


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ListView listView = (ListView) findViewById(R.id.list_view);
        mShoppingListAdapter = new FirebaseListAdapter<OrderList>(this,
                OrderList.class, R.layout.single_active_list, rootRef) {
            @Override
            protected void populateView(View v, OrderList model) {
                super.populateView(v, model);
                TextView listNameView = (TextView) v.findViewById(R.id.text_view_list_name);
                TextView ownerView = (TextView) v.findViewById(R.id.text_view_created_by_user);
                listNameView.setText(model.getOrderName());
                ownerView.setText(model.getOwner());
            }
        };
        listView.setAdapter(mShoppingListAdapter);
    }

}
