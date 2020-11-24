package com.cyclepricing.Cycle.Pricing.Engine.producer;

import com.cyclepricing.Cycle.Pricing.Engine.models.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private final BlockingQueue<Bicycle> sharedQueue;
    private int threadNo;
    public Producer(BlockingQueue<Bicycle> sharedQueue,int threadNo) {
        this.threadNo = threadNo;
        this.sharedQueue = sharedQueue;
    }
    @Override
    public void run() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Bicycle[] bicyclesArray = mapper.readValue(new File("src/main/resources/bicyclesarray.json"), Bicycle[].class);
            for(int i = 0; i < bicyclesArray.length; i++) {
                try {
                    BreakAndHandle breakAndHandle = bicyclesArray[i].getBreakAndHandle();
                    ChainAssemble chainAssemble = bicyclesArray[i].getChainAssemble();
                    Frame frame = bicyclesArray[i].getFrame();
                    Gear gear = bicyclesArray[i].getGear();
                    Wheel wheel = bicyclesArray[i].getWheel();
                    wheel.setPrice(wheel.getRim().getPrice() + wheel.getSpokes().getPrice() + wheel.getTube().getPrice() + wheel.getTyre().getTyrePrice(wheel.getTyre().getDate()));
                    Price price = Price.builder().price(frame.getPrice() + gear.getPrice()+breakAndHandle.getPrice()+chainAssemble.getPrice() + wheel.getPrice()).duration(new Date()).build();
                    Bicycle bicycle = Bicycle.builder()
                            .breakAndHandle(breakAndHandle)
                            .chainAssemble(chainAssemble)
                            .frame(frame)
                            .gear(gear)
                            .wheel(wheel)
                            .price(price).build();
                    sharedQueue.put(bicycle);
                    System.out.println("Produced:" + bicycle.getPrice() + ":by thread:"+ threadNo);
                } catch (Exception err) {
                    err.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}