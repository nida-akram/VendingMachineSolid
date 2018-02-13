package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class StorageTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Storage storage;

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
        storage = new Storage();
    }

    @Test
    public void displayErrorMessageIfOptionNumberIsAlreadyUsed() {
        storage.addItemToStorage("Fanta", BigDecimal.valueOf(2.10), 1);
        assertEquals("Error, an item already exists with this item number!\n", outContent.toString());
    }

    @Test
    public void shouldAddItemToListIfOptionNumberIsNotUsed() {
        storage.addItemToStorage("Coke", BigDecimal.valueOf(2.10), 1);
        assertEquals(1, storage.getListofItems().size());
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }
}
