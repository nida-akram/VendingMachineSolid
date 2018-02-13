package com.company;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Card{
    private int attemptLimit = 3;
    private int attemptCount = 0;

    private boolean isPinCorrect(int pin) {
        int correctPin = 1234;
        if (pin == correctPin){
                System.out.println("Approved!");
            } else {
                attemptCount++;
        }
            return pin == correctPin;
        }

    public boolean handlePin(){
        System.out.println("attemptCount: " + attemptCount);
        if (attemptCount >= attemptLimit){
            return false;
        }
        if (isPinCorrect(getUserPin())) {
            return true;
        } else if(attemptCount != attemptLimit){
            return handlePin();
        } else {
            System.out.println("EXCEEDED ATTEMPTS (" + attemptLimit + ") - CARD BLOCKED");
            return false;
        }
    }

    private int getUserPin() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please insert your card!");
        System.out.println("Please enter your pin");
        int pin = input.nextInt();
        return pin;
    }

    public void getTotalPrice(List<Item> chosenSelection) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Item item : chosenSelection) {
            totalPrice = totalPrice.add(item.getPrice());
        }
        System.out.println("Your total amount is : £" + totalPrice);
    }
}
