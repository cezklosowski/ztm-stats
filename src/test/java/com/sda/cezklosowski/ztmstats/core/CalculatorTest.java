package com.sda.cezklosowski.ztmstats.core;

import com.sda.cezklosowski.ztmstats.model.Vehicle;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class CalculatorTest {

    List<Vehicle> testVehicles = List.of(
            new Vehicle("148", 50, -2),
            new Vehicle("148", 45, 10),
            new Vehicle("127", 0, 0),
            new Vehicle("N13", 15, 0),
            new Vehicle("N13", 10, 350)
    );

    @Test
    public void shouldCalculateAvgForAll() {

        Double result = Calculator.avgSpeed(testVehicles);
        assertEquals(24, result, 0);
    }

    @Test
    public void shouldCalculateAvgForAllLines() {
        Map<String, Double> result = Calculator.avgSpeedByAllLines(testVehicles);
        Double avg148 = result.get("148");
        assertEquals(47.5, avg148, 0);
    }

    @Test
    public void shouldCalculateForEmptyList() {
        Map<String, Double> result = Calculator.avgSpeedByAllLines(new ArrayList<>());
        assertEquals(0, result.keySet().size());
    }

    @Test
    public void shouldCalculateForGivenLine() {
        Double resultFor148 = Calculator.avgSpeedForGivenLine("148", testVehicles);
        Double resultFor127 = Calculator.avgSpeedForGivenLine("127", testVehicles);
        Double resultForNotExistingLine = Calculator.avgSpeedForGivenLine("XXX", testVehicles);

        assertEquals(47.5, resultFor148, 0);
        assertEquals(0, resultFor127, 0);
        assertEquals(0, resultForNotExistingLine, 0);


    }

}