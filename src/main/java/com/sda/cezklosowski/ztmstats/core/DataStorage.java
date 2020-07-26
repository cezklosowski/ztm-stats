package com.sda.cezklosowski.ztmstats.core;

import com.sda.cezklosowski.ztmstats.model.VehicleDTO;
import com.sda.cezklosowski.ztmstats.model.ZtmData;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DataStorage {
    private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private LocalDateTime updateTime;
    private List<VehicleDTO> vehicleDTOS;

    public void update(ZtmData ztmData) {
        updateTime = LocalDateTime.parse(ztmData.getUpdateTime(), DATE_TIME_FORMAT);
        vehicleDTOS = ztmData.getVehicleDTOList();
        System.out.println("Updated storage at " + LocalTime.now());
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public List<VehicleDTO> getVehicleDTOS() {
        return vehicleDTOS;
    }

    public void setVehicleDTOS(List<VehicleDTO> vehicleDTOS) {
        this.vehicleDTOS = vehicleDTOS;
    }
}
