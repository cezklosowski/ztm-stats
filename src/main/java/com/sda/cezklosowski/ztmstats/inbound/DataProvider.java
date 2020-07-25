package com.sda.cezklosowski.ztmstats.inbound;

import com.sda.cezklosowski.ztmstats.model.ZtmData;

import java.io.IOException;

public class DataProvider {

    private static final String URL = "https://ckan2.multimediagdansk.pl/gpsPositions";

    public ZtmData getZtmData() {
        String rawJson = null;
        try {
            rawJson = ZtaRawDataProvider.requestCurrentData(URL);
        } catch (IOException e) {
            System.out.println("Error getting data from " + URL);
            e.printStackTrace();
            return null;
        }
        return DataMapper.mapJsonToZtmData(rawJson);
    }

}
