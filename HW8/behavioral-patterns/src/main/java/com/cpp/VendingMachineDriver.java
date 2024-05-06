package com.cpp;

import com.cpp.Entity.VendingMachine.VendingMachine;

public class VendingMachineDriver {
    public static void main(String[] args) {
        // Create the vending machine instance
        VendingMachine vendingMachine = new VendingMachine();

        // Display initial state
        System.out.println("Vending Machine initialized in Idle state.");

        // User action sequence
        simulateUserAction(vendingMachine, "Coke", 1.50);
        simulateUserAction(vendingMachine, "Pepsi", 1.00);
        simulateUserAction(vendingMachine, "Doritos", 2.00);
        simulateUserAction(vendingMachine, "KitKat", 0.75);
        simulateUserAction(vendingMachine, "Snickers", 1.50);
        simulateUserAction(vendingMachine, "Snickers", 1.50);
    }

    private static void simulateUserAction(VendingMachine vendingMachine, String snackName, double money) {
        System.out.println("\nAttempting to select: " + snackName);
        vendingMachine.selectSnack(snackName);
        System.out.println("Inserting money: $" + money);
        vendingMachine.insertMoney(money);
    }
}
    


