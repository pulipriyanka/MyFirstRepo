package com.prokarma.gtp6b.executors.stpe;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		
		service.scheduleAtFixedRate(new SimpleTask("Task-" + 1), 0, 3, TimeUnit.SECONDS);
		

		System.out.println("Finished execution...");


	}
}
