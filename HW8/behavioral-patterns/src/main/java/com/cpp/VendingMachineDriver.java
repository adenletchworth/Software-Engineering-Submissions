package com.cpp;

import com.cpp.Entity.VendingMachine.VendingMachine;

public class VendingMachineDriver {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        System.out.println("Vending Machine initialized in Idle state.");

        simulateUserAction(vendingMachine, "Coke", 1.50);
        simulateUserAction(vendingMachine, "Pepsi", 1.00);
        simulateUserAction(vendingMachine, "Doritos", 2.00);
        simulateUserAction(vendingMachine, "KitKat", 0.75);
        simulateUserAction(vendingMachine, "Snickers", 1.50);
        System.out.println("Snickers Out of Stock Now");
        simulateUserAction(vendingMachine, "Snickers", 1.50);
    }

    private static void simulateUserAction(VendingMachine vendingMachine, String snackName, double money) {
        System.out.println("\nAttempting to select: " + snackName);
        vendingMachine.selectSnack(snackName);
        System.out.println("Inserting money: $" + money);
        vendingMachine.insertMoney(money);
    }
}
    


