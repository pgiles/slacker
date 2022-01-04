package com.pgiles.slacker.domain;

import java.util.Collections;
import java.util.List;

public class OrderStub {

    public static Order minimumNumberOfFields() {
        Order order = new Order();
        order.setId("1234");
        order.setTotal(0.68684);
        order.setItems(Collections.singletonList(new Item("0", 9.99)));

        return order;
    }

    public static Order opening() {
        Order order = new Order();
        order.setId("1234");
        order.setTime("2019-01-02T23:05:00.685840206Z");

        order.setTotal(0.68684);
        order.setItems(Collections.singletonList(new Item("0", 4.99)));

        return order;
    }

    public static Order closing() {
        Order order = new Order();
        order.setId("1234");
        order.setTime("2019-01-02T22:15:00.385240127Z");
        order.setTotal(1.09);

        Item item = new Item("0", .99);
        List<Item> items = Collections.singletonList(item);
        order.setItems(items);

        return order;
    }
}