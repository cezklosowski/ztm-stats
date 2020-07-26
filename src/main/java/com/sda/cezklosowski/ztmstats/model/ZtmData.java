package com.sda.cezklosowski.ztmstats.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ZtmData {
    @JsonProperty("LastUpdateData")
    private String updateTime;
    @JsonProperty("Vehicles")
    private List<VehicleDTO> vehicleDTOList;

    public String getUpdateTime() {
        return updateTime;
    }

    public List<VehicleDTO> getVehicleDTOList() {
        return vehicleDTOList;
    }


}
