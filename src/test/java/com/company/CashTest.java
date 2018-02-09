package com.company;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class CashTest {

    @Test
    public void shouldReturnCorrectChange () {
        Cash coins = new Cash();
        BigDecimal price = BigDecimal.valueOf(2.50);
        BigDecimal cash = BigDecimal.valueOf(5);
        assertEquals(BigDecimal.valueOf(2.50),coins.calculateChange(cash, price));
    }

}
