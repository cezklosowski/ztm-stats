package com.sda.cezklosowski.ztmstats.model;

public class Vehicle {
    private final String line;
    private final Integer speed;
    private final Integer delay;

    public Vehicle(String line, Integer speed, Integer delay) {
        this.line = line;
        this.speed = speed;
        this.delay = delay;
    }

    public String getLine() {
        return line;
    }

    public Integer getSpeed() {
        return speed;
    }

    public Integer getDelay() {
        return delay;
    }
}
