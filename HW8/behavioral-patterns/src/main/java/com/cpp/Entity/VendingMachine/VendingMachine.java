package com.cpp.Entity.VendingMachine;

import java.util.HashMap;

import com.cpp.Entity.VendingMachine.Handlers.*;

public class VendingMachine {
    private StateOfVendingMachine machineState;
    private Snack selectedSnack;
    private HashMap<String, Integer> snackInventory = new HashMap<>();
    private SnackDispenserHandler firstHandler;

    public VendingMachine() {
        this.snackInventory = new HashMap<>();
        setupChainOfResponsibility();
        loadInitialStock();
        machineState = new IdleState(this);  
    }

    private void setupChainOfResponsibility() {
        CokeHandler coke = new CokeHandler();
        PepsiHandler pepsi = new PepsiHandler();
        CheetosHandler cheetos = new CheetosHandler();
        DoritosHandler doritos = new DoritosHandler();
        KitKatHandler kitKat = new KitKatHandler();
        SnickersHandler snickers = new SnickersHandler();

        coke.setNextHandler(pepsi);
        pepsi.setNextHandler(cheetos);
        cheetos.setNextHandler(doritos);
        doritos.setNextHandler(kitKat);
        kitKat.setNextHandler(snickers);

        firstHandler = coke;
    }


    private void loadInitialStock() {
        snackInventory.put("Coke", 10);
        snackInventory.put("Pepsi", 15);
        snackInventory.put("Cheetos", 20);
        snackInventory.put("Doritos", 25);
        snackInventory.put("KitKat", 30);
        snackInventory.put("Snickers", 1);
    }

    public void selectSnack(String snackName) {
        if (snackInventory.containsKey(snackName) && snackInventory.get(snackName) > 0) {
            Snack snack = new Snack(snackName, findPriceBySnackName(snackName));
            selectedSnack = snack;
            machineState.selectSnack();
        } else {
            System.out.println("Snack selection invalid or unavailable.");
        }
    }

    public Snack getSnack() {
        return selectedSnack;
    }

    public void setSnack(String snackName) {
        if (snackName != null) {
            selectedSnack = new Snack(snackName, findPriceBySnackName(snackName));
        } else {
            selectedSnack = null;  
        }
    }

    public void insertMoney(double money) {
        machineState.insertMoney(money);
    }    

    public boolean processPayment(double money) {
        double price = selectedSnack.getPrice();
        if (money >= price) {
            double change = money - price;
            if (change > 0) {
                System.out.println("Please take your change: $" + change);
            }
            return true;
        }
        return false;
    }

    public void dispenseSnack() {
        machineState.dispenseSnack();
    }

    public void idle() {
        machineState.idle();
    }

    public void awaitingPayment() {
        machineState.awaitingPayment();
    }

    public void dispensing() {
        machineState.dispensing();
    }

    public boolean isSnackAvailable(Snack snack) {
        return snackInventory.get(snack.getName()) != null && snackInventory.get(snack.getName()) > 0;
    }

    public void setMachineState(StateOfVendingMachine newMachineState) {
        System.out.println("Transitioning to " + newMachineState.getClass().getSimpleName());
        this.machineState = newMachineState;
    }

    public double findPriceBySnackName(String snackName) {
        if (snackName == null) return 0.0;

        return switch (snackName) {
            case "Coke" -> 1.25;
            case "Pepsi" -> 1.50;
            case "Cheetos" -> 1.75;
            case "Doritos" -> 2.00;
            case "KitKat" -> 1.00;
            case "Snickers" -> 1.25;
            default -> 0.0;
        };
    }

    public void decrementSnack(String snackName) {
        snackInventory.put(snackName, snackInventory.get(snackName) - 1);
    }

    public StateOfVendingMachine getMachineState(){
        return machineState;
    }

    public SnackDispenserHandler getFirstHandler(){
        return firstHandler;
    }
}
