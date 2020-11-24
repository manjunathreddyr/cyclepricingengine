package com.cyclepricing.Cycle.Pricing.Engine;

import com.cyclepricing.Cycle.Pricing.Engine.consumer.Consumer;
import com.cyclepricing.Cycle.Pricing.Engine.models.Bicycle;
import com.cyclepricing.Cycle.Pricing.Engine.producer.Producer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

@SpringBootApplication
public class CyclePricingEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(CyclePricingEngineApplication.class, args);
		BlockingQueue<Bicycle> sharedQueue = new LinkedBlockingQueue<>();

		ExecutorService pes = Executors.newFixedThreadPool(10);
		ExecutorService ces = Executors.newFixedThreadPool(10);
		for(int i = 1; i <= 10; i++) {
			pes.submit(new Producer(sharedQueue, i));
			ces.submit(new Consumer(sharedQueue, i));
		}
		pes.shutdown();
		ces.shutdown();
	}

}
