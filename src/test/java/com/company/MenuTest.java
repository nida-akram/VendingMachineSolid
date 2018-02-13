package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MenuTest {
    private Menu menu;
    @Before
    public void setUp() {
        menu = new Menu();
    }

    @Test
    public void shouldReturnTrueIfUserWantsToMakeAnotherSelection() {
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        BigDecimal depositedCash = BigDecimal.valueOf(1);
        BigDecimal totalPrice = BigDecimal.ZERO;
        PaymentTypeEnum paymentType = PaymentTypeEnum.CASH;
        assertTrue(menu.askIfAnotherSelection(depositedCash, totalPrice, paymentType));
    }

    @Test
    public void shouldReturnFalseIfUserDoNotWantToMakeAnotherSelection() {
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        BigDecimal depositedCash = BigDecimal.valueOf(1);
        BigDecimal totalPrice = BigDecimal.ZERO;
        PaymentTypeEnum paymentType = PaymentTypeEnum.CASH;
        assertFalse(menu.askIfAnotherSelection(depositedCash, totalPrice, paymentType));
    }


}
