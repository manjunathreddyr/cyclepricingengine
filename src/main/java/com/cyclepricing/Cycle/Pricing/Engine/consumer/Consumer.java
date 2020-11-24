package com.cyclepricing.Cycle.Pricing.Engine.consumer;

import com.cyclepricing.Cycle.Pricing.Engine.models.Bicycle;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final BlockingQueue<Bicycle> sharedQueue;
    private int threadNo;
    public Consumer (BlockingQueue<Bicycle> sharedQueue, int threadNo) {
        this.sharedQueue = sharedQueue;
        this.threadNo = threadNo;
    }

    @Override
    public void run() {
        while(true){
            try {
                Bicycle bicycle = sharedQueue.take();
                System.out.println("Consumed: "+ bicycle.getPrice() + ":by thread:" + threadNo);
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
    }
}