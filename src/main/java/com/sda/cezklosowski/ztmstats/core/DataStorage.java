package com.sda.cezklosowski.ztmstats.core;

import com.sda.cezklosowski.ztmstats.model.Vehicle;
import com.sda.cezklosowski.ztmstats.model.VehicleDTO;
import com.sda.cezklosowski.ztmstats.model.ZtmData;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class DataStorage {
    private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private LocalDateTime updateTime;
    private List<Vehicle> vehicles;

    public void update(ZtmData ztmData) {
        updateTime = LocalDateTime.parse(ztmData.getUpdateTime(), DATE_TIME_FORMAT);
        vehicles = ztmData.getVehicleDTOList().stream()
                .map(DataStorage::mapVehicle)
                .collect(Collectors.toList());
        System.out.println("Updated storage at " + LocalTime.now());
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public static Vehicle mapVehicle(VehicleDTO vehicleDTO) {
        return new Vehicle(vehicleDTO.getLine(), vehicleDTO.getSpeed(), vehicleDTO.getDelay());
    }
}
