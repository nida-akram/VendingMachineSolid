package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CardTest {
    private Card card;

    @Before
    public void setup() {
        card = new Card();
    }

    @Test
    public void shouldReturnTrueWhenPinIsCorrect () {
        int correctPin = 1234;
        assertEquals(true, card.isPinCorrect(correctPin));
    }

    @Test
    public void shouldReturnFalseWhenPinIsIncorrect () {
        int incorrectPin = 0000;
        assertEquals(false, card.isPinCorrect(incorrectPin));



    }
}
