package com.sda.cezklosowski.ztmstats.inbound;

import com.sda.cezklosowski.ztmstats.core.DataStorage;
import com.sda.cezklosowski.ztmstats.model.ZtmData;

import java.time.LocalTime;
import java.util.Optional;

public class QueryThread extends Thread {
    private DataStorage dataStorage;

    public QueryThread(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    @Override
    public synchronized void start() {
        System.out.println(getName() + " has started at - " + LocalTime.now());
        super.start();
    }

    @Override
    public void run() {

        // do work

        while (true) {
            Optional<ZtmData> optionalOfZtmData = DataProvider.getZtmData();
            optionalOfZtmData.ifPresentOrElse(
                    ztmData -> dataStorage.update(ztmData),
                    () -> System.out.println("No ZTA data retrived!"));
            try {
                Thread.sleep(30_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
