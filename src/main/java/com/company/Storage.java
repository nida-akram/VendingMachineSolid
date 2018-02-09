package com.company;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static List<Item> listofItems = new ArrayList<>();

    public static void initialiseStorage() {
        addItemToStorage("Coke", BigDecimal.valueOf(1.50), 1);
        addItemToStorage("Fanta", BigDecimal.valueOf(1.65), 2);
        addItemToStorage("Sprite", BigDecimal.valueOf(1.15), 3);
        addItemToStorage("Dairy-Milk", BigDecimal.valueOf(2.20), 4);
        addItemToStorage("Double Decker", BigDecimal.valueOf(2.60), 5);
        addItemToStorage("Margherita Pizza", BigDecimal.valueOf(2.40), 6);
        addItemToStorage("Chicken Tikka Pizza", BigDecimal.valueOf(3.50), 7);
    }

    public static void addItemToStorage(String name, BigDecimal price, int optionNumber) {
        if (!isOptionNumberValid(optionNumber)) {
            listofItems.add(new Item(name, price, optionNumber));
        } else {
            System.out.println("Error, an item already exists with this item number!");
        }
    }

    private static boolean isOptionNumberValid (int optionNumber) {
        for (Item item : listofItems) {
            if (optionNumber == item.getOptionNumber()) {
                return true;
            }
        }
        return false;
    }

    public static Item getItemByOptionNumber(int optionNumber) {
        for (Item item: listofItems) {
            if(item.getOptionNumber() == optionNumber) {
                return item;
            }
        }
        return null;
    }

    public static List<Item> getListofItems() {
        return listofItems;
    }
}
