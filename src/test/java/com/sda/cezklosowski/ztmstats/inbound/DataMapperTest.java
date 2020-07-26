package com.sda.cezklosowski.ztmstats.inbound;

import com.sda.cezklosowski.ztmstats.model.VehicleDTO;
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
        List<VehicleDTO> vehicleDTOS = ztmData.getVehicleDTOList();
        //then
        assertEquals(7, vehicleDTOS.size());
        assertEquals("118", vehicleDTOS.get(1).getLine());
    }
}