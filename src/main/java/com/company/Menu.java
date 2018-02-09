package com.company;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Menu {
    private DecimalFormat df = new DecimalFormat("#.00");

    public void printItems() {
        System.out.println("Please choose from the following option:");
        for (Item item : Storage.getListofItems()) {
            System.out.println(item.getOptionNumber() + ". " + item.getName() + " £" + df.format(item.getPrice()));
        }
    }

    public Item getUserInput() {
        Scanner input = new Scanner(System.in);
        int optionNumber = input.nextInt();
        if (!isValidOption(optionNumber)) {
            System.out.println("Please choose the correct option number");
            getUserInput();
        }
        return Storage.getItemByOptionNumber(optionNumber);
    }

    private boolean isValidOption(int optionNumber) {
        for (Item item : Storage.getListofItems()) {
            if (item.getOptionNumber() == optionNumber) {
                return true;
            }
        }
        return false;
    }

    public boolean askIfAnotherSelection(BigDecimal depositedCash, BigDecimal totalPrice) {
        Scanner input = new Scanner(System.in);
        if (depositedCash.compareTo(totalPrice) == 1) {
            System.out.println("Would you like to make another selection?\n 1.Yes\n 2.No");
            try {
                int choice = input.nextInt();
                if (choice == 1) {
                    return true;
                } else if (choice == 2) {
                    return false;
                } else {
                    System.out.println("Please choose the correct number!");
                    return askIfAnotherSelection(depositedCash, totalPrice);
                }
            } catch (Exception e) {
                return askIfAnotherSelection(depositedCash, totalPrice);
            }
        }
        return  false;
    }
}