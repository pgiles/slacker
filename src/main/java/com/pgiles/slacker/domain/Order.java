package com.pgiles.slacker.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private String id;
    private List<Item> items = new ArrayList<>();
    private BigDecimal total;
    private String time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public BigDecimal getTotal() {
        return BigDecimal.valueOf(total.doubleValue());
    }

    public void setTotal(double total) {
        this.total = new BigDecimal(total);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public static Order stub() {
        Order order = new Order();
        order.setId("0");
        order.getItems().add(new Item("1", 9.99));
        order.setTotal(5.99);
        order.setTime(java.time.Instant.now().toString());
        return order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return new EqualsBuilder().append(id, order.id).append(items, order.items).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(items).toHashCode();
    }
}
