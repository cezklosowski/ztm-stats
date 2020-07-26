package com.sda.cezklosowski.ztmstats.core;

import com.sda.cezklosowski.ztmstats.inbound.DataMapper;
import com.sda.cezklosowski.ztmstats.model.ZtmData;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class DataStorageTest {

    @Test
    public void shouldUpdateData() throws IOException {
        //given
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("test.json");
        String testJson = new String(resourceAsStream.readAllBytes(), Charset.defaultCharset());
        ZtmData ztmData = DataMapper.mapJsonToZtmData(testJson);

        // when
        DataStorage dataStorage = new DataStorage();
        dataStorage.update(ztmData);

        //then
        LocalDateTime expectedDateTime = LocalDateTime.of(2020, 7, 25, 14, 45, 00);
        LocalDateTime actualUpdateTime = dataStorage.getUpdateTime();

        assertEquals(expectedDateTime, actualUpdateTime);
        assertEquals(7, dataStorage.getVehicles().size());
    }

}