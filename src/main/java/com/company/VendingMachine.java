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
    private BigDecimal depositedCash = BigDecimal.ZERO;
    private boolean isValid = true;
    private boolean anotherSelection;
    private boolean machineActive = true;



    public VendingMachine(PaymentTypeService paymentTypeService, Menu menu, Cash cash, Card card, Contactless contactless) {
        this.paymentTypeService = paymentTypeService;
        this.menu = menu;
        this.cash = cash;
        this.card = card;
        this.contactless = contactless;
    }

    public void start() {
        Storage.initialiseStorage();
        List<Item> chosenItems = new ArrayList<>();
        while (machineActive){
            chosenItems.clear();
            PaymentTypeEnum paymentType = paymentTypeService.getPaymentType();
            handleInitalPayment(paymentType);
            if (isValid) {
                menuOption(chosenItems, paymentType);
                handlePaymentType(paymentType, chosenItems);
                dispenseItems(chosenItems);
            }
            System.out.println("\n");
        }
    }

    private void menuOption (List<Item> chosenItems, PaymentTypeEnum paymentType) {
        do {
            menu.printItems();
            Item chosenItem = menu.getUserInput();
            chosenItems.add(chosenItem);
            anotherSelection = menu.askIfAnotherSelection(depositedCash, cash.getTotalPrice(chosenItems), paymentType);
        } while (anotherSelection);
    }

    private void handleInitalPayment(PaymentTypeEnum paymentType) {
        if (paymentType == PaymentTypeEnum.CASH) {
            depositedCash = cash.takePayment();
        } else if (paymentType == PaymentTypeEnum.CARD) {
            isValid = card.handlePin();
        }
    }

    private void handlePaymentType(PaymentTypeEnum paymentType, List<Item> chosenItems) {
        if (paymentType == PaymentTypeEnum.CONTACTLESS) {
            contactless.takePayment();
        } else if (paymentType == PaymentTypeEnum.CASH) {
            cash.getChange(depositedCash, cash.getTotalPrice(chosenItems));
        } else if (paymentType == PaymentTypeEnum.CARD) {
            card.getTotalPrice(chosenItems);
        }
    }

    private void dispenseItems(List<Item> chosenSelection) {
        for (Item item : chosenSelection) {
            System.out.println("Dispensing your item: " + item.getName());
        }
    }
}