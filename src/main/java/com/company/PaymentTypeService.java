package com.company;

import java.util.Scanner;

public class PaymentTypeService {

    public PaymentTypeEnum getPaymentType(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please choose from the options; Cash, Card or Contactless!\n 1. Cash\n 2. Card\n 3. Contactless");
        PaymentTypeEnum paymentType = PaymentTypeEnum.CASH;
        int choice = input.nextInt();

        if(choice == 1) {
            paymentType = PaymentTypeEnum.CASH;
        } else if (choice == 2) {
            paymentType = PaymentTypeEnum.CARD;
        } else if (choice == 3) {
            paymentType = PaymentTypeEnum.CONTACTLESS;
        }
        else {
            System.out.println("Please choose the correct number");
            getPaymentType();
        }
        return paymentType;
    }
}
