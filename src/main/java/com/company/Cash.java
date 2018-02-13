package com.company;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class Cash{
    private DecimalFormat df = new DecimalFormat("0.00");

    private BigDecimal calculateChange(BigDecimal cash, BigDecimal price) {
        BigDecimal change = cash.subtract(price);
        if (change.compareTo(BigDecimal.ZERO)== -1) {
            change = getExtraCash(change.abs());
        }
        return change;
    }

    public BigDecimal takePayment() {
        System.out.println("Please insert cash");
        Scanner input = new Scanner(System.in);
        return BigDecimal.valueOf(input.nextDouble());
    }

    public BigDecimal getTotalPrice(List<Item> chosenSelection) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Item item : chosenSelection) {
            totalPrice = totalPrice.add(item.getPrice());
        }
        return totalPrice;
    }

    public void getChange(BigDecimal depositedCash, BigDecimal totalPrice){
        System.out.println("Please take your change: £" + df.format(calculateChange(depositedCash, totalPrice)));
    }

    private BigDecimal getExtraCash(BigDecimal change) {
        BigDecimal cashNeeded = change;
        while (cashNeeded.compareTo(BigDecimal.ZERO)== 1) {
            System.out.println("Please insert " + "£" + df.format(cashNeeded));
            cashNeeded = cashNeeded.subtract(takePayment());
        }
     return cashNeeded.abs();
    }
}