package com.example.pakoandrade.firebaseexample;

/**
 * Created by pakoAndrade on 26/06/16.
 */
public class OrderList {
    String orderName;
    String owner;

    public OrderList() {
    }

    public OrderList(String orderName, String owner) {

        this.orderName = orderName;
        this.owner = owner;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
