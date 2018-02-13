package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CardTest {
    private Card card;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
        card = new Card();
    }

    @Test
    public void shouldAllowAccessWhenPinIsCorrect () {
        ByteArrayInputStream in = new ByteArrayInputStream("1234".getBytes());
        System.setIn(in);
        assertEquals(true, card.handlePin());
    }

    @Test
    public void shouldReturnTotalPrice() {
        List<Item> list = new ArrayList();
        list.add(new Item("Coke", BigDecimal.valueOf(1.50), 1));
        list.add(new Item("Fanta", BigDecimal.valueOf(1.65), 2));
        card.getTotalPrice(list);
        assertEquals("Your total amount is : £3.15\n", outContent.toString());
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }
}
