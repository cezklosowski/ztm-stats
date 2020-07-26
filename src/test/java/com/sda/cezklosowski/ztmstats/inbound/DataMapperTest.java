package com.sda.cezklosowski.ztmstats.inbound;

import com.sda.cezklosowski.ztmstats.model.Vehicle;
import com.sda.cezklosowski.ztmstats.model.ZtmData;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;

import static org.junit.Assert.*;

public class DataMapperTest {

    private String testJson = RawDataProvider.TESTJSON;

    @Test
    public void shouldMapSuccessfully() throws IOException {
        //given
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("test.json");
        String testJson = new String(resourceAsStream.readAllBytes(), Charset.defaultCharset());
        //when
        ZtmData ztmData = DataMapper.mapJsonToZtmData(testJson);
        List<Vehicle> vehicles = ztmData.getVehicleList();
        //then
        assertEquals(7, vehicles.size());
        assertEquals("118", vehicles.get(1).getLine());
    }
}