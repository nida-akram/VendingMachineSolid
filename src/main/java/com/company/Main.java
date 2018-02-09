package com.company;

public class Main {

    public static void main(String[] args) {
        new VendingMachine(new PaymentTypeService(),new Menu(),new Cash(), new Card(), new Contactless()).start();
    }
}
