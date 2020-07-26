package com.sda.cezklosowski.ztmstats.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ZtmData {
    @JsonProperty("LastUpdateData")
    private String updateTime;
    @JsonProperty("Vehicles")
    private List<Vehicle> vehicleList;

    public String getUpdateTime() {
        return updateTime;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }


}
