package com.example.bookorderapp.util;

import com.example.bookorderapp.data.order.Order;

import java.util.ArrayList;

public class AppHolder {

    public static Order order = new Order(new ArrayList<>());
}
