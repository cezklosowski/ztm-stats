package com.sda.cezklosowski.ztmstats.inbound;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.cezklosowski.ztmstats.model.ZtmData;

public class DataMapper {

    public static ZtmData mapJsonToZtmData(String json){
        ObjectMapper objectMapper = new ObjectMapper();
        ZtmData ztmData = null;

        try {
            ztmData = objectMapper.readValue(json,ZtmData.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ztmData;

    }
}
