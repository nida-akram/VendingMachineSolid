package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CashTest {
    private Cash coins;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
        coins = new Cash();

    }

    @Test
    public void shouldReturnCorrectChange() {
        BigDecimal price = BigDecimal.valueOf(2.50);
        BigDecimal cash = BigDecimal.valueOf(5);
        coins.getChange(cash, price);
        assertEquals("Please take your change: £2.50\n", outContent.toString());
    }

    @Test
    public void shouldReturnTotalPrice() {
        List<Item> list = new ArrayList();
        list.add(new Item("Coke", BigDecimal.valueOf(1.50), 1));
        list.add(new Item("Fanta", BigDecimal.valueOf(1.65), 2));
        assertEquals(BigDecimal.valueOf(3.15), coins.getTotalPrice(list));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }

}
