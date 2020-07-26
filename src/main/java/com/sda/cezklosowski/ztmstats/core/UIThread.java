package com.sda.cezklosowski.ztmstats.core;

import java.time.LocalTime;
import java.util.Map;
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
            System.out.println("2 - Print avg speed for all Gdańsk vehicles");
            System.out.println("3 - Print avg speed for all Gdańsk vehicles by line");
            System.out.println("4 - Print avg speed for given line");
            System.out.println("0 - Quit");

            chosenOption = sc.nextInt();
            sc.nextLine();
            if (chosenOption == 1) {
                System.out.println(dataStorage.getVehicles());
            } else if (chosenOption == 2) {
                Double avgSpeedForAllVehicles = Calculator.avgSpeed(dataStorage.getVehicles());
                System.out.println(avgSpeedForAllVehicles);
            } else if (chosenOption == 3) {
                Map<String, Double> avgSpeedByLine = Calculator.avgSpeedByAllLines(dataStorage.getVehicles());
                System.out.println(avgSpeedByLine);
            } else if (chosenOption == 4) {
                System.out.println("Enter line number");
                String lineNumber = sc.nextLine();
                Double avgSpeedForGivenLine = Calculator.avgSpeedForGivenLine(lineNumber, dataStorage.getVehicles());
                System.out.println(avgSpeedForGivenLine);
            }
        } while (chosenOption != 0);


    }
}
