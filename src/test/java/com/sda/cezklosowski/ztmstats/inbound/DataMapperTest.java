package com.sda.cezklosowski.ztmstats.inbound;

import com.sda.cezklosowski.ztmstats.model.Vehicle;
import com.sda.cezklosowski.ztmstats.model.ZtmData;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DataMapperTest {

    private String testJson = RawDataProvider.TESTJSON;

    @Test
    public void shouldMapSuccessFully(){
        ZtmData ztmData = DataMapper.mapJsonToZtmData(testJson);
        List<Vehicle> vehicle = ztmData.getVehicleList();
        assertEquals(7,vehicle.size());

    }
}