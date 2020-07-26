package com.sda.cezklosowski.ztmstats.core;

import com.sda.cezklosowski.ztmstats.model.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Calculator {

    public static Double avgSpeed(List<Vehicle> vehicles) {
        List<Integer> speeds = new ArrayList<>();

        /* my solution
        vehicles.stream().forEach(vehicle -> speeds.add(vehicle.getSpeed()));
        Integer sumSpeed = 0;
        for (int i = 0; i < speeds.size(); i++) {
            sumSpeed += speeds.get(i);
        }
        return (double) sumSpeed/speeds.size();
        */

        return vehicles.stream()
                .mapToInt(vehicle -> vehicle.getSpeed())
                .average()
                .orElse(0);
    }

    public static Map<String, Double> avgSpeedByAllLines(List<Vehicle> vehicles) {
        return vehicles.stream()
                .collect(Collectors.
                        groupingBy(Vehicle::getLine,
                                Collectors.averagingInt(Vehicle::getSpeed)));
    }

    public static Double avgSpeedForGivenLine(String line, List<Vehicle> vehicles) {
        List<Vehicle> oneLineVehicles = vehicles.stream()
                .filter(vehicle -> vehicle.getLine().equals(line))
                .collect(Collectors.toList());
        return avgSpeed(oneLineVehicles);

    }

}
