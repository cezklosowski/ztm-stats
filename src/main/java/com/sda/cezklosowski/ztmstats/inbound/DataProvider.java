package com.sda.cezklosowski.ztmstats.inbound;

import com.sda.cezklosowski.ztmstats.model.ZtmData;

import java.io.IOException;
import java.util.Optional;

public class DataProvider {

    private static final String URL = "https://ckan2.multimediagdansk.pl/gpsPositions";

    public static Optional<ZtmData> getZtmData() {
        String rawJson = null;
        try {
            rawJson = ZtaRawDataProvider.requestCurrentData(URL);
        } catch (IOException e) {
            System.out.println("Error getting data from " + URL);
            e.printStackTrace();
            return Optional.empty();
        }
        return Optional.ofNullable(DataMapper.mapJsonToZtmData(rawJson));
    }

}
