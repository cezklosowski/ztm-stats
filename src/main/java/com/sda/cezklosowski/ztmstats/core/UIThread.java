package com.sda.cezklosowski.ztmstats.core;

import java.time.LocalTime;
import java.util.Scanner;

public class UIThread extends Thread {

    private DataStorage dataStorage;

    public UIThread(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    @Override
    public synchronized void start() {
        System.out.println(getName() + " has started at - " + LocalTime.now());
        super.start();
    }

    @Override
    public void run() {

        Scanner sc = new Scanner(System.in);
        int chosenOption;
        do {
            System.out.println("Please choose an option:");
            System.out.println("1 - Print all vehicles");
            System.out.println("0 - Quit");

            chosenOption = sc.nextInt();
            if (chosenOption == 1) {
                System.out.println(dataStorage.getVehicles());
            }

        } while (chosenOption != 0);


        // do work

    }
}
