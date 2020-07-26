package com.sda.cezklosowski.ztmstats.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true) // pomija dane z Jsona, których nie może dopasować do danych w javie
public class VehicleDTO {
    @JsonProperty("Line")
    private String line;
    @JsonProperty("Speed")
    private Integer speed; // Integer, żeby było widać kiedy jest błąd - null, a kiedy 0 km/h
    @JsonProperty("Delay")
    private Integer delay;

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "line='" + line + '\'' +
                ", speed=" + speed +
                ", delay=" + delay +
                '}';
    }
}
