package com.company;

import java.util.Scanner;

public class PaymentTypeService {

    public PaymentTypeEnum getPaymentType(){
        boolean isInvalid = true;
        Scanner input = new Scanner(System.in);
        System.out.println("Please choose from the options:\n 1. Cash\n 2. Card\n 3. Contactless");
        PaymentTypeEnum paymentType = PaymentTypeEnum.CASH;
        while (isInvalid) {
            int choice = input.nextInt();

            if (choice == 1) {
                paymentType = PaymentTypeEnum.CASH;
                isInvalid = false;
            } else if (choice == 2) {
                paymentType = PaymentTypeEnum.CARD;
                isInvalid = false;
            } else if (choice == 3) {
                paymentType = PaymentTypeEnum.CONTACTLESS;
                isInvalid = false;
            } else {
                System.out.println("Please choose the correct number");
            }
        }
        return paymentType;
    }
}
