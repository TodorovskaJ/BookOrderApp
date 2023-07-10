package com.example.bookorderapp.data.order;

import com.example.bookorderapp.data.menu.MenuItem;

import java.util.ArrayList;

public class Order {

    private ArrayList<MenuItem> items;

    public Order(ArrayList<MenuItem> items) {
        this.items = items;
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<MenuItem> items) {
        this.items = items;
    }
}
