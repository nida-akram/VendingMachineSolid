package com.company;

import java.math.BigDecimal;

public class Item {
    private String name;
    private BigDecimal price;
    private int optionNumber;

    public Item (String name, BigDecimal price, int optionNumber) {
        this.name = name;
        this.price = price;
        this.optionNumber = optionNumber;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getOptionNumber() {
        return optionNumber;
    }
}
