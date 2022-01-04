package com.pgiles.slacker.domain;

import java.math.BigDecimal;

public class Item {

    private String id;
    private BigDecimal price;

    public Item(String id, double price) {
        this.id = id;
        this.price = new BigDecimal(price);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
