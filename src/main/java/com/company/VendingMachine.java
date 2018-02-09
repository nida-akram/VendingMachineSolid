package com.company;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private PaymentTypeService paymentTypeService;
    private Menu menu;
    private Cash cash;
    private Card card;
    private Contactless contactless;
    private BigDecimal depositedCash;


    public VendingMachine(PaymentTypeService paymentTypeService, Menu menu, Cash cash, Card card, Contactless contactless) {
        this.paymentTypeService = paymentTypeService;
        this.menu = menu;
        this.cash = cash;
        this.card = card;
        this.contactless = contactless;
    }

    public void start() {
        boolean isValid = false;
        Storage.initialiseStorage();
        List<Item> chosenItems = new ArrayList<>();
        PaymentTypeEnum paymentType = paymentTypeService.getPaymentType();
        if (paymentType == PaymentTypeEnum.CASH) {
            depositedCash = cash.takePayment();
        } else if (paymentType == PaymentTypeEnum.CARD) {
            isValid = card.handlePin();
        }
        boolean anotherSelection;
        if (isValid) {
            do {
                menu.printItems();
                Item chosenItem = menu.getUserInput();
//            if (hasSufficientMoney(chosenItem)) {
                chosenItems.add(chosenItem);
//            }
//            else {
//                System.out.println("Insufficient money for: " + chosenItem.getName());
//            }
                anotherSelection = menu.askIfAnotherSelection();
            } while (anotherSelection);


            if (paymentType == PaymentTypeEnum.CONTACTLESS) {
                contactless.takePayment();
            } else if (paymentType == PaymentTypeEnum.CASH) {
                cash.getTotalPrice(depositedCash, chosenItems);
            } else if (paymentType == PaymentTypeEnum.CARD) {
                card.getTotalPrice(chosenItems);
            }
            dispenseItems(chosenItems);
        }
    }

    public void dispenseItems(List<Item> chosenSelection) {
        for (Item item : chosenSelection) {
            System.out.println("Dispensing your item: " + item.getName());
        }
    }

//    // TODO possible move into a different class
//    private boolean hasSufficientMoney(Item chosenItem){
//        double currentTotal = 0;
//        for (Item item : Storage.getListofItems()){
//            // TODO Bad hack - fix this properly ;-)
//            currentTotal += Double.valueOf("" + item.getPrice());
//        }
//        double chosenItemPrice = Double.valueOf("" + chosenItem.getPrice());
//        if (chosenItemPrice + currentTotal > Double.valueOf("" + depositedCash)){
//            return false;
//        }
//        return true;
//    }
}

//TODO 3 times attempt at card payment
//TODO sort my bloody cash out
//TODO in cash class, make the would you like another option go away if not enough money at start